package mBankingControlCenter;


import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import mBankingUtilityCenter.RandomNumGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonFinancialTransactions extends ExtentManager{
	private static String response;
	public static String request;
	public static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	@Test(priority=1)
	public void balanceEnqWithValidData() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq();
		response = sendReq (request, "Balance Enquiry");
		assertResponse(response);
	}
	

	@Test(priority=1)
	public void balanceEnqWithInvalidAccNo() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("invalidaccno"));
		response = sendReq (request, "Balance Enquiry");
		assertTrue(response.substring(2,4).contains("AF"));	
	}
	
	@Test(priority=2)
	public void MiniStatement() throws IOException, SQLException {
		request = StaticStore.miniStatement();
		response = sendReq (request, "Mini statement");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void TransactionHistory() throws IOException, SQLException {
		request = StaticStore.transactionHistory();
		response = sendReq (request, "Transaction History");
		assertResponse(response);
	}

	@Test(priority=4)
	public void GenerateMMID() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		response = sendReq (request, "Generate MMID");
		assertResponse(response);
	}

	@Test(priority=5)
	public void RetrieveMMID() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = sendReq (request, "Retrieve MMID");
		assertResponse(response);
	}

	@Test(priority=6)
	public void CancelMMIDAll() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		response = sendReq (request, "Cancel MMID All");
		assertResponse(response);
	}

	@Test(priority=7)
	public void CancelMMIDSingle() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID"); // calling generate MMID
		request = StaticStore.cancelMMIDSingle();
		response = sendReq (request, "Cancel MMID Single");
		assertResponse(response);
	}

	@Test(priority=8)
	public void EmailIDFetch() throws IOException, SQLException {
		request = StaticStore.emailIDFetch();
		response = sendReq (request, "Email ID fetch");
		assertResponse(response);
	}

	@Test(priority=9)
	public void EmailIDUpdate() throws IOException, SQLException {
		request = StaticStore.updateEmailID("abc@fss.com");
		response = sendReq (request, "Email ID Update");
		assertResponse(response);
	}

	@Test(priority=10)
	public void ChequeStatus() throws IOException, SQLException {
		request = StaticStore.chequeStatus("123456");
		response = sendReq (request, "Cheque status");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void StopCheque() throws IOException, SQLException {
		request = StaticStore.stopCheque("123456");
		response = sendReq (request, "Stop Cheque");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void Accountfetch() throws IOException, SQLException {
		request = StaticStore.Accountfetch();
		response = sendReq (request, "Account Fetch");
		assertResponse(response);
	}
	
	
	@Test(priority=12)
	public void changeloginpwd() throws IOException, SQLException {
		request = StaticStore.changeloginpwd("8609547570776098518502128580812621291");
		response = sendReq (request, "Change Login Password");
		assertResponse(response);
	}
	
	@Test(priority=13)
	public void balanceEnqWithClosedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("closedaccountno"));
		response = sendReq (request, "Balance Enquiry with closed Account");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void balanceEnqWithInactiveAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, "Balance Enquiry with Inactive Account");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void balanceEnqWithBlockedAccount() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("blockedaccountno"));
		response = sendReq (request, "Balance Enquiry with Blocked Account");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void balanceEnqForAccountHavingZeroBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Zerobalnacc"));
		response = sendReq (request, "Balance Enquiry For Account Having Zero Balance");
		assertResponse(response);
	}
	
	@Test(priority=17)
	public void balanceEnqForAccountHavingNegativeBalnc() throws IOException, SQLException
	{
		request = StaticStore.balanceEnq(prop.getProperty("Negbalnacc"));
		response = sendReq (request, "Balance Enquiry For Account Having Negative Balance");
		assertResponse(response);
	}
	
	
	@Test(priority=18)
	public void MiniStatementForClosedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("closedaccountno"));
		response = sendReq (request, "Mini statement For Closed Account");
		assertResponse(response);
	}
	
	@Test(priority=19)
	public void MiniStatementForinactiveAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("inactiveaccountno"));
		response = sendReq (request, "Mini statement For Inactive Account");
		assertResponse(response);
	}
	
	@Test(priority=20)
	public void MiniStatementForBlockedAccount() throws IOException, SQLException {
		request = StaticStore.miniStatement(prop.getProperty("blockedaccountno"));
		response = sendReq (request, "Mini Statement For Blocked Account");
		assertResponse(response);
	}
	
	
	@Test(priority=21)
	public void ChequeStatusCheckNotIssuedToCustomer() throws IOException, SQLException {
		request = StaticStore.chequeStatus(prop.getProperty("InvalidCheckNo"));
		response = sendReq (request, "Cheque Status Check Not Issued To Customer");
		assertResponse(response);
	}
	
	@Test(priority=22)
	public void StopChequeCheckAlreadyStopped() throws IOException, SQLException {
		request = StaticStore.stopCheque(prop.getProperty("CheckNo"));
		response = sendReq (request, "Stop Cheque Check Already Stopped");
		assertResponse(response);
	}
	
	@Test(priority=23)
	public void AgainCancelAllMMIDs() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Again Cancel All MMIDs"); // calling generate MMID
		request = StaticStore.cancelMMIDAll();
		request = StaticStore.cancelMMIDAll();
		response = sendReq (request, "Again Cancel All MMIDs");
		assertResponse(response);
	}
	
	@Test(priority=24)
	public void RetrieveMMIDs() throws IOException, SQLException {
		request = StaticStore.retrieveMMID();
		response = sendReq (request, "Retrieve MMID");
		assertResponse(response);
	}
	
	@Test(priority=25)
	public void GenerateMMIDs() throws IOException, SQLException {
		request = StaticStore.generateMMID();
		request = StaticStore.retrieveMMID();
		response = sendReq (request, "Generate MMID");
		assertResponse(response);
	}
	
	public static void main(String[] args) {		request = StaticStore.balanceEnq();
	try {
		response = sendReq (request, "Balance Enquiry");
	} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	assertResponse(response);}
	
}














