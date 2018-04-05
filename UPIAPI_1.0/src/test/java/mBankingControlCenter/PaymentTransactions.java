package mBankingControlCenter;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import mBankingPageObjectModel.StaticStore;
import mBankingUtilityCenter.ExtentManager;
import mBankingUtilityCenter.HttpConnect;
import java.io.IOException;
import java.sql.SQLException;

public class PaymentTransactions extends ExtentManager{

	private static String response;
	public static String request;
	static HttpConnect obj=new HttpConnect();

	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	

	@Test(priority=0)
	public void Billercategorylist() throws IOException, SQLException {
		request = StaticStore.Billercategorylist();
		response =sendReq(request, "Billercategorylist");
		assertResponse(response);
	}
	
	@Test(priority=1)
	public void billerlist() throws IOException, SQLException {
		request = StaticStore.billerlist("000000000057");
		response =sendReq(request, "BillerList");
		assertResponse(response);
	}
	
	@Test(priority=2)
	public void billerregisration() throws IOException, SQLException {
		request = StaticStore.billerregisration("000000000057");
		response =sendReq(request, "Biller Registration");
		assertResponse(response);
	}
	
	
	@Test(priority=3)
	public void biilerregistrationconfirm() throws IOException, SQLException {
		request = StaticStore.biilerregistrationconfirm("000000000057","Birla Sunlife,Mumbai","228875554","5278775554","likha");
		response =sendReq(request, "Biller Registration Confirm");
		assertResponse(response);
	}

	
	@Test(priority=4)
	public void Accountselectionbiilerlist() throws IOException, SQLException {
		request = StaticStore.Accountselectionbiilerlist();
		response =sendReq(request, "Account selection biiler list");
		assertResponse(response);
	}
	
	@Test(priority=5)
	public void biilerlistselection() throws IOException, SQLException {
		request = StaticStore.biilerlistselection("gfxv");
		response =sendReq(request, "Biller List Selection");
		assertResponse(response);
	}
	
	
	@Test(priority=6)
	public void RegBillerpay() throws IOException, SQLException {
		request = StaticStore.RegBillerpay("gfxv");
		response =sendReq(request, "Register Biller Pay");
		assertResponse(response);
	}
	
	@Test(priority=7)
	public void RegBillerpayconfirm() throws IOException, SQLException {
		request = StaticStore.RegBillerpayconfirm("gfxv","100","");
		response =sendReq(request, "Register Biller Pay Confirm");
		assertResponse(response);
	}
	
	
	@Test(priority=8)
	public void biilerderegselection() throws IOException, SQLException {
		request = StaticStore.biilerderegselection();
		response =sendReq(request, "Biller Registration selection");
		assertResponse(response);
	}
	
	@Test(priority=9)
	public void AdHocBillercategorylist() throws IOException, SQLException {
		request = StaticStore.AdHocBillercategorylist();
		response =sendReq(request, "AdHoc Biller Category List");
		assertResponse(response);
	}
	
	@Test(priority=10)
	public void AdHocbillerlist() throws IOException, SQLException {
		request = StaticStore.AdHocbillerlist("000000000057");
		response =sendReq(request, "AdHoc Biller List");
		assertResponse(response);
	}
	
	@Test(priority=11)
	public void billerlistselection() throws IOException, SQLException {
		request = StaticStore.billerlistselection("Birla Sunlife,Mumbai");
		response =sendReq(request, "Biller List Selection");
		assertResponse(response);
	}
	
	@Test(priority=12)
	public void Adhocpayconfirm() throws IOException, SQLException {
		request = StaticStore.Adhocpayconfirm("Birla Sunlife,Mumbai","228881554","528885554","100","807415244998");
		response =sendReq(request, "AdHoc Pay Confirm");
		assertResponse(response);
	}
	
	@Test(priority=13)
	public void Rechargelist() throws IOException, SQLException {
		request = StaticStore.Rechargelist();
		response =sendReq(request, "Recharge List");
		assertResponse(response);
	}
	
	@Test(priority=14)
	public void Operatorsearch() throws IOException, SQLException {
		request = StaticStore.Operatorsearch("MTP","dgha");
		response =sendReq(request, "Operator Search");
		assertResponse(response);
	}
	
	@Test(priority=15)
	public void Rechargeconfirm() throws IOException, SQLException {
		request = StaticStore.Rechargeconfirm("","","","","");
		response =sendReq(request, "Recharge Confirm");
		assertResponse(response);
	}
	
	@Test(priority=16)
	public void RechargeStatusEnq() throws IOException, SQLException {
		request = StaticStore.RechargeStatusEnq("","");
		response =sendReq(request, "Recharge Status Enquiry");
		assertResponse(response);
	}
}
