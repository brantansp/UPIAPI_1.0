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


/**
 * 
 * @author brantansp
 *
 */

public class Transactions extends ExtentManager{
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
	public static void AddBank() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.AddBank());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		
	}
	
	@Test
	public static void ListBankAcc() throws IOException, SQLException {
		response = postXML(XMLBuilder.ListBankAcc(accno));
		if(dbReport=="Y")
		{
			Report.write(Db.fetchTxn(getTranID(response)));
		}
		assertTrue (getResCode(response).contains("000"));
	}


	@Test
	public static void RegisterAcc() throws IOException, SQLException {
	response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void ConfirmCollectMoney() throws IOException, SQLException {
		response = postXML(XMLBuilder.ConfirmCollectMoney(txnid));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void listpendingapproval() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.listpendingapproval());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void GenerateVirAddr() throws IOException, SQLException {
		

		response = postXML(XMLBuilder.GenerateVirAddr(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void ViewRegAccnts() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ViewRegAccnts());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void ChangePin() throws IOException,SQLException{
		response = postXML(XMLBuilder.ChangePin(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}	
	
	@Test
	public static void GenerateBankOTP() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.GenerateBankOTP(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void MobBankRegistration() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.MobBankRegistration(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void ReqValAddress() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void CollectMoney() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void RemoveRegVirAddr() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.RemoveRegVirAddr(viraddr));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void RemoveRegBankAcc() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.RemoveRegBankAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
		
	@Test
	public static void ListRegPayee() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ListRegPayee());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));

	}
	@Test
	public static void BalanceInq() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.BalanceInq(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	
	@Test
	public static void CheckTxnStatus() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.CheckTxnStatus(txnid));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	

	@Test
	public static void RegisterPayee() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.RegisterPayee());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void TxnList() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.TxnList());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	@Test
	public static void ViewRegVirAddr() throws IOException, SQLException {
		
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}
	
	
@Test
public static void AddBankTransactionPositiveFlow() throws IOException,SQLException{
			
			response = HttpConnect.postXML(XMLBuilder.AddBank());
			if (response.contains("000")) // check for element to present
			{
			String bankid = response.substring(response.lastIndexOf("<BankId>")+8, response.lastIndexOf("</BankId>"));		
			response = postXML(XMLBuilder.ViewRegAccnts(bankid));
			String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
			response = postXML(XMLBuilder.RegisterAcc(accno));
     		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
			}
	}

@Test(dependsOnMethods= ("AddBankTransactionPositiveFlow"))
public static void AddBankTransactionExistingAccount() throws IOException,SQLException{
			
	response = HttpConnect.postXML(XMLBuilder.AddBank());

	if (response.contains("000")) // check for element to present
	{
	String bankname = response.substring(response.lastIndexOf("<java:BankName>")+8, response.lastIndexOf("|"));		
		response = postXML(XMLBuilder.ListBankAcc("United Bank of India"));
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+7, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.RegisterAcc(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	}

	}

@Test
public static void AddBankTransactionWithInvalidAccNo() throws IOException,SQLException{
			
			response = HttpConnect.postXML(XMLBuilder.AddBank());
			if (response.contains("000")) // check for element to present
			{
			String bankid = response.substring(response.lastIndexOf("<BankId>")+8, response.lastIndexOf("</BankId>"));		
			response = postXML(XMLBuilder.ViewRegAccnts(bankid));
		//	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
			response = postXML(XMLBuilder.RegisterAcc(prop.getProperty("InvAccNo")));
     		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
			}
	}


@Test
public static void AddVPATransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
		response = postXML(XMLBuilder.GenerateVirAddr("0001000109354382"));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}


@Test(dependsOnMethods= ("AddVPATransactionPositiveFlow"))
public static void AddVPATransactionAddingExistingVPA() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.GenerateVirAddr(prop.getProperty("Accno1")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void SetUPIPinTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.MobBankRegistration(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}


@Test
public static void SetUPIPinTransactionwithInvalidCardDetails() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.GenerateBankOTP(accno));
	response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("Invcard"),prop.getProperty("Invexpiry")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}
	
@Test
public static void SetUPIPinTransactionwithInvalidOTP() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.GenerateBankOTP(accno));
	response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("InvOTP")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void SetUPIPinTransactionwithExpiredOTP() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.GenerateBankOTP(accno));
	response = postXML(XMLBuilder.MobBankRegistration(prop.getProperty("OTP")));
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}


