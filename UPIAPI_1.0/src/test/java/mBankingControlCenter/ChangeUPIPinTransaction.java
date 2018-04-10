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

public class ChangeUPIPinTransaction extends ExtentManager{
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
	
	
	@Test(priority = 0)
	public static void ChangeUPIPinTransactionPositiveFlow() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
		response = postXML(XMLBuilder.ChangePin(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	}

	@Test
	public static void ChangeUPIPinTransactionPinNotSetToAccount() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
		response = postXML(XMLBuilder.ChangePin(accno,prop.getProperty("EmptyPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	}

	@Test
	public static void ChangeUPIPinTransactionInvalidPin() throws IOException,SQLException{
		response = postXML(XMLBuilder.ViewRegAccnts());
		if (response.contains("000")) // check for element to present
		{
		String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
		response = postXML(XMLBuilder.ChangePin(accno,prop.getProperty("InvPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	}

	

}
