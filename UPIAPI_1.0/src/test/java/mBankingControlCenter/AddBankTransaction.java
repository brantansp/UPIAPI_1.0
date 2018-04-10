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


public class AddBankTransaction extends ExtentManager{

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
	public static void AddBankTransactionONUSPositiveFlow() throws IOException,SQLException{
				
		response = HttpConnect.postXML(XMLBuilder.AddBank());
	if (response.contains("000")) // check for element to present
	{
	String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));		
			response = postXML(XMLBuilder.ListBankAcc("United Bank of India"));
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
			response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
		}
	
	@Test
	public static void AddBankTransactionOFFUSPositiveFlow() throws IOException,SQLException{
				
					response = HttpConnect.postXML(XMLBuilder.AddBank());
	if (response.contains("000")) // check for element to present
	{
	String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));		
			response = postXML(XMLBuilder.ListBankAcc("Vijaya Bank"));
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
			response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
		}
	

@Test(dependsOnMethods= ("AddBankTransactionONUSPositiveFlow"))
public static void AddBankTransactionONUSExistingAccount() throws IOException,SQLException{
	response = HttpConnect.postXML(XMLBuilder.AddBank());
	if (response.contains("000")) // check for element to present
	{
		String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));	
	response = postXML(XMLBuilder.ViewRegAccnts("Indian Bank"));
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
	response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
}


@Test
public static void AddBankTransactionONUSWithInvalidAccNo() throws IOException,SQLException{
	response = HttpConnect.postXML(XMLBuilder.AddBank());

	if (response.contains("000")) // check for element to present
	{
		String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));
		response = postXML(XMLBuilder.ListBankAcc("Indian Bank"));
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.RegisterAcc(prop.getProperty("InvAccNo")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}

}

@Test(dependsOnMethods= ("AddBankTransactionOFFUSPositiveFlow"))
public static void AddBankTransactionOFFUSExistingAccount() throws IOException,SQLException{
	response = HttpConnect.postXML(XMLBuilder.AddBank());

	if (response.contains("000")) // check for element to present
	{
		String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));
		response = postXML(XMLBuilder.ListBankAcc("Indian Bank"));
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}

	}


@Test
public static void AddBankTransactionOFFUSWithInvalidAccNo() throws IOException,SQLException{
	response = HttpConnect.postXML(XMLBuilder.AddBank());

	if (response.contains("000")) // check for element to present
	{
		String bankname = response.substring(response.lastIndexOf("<java:BankName>")+15, response.lastIndexOf("|"));
		response = postXML(XMLBuilder.ListBankAcc("Indian Bank"));
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.RegisterAcc(prop.getProperty("InvAccNo")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}

}



	
}
