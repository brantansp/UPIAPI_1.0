package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.awt.print.Printable;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.Properties;

import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.Report;
import mBankingUtilityCenter.XMLBuilder;
import mBankingUtilityCenter.Db;

import org.testng.annotations.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class test extends ExtentManager {
	private static String response;
	static HttpConnect obj=new HttpConnect();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	protected static Properties prop=getProperty();
	public static Properties dbprop;
	public static String rrn;
	private static String dbResult[];
	private static String dbReport= "Y";
	static String txnid = null;
	static String accno = null;
	static String viraddr = null;
	static String pin=null;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	

	/*@Test(priority = 0)
	public static void AddBank() throws IOException, SQLException {
		response = postXML(XMLBuilder.CollectMoneyUNBI());
		String RRN = response.substring(response.lastIndexOf("<java:TxnId>")+12 , response.lastIndexOf("</java:TxnId>"));
		System.out.println(RRN);
		response = postXML(XMLBuilder.ConfirmCollectMoneyUNBI(RRN));	
	}*/
	
	public static void main(String[] args) {
		try {
			response = HttpConnect.postXML(XMLBuilder.AddBank());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bankid = response.substring(response.lastIndexOf("<java:BankName>")+36, response.lastIndexOf("</java:BankName>"));		
		try {
			response = postXML(XMLBuilder.ViewRegAccnts(bankid));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
		try {
			response = postXML(XMLBuilder.RegisterAcc(accno));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
/*		
		try {
			response = postXML(XMLBuilder.CollectMoneyUNBI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String RRN = response.substring(response.lastIndexOf("<java:TxnId>")+12 , response.lastIndexOf("</java:TxnId>"));
		System.out.println(RRN);
		try {
			response = postXML(XMLBuilder.ConfirmCollectMoneyUNBI(RRN));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
}
















