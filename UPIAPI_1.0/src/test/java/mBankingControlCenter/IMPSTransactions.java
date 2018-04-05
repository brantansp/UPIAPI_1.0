package mBankingControlCenter;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class IMPSTransactions extends ExtentManager{
	private static String response;
	private static int index;
	public static String request;
	static HttpConnect obj=new HttpConnect();
	static Properties prop=getProperty();
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	
	public static void main(String[] args) {

		
		request = StaticStore.m2mbensearch(prop.getProperty("FTBenNickName"));
		try {
			response =sendReq(request, "m2m Benificiary Account list");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *  IMPS P2P.
	 */
	
	@Test(priority=0)
	public void IMPSP2PInstantPayment() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPayment");
		assertResponse(response);
	}
	
	
	@Test(priority=1)
	public void IMPSP2PAddBeneficiaryPreConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}
	
	
	@Test(priority=2)
	public void IMPSP2PAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PConfBen(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void IMPSP2PBeneficiaryPaymentListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=3)
	public void IMPSP2PBeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch("");
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=4)
	public void IMPSP2PBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf(prop.getProperty("IMPSBenNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	
	@Test(priority=5)
	public void IMPSP2PBeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiryWKw");
		assertResponse(response);
	}
	
	@Test(priority=6)
	public void IMPSP2PBeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PBenSearch("");
		response =sendReq(request, "IMPSP2PBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void IMPSP2PDeleteBeneficiaryListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch( "");
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=8)
	public void IMPSP2PDeleteBeneficiaryListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void IMPSP2PDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

	@Test(priority=10)
	public void IMPSP2PInstantPaymentWithInvalidMMID() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("InvalidBenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentWithInvalidMMID");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void IMPSP2PInstantPaymentWithExceededAmount() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("ExceededAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentWithExceededAmount");
		assertTrue(response.substring(2,4).contains("21"));		
	}
	
	
	@Test(priority=12)
	public void IMPSP2PInstantPaymentWithInsufficientAmount() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("InsufficientAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentWithInsufficientAmount");
		assertTrue(response.substring(2,4).contains("20"));	
	}

	@Test(priority=13)
	public void IMPSP2PBeneficiaryPaymentConfirmationwithExceededAmount() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf(prop.getProperty("IMPSBenNickname"), 
				prop.getProperty("ExceededAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmationwithExceededAmount");
		assertResponse(response);
	}
	
	
	@Test(priority=14)
	public void IMPSP2PBeneficiaryPaymentConfirmationwithInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf(prop.getProperty("IMPSBenNickname"), 
				prop.getProperty("InsufficientAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmationwithInsufficientAmount");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void IMPSP2PInstantPaymentForM0Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM0forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM0Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M0"));
	}

	@Test(priority=16)
	public void IMPSP2PInstantPaymentForM1Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM1forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM1Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M1"));
	}

	@Test(priority=17)
	public void IMPSP2PInstantPaymentForM2Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM2forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM2Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M2"));
	}

	@Test(priority=18)
	public void IMPSP2PInstantPaymentForM3Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM3forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM3Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M3"));
	}

	@Test(priority=19)
	public void IMPSP2PInstantPaymentForM4Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM4forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM4Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M4"));
	}

	@Test(priority=20)
	public void IMPSP2PInstantPaymentForM5Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM5forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM5Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M5"));
	}

	@Test(priority=21)
	public void IMPSP2PInstantPaymentForM6Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNoforM6forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentForM6Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M6"));
	}

	@Test(priority=22)
	public void IMPSP2PInstantPaymentfor92Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNofor92forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentfor92Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("92"));
	}

	@Test(priority=23)
	public void IMPSP2PInstantPaymentfor13Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNofor13forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentfor13Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("13"));
	}

	@Test(priority=24)
	public void IMPSP2PInstantPaymentfor51Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2PInstant(prop.getProperty("MobileNofor51forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PInstantPaymentfor51Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("51"));
	}

	
	@Test(priority=25)
	public void IMPSP2PAddBeneficiaryWithExistingNickname() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo1"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=26)
	public void IMPSP2PAddBeneficiaryRegMobileWithOtherNickname() throws IOException, SQLException {
		request = StaticStore.impsP2PAddBen(prop.getProperty("IMPSBenMobNo"), 
				prop.getProperty("BenMMID"), prop.getProperty("IMPSBenNickname1"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=27)
	public void IMPSP2PBeneficiaryPaymentListenquiryWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.impsP2PPaySearch(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=28)
	public void IMPSP2PBeneficiaryPaymentConfirmationWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=29)
	public void IMPSP2PDeleteAlreadydeletedBen() throws IOException, SQLException {
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=30)
	public void IMPSP2PRegBeneficiaryPaymentForM0Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM0forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		
		assertTrue(response.substring(2,4).contains("M0"));

	}
	
	@Test(priority=31)
	public void IMPSP2PRegBeneficiaryPaymentForM1Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM1forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM1Decline");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		
		assertTrue(response.substring(2,4).contains("M1"));

	}
	
	@Test(priority=32)
	public void IMPSP2PRegBeneficiaryPaymentForM2Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM2forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM2Decline");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		
		assertTrue(response.substring(2,4).contains("M2"));

	}
	
	@Test(priority=33)
	public void IMPSP2PRegBeneficiaryPaymentForM3Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM3forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM3Decline");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PDeleteBeneficiaryConfirmation");
		
		assertTrue(response.substring(2,4).contains("M3"));

	}
	
	@Test(priority=34)
	public void IMPSP2PRegBeneficiaryPaymentForM4Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM4forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM4Decline");
		
		assertTrue(response.substring(2,4).contains("M4"));

	}
	
	@Test(priority=35)
	public void IMPSP2PRegBeneficiaryPaymentForM5Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM5forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM5Decline");
		assertTrue(response.substring(2,4).contains("M5"));

	}
	
	@Test(priority=36)
	public void IMPSP2PRegBeneficiaryPaymentForM6Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2PAddBen(prop.getProperty("MobileNoforM6forP2P"), 
				prop.getProperty("BenMMID"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PAddBeneficiaryPreConfirmation");
		
		request = StaticStore.impsP2PPayConf(prop.getProperty("RandomNickname"), 
				prop.getProperty("IMPSAmount"),  prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2PBeneficiaryPaymentConfirmation");
		assertResponse(response);
		
		request = StaticStore.impsP2PDelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2PRegBeneficiaryPaymentForM6Decline");
		assertTrue(response.substring(2,4).contains("M6"));

	}
	
	
	
	/*
	 * IMPS P2A 
	 */
	
	@Test(priority=101)
	public void IMPSP2AInstantPayment() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPayment");
		assertResponse(response);
	}
	
	@Test(priority=102)
	public void IMPSP2AAddBeneficiary() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=103)
	public void IMPSP2AAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2AConfBen(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiaryconfirmation");
		assertResponse(response);
	}
	
	@Test(priority=104)
	public void IMPSP2ABeneficiaryPaymentListenquiryWkW() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=105)
	public void IMPSP2ABeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch("");
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=106)
	public void IMPSP2ABeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=107)
	public void IMPSP2ABeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2ABenDetailSearch("");
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=108)
	public void IMPSP2ABeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2ABenDetailSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ABeneficiarySearchListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=109)
	public void IMPSP2ADeleteBeneficiaryListenquiry() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	
	@Test(priority=110)
	public void IMPSP2ADeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2ADeleteBeneficiaryConfirmation");
		assertResponse(response);
	}
	
	@Test(priority=111)
	public void IMPSP2AInstantPaymentWithRandomAccandIFSCcode() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("InvalidIMPSBenAcNo"),
				 prop.getProperty("InvalidIMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentWithRandomAccandIFSCcode");
		assertTrue(response.substring(2,4).contains("09"));		
	}
	
	@Test(priority=112)
	public void IMPSP2AInstantPaymentWithExceededAmount() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("ExceededAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentWithExceededAmount");
		assertTrue(response.substring(2,4).contains("21"));
	}
	
	@Test(priority=113)
	public void IMPSP2AInstantPaymentWithInsufficientAmount() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("InsufficientAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentWithInsufficientAmount");
		assertTrue(response.substring(2,4).contains("20"));
	}
	
	
	@Test(priority=114)
	public void IMPSP2AAddBeneficiaryWithRandomAccandIFSCcode() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("InvalidIMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("InvalidIMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiaryWithRandomAccandIFSCcode");
		assertTrue(response.substring(2,4).contains("09"));
	}
	
	@Test(priority=115)
	public void IMPSP2ABeneficiaryPaymentConfirmationWithExceedeAmount() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("ExceededAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmationWithExceedeAmount");
		assertTrue(response.substring(2,4).contains("21"));
	}
	
	@Test(priority=116)
	public void IMPSP2ABeneficiaryPaymentConfirmationWithInsufficientAmount() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("InsufficientAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmationWithInsufficientAmount");
		assertTrue(response.substring(2,4).contains("20"));
	}
	
	@Test(priority=117)
	public void IMPSP2AInstantPaymentForM0Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM0forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM0Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M0"));
	}

	@Test(priority=118)
	public void IMPSP2AInstantPaymentForM1Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM1forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM1Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M1"));
	}

	@Test(priority=119)
	public void IMPSP2AInstantPaymentForM2Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM2forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM2Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M2"));
	}

	@Test(priority=120)
	public void IMPSP2AInstantPaymentForM3Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM3forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM3Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M3"));
	}

	@Test(priority=121)
	public void IMPSP2AInstantPaymentForM4Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM4forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM4Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M4"));
	}

	@Test(priority=122)
	public void IMPSP2AInstantPaymentForM5Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM5forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM5Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M5"));
	}

	@Test(priority=123)
	public void IMPSP2AInstantPaymentForM6Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNoforM6forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentForM6Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("M6"));
	}

	@Test(priority=124)
	public void IMPSP2AInstantPaymentfor92Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNofor92forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentfor92Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("92"));
	}

	@Test(priority=125)
	public void IMPSP2AInstantPaymentfor13Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNofor13forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentfor13Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("13"));
	}

	@Test(priority=126)
	public void IMPSP2AInstantPaymentfor51Decline() throws IOException, SQLException {
		sendReq (StaticStore.generateMMID(), "Generate MMID");
		request = StaticStore.impsP2AInstant(prop.getProperty("AccNofor51forP2A"),
				 prop.getProperty("IMPSIFSC"), prop.getProperty("IMPSAmount"), 
				 prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2AInstantPaymentfor51Decline");
		//assertResponse(response);
		assertTrue(response.substring(2,4).contains("51"));
	}

	@Test(priority=127)
	public void IMPSP2AAddBeneficiaryWithExistingNickname() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo1"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=128)
	public void IMPSP2AAddBeneficiaryRegMobileWithOtherNickname() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("IMPSBenAcNo"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("IMPSBenNickname1"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		assertResponse(response);
	}
	
	@Test(priority=129)
	public void IMPSP2ABeneficiaryPaymentListenquiryWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.impsP2APaySearch(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=130)
	public void IMPSP2ABeneficiaryPaymentWithRandomNickname() throws IOException, SQLException {
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		assertResponse(response);
	}
	
	
	@Test(priority=131)
	public void IMPSP2ARegBeneficiaryPaymentForM0Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM0forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM0Decline");
		
		assertTrue(response.substring(2,4).contains("M0"));

	}
	
	@Test(priority=132)
	public void IMPSP2ARegBeneficiaryPaymentForM1Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM1forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM1Decline");
		assertTrue(response.substring(2,4).contains("M1"));

	}
	
	@Test(priority=133)
	public void IMPSP2ARegBeneficiaryPaymentForM2Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM2forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM2Decline");
		assertTrue(response.substring(2,4).contains("M2"));

	
	}
	
	@Test(priority=134)
	public void IMPSP2ARegBeneficiaryPaymentForM3Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM3forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM3Decline");
	
		assertTrue(response.substring(2,4).contains("M3"));

	}
	
	@Test(priority=135)
	public void IMPSP2ARegBeneficiaryPaymentForM4Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM4forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM4Decline");
		assertTrue(response.substring(2,4).contains("M4"));

	}
	
	@Test(priority=136)
	public void IMPSP2ARegBeneficiaryPaymentForM5Decline() throws IOException, SQLException {
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM5forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM5Decline");
	
		assertTrue(response.substring(2,4).contains("M5"));

	}
	
	
	@Test(priority=137)
	public void IMPSP2ARegBeneficiaryPaymentForM6Decline() throws IOException, SQLException {
		
		request = StaticStore.impsP2AAddBen(prop.getProperty("AccNoforM6forP2A"),
				 prop.getProperty("IMPSAccType"), prop.getProperty("IMPSIFSC"), 
				 prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2AAddBeneficiary");
		
		request = StaticStore.impsP2APayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount") , prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2ABeneficiaryPaymentConfirmation");
		
		request = StaticStore.impsP2ADelBenConf(prop.getProperty("RandomNickname"));
		response =sendReq(request, "IMPSP2ARegBeneficiaryPaymentForM6Decline");
	
		assertTrue(response.substring(2,4).contains("M6"));

	}
	
	
	/*
	 * IMPS P2U
	 */
	
	@Test(priority=201)
	public void IMPSP2UInstantPayment() throws IOException, SQLException {
		request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPayment");
		assertResponse(response);
	}
		
	@Test(priority=202)
	public void impsP2UAddBenPreConf() throws IOException, SQLException {
		request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "impsP2UAddBenPreConf");
			assertResponse(response);
	}
	
	@Test(priority=203)
	public void IMPSP2UAddBeneficiaryconfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UAddBenConf(prop.getProperty("IMPSAadharNo"),
				prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			assertResponse(response);
	}
	
	@Test(priority=204)
	public void IMPSP2UBeneficiaryPaymentListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayListEnq(prop.getProperty("IMPSBenNickname"));
			response =sendReq(request, "IMPSP2UBeneficiaryPaymentListenquiryWKw");
			assertResponse(response);
	}
	
	@Test(priority=205)
	public void IMPSP2UBeneficiaryPaymentListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayListEnq("");
			response =sendReq(request, "IMPSP2UBeneficiaryPaymentListenquiryWoKw");
			assertResponse(response);
	}
	
	@Test(priority=206)
	public void IMPSP2UBeneficiaryPaymentConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("IMPSBenNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			assertResponse(response);

	}
	
	
	@Test(priority=207)
	public void IMPSP2UBeneficiarySearchListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDetailsSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UBeneficiarySearchListenquiry");
		assertResponse(response);
   }
	
	@Test(priority=208)
	public void IMPSP2UBeneficiarySearchListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDetailsSearch("");
		response =sendReq(request, "IMPSP2UBeneficiarySearchListenquiryWoKw");
		assertResponse(response);
   }
	
	@Test(priority=209)
	public void IMPSP2UDeleteBeneficiaryListenquiryWKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelSearch(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=210)
	public void IMPSP2UDeleteBeneficiaryListenquiryWoKw() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelSearch("");
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryListenquiry");
		assertResponse(response);
	}
	
	@Test(priority=211)
	public void IMPSP2UDeleteBeneficiaryConfirmation() throws IOException, SQLException {
		request = StaticStore.impsP2UBenDelConf(prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "IMPSP2UDeleteBeneficiaryConfirmation");
		assertResponse(response);
	}

