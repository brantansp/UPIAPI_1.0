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

public class FinancialTransactions extends ExtentManager{
	
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
	
	//1.Send Money
	@Test
	public static void SendMoneyTransactionPositiveFlowONUSWithVPA()throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	if (response.contains("000")) // check for element to present
	{
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr("0389010344822"));
		response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<java:VirAddr>")+14, response.lastIndexOf("</java:VirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress("12345@utbi"));
		response = postXML(XMLBuilder.sendmoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	}
	
	@Test
	public static void SendMoneyTransactionPositiveFlowONUSWithAcc()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void SendMoneyTransactionPositiveFlowONUSWithAadhar()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	
	


	@Test
	public static void SendMoneyTransactionONUSWithInvalidVPA()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvVPA")));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void SendMoneyTransactionONUSWithInvalidPin()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney(prop.getProperty("InvPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void SendMoneyTransactionONUSPinIsNotSet()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney(prop.getProperty("NoPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void SendMoneyTransactionPositiveFlowOFFUSwithVPA()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
	}

	@Test
	public static void SendMoneyTransactionOFFUSWithInvalidVPA()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvVPA")));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void SendMoneyTransactionOFFUSWithInvalidPin()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney(prop.getProperty("InvPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void SendMoneyTransactionOFFUSPinIsNotSet()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney(prop.getProperty("NoPin")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}


	//2.Collect Money
	
	@Test
	public static void CollectMoneyTransactionPositiveFlowONUSwithVPA()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	
	@Test
	public static void CollectMoneyTransactionONUSInvalidVPA()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		//String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvPayeeVPA")));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void CollectMoneyTransactionONUSInvalidPin()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}


	@Test
	public static void CollectMoneyTransactionPositiveFlowOFFUS()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}



	@Test
	public static void CollectMoneyTransactionOFFUSInvalidVPA()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		//String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvPayeeVPA")));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	@Test
	public static void CollectMoneyTransactionOFFUSInvalidPin()throws IOException,SQLException{
		response = postXML(XMLBuilder.ListRegPayee());
		String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}

	//3.Pending Approval
	
	@Test(dependsOnMethods={"CollectMoneyTransactionPositiveFlowONUS" , "CollectMoneyTransactionPositiveFlowOFFUS"})
	public static void PendingApprovalTransactionPositiveFlow()throws IOException,SQLException{
		
		response = postXML(XMLBuilder.listpendingapproval());
		String txnid = response.substring(response.lastIndexOf("<PenTxnId ")+11, response.lastIndexOf("</PenTxnId>"));
		response = postXML(XMLBuilder.ConfirmCollectMoney(txnid));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
		
	}

	@Test(dependsOnMethods={"CollectMoneyTransactionPositiveFlowONUS" , "CollectMoneyTransactionPositiveFlowOFFUS"})
	public static void PendingApprovalTransactionDecline()throws IOException,SQLException{
		response = postXML(XMLBuilder.listpendingapproval());
		//String txnid = response.substring(response.lastIndexOf("<PenTxnId ")+11, response.lastIndexOf("</PenTxnId>"));
		response = postXML(XMLBuilder.ConfirmCollectMoney(prop.getProperty("InvCollectOption")));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
		
	}

	

}
