package mBankingControlCenter;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.*;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class FundTransferTransactions extends ExtentManager {
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();
	static Properties prop=getProperty();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	public static void main(String[] args) {

		
		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
 				prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
 		try {
			response =sendReq(request, "m2m Quick FT");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}	
	
	/*
	 * M2M
	 */

   @Test(priority=1)
	public void m2mQuickFT() throws IOException, SQLException {
		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m Quick FT");
		assertResponse(response);
	}
   
   
   @Test(priority=2)
	public void m2mBenRegAcclist() throws IOException, SQLException {
		request = StaticStore.m2mBenRegAcclist(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m Benificiary Account list");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void m2mBenReg() throws IOException, SQLException {
		request = StaticStore.m2mBenReg(prop.getProperty("BenMobileNo"), 
				prop.getProperty("FTBenNickName"), prop.getProperty("BenAccNo"));
		response =sendReq(request, "m2m Benificiary Registration");
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void m2mPaybensearch() throws IOException, SQLException {
		request = StaticStore.m2mPaybensearch();
		response =sendReq(request, "m2m Register benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void m2mbenpayment() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m benificiary payment");
		assertResponse(response);
	}
	
	
	@Test(priority=6)
	public void m2mBenSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch("");
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void m2mBenSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbensearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m benificiary search");
		assertResponse(response);
	}
	
	
	@Test(priority=8)
	public void m2mBenDelSearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch("");
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void m2mBenDelSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m benificiary delete search");
		assertResponse(response);
	}
	
	@Test(priority=10)
	public void m2mBenDelete() throws IOException, SQLException {
		request = StaticStore.m2mbenedelete(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "M2M benificiary delete");
		assertResponse(response);
	}
	
	@Test(priority=11)
 	public void m2mQuickFTBenificiaryNotRegForMobileBanking() throws IOException, SQLException {
 		request = StaticStore.m2mQuickFT(prop.getProperty("NotregBenMobileNo"), 
 				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
 		response =sendReq(request, "m2m Quick FT Benificiary Not Registered For Mobile Banking");
		assertTrue(response.substring(2,4).contains("09"));

 	}
   
   @Test(priority=12)
  	public void m2mQuickFTInsufficientAmount() throws IOException, SQLException {
  		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
  				prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
  		response =sendReq(request, "m2m Quick FT Insufficient Amount");
		assertTrue(response.substring(2,4).contains("20"));

  	}
	
   @Test(priority=13)
 	public void m2mQuickFTAmountExceedsLimit() throws IOException, SQLException {
 		request = StaticStore.m2mQuickFT(prop.getProperty("BenMobileNo"), 
 				prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
 		response =sendReq(request, "m2m Quick FT Amount Exceeds Limit");
		assertTrue(response.substring(2,4).contains("21"));

 	}

   @Test(priority=14)
  	public void m2mBenRegAcclistForRandomMobileNo() throws IOException, SQLException {
  		request = StaticStore.m2mBenRegAcclist(prop.getProperty("NotregBenMobileNo"), 
  				prop.getProperty("FTBenNickName"));
  		response =sendReq(request, "m2m Ben Reg Acclist For Random Mobile No");
  		assertResponse(response);
  	}
   
   @Test(priority=15)
	public void m2mbenpaymentExceedTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m ben payment Exceed Transaction Amount");
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(priority=16)
	public void m2mbenpaymentInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2mbenpayment(prop.getProperty("FTBenNickName"), 
		prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2m ben payment Insufficient Amount");
	//	assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));

	}
	
	@Test(priority=17)
	public void m2mBenDelSameBenSearchWKw() throws IOException, SQLException {
		request = StaticStore.m2mbendelsearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2m Ben Del Same Ben SearchWKw");
		assertResponse(response);
	}
	
	/*
	 * M2A
	 */
	
	@Test(priority=51)
	public void m2aQuickFT() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("WtFTAmount"));
		response =sendReq(request, "P2A Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=52)
	public void m2aBenRegSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenRegSearch(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificary registration search");
		assertResponse(response);
	}
	
	@Test(priority=53)
	public void m2aBenReg() throws IOException, SQLException {
		request = StaticStore.m2abenreg(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary req");
		assertResponse(response);
	}
	
	@Test(priority=54)
	public void m2aBenPaymentSearch() throws IOException, SQLException {
		request = StaticStore.m2aBenPaySearch();
		response =sendReq(request, "m2a benificiary payment search");
		assertResponse(response);
	}
	
	@Test(priority=55)
	public void m2aBenPayment() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("WtFTAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2a benificiary payment");
		assertResponse(response);
	}
	
	@Test(priority=56)
	public void m2abendetailsWoKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails("");
		response =sendReq(request, "m2a benificiary details Without Keyword");
		assertResponse(response);
	}
	
	@Test(priority=57)
	public void m2abendetailsWKw() throws IOException, SQLException {
		request = StaticStore.m2abendetails(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary details With Keyword");
		assertResponse(response);
	}
	
	@Test(priority=58)
	public void m2abenderegsearchWoKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch("");
		response =sendReq(request, "m2a benificiary deregistration search without keyword");
		assertResponse(response);
	}
	
	@Test(priority=59)
	public void m2abenderegsearchWKw() throws IOException, SQLException {
		request = StaticStore.m2aBenDeregSearch(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	@Test(priority=60)
	public void m2aBenDereg() throws IOException, SQLException {
		request = StaticStore.m2aBenDereg(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a benificiary deregistration search with keyword");
		assertResponse(response);
	}
	
	@Test(priority=61)
	public void m2aQuickFTRandomBenAccount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("InvalidBenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("WtFTAmount"));
		response =sendReq(request, "m2a Quick FT Random Ben Account");
		assertResponse(response);
	}
	
	@Test(priority=62)
	public void m2aQuickFTExceedsTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("ExceededAmount"));
		response =sendReq(request, "m2a Quick FT Exceeds Transaction Amount");
		assertTrue(response.substring(2,4).contains("21"));

		//assertResponse(response);
	}
	
	@Test(priority=63)
	public void m2aQuickFTInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2aQuickFT(prop.getProperty("BenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("InsufficientAmount"));
		response =sendReq(request, "m2a QuickFT Insufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(priority=64)
	public void m2aBenRegWithRandomBenAccount() throws IOException, SQLException {
		request = StaticStore.m2abenreg(prop.getProperty("RandomBenAccNo"), 
				prop.getProperty("BenAccTypeFT"), prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a Ben Reg With Random Ben Account");
		assertResponse(response);
	}
	
	@Test(priority=65)
	public void m2aBenPaymentExceedTransactionAmount() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("ExceededAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2a Ben Payment Exceed Transaction Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));
	}
	
	@Test(priority=66)
	public void m2aBenPaymentInSufficientAmount() throws IOException, SQLException {
		request = StaticStore.m2aBenPay(prop.getProperty("FTBenNickName"), 
				prop.getProperty("InsufficientAmount"), prop.getProperty("FTRemarks"));
		response =sendReq(request, "m2a Ben Payment InSufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(priority=67)
	public void m2aBenDeregSameBen() throws IOException, SQLException {
		request = StaticStore.m2aBenDereg(prop.getProperty("FTBenNickName"));
		response =sendReq(request, "m2a Ben De-register Same Ben");
		assertResponse(response);
	}
	

	/*
	 * NEFT
	 */
	
	//@Test(priority=101)  Not available in TMB
	public void NEFTQuickFT() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT(prop.getProperty("BenAccountno"), prop.getProperty("AccountType"),
				prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"), 
				prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT Quick FT");
		assertResponse(response);
	}
	
	@Test(priority=102)
	public void NEFTbenreg() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary registration");
		assertResponse(response);
	}
	
	
	@Test(priority=103)
	public void NEFTbenregconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("BenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary registration confirm");
		assertResponse(response);
	}

	
	@Test(priority=104)
	public void NEFTbenlist() throws IOException, SQLException {
		request = StaticStore.NEFTbenlist();
		response =sendReq(request, "NEFT benificiary list");
		assertResponse(response);
	}
	
	@Test(priority=105)
	public void NEFTbenpayment() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("NeftAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT benificiary payment");
		assertResponse(response);
	}
	
	
	@Test(priority=106)
	public void NEFTbendetail() throws IOException, SQLException {
		request = StaticStore.NEFTbendetail(prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary detail");
		assertResponse(response);
	}
	
	@Test(priority=107)
	public void NEFTbendereglist() throws IOException, SQLException {
		request = StaticStore.NEFTbendereglist("");
		response =sendReq(request, "NEFT benificiary de-registration list");
		assertResponse(response);
	}
	
	@Test(priority=108)
	public void NEFTbenderegconfirm() throws IOException, SQLException {
		request = StaticStore.NEFTbenderegconfirm(prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT benificiary de-registration confirm");
		assertResponse(response);
	}
	
	@Test(priority=109)
	public void NEFTQuickFTWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTQuickFT(prop.getProperty("BenAccountno"), prop.getProperty("AccountType"),
				prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"), 
				prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT Quick FT With Invalid IFSC code");
		assertResponse(response);
		
	}
	
	@Test(priority=110)
	public void NEFTbenregWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTbenreg(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT ben reg With Invalid IFSC code");
		assertResponse(response);
	}
	
	@Test(priority=111)
	public void NEFTbenregconfirmWithInvalidIFSCcode() throws IOException, SQLException {
		request = StaticStore.NEFTbenregconfirm(prop.getProperty("BenAccountno"), 
				prop.getProperty("AccountType"), prop.getProperty("InvalidBenIFSCcode"), prop.getProperty("BenNickName"));
		response =sendReq(request, "NEFT ben reg confirm With Invalid IFSC code");
		assertResponse(response);
	}

	@Test(priority=112)
	public void NEFTbenpaymentWithExceededAmount() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("ExceededAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT ben payment With Exceeded Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("21"));

	}
	
	@Test(priority=113)
	public void NEFTbenpaymentWithInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("InsufficientAmount"),
				prop.getProperty("BenNickName") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFT ben payment With Insufficient Amount");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("20"));

	}
	
	@Test(priority=114)
	public void NEFTbenpaymentWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.NEFTbenpayment(prop.getProperty("NeftAmount"),
				prop.getProperty("RandomNickname") , prop.getProperty("NeftRemarks"));
		response =sendReq(request, "NEFTbenpaymentWithRandomNickname");
		assertResponse(response);
	}
	
}