@Test(priority=212)
public void IMPSP2UInstantPaymentWithInvalidAadhar() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("InvalidIMPSAadharNo"),
		prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
	response =sendReq(request, "IMPSP2UInstantPaymentWithInvalidAadhar");
	assertResponse(response);
}

@Test(priority=213)
public void IMPSP2UInstantPaymentWithExceededAmount() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
		prop.getProperty("IMPSAccType"), prop.getProperty("ExceededAmount"), prop.getProperty("IMPSRemarks"));
	response =sendReq(request, "IMPSP2UInstantPaymentWithExceededAmount");
	assertTrue(response.substring(2,4).contains("21"));
}

@Test(priority=214)
public void IMPSP2UInstantPaymentWithInsufficientAmount() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("IMPSAadharNo"),
		prop.getProperty("IMPSAccType"), prop.getProperty("InsufficientAmount"), prop.getProperty("IMPSRemarks"));
	response =sendReq(request, "IMPSP2UInstantPaymentWithInsufficientAmount");
	assertTrue(response.substring(2,4).contains("20"));
}

@Test(priority=215)
public void IMPSP2UBeneficiaryPaymentConfirmationWithExceededAmount() throws IOException, SQLException {
	request = StaticStore.impsP2UBenPayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("ExceededAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UBeneficiaryPaymentConfirmationWithExceededAmount");
		assertTrue(response.substring(2,4).contains("21"));

}

@Test(priority=216)
public void IMPSP2UBeneficiaryPaymentConfirmationWithInsufficientAmount() throws IOException, SQLException {
	request = StaticStore.impsP2UBenPayConf(prop.getProperty("IMPSBenNickname"),
			prop.getProperty("InsufficientAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UBeneficiaryPaymentConfirmationWithInsufficientAmount");
		assertTrue(response.substring(2,4).contains("20"));

}

@Test(priority=217)
public void impsP2UAddBenPreConfwithInvalidAadharNo() throws IOException, SQLException {
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("InvalidIMPSAadharNo"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		assertResponse(response);
}

@Test(priority=218)
public void IMPSP2UInstantPaymentForM0Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM0P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM0Decline");
		assertResponse(response);
	
}

@Test(priority=219)
public void IMPSP2UInstantPaymentForM1Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM1P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM1Decline");
		assertResponse(response);
}

@Test(priority=220)
public void IMPSP2UInstantPaymentForM2Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM2P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM2Decline");
		assertResponse(response);
	
}

@Test(priority=221)
public void IMPSP2UInstantPaymentForM3Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM3P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM3Decline");
		assertResponse(response);
	
}

@Test(priority=222)
public void IMPSP2UInstantPaymentForM4Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM4P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM4Decline");
		assertResponse(response);
	
}

@Test(priority=223)
public void IMPSP2UInstantPaymentForM5Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM5P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM5Decline");
		assertResponse(response);

}

@Test(priority=224)
public void IMPSP2UInstantPaymentForM6Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNoforM6P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentForM6Decline");
		assertResponse(response);

}

@Test(priority=225)
public void IMPSP2UInstantPaymentfor92Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNofor92P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentFor92Decline");
		assertResponse(response);
	
}

@Test(priority=226)
public void IMPSP2UInstantPaymentfor13Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNofor13P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentFor13Decline");
		assertResponse(response);
	
}

@Test(priority=227)
public void IMPSP2UInstantPaymentfor51Decline() throws IOException, SQLException {
	request = StaticStore.impsP2UInstant(prop.getProperty("AadharNofor51P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UInstantPaymentFor51Decline");
		assertResponse(response);
	
}

@Test(priority=228)
public void IMPSP2UAddBeneficiaryWithExistingNickname() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("IMPSAadharNo1"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		assertResponse(response);

}

@Test(priority=229)
public void IMPSP2UAddBeneficiaryRegMobileWithOtherNickname() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("IMPSAadharNo"),
			prop.getProperty("IMPSAccType"), prop.getProperty("IMPSBenNickname1"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		assertResponse(response);

}

@Test(priority=230)
public void IMPSP2UBeneficiaryPaymentListenquiryWithRandomNickname() throws IOException, SQLException {
	request = StaticStore.impsP2UBenDetailsSearch(prop.getProperty("RandomNickname"));
	response =sendReq(request, "IMPSP2UBeneficiarySearchListenquiry");
	assertResponse(response);

}

@Test(priority=231)
public void IMPSP2UBeneficiaryPaymentWithRandomNickname() throws IOException, SQLException {
	
	request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
			prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
		response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
		assertResponse(response);
}

@Test(priority=232)
public void IMPSP2URegBeneficiaryPaymentForM0Decline() throws IOException, SQLException {

	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM0P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM0Decline");
			
			assertTrue(response.substring(2,4).contains("M0"));

}

@Test(priority=233)
public void IMPSP2URegBeneficiaryPaymentForM1Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM1P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM1Decline");

			assertTrue(response.substring(2,4).contains("M1"));

}

@Test(priority=234)
public void IMPSP2URegBeneficiaryPaymentForM2Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM2P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM2Decline");

			assertTrue(response.substring(2,4).contains("M2"));

}

@Test(priority=235)
public void IMPSP2URegBeneficiaryPaymentForM3Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM3P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM3Decline");

			assertTrue(response.substring(2,4).contains("M3"));

}

@Test(priority=236)
public void IMPSP2URegBeneficiaryPaymentForM4Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM4P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM4Decline");

			assertTrue(response.substring(2,4).contains("M4"));

}

@Test(priority=237)
public void IMPSP2URegBeneficiaryPaymentForM5Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM5P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM5Decline");

			assertTrue(response.substring(2,4).contains("M5"));

}


@Test(priority=238)
public void IMPSP2URegBeneficiaryPaymentForM6Decline() throws IOException, SQLException {
	
	request = StaticStore.impsP2UAddBenPreConf(prop.getProperty("AadharNoforM6P2U"),
			prop.getProperty("IMPSAccType"), prop.getProperty("RandomNickname"));
		response =sendReq(request, "impsP2UAddBenPreConf");
		
		request = StaticStore.impsP2UBenPayConf(prop.getProperty("RandomNickname"),
				prop.getProperty("IMPSAmount"), prop.getProperty("IMPSRemarks"));
			response =sendReq(request, "IMPSP2UAddBeneficiaryconfirmation");
			
			request = StaticStore.impsP2UBenDelConf(prop.getProperty("RandomNickname"));
			response =sendReq(request, "IMPSP2URegBeneficiaryPaymentForM6Decline");
	
			assertTrue(response.substring(2,4).contains("M6"));

}



}













