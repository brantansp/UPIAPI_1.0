package mBankingUtilityCenter;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;
import java.util.Map;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @author brantansp
 *
 */
public class Hmac {

	  private Map<String, String> integrityCheckRequired;
	  private Map<String, String> integrityCheckVersions;
	  private static String modulus ="203577465141885203944391850079714410739";
	  private static String privateKey = "30879710407487080765481767401582893505";
	  private static String publickey = "65537";
	  private static String keyLength;
	  private String httpsEnable;
	  
	  public static void main (String [] args) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException 
	  {
		  /**
		   * Example to Validate the request received with HMAC from mobile
		   */
		  String Request = "7e8c181f621b8b2918216adb266c9ddc7774e1a31830dc88939c8f2cf16ed64b*!9894060407APL1;N;422132;123457;4.0.5;504511000422132;108275514071541287394238077519949769235";
		//  isValidData(Request);
          
		  /**
           * Generating Unique random number(HMAC key) to be append at the end of request
           */
		  BigInteger randNum = new BigInteger(45, new Random());
		  //System.out.println("Random number : " +randNum);
		
		  /**
		   * Encrypting HMAC key to be sent in request
		   */
		 BigInteger encryptedKey =  randNum.modPow(new BigInteger(publickey, 10) , new BigInteger(modulus, 10));
		 //System.out.println("Encrypted data : "+encryptedKey);
		 
		 
		 String halfRequest = "9322908654APGC;BVD:4.1.15#ANDROID7.1.1#H1280W720#Lenovo A7000-a;";
		 String fullRequest = halfRequest+randNum;
		 System.out.println("Request : " +fullRequest);
		 Hmacing(fullRequest, halfRequest, encryptedKey);
	

		 
		 //isValidData(FinalRequest);

		 BigInteger decryptedKey = encryptedKey.modPow(new BigInteger(privateKey, 10) , new BigInteger(modulus, 10));
		 System.out.println("Decrypted Key : " + decryptedKey);
	
	  
	  }
	  
	  public static String Hmacing(String fullRequest, String halfRequest, BigInteger uniNum) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException
	  {
		  BigInteger encryptedKey = uniNum.modPow(new BigInteger(publickey, 10) , new BigInteger(modulus, 10));
		  String text = ""+uniNum; 
		  String hashedRequest = calculateRFC2104HMAC(fullRequest, text);
		  String FinalRequest=hashedRequest+ "*!"+halfRequest+encryptedKey;
		  //System.out.println("FinalRequest : " +FinalRequest);
		  return FinalRequest;
	  }
	  


	  public static BigInteger decrypt(BigInteger encrypted, BigInteger privateKey, BigInteger modulus)
	  {
	    return encrypted.modPow(privateKey, modulus);
	  }
	  
	  public static BigInteger encrypt(BigInteger encrypted, BigInteger publickey, BigInteger modulus)
	  {
		  return encrypted.modPow(publickey, modulus);
	  }
	  
	  public static boolean isValidData(String request)
	  {/*
	    try
	    {
	      String key = "";
	      String[] hmacData = request.split("\\*\\!");
	      String hashedData = hmacData[0];	     
	      request = hmacData[1];
	      String[] messageArray = request.split(";");
	      String encryptedKey = messageArray[(messageArray.length - 1)];	      
		  key = decrypt(new BigInteger(encryptedKey), new BigInteger(getPrivateKey()), new BigInteger(getModulus())).toString();	     
// KEY LENGTH IMPLEMENTATION REASON NOT KNOWN BUT PRONE TO ERROR IN THIS IMPLEMENTATION
	      if (key.length() == 14) {
	        key = StringUtils.leftPad(key, 15, '0');
	      } 
	      else if 
	      
	      (key.length() != Integer.parseInt(""+key.length())) {
	        key = StringUtils.leftPad(key, Integer.parseInt(""+key.length()), '0');
	      }
  
	      request = request.substring(0, request.lastIndexOf(";")) + ";" + key;
	      String hashedRequest = calculateRFC2104HMAC(request, key);
	      if (hashedData.equals(hashedRequest)) {
	        return true;
	      }else{
	    	  return false;
	      }
	    }
	    catch (InvalidKeyException e)
	    {
	      e.printStackTrace();
	    }
	    catch (SignatureException e)
	    {
	      e.printStackTrace();
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	      e.printStackTrace();
	    }
	    */
	    return false;
	  }
	  
	  public String updatedRequest(String request)
	  {
	    String[] hmacData = request.split("\\*\\!");
	    return hmacData[1];
	  }
	  
	  public static String getKeyLength()
	  {
	    return keyLength;
	  }
	  
	  public void setKeyLength(String keyLength)
	  {
	    this.keyLength = keyLength;
	  }
	  
	  public Map<String, String> getIntegrityCheckRequired()
	  {
	    return this.integrityCheckRequired;
	  }
	  
	  public void setIntegrityCheckRequired(Map<String, String> integrityCheckRequired)
	  {
	    this.integrityCheckRequired = integrityCheckRequired;
	  }
	  
	  public Map<String, String> getIntegrityCheckVersions()
	  {
	    return this.integrityCheckVersions;
	  }
	  
	  public void setIntegrityCheckVersions(Map<String, String> integrityCheckVersions)
	  {
	    this.integrityCheckVersions = integrityCheckVersions;
	  }
	  
	  public static String getModulus()
	  {
	    return modulus;
	  }
	  
	  public void setModulus(String modulus)
	  {
	    this.modulus = modulus;
	  }
	  
	  public static String getPrivateKey()
	  {
	    return privateKey;
	  }
	  
	  public void setPrivateKey(String privateKey)
	  {
	    this.privateKey = privateKey;
	  }
	  
	  public String getHttpsEnable()
	  {
	    return this.httpsEnable;
	  }
	  
	  public void setHttpsEnable(String httpsEnable)
	  {
	    this.httpsEnable = httpsEnable;
	  }
      
	  private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	  
	  private static String toHexString(byte[] bytes)
	  {
	    Formatter formatter = new Formatter();
	    
	    byte[] arrayOfByte = bytes;
	    int j = bytes.length;
	    for (int i = 0; i < j; i++)
	    {
	      byte b = arrayOfByte[i];
	      //System.out.println("Byte B is " + b);
	      formatter.format("%02x", new Object[] { Byte.valueOf(b) });
	      //System.out.println("Formatter : "+formatter);
	    }
	    //System.out.println("Formatter : "+formatter.toString());
	    return formatter.toString();
	  }
	  
	  public static String calculateRFC2104HMAC(String data, String key)
	    throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	  {
	    SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
	    Mac mac = Mac.getInstance("HmacSHA256");
	    mac.init(signingKey);
	    //System.out.println("Mac : "+mac.doFinal(data.getBytes()));
	    //System.out.println("ToHexString : "+ toHexString(mac.doFinal(data.getBytes())));
	    return toHexString(mac.doFinal(data.getBytes()));
	  }
	  

}
