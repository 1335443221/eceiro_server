package com.timber.eceiro.common.utils;

import com.timber.eceiro.common.Interceptor.MyException;
import com.timber.eceiro.common.beans.WebToken;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("deprecation")
@Component
public class WebTokenUtil {
	
    private static Logger log = LoggerFactory.getLogger(WebTokenUtil.class);
    private static WebToken webToken = new WebToken();
    static {
        try {
            Resource resource = new ClassPathResource("/webtoken.properties");
            Properties Props = PropertiesLoaderUtils.loadProperties(resource);
            webToken.setExpiresSecond(Props.getProperty("expiresSecond") == null ? 6379
                    : Integer.parseInt(Props.getProperty("expiresSecond")));
            webToken.setName(Props.getProperty("name"));
            webToken.setSalt(Props.getProperty("salt"));
        }catch (ExpiredJwtException ex) {
            throw new MyException(CodeMsg.AUTH_EXPIRES,0);
        }catch (Exception ex) {
            throw new MyException(CodeMsg.TOKEN_FAILS,0);
        }
    }
    /**
     * @desc 生成一个token值
     * @param key
     * @param obj
     * @return
     */
    public static String getWebToken(String key, Object obj) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        // 生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(webToken.getSalt());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
        // 添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").claim(key, obj).setIssuer(webToken.getName())
                .signWith(SignatureAlgorithm.HS256, signingKey);
        // 添加Token过期时间
        long TTLMillis = webToken.getExpiresSecond() * 24 * 60 * 60 * 1000;
        // long TTLMillis = webToken.getExpiresSecond() * 1000;
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
        // 生成JWT
        return builder.compact();
    }
    /**
     * @desc 解析token值
     * @param jsonWebToken
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseWebToken(String jsonWebToken, String key) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(webToken.getSalt()))
                    .parseClaimsJws(jsonWebToken).getBody();
            Map<String, Object> res = (Map<String, Object>) claims.get(key);
            return res;
        } catch (ExpiredJwtException ex) {
            throw new MyException(CodeMsg.AUTH_EXPIRES,0);
        }catch (Exception ex) {
            throw new MyException(CodeMsg.TOKEN_FAILS,0);
        }
    }
    /**
     * 获取webtoken的失效时间
     * 
     * @param jsonWebToken
     * @return
     */
    public static Long getWebTokenTime(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(webToken.getSalt()))
                    .parseClaimsJws(jsonWebToken).getBody();
            Long expireTime = claims.getExpiration().getTime();
            if(expireTime>System.currentTimeMillis()/1000){
                return claims.getExpiration().getTime();
            }
        }catch (ExpiredJwtException ex) {
            throw new MyException(CodeMsg.AUTH_EXPIRES,0);
        } catch (MyException ex) {
            throw ex;
        }catch (Exception ex) {
            throw new MyException(CodeMsg.TOKEN_FAILS,0);
        }
        return null;
    }
    /**
     * 获取当前登录的用户对象
     */
     public static Map<String, Object> getUserByWebToken(String token) {
         try {
               //String jsonWebToken = request.getHeader("token");
               /*if (jsonWebToken == null) {
                   return null;
               }*/
               Map<String, Object> tUserMap = (Map<String, Object>)parseWebToken(token, "tUser");
               if (tUserMap == null) {
                   throw new MyException(1002,"授权过期,请重新登录",0);
               }
               return tUserMap;
          } catch (MyException ex) {
             throw ex;
         }catch (Exception ex) {
             throw new MyException(CodeMsg.TOKEN_FAILS,0);
         }
     }

     public static Integer getUserIdByToken(String token){
         return (Integer)getUserByWebToken(token).get("user_id");
     }

    public static String getRongUserIdByToken(String token){
        return String.valueOf(getUserByWebToken(token).get("rong_user_id"));
    }

    public static Integer getRoleIdByToken(String token){
        return (Integer)getUserByWebToken(token).get("role_id");
    }
}