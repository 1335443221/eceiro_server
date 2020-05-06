/**
 * 作者：pjp
 * 邮箱：vippjp@163.com
 */
package com.timber.eceiro.common.utils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Rsa1 {

	/**
	 * 使用私钥解密
	 * 
	 * @see
	 */
	public String decryptByPrivateKey(String data) {
	
		String str = "";
		try {
			//data = data.trim(); // 取值
			data=data.replaceAll(" ", "+");
			byte[] pribyte = base64decode("");
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
			Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c1.init(Cipher.DECRYPT_MODE, privateKey);
			// 对数据分段解密
			int inputLen = base64decode(data).length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > 128) {
					cache = c1.doFinal(base64decode(data), offSet, 128);
				} else {
					cache = c1.doFinal(base64decode(data), offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 128;
			}
			byte[] decryptedData = out.toByteArray();
			str = new String(decryptedData);
			str=URLDecoder.decode(str,"GBK");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;

	}

	/**
	 * 使用公钥加密
	 * 
	 * @see
	 */
	public String encryptByPublicKey(String data) {
		// 加密
		String str = "";
		try {
			byte[] pubbyte = base64decode("");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
			Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c1.init(Cipher.ENCRYPT_MODE, rsaPubKey);

			int inputLen = data.getBytes().length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;
			byte[] cache;
			int i = 0;
			// 对数据分段加密
			while (inputLen - offSet > 0) {
				if (inputLen - offSet > 117) {
					cache = c1.doFinal(data.getBytes(), offSet, 117);
				} else {
					cache = c1.doFinal(data.getBytes(), offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				i++;
				offSet = i * 117;
			}
			byte[] encryptedData = out.toByteArray();
			String string = new String(encryptedData);
			out.close();

			str = base64encode(encryptedData);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}


	/**
	 * base64加密
	 * 
	 * @param bstr
	 * @return
	 */
	@SuppressWarnings("restriction")
	private String base64encode(byte[] bstr) {
		String str = new sun.misc.BASE64Encoder().encode(bstr);
		str = str.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
		return str;
	}

	/**
	 * base64解密
	 * 
	 * @param str
	 * @return byte[]
	 */
	@SuppressWarnings("restriction")
	private byte[] base64decode(String str) {
		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bt;
	}

 
}
