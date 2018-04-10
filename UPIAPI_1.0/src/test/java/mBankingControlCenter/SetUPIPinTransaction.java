package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.XMLBuilder;

public class SetUPIPinTransaction extends ExtentManager{
	
	private static String response;
	static HttpConnect obj=new HttpConnect();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	protected static Properties prop = getProperty();
	public static Properties dbprop;
	public static String rrn;
	private static String dbResult[];
	private static String dbReport= "Y";
	static String txnid = null;
	static String accno = null;
	static String viraddr = null;
	static String pin=null;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	
	@Test
	public static void SetUPIPinTransactionPositiveFlow() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
				response = postXML(XMLBuilder.GenerateBankOTP("0389010344822"));
				response = postXML(XMLBuilder.MobBankRegistration("0389010344822"));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	}

	@Test
	public static void SetUPIPinTransactionwithInvalidCardDetails() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.GenerateBankOTP(accno));
		response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("Invcard"),prop.getProperty("Invexpiry")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		}
	}
		
	@Test
	public static void SetUPIPinTransactionwithInvalidOTP() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.GenerateBankOTP(accno));
		response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("InvOTP")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	}

	@Test
	public static void SetUPIPinTransactionwithExpiredOTP() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
			String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.GenerateBankOTP(accno));
		response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("OTP")));
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	}

	@Test
	public static void SetUPIPinTransactionwithBlockedAcc() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
			String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.GenerateBankOTP(prop.getProperty("BlockedAccount")));
		response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("OTP")));
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	}

	

}
