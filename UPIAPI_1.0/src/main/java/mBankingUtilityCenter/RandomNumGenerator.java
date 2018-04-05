package mBankingUtilityCenter;

import java.util.Random;
import java.math.BigInteger;


public class RandomNumGenerator {
	//static BigInteger randNum  = new BigInteger(53, new Random());
	static BigInteger randNum;
	public static BigInteger generate()
	{
	    randNum  = new BigInteger(53, new Random());
		if (lengthCheck(randNum)) 
		{
			generate();
		}
		return randNum;
	}
	
	public static boolean lengthCheck(BigInteger randNum)
	{
		boolean flag =false;
		if (randNum.toString().length() != 16) 
		{
			flag = true;
		}
		return flag;
	}
}










