package com.timber.eceiro.common.utils;

/**
 * 作者：pjp
 * 邮箱：vippjp@163.com
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
 
import javax.crypto.Cipher;
 
public class Rsa {
	
	private String priKey;
	private String pubKey;
	
	public static void main(String[] args) {
		Rsa rsa = new Rsa();
		String str = "我要加密这段文字。";
//		System.out.println("原文:"+"我要加密这段文字。");
//		String crypt = rsa.encryptByPrivateKey(str);
//		System.out.println("私钥加密密文:"+crypt);
//		String result = rsa.decryptByPublicKey(crypt);
//		System.out.println("原文:"+result);
//		
//		System.out.println("---");
		
		
		
		
		
		str = "123";
		System.out.println("原文:"+"123");
		String crypt = rsa.encryptByPublicKey(str);
		System.out.println("公钥加密密文:"+crypt);
		String result = rsa.decryptByPrivateKey("X/pgdFAclIELHJFvQVCzdcEvHN23a7Lttaouobe9dyRSZtofGHwmhDmNeL2dSI1iSmjaYh36uIe667E+ToOQ2hg28xipZPo4FpyKINOapBD+tYSWlMuen6wcwgkfOyC75DRfAHWEDqpltfrZfDkA6Hf6XGl76xEQgnhSG6t3mvo=");
		System.out.println("原文:"+result);
		
		System.out.println("---");
		
//		str = "我要签名这段文字。";
//		System.out.println("原文："+str);
//		String str1 = rsa.signByPrivateKey(str);
//		System.out.println("签名结果："+str1);
//		if(rsa.verifyByPublicKey(str1, str)){
//			System.out.println("成功");
//		} else {
//			System.out.println("失败");
//		}
	}
 
//	public Rsa(){
//		priKey = readStringFromFile("java_private.pem");
//		pubKey = readStringFromFile("java_public.pem");
//	}
	
	  /**
	   * 使用私钥加密
	   * @see decByPriKey
	   */
	  public String encryptByPrivateKey(String data) {
	    // 加密
	    String str = "";
	    try {
			byte[] pribyte = base64decode("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKbVhyEl0dXL2Jew"
			+"N9B8wQHaZ07nC5oSKpQR6sc7sdsoqS+G4h9zuFpBXlspOIpnvoWeSRckwX6icytC"
			+"uuqThOJaVhmiKV6w8zzyOvTVn0yaHMpXu9ZuhWFhx3xzDYy5rQfAAzKX1MO3k4ta"
			+"ZPTQLj8u7vaVEvbVq/FFO+YNCgCpAgMBAAECgYB1x4s1eJiyAc4wEITm2Bv+Lez/"
			+"BBfptmd+z0NbUiZW3VbLqcLbh3ufpERzwR8cfu8/L6bUAuvjddYutVZ2Ip0Nd7dG"
			+"5rrktH+7R8UT89fn87bUa5NlLee+egyoz/PJ63X4JjEg5OJbkXMbK4YrTypS0IAx"
			+"nZv+7BeSsCrzNlpWAQJBANgmHMDNrIWvU3qVf7u8SS/g+WrlvKMWOXtYjH2OqWoO"
			+"Vtmh4Or1PbaPIMnPAXFYiYYW8wcLYnVmVCez5qaysWkCQQDFl9XONZIMFAvdJ5S2"
			+"UFk63bEYtCroKZjddTlE6K/j+Vj2IaCFm94i4x1YzJR0KrykrtBTLRi7nuWmdJMJ"
			+"r61BAkA7dxDGAk+KX9fJi8OedIh2AaDcxeOFwqGBy7Sq/kqhgNxn918XhOy7gtj0"
			+"bFzrP/5lw36M25b00XgpjBbSmaqxAkBnBN/TUHjh1T3OQ0m0uDWdjGI+KAlK3A04"
			+"QVrng43ZBXMNeMDRiE+Lzu/JEXjBDFsoXYB+LT/86j5/x721yiNBAkEAgi0F5BvA"
			+"wYZQXqAx3iyuj8R9uUKpLePafyBRHnLNrFux2VD0ZX3pXCmfDDmtM/NMO491dI84"
			+"6NbVOvxWcNPQ/Q==");
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
	    	Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    	c1.init(Cipher.ENCRYPT_MODE, privateKey);
	    	str = base64encode(c1.doFinal(data.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			
	    }
	    return str;
	  }
	  
	  /**
	   * 使用私钥解密
	   * @see decByPriKey
	   */
	  public String decryptByPrivateKey(String data) {
	    // 解密
	    String str = "";
	    try {
	    	
	    	String a=
	    	"MIICxjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQIvqTAvi8QTMECAggA"
					+ "MBQGCCqGSIb3DQMHBAhTjg3Jop/B8gSCAoCjSYkxCXcaIPHsuzsqfPVbIIaMxr6X"
					+ "5X/ITbvp3yDlpMfAsGMuD7++HOWcMN1GDaO44BapdSVMcUruQx1FRh+Yf4nbYnbE"
					+ "pGfah9geCdyLPdXSEPZNEpi0UER3bl8vHEp9ywgNioCMvq1WuyF3ogny+UIkwToD"
					+ "pn8HbTmvUZJ6F4Od2IprDJEmk8tHeRPaeZJ4q1nz5Afz6PyHb2WCHlUp8RHUvo5k"
					+ "Nafe8cVcnb+qfyr9QQ+XTjhhBTSXwZZYBpikfzA/y3mlc8QP1yLzEcN3W19o1yN7"
				+ "qy1b6NNtE8/5EJY8N90LPDrpXWrP80KJYT4G2UHN0Z5odNT+6e5+YmwXvJO2LsnX"
					+ "pQbMqiHrxmbKwsPrCkF/9BO3QS5EDUsK7l6C/U5Tv7pTqR5I2zS4HsWfb3SAxZw0"
				+ "QeBD2h4xFYu6ERO7XKk4ekvhR46mR4T0FYLvoKwWoAg9TIjej4Ca/NdEao5t7Hv5"
					+ "hbEWYrJKLeCeGQv3f4xI2sHT+5ND7D99JOlzjgh1UGz5U8Cq/tp2niRYYOugLfkQ"
					+ "n1l6lv5JLA6dzBm2w+qPN07QvNEnHYjry/yOEmZAfaf/F6YSanUrG9rDhbOox4I5"
					+ "J29RlR7gXOMfUzuGFA4eg4VbbUR4AfSlGkfR1NcMjehVlrl+CdvUDstKX+g1lpq1"
					+ "t3UUx+I/n5vQHIGpX/5ktP7BBYi/iz7ecluZApcbdFdQeJmnVBkPHvA5spzv9c1O"
					+ "tP/x2Hf3833KMsv7IWnBEIxdAuimB2EXYV4r2cNLIM7rh8CJFm+SqVYYSyzfwawU"
					+ "z+Yd9s09duozAIKSNtIl5lxNJ55V59PoqNwFiY6efc+//iwtVI6Iz+rR";
	    	
	    	
	    	
	    	
	    	
	    	//把RSA公钥格式PKCS#1转换成PKCS#8
	        org.bouncycastle.asn1.pkcs.RSAPublicKey rsaPublicKey =  org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(
	        org.bouncycastle.util.encoders.Base64.decode(a));

	        java.security.spec.RSAPublicKeySpec publicKeySpec = new java.security.spec.RSAPublicKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());

	        java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");

	        java.security.PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
	      
	        
	    	
			byte[] pribyte = base64decode(a);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
	    	Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    	c1.init(Cipher.DECRYPT_MODE, privateKey);
	    	byte[] temp = c1.doFinal(base64decode(data));
	    	str = new String(temp);
		} catch (Exception e) {
			e.printStackTrace();
			
	    }
	    return str;
	  }
 
	  
	  /**
	   * 使用公钥加密
	   * @see decByPriKey
	   */
	  public String encryptByPublicKey(String data) {
	    // 加密
	    String str = "";
	    try {
	    	byte[] pubbyte = base64decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHjUWha65liBtEAqzaCnUclbHLdeptgNllgeo+Vw2u/3HbpnKXC9gyFRxTOtKSTd4xWf0p8Sd8UVIU0BKj/ibaS8hLaB6s6TDG2VpBbggl//WD38Hee1m/0HwYTzL4MebbK8EX9xcw93t8vurf2igZZEQ0x3tuZH0FDL5tpvEgsQIDAQAB");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
	    	Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    	c1.init(Cipher.ENCRYPT_MODE, rsaPubKey);
	    	str = base64encode(c1.doFinal(data.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
			
	    }
	    return str;
	  }
	  
	  /**
	   * 使用公钥解密
	   * @see decByPriKey
	   */
	  public String decryptByPublicKey(String data) {
	    // 加密
	    String str = "";
	    try {
			byte[] pubbyte = base64decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCm1YchJ"
					+ "dHVy9iXsDfQfMEB2mdO5wuaEiqUEerHO7HbKKkvhuIfc7haQV5bKTiKZ76FnkkXJMF+onMrQrrqk4TiWlYZoilesPM88jr01Z9Mmh"
					+ "zKV7vWboVhYcd8cw2Mua0HwAMyl9TDt5OLWmT00C4/Lu72lRL21avxRTvmDQoAqQIDAQAB");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
	    	Cipher c1 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	    	c1.init(Cipher.DECRYPT_MODE, rsaPubKey);
	    	byte[] temp = c1.doFinal(base64decode(data));
	    	str = new String(temp);
		} catch (Exception e) {
			e.printStackTrace();
			
	    }
	    return str;
	  }
	/**
	 * 本方法使用SHA1withRSA签名算法产生签名
	 * @param String src 签名的原字符串
	 * @return String 签名的返回结果(16进制编码)。当产生签名出错的时候，返回null。
	 */
	public String signByPrivateKey(String src) {
		try {
			Signature sigEng = Signature.getInstance("SHA1withRSA");
			byte[] pribyte = base64decode("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKbVhyEl0dXL2Jew"
					+"N9B8wQHaZ07nC5oSKpQR6sc7sdsoqS+G4h9zuFpBXlspOIpnvoWeSRckwX6icytC"
					+"uuqThOJaVhmiKV6w8zzyOvTVn0yaHMpXu9ZuhWFhx3xzDYy5rQfAAzKX1MO3k4ta"
					+"ZPTQLj8u7vaVEvbVq/FFO+YNCgCpAgMBAAECgYB1x4s1eJiyAc4wEITm2Bv+Lez/"
					+"BBfptmd+z0NbUiZW3VbLqcLbh3ufpERzwR8cfu8/L6bUAuvjddYutVZ2Ip0Nd7dG"
					+"5rrktH+7R8UT89fn87bUa5NlLee+egyoz/PJ63X4JjEg5OJbkXMbK4YrTypS0IAx"
					+"nZv+7BeSsCrzNlpWAQJBANgmHMDNrIWvU3qVf7u8SS/g+WrlvKMWOXtYjH2OqWoO"
					+"Vtmh4Or1PbaPIMnPAXFYiYYW8wcLYnVmVCez5qaysWkCQQDFl9XONZIMFAvdJ5S2"
					+"UFk63bEYtCroKZjddTlE6K/j+Vj2IaCFm94i4x1YzJR0KrykrtBTLRi7nuWmdJMJ"
					+"r61BAkA7dxDGAk+KX9fJi8OedIh2AaDcxeOFwqGBy7Sq/kqhgNxn918XhOy7gtj0"
					+"bFzrP/5lw36M25b00XgpjBbSmaqxAkBnBN/TUHjh1T3OQ0m0uDWdjGI+KAlK3A04"
					+"QVrng43ZBXMNeMDRiE+Lzu/JEXjBDFsoXYB+LT/86j5/x721yiNBAkEAgi0F5BvA"
					+"wYZQXqAx3iyuj8R9uUKpLePafyBRHnLNrFux2VD0ZX3pXCmfDDmtM/NMO491dI84"
					+"6NbVOvxWcNPQ/Q==");
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pribyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPrivateKey privateKey = (RSAPrivateKey) fac.generatePrivate(keySpec);
			sigEng.initSign(privateKey);
			sigEng.update(src.getBytes());
			byte[] signature = sigEng.sign();
			return base64encode(signature);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 
	/**
	 * 使用共钥验证签名
	 * @param sign
	 * @param src
	 * @return
	 */
	public boolean verifyByPublicKey(String sign, String src) {
		try {
			Signature sigEng = Signature.getInstance("SHA1withRSA");
			byte[] pubbyte = base64decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCm1YchJ"
					+ "dHVy9iXsDfQfMEB2mdO5wuaEiqUEerHO7HbKKkvhuIfc7haQV5bKTiKZ76FnkkXJMF+onMrQrrqk4TiWlYZoilesPM88jr01Z9Mmh"
					+ "zKV7vWboVhYcd8cw2Mua0HwAMyl9TDt5OLWmT00C4/Lu72lRL21avxRTvmDQoAqQIDAQAB");
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubbyte);
			KeyFactory fac = KeyFactory.getInstance("RSA");
			RSAPublicKey rsaPubKey = (RSAPublicKey) fac.generatePublic(keySpec);
			sigEng.initVerify(rsaPubKey);
			sigEng.update(src.getBytes());
			byte[] sign1 = base64decode(sign);
			return sigEng.verify(sign1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
 
	/**
	 *  base64加密
	 * @param bstr
	 * @return
	 */
	@SuppressWarnings("restriction")
	private String base64encode(byte[] bstr) {
		String str =  new sun.misc.BASE64Encoder().encode(bstr);
		str = str.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
		return str;
	}
 
	/**
	 * base64解密
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
 
	/**
	 * 从文件中读取所有字符串
	 * @param fileName
	 * @return	String
	 */
	private String readStringFromFile(String fileName){
		StringBuffer str = new StringBuffer();
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			char[] temp = new char[1024];
			while (fr.read(temp) != -1) {
				str.append(temp);
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
 
		}
		return str.toString();
	}
}