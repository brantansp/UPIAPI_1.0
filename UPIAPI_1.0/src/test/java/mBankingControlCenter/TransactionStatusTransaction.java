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

public class TransactionStatusTransaction extends ExtentManager{
	
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
	public static void TransactionStatusPositiveFlow() throws IOException,SQLException{
		response = postXML(XMLBuilder.TxnList());
		if (response.contains("000")) // check for element to present
		{
		String txnid = response.substring(response.lastIndexOf("<java:TxnId>")+12, response.lastIndexOf("</java:TxnId>"));
		response = postXML(XMLBuilder.CheckTxnStatus(txnid));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		}
	}

}
