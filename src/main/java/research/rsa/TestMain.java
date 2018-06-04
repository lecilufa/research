package research.rsa;

import java.io.File;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class TestMain {


	//公钥 密钥生成器
	@Test
	public void generateKeys() throws Exception{
		
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);//生成大小最好是 1024  RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024  
									//明文长度 1024/8 -11 = 117 byte  超过则报错  1byte = 英文字符或标点
									//传输长明文 可以考虑分段加密  分段解密  不推荐用超长的密钥  会极度的卡
		
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();//获取公钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();//获取私钥
		
		String publicKeyString = Base64.encodeBase64String(publicKey.getEncoded());		//公钥字符串
		String privateKeyString = Base64.encodeBase64String(privateKey.getEncoded());	//密钥字符串
		
		FileUtils.writeStringToFile(new File("C:/nicot/JDK/publicKey.txt"), publicKeyString);	
		FileUtils.writeStringToFile(new File("C:/nicot/JDK/privateKey.txt"), privateKeyString);	
	}
	
	//以   密码_验证码  的格式传送，到服务器 先找验证码， 在去验证码验证密码
	@Test
	public void test2()throws Exception{
		
		String randomCode = RandomStringUtils.randomAlphanumeric(9);
		
		String data = "mkjdion^h_d321323_"+randomCode;
		
		int lastIndex = data.lastIndexOf("_"+ randomCode);
		
		if(lastIndex != -1){
			System.out.println(randomCode);
			System.out.println(data.substring(0, lastIndex));
		}else{
			System.out.println("验证码不对");
		}
		
		
	}
	
	
	//虽然RSA每次加密字符串都不一样,还得加验证吗
	@Test
	public void testing()throws Exception{
		
		String publicK = FileUtils.readFileToString(new File("C:/nicot/JDK/puplicKey.txt"));
		String privateK = FileUtils.readFileToString(new File("C:/nicot/JDK/privateKey.txt"));
		
		PublicKey publicKey = this.getPublicKey(publicK);
		PrivateKey privateKey = this.getPrivateKey(privateK);
		
		String data = "This is me.";
		
		byte[] mi = this.encrypt(data, publicKey);		
		System.out.println(Base64.encodeBase64String(mi));		//编码后的结果
		
		
		byte[] desData = this.decrypt(mi, privateKey);		//解码 还原字符串
		String desStr = new String(desData);
				
		System.out.println(desStr);
		
	}
	
	
	private byte[] encrypt(String data,PublicKey key) throws Exception{
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(data.getBytes());
	}
	
	private  byte[] decrypt(byte[] data,PrivateKey key) throws Exception{
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(data);
	}
	
	private  PrivateKey getPrivateKey(String privateKeyData) throws Exception{

		byte[] decodeKey = Base64.decodeBase64(privateKeyData); // 将字符串Base64解码
		PKCS8EncodedKeySpec x509 = new PKCS8EncodedKeySpec(decodeKey);// 创建x509证书封装类
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");// 指定RSA
		PrivateKey privateKey = keyFactory.generatePrivate(x509);// 生成私钥
		return privateKey;
	}
	
	private  PublicKey getPublicKey(String publicKeyData) throws Exception{

		byte[] decodeKey = Base64.decodeBase64(publicKeyData);
		X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodeKey);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509);
		return publicKey;
	}
	
}
