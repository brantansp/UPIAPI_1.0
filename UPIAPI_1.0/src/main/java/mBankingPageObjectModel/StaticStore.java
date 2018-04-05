package mBankingPageObjectModel;

import java.util.Properties;

import mBankingUtilityCenter.ExcelReader;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.RandomNumGenerator;

public class StaticStore extends ExtentManager{
	
	static StringBuilder sb = new StringBuilder() ;
	static Properties prop=getProperty();
	
	public static void main(String[] args) 
	{
		System.out.println(prop.getProperty("RemAccountno")+";");
		
	}
	
	public static String SilentSms (String imei, String randNum)   
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APMN;");
		sb.append("BVD:");
		sb.append("4.3.12%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus%23"+imei+"%23"+randNum+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String SilentSms2(String imei, String randNum)   //request with #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APMN;");
		sb.append("BVD:");
		sb.append("4.3.12#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#"+imei+"#"+randNum+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	/*
	 * Pre-Login
	 */
	
	public static String buildActivation ()   //request with %23 instead of #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APNA;");
		sb.append("BVD:");
		sb.append("4.0.9%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus;");
		sb.append("187130741006119135681847934352771245371;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String buildActivation2 ()   //request with %23 instead of #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APNA;");
		sb.append("BVD:");
		sb.append("4.0.9#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus;");
		sb.append("187130741006119135681847934352771245371;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//9894060407APCG;BVD:4.0.1#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus;463795;123457;4.0;0;191490637757208275427826874468706462063
	public static String GPRSCheckNew ()   //request with %23 instead of #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APCG;");
		sb.append("BVD:");
		sb.append("4.0.9%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String GPRSCheckNew2 ()   //request with %23 instead of #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APCG;");
		sb.append("BVD:");
		sb.append("4.0.9#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//Products > Offers > 
	//9894060407AP2O;N;001;463795;123457;4.0;0;52665709985089953900417908053905542595
	public static String productOfferLeg2 ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP2O;");
		sb.append("N;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}

	//9894060407AP3O;N;Mobile;001;463795;123457;4.0;0;174913281654798569843261100464854016811
	public static String productOfferLeg3 (String x)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP3O;");
		sb.append("N;");
		sb.append(x+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//9894060407AP4O;N;Mobile;Android;001;463795;123457;4.0;0;110222342128744644883790662370907286359
	public static String productOfferLeg4 (String x, String y)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP4O;");
		sb.append("N;");
		sb.append(x+";");
		sb.append(y+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	
	//9894060407AP5O;N;Mobile;Android;86;463795;123457;4.0;0;42364739127431391956066789844763901389
	public static String productOfferLeg5 (String x, String y, String z)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5O;");
		sb.append("N;");
		sb.append(x+";");
		sb.append(y+";");
		sb.append(z+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//Loan
	//9894060407APLR;N;100;10;12;2;463795;123457;4.0;0;28396647691290863989616373173741955642
	public static String Loan (String x, String y, String z, String k)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APLR;");
		sb.append("N;");
		sb.append(x+";");
		sb.append(y+";");
		sb.append(z+";");
		sb.append(k+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//version update
	//9894060407APBV;N;4.1.16;ARD;504511;123457;4.0;0;1522735794546
	public static String versionUpgrade (String currVersion)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APBV;");
		sb.append("N;");
		sb.append(currVersion+";");
		sb.append("ARD;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//ATM loc uusing PIN
	//	APAL;N;P;635851; ;001;504511;123457;4.0;0;9894060407
	public static String ATMPinSearch (String pincode, String mpin)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APAL;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(mpin+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("P;");
		sb.append(pincode+";");
		sb.append(" ;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//9894060407APAL;N;L;ch; ;001;504511;123457;4.0;0;1522736449475
	public static String ATMLocationSearch (String location)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APAL;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("L;");
		sb.append(location+";");
		sb.append(" ;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//branch loc
	//9894060407AP1L;N;P;635851; ;001;504511;123457;4.0;0;1522736556357
	//9894060407AP1L;N;L;ch; ;001;504511;123457;4.0;0;1522736596103	Y	-	null
	//9894060407AP1L;N;L;ch; ;21;504511;123457;4.0;0;1522736677425
	public static String BranchPinSearch (String pincode)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP1L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("P;");
		sb.append(pincode+";");
		sb.append(" ;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String BranchLocationSearch (String location)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP1L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("L;");
		sb.append(location+";");
		sb.append(" ;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//refer friend
	//9894060407APZ5;N;brantan;brantansp3EM*#L9fss.co.in;9047637908;463795;123457;4.0;0;156427595325614052516425771169862832947
	public static String referFriend (String name, String mailID, String mobNo)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APZ5;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(name+";");
		sb.append(mailID+";");
		sb.append(mobNo+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//Feedback
	//9894060407AP1F;N;001;463795;123457;4.0;0;193642678486689309906116376043656160964
	public static String feedbackleg1 ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP1F;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//9894060407AP2F;N;90*1#91*1#110*1#150*1;test;463795;123457;4.0;0;179037572733429785283578924912205114102
	public static String feedbackleg2 ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP2F;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("90*1%2391*1%23110*1%23150*1;");
		sb.append("test;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String feedbackleg2_ ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP2F;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("90*1#91*1#110*1#150*1;");
		sb.append("test;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//Forgot password
	//9894060407APOG;463795;123457;4.0;0;114708343457668991672203685532975502159  
	public static String OTPGeneration ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APOG;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//9894060407APOV;69349112813202152646087269368538447620;463795;123457;4.0;0;26000064459182838061035821015230919775
	public static String OTPVerification(String encPin)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APOV;");
		sb.append(encPin+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
		//9894060407APP3;Y;193236764614536154242346493710901391873;463795;123457;4.0;0;41425399265261176686215331752420743641
	public static String loginmPinCheck(String mPIN)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APP3;");
		sb.append("Y;");
		sb.append(mPIN+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
		//9894060407APFN;BVD:4.0.1#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#864829030310400#1522737602321;463795;123457;4.0;0;171762895022425228530675880511995212845
	
	public static String loginNewPinSet (String imei, String randNum)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APFN;");
		sb.append("4.3.12%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus%23"+imei+"%23"+randNum+";");
		sb.append("test;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String loginNewPinSet_ (String imei, String randNum)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APFN;");
		sb.append("4.3.12#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#"+imei+"#"+randNum+";");
		sb.append("test;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	/*
	 * 
	 */
	
	//APGC;BVD:4.0.9#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#10.175.117.48#12.8354858,80.2235916;454545;123457;4.0.5;0;9894060407
	public static String GPRSCheck ()   //request with %23 instead of #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APGC;");
		sb.append("BVD:");
		sb.append("4.0.9%23ANDROID7.1.1%23H1920W1080%23LENOVO Lenovo K8 Plus%2310.175.117.48%2312.8354858%2C80.2235916%3B");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String GPRSCheck2()   //request with #
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APGC;");
		sb.append("BVD:");
		sb.append("4.0.9#ANDROID7.1.1#H1920W1080#LENOVO Lenovo K8 Plus#10.175.117.48#12.8354858,80.2235916;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	public static String balanceEnq (String remAccountno)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APBE;");
		if(prop.getProperty("mPINRequired").equals("Y"))
			
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(remAccountno+";");
		return sb.toString();
	}
	
	
	public static String balanceEnq ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APBE;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String miniStatement ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APMS;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String miniStatement (String remAccountno)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APMS;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(remAccountno+";");
		return sb.toString();
	}
	public static String transactionHistory ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APTH;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String generateMMID ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APIM;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String retrieveMMID ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APS6;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("RemAccountno")+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String cancelMMIDAll ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APRC;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("ALL;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String cancelMMIDSingle ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APRC;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("RemAccountno")+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String emailIDFetch ()
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APZ6;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String updateEmailID (String emailID)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APZ3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(emailID+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String chequeStatus (String chqNo)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APLW;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(chqNo+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String stopCheque (String chqNo)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APL4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(chqNo+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	// NA
	
	public static String Accountfetch ()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APSY;");
		if(prop.getProperty("bankCode").equals("454545"))
		{
		sb.append("0001;");
		}else
		{
		sb.append("2;");
		}
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	 //9894060407APP5;8609547570776098518502128580812621291;454545;123457;4.0.5;182058368413177886340199749077473758504
	public static String changeloginpwd (String newpassword)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APP5;");
		sb.append(newpassword+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append("0;");
		return sb.toString();
	}
	
	//Financial Transactions		
	//IMPS Instant Payment
	public static String impsP2PInstant (String benMobNo, String benMMID, String amount, String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APQI;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMobNo+";");
		sb.append(benMMID+";");
		sb.append(amount+";");
		sb.append(remark+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

    /*
     * IMPS P2P
     */
	
	public static String impsP2PAddBen ( String benMobNo,String benMMID, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW1;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMMID+";");
		sb.append(benMobNo+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2PConfBen ( String benMobNo,String benMMID, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW2;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benMMID+";");
		sb.append(benMobNo+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APD9;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PDelBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2PDelBenConf (String benName)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP5D;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2PPaySearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("P;");
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2PPayConf (String benName,String amount,String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APW4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(amount+";");
		sb.append(remark+ ";");
		sb.append(benName+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	/*
	 *  IMPS P2A
	 */
	
	public static String impsP2AInstant (String benAcNo, String benIFSC, String amount, String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK1;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benAcNo+";");
		sb.append(prop.getProperty("RemAccountType")+";");
		sb.append(benIFSC+";");
		sb.append(amount+";");
		sb.append(remark+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2AAddBen (String accNo,  String accType, String ifsccode, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK2;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(accNo+";");
		sb.append(accType+";");
		sb.append(ifsccode+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2AConfBen (String accNo,  String accType, String ifsccode, String nickname)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(accNo+";");
		sb.append(accType+";");
		sb.append(ifsccode+";");
		sb.append(nickname+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2ABenDetailSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP4W;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("1;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2ABenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APD9;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2ADelBenSearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP6L;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("1;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}

	public static String impsP2ADelBenConf (String benName)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP6D;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2APaySearch (String searchText)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK4;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(searchText+";");
		sb.append("1;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String impsP2APayConf (String benName,String amount,String remark)
	{
		sb.delete(0, sb.length());
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APK5;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(benName+";");
		sb.append(amount+";");
		sb.append(remark+ ";");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	/*
	 *  IMPS P2U
	 */
	
	public static String impsP2UInstant (String aadharNo,  String accType, String amount, String remark)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP1U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(aadharNo+";");
	sb.append(accType+";");
	sb.append(amount+";");
	sb.append(remark+";");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	public static String impsP2UAddBenPreConf (String aadharNo,  String accType, String nickname)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP2U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(aadharNo+";");
	sb.append(accType+";");
	sb.append(nickname+";");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
		
	public static String impsP2UAddBenConf (String aadharNo,  String accType, String nickname)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP3U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(aadharNo+";");
	sb.append(accType+";");
	sb.append(nickname+";");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	//AP4U;Y;15316170605690416310253121025515855714; ;001;463795;123457;4.0;2478623864983269;9894060407~MPAYMQ1~REQ~I~31/03/2018 12:54:42.948 ~
	
	public static String impsP2UBenPayListEnq(String searchText)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP4U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(searchText+";");
	sb.append("001;");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	//AP5U;Y;15316170605690416310253121025515855714;IMPSBenenficiary;10; ;463795;123457;4.0;2478623864983269;9894060407~MPAYMQ1~REQ~I~31/03/2018 12:54:50.066 ~
	
	public static String impsP2UBenPayConf(String BenName, String Amount, String remark)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP5U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(BenName+";");
	sb.append(Amount+";");
	sb.append(remark+";");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	//AP6U;Y;15316170605690416310253121025515855714; ;001;463795;123457;4.0;2478623864983269;9894060407~MPAYMQ1~REQ~I~31/03/2018 12:55:06.842 ~
	
	public static String impsP2UBenDetailsSearch(String searchtext)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP6U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(searchtext+";");
	sb.append("001;");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	//AP7U;Y;15316170605690416310253121025515855714; ;001;463795;123457;4.0;2478623864983269;9894060407~MPAYMQ1~REQ~I~31/03/2018 12:55:17.194 ~
	
	public static String impsP2UBenDelSearch(String searchtext)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP7U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(searchtext+";");
	sb.append("001;");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	//AP8U;Y;15316170605690416310253121025515855714;Ghhhh;463795;123457;4.0;2478623864983269;9894060407~MPAYMQ1~REQ~I~31/03/2018 12:55:20.547 ~
	
	public static String impsP2UBenDelConf(String benname)
    {
	sb.delete(0, sb.length());
	sb.append(prop.getProperty("RemMobileno"));
	sb.append("AP8U;");
	if(prop.getProperty("mPINRequired").equals("Y"))
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	sb.append(prop.getProperty("mPIN")+";");
	}
	else
	{
	sb.append(prop.getProperty("mPINRequired")+";");
	}
	sb.append(benname+";");
	sb.append(prop.getProperty("bankCode")+";");
	sb.append(prop.getProperty("DUKPT")+";");
	sb.append(prop.getProperty("buildVersion")+";");
	sb.append(prop.getProperty("RemAccountno")+";");
	return sb.toString();
    }
	
	// *** UNBI payments-Bill Pay ***//
	
	// *** Biller Registration ***//
	public static String Billercategorylist()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB2;");
        sb.append("P;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerlist(String Typeofbiller)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB9;");
		sb.append(Typeofbiller+";");
        sb.append("P;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerregisration(String Typeofbillerlist)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB3;");
		if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(Typeofbillerlist+";");
        sb.append("P;");
	    sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	public static String biilerregistrationconfirm (String Typeofbiller, String Typeofbillerlist, String Field1, String Field2, String Nickname	)
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APB4;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append(Typeofbiller+";");
	    sb.append(Typeofbillerlist+";");
	    sb.append("2;");
	    sb.append(Field1+":");
	    sb.append(Field2+";");
	    sb.append(Nickname+";");
	    sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	 
	
	// *** Registered Bill Payment ***//
	
	public static String Accountselectionbiilerlist()
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBX;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String biilerlistselection(String Registerdbiller1)
	{ 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBW;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String RegBillerpay(String Registerdbiller1)
	{
	 
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("AP1B;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("A;");
	    sb.append(Registerdbiller1+";");
	    sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String RegBillerpayconfirm(String Registerdbiller1, String Amount, String transactionId)
	{
		sb.delete(0, sb.length());
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APB6;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
	    sb.append("P;");
	    sb.append("5044821053000059;");
	    sb.append(Amount+";");
	    sb.append(transactionId+";");
		sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	// *** Biller Deregistration ***//
	
	public static String biilerderegselection()
	{
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBZ;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("001;");
        sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	public static String biilerderegister(String Registerdbiller1)
	{
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("APBY;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		sb.append(prop.getProperty("mPIN")+";");
		}
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append(Registerdbiller1+";");
        sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno")+";");
	    return sb.toString();
	}
	
	// *** Adhoc Bill Payment***//
	
	public static String AdHocBillercategorylist()
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APB2;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
        sb.append("A;");
		sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String AdHocbillerlist(String Typeofbiller)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDW;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbiller+";");
        sb.append("001;");
		sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String billerlistselection(String Typeofbillerlist)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDT;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbillerlist+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Adhocpayconfirm(String Typeofbillerlist, String Field1, String Field2, String Amount, String Transactionid	)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("APDM;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(Typeofbillerlist+";");
		sb.append(Field1+";");
		sb.append(Field2+";");
		sb.append(Amount+";");
		sb.append(Transactionid+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Rechargelist ()
	{
	   // sb.delete(0, sb.length());
		StringBuilder sb = new StringBuilder() ;
	    sb.append(prop.getProperty("RemMobileno"));
	    sb.append("AP2T;");
	    if(prop.getProperty("mPINRequired").equals("Y"))
	    {
	    sb.append(prop.getProperty("mPINRequired")+";");
	    sb.append(prop.getProperty("mPIN")+";");
	    }
		else
		{
		sb.append(prop.getProperty("mPINRequired")+";");
		}
	    sb.append("0001;");
	    sb.append(prop.getProperty("bankCode")+";");
	    sb.append(prop.getProperty("DUKPT")+";");
	    sb.append(prop.getProperty("buildVersion")+";");
	    sb.append(prop.getProperty("RemAccountno"));
	    return sb.toString();
	}
	
	public static String Operatorsearch(String TypeofRecharge, String searchfield1)
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP2T;");
		  if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(searchfield1+";");
	    sb.append("MTP:DTH:DTC;");
		sb.append("0001;");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String Rechargeconfirm(String TypeofRecharge, String searchresult, String RechargeMobNo,String RechargeAmount,String TransactionId )
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP3T;");
		  if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(searchresult+";");
		sb.append("O;");
		sb.append("MTP:DTH:DTC;");
		sb.append(RechargeMobNo+";");
		sb.append(RechargeAmount+";");
		sb.append(prop.getProperty("RechargeNickname")+";");
		sb.append(TransactionId+";");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	public static String RechargeStatusEnq(String TypeofRecharge, String TransactionId )
	{
		StringBuilder sb = new StringBuilder() ;
		sb.append(prop.getProperty("RemMobileno"));
		sb.append("AP7T;");
		 if(prop.getProperty("mPINRequired").equals("Y"))
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			sb.append(prop.getProperty("mPIN")+";");
			}
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		sb.append(TypeofRecharge+";");
		sb.append(TransactionId+";");
		sb.append("1;");
        sb.append(prop.getProperty("bankCode")+";");
		sb.append(prop.getProperty("DUKPT")+";");
		sb.append(prop.getProperty("buildVersion")+";");
		sb.append(prop.getProperty("RemAccountno")+";");
		return sb.toString();
	}
	
	//** Fund Transfer within bank **//
		// 
		public static String m2mQuickFT(String BenMobileNo,String Amount,String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQM;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(BenMobileNo+";");
			sb.append(Amount+";");
			sb.append(Remarks+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mBenRegAcclist(String BenMobileNo,String Nickname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APRM;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(BenMobileNo+";");
			sb.append(Nickname+";");
			sb.append("0001;");
			sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mBenReg(String BenMobileNo,String Nickname, String BenAccountno)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APC1;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(BenMobileNo+";");
			sb.append(Nickname+";");
			sb.append(BenAccountno+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		//APF1;Y;15316170605690416310253121025515855714;P;001;463795;123457;4.0;2478623864983269;9894060407
		public static String m2mPaybensearch()
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APF1;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append("P;");
			sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
       //APFT;Y;130924667927751279584590111688231373857?15316170605690416310253121025515855714;10;test;FTBeneficiary;463795;123457;4.0;2478623864983269;9894060407
		public static String m2mbenpayment(String Benregname, String Amount,String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APFT;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(Amount+";");
			sb.append(Remarks+";");
			sb.append(Benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbensearch(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APD5;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbendelsearch(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP2L;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2mbenedelete(String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP2D;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(Benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2aQuickFT(String BenAccountno,String AccountType,String Amount)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQT;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(BenAccountno+";");
	        sb.append(AccountType+";");
	        sb.append(Amount+";");
	        sb.append(prop.getProperty("FTRemarks")+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
	
		public static String m2aBenRegSearch(String BenAccountno,String AccountType, String Benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APRA;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(prop.getProperty("bankCode")+";");
	        sb.append(BenAccountno+";");
	        sb.append(AccountType+";");
	        sb.append(Benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2abenreg(String BenAccountno,String accountType,String benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APC2;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append(prop.getProperty("bankCode")+";");
		    sb.append(BenAccountno+";");
	        sb.append(accountType+";");
	        sb.append(benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2aBenPaySearch()
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APF2;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
			sb.append("F;");
			sb.append("001;");
			sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}

		public static String m2aBenPay(String benregname, String amount, String remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APFA;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(amount+";");
	        sb.append(remarks+";");
	        sb.append(benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		
		public static String m2abendetails(String searchtext)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APD6;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(searchtext+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}

		public static String m2aBenDeregSearch(String searchfield1)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP3L;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(searchfield1+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String m2aBenDereg(String benregname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP3D;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
	        sb.append(benregname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		//** need to add P2Abendereg **//
		
		//** Fund Transfer-otherbank NEFT**//
		public static String NEFTQuickFT(String benaccountno,String accounttype,String benIFSCcode,String benname, String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQN;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
		    sb.append(Remarks+";");
	        sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		
		public static String NEFTbenreg(String benaccountno,String accounttype,String benIFSCcode,String benname )
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ2;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenregconfirm(String benaccountno,String accounttype,String benIFSCcode,String benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ3;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(benaccountno+";");
		    sb.append(accounttype+";");
		    sb.append(benIFSCcode+";");
		    sb.append(benname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenlist()
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ7;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append("P;");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
		
		public static String NEFTbenpayment(String Amount,String Benname, String Remarks)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APQ8;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(Amount+";");
		    sb.append(Remarks+";");
		    sb.append(Benname+";");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
	
		public static String NEFTbendetail(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("APNL;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(Benname+";");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
	
		public static String NEFTbendereglist(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP4L;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(Benname+";");
		    sb.append("001;");
	        sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}
	
		
		public static String NEFTbenderegconfirm(String Benname)
		{
			StringBuilder sb = new StringBuilder() ;
			sb.append(prop.getProperty("RemMobileno"));
			sb.append("AP4D;");
			if(prop.getProperty("mPINRequired").equals("Y"))
		    {
		    sb.append(prop.getProperty("mPINRequired")+";");
		    sb.append(prop.getProperty("mPIN")+";");
		    }
			else
			{
			sb.append(prop.getProperty("mPINRequired")+";");
			}
		    sb.append(Benname+";");
		    sb.append(prop.getProperty("bankCode")+";");
			sb.append(prop.getProperty("DUKPT")+";");
			sb.append(prop.getProperty("buildVersion")+";");
			sb.append(prop.getProperty("RemAccountno")+";");
			return sb.toString();
		}


}