@Test
public static void ManageAccountTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.RemoveRegBankAcc(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
			
}
@Test(priority = 0)
public static void ChangeUPIPinTransactionPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
	response = postXML(XMLBuilder.ChangePin(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}

@Test
public static void ChangeUPIPinTransactionPinNotSetToAccount() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
	response = postXML(XMLBuilder.ChangePin(accno,prop.getProperty("EmptyPin")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}

@Test
public static void ChangeUPIPinTransactionInvalidPin() throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<PayerAccNo>")+7, response.lastIndexOf("</PayerAccNo>"));
	response = postXML(XMLBuilder.ChangePin(accno,prop.getProperty("InvPin")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}

@Test
public static void ParticipantsTransactionPositiveFlowWithVPA() throws IOException,SQLException{
	response = postXML(XMLBuilder.RegisterPayee());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
}


@Test(dependsOnMethods= ("ParticipantsTransactionPositiveFlow"))
public static void ParticipantsTransactionExistingNickname() throws IOException,SQLException{
	response = postXML(XMLBuilder.RegisterPayee());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
}


@Test
public static void ParticipantsTransactionInvalidPayeeDetails() throws IOException,SQLException{
	response = postXML(XMLBuilder.RegisterPayee(prop.getProperty("InvPayeeNickName"),prop.getProperty("InvPayeeVirAddr")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
}

@Test
public static void ParticipantsTransactionPositiveFlowWithAccountNo() throws IOException,SQLException{
	response = postXML(XMLBuilder.RegisterPayeeAcc());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
}


@Test
public static void ParticipantsTransactionInvalidPayeeAccountDetails() throws IOException,SQLException{
	response = postXML(XMLBuilder.RegisterPayee(prop.getProperty("InvPayeeAccNo"),prop.getProperty("InvPayeeIFSCCode")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));	
}

@Test
public static void BalanceEnquiryTransactionPositiveFlow()throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.BalanceInq("0389010344822"));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void BalanceEnquiryTransactionPinIsNotSetToAccount()throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.BalanceInq(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void BalanceEnquiryTransactionInvalidPin()throws IOException,SQLException{
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo>")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.BalanceInq(accno));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}



@Test
public static void SendMoneyTransactionPositiveFlowONUSWithVPA()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
	response = postXML(XMLBuilder.ReqValAddress(viraddr));
	response = postXML(XMLBuilder.sendmoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}


@Test
public static void SendMoneyTransactionPositiveFlowONUSWithAcc()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
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
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
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
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvVPA")));
	response = postXML(XMLBuilder.sendmoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void SendMoneyTransactionONUSWithInvalidPin()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
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
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
	response = postXML(XMLBuilder.ReqValAddress(viraddr));
	response = postXML(XMLBuilder.sendmoney(prop.getProperty("NoPin")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}



/*@Test
public static void SendMoneyTransactionPositiveFlowONUSWithAccountNo()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	response = postXML(XMLBuilder.sendmoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}*/

@Test
public static void SendMoneyTransactionPositiveFlowOFFUSwithVPA()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
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
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	response = postXML(XMLBuilder.ReqValAddress(prop.getProperty("InvVPA")));
	response = postXML(XMLBuilder.sendmoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void SendMoneyTransactionOFFUSWithInvalidPin()throws IOException,SQLException{
	
	response = postXML(XMLBuilder.ViewRegAccnts());
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
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
	String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
	response = postXML(XMLBuilder.ViewRegVirAddr(accno));
	response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
	response = postXML(XMLBuilder.ReqValAddress(viraddr));
	response = postXML(XMLBuilder.sendmoney(prop.getProperty("NoPin")));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
}


@Test
public static void CollectMoneyTransactionPositiveFlowONUSwithVPA()throws IOException,SQLException{
	response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
	response = postXML(XMLBuilder.ReqValAddress(viraddr));
	response = postXML(XMLBuilder.CollectMoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void CollectMoneyTransactionPositiveFlowONUSwithAcc()throws IOException,SQLException{
	response = postXML(XMLBuilder.ListRegPayee());
	String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
	response = postXML(XMLBuilder.ReqValAddress(viraddr));
	response = postXML(XMLBuilder.CollectMoney());
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
}

@Test
public static void CollectMoneyTransactionPositiveFlowONUSwithAadhar()throws IOException,SQLException{
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

@Test
public static void TransactionStatusPositiveFlow() throws IOException,SQLException{
	response = postXML(XMLBuilder.TxnList());
	String txnid = response.substring(response.lastIndexOf("<OrgTxnId ")+10, response.lastIndexOf("</OrgTxnId>"));
	response = postXML(XMLBuilder.CheckTxnStatus(txnid));
	assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
	
	
}



	public static void main(String[] args) {

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
		}
		
		/*response = postXML(XMLBuilder.AddBank());
		if(true)
		{
			dbResult = Db.fetchTxn(rrn);
			System.out.println("DB Result : "+dbResult);
			Report.write( dbResult);
		}		
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));*/


		/*response = postXML(XMLBuilder.ViewRegAccnts());
		//String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
		String accno = getResCode(response);
		log.info("log info print : "+accno);
		*/
		/*response = postXML(XMLBuilder.MobBankRegistration(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
*/		//test 

		
	/*	response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
		response = postXML(XMLBuilder.BalanceInq(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("999"));
	*/	
		/*response = postXML(XMLBuilder.ListRegPayee());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		*/
		
		/*response = postXML(XMLBuilder.ViewRegAccnts());
		//String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
		String accno = getResCode(response);
		log.info("log info print : "+accno);
		
		response = postXML(XMLBuilder.GenerateVirAddr(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		*/
		
		/*response = postXML(XMLBuilder.TxnList());
		//String txnid = response.substring(response.lastIndexOf("<OrgTxnId ")+11, response.lastIndexOf("</OrgTxnId>"));
		String txnid = getResCode(response);
		log.info("log info print : "+txnid);
		
		response = postXML(XMLBuilder.CheckTxnStatus(txnid));

		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
*/
		

		/*response = postXML(XMLBuilder.ViewRegAccnts());
		//String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
		String accno = getResCode(response);
		log.info("log info print : "+accno);
		response = postXML(XMLBuilder.ViewRegVirAddr(accno));
		response = postXML(XMLBuilder.ListRegPayee());
		//String viraddr = response.substring(response.lastIndexOf("<PayeeVirAddr ")+14, response.lastIndexOf("</PayeeVirAddr>"));
		String viraddr = getResCode(response);
		log.info("log info print : "+viraddr);	
		response = postXML(XMLBuilder.ReqValAddress(viraddr));
		response = postXML(XMLBuilder.sendmoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
		*/
		/*response = postXML(XMLBuilder.CollectMoney());
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));
*/
	/*	response = postXML(XMLBuilder.ViewRegAccnts());
		String accno = response.substring(response.lastIndexOf("<AccNo ")+7, response.lastIndexOf("</AccNo>"));
		response = postXML(XMLBuilder.GenerateVirAddr(accno));
		assertTrue (response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>")).contains("000"));*/
		
	}

	}















