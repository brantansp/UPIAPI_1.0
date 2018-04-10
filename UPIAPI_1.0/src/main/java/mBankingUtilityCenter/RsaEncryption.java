package mBankingUtilityCenter;

import java.math.BigInteger;

public class RsaEncryption {
	
	private final static BigInteger one = new BigInteger("1");

	private BigInteger privateKey;

	private BigInteger publicKey;

	private BigInteger modulus;
        
        public String cipherText;

        public RsaEncryption(String pin,String modulus) {  
        	
		String publicKey = "65537";
		BigInteger encrypted = encrypt(new BigInteger(pin),
				new BigInteger(publicKey), new BigInteger(modulus));		
                cipherText = encrypted+"";
	}

	public BigInteger getPublicKey() {
		return this.publicKey;
	}

	public BigInteger getPrivateKey() {
		return this.privateKey;
	}

	public BigInteger getModulus() {
		return this.modulus;
	}

	public BigInteger encrypt(BigInteger message, BigInteger publicKey,
			BigInteger modulus) {
		return message.modPow(publicKey, modulus);
	}

	public static String encrypt(String pin)
	{//203577465141885203944391850079714410739
		RsaEncryption newEnc = new RsaEncryption(pin ,"146504016254942178571165737768179125693");
		//RSADecryptionNEW dec=new RSADecryptionNEW();
		 System.out.println(newEnc.cipherText);
		 return newEnc.cipherText;
	}
	
	public static String encrypt(String pin, String modulus)
	{//203577465141885203944391850079714410739
		RsaEncryption newEnc = new RsaEncryption(pin , modulus);
		//RSADecryptionNEW dec=new RSADecryptionNEW();
		 //System.out.println(newEnc.cipherText);
		 return newEnc.cipherText;
	}
	
	public static void main(String[] args) {
		//RsaEncryption newEnc = new RsaEncryption("1111","203577465141885203944391850079714410739");
		//RSADecryptionNEW dec=new RSADecryptionNEW();
		 System.out.println(encrypt("2580"));
		 System.out.println(encrypt("2222", "131309369321510784120473755170419681821"));
}
}
