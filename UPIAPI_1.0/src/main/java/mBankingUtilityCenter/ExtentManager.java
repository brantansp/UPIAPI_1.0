package mBankingUtilityCenter;

import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
/**
 * 
 * @author brantansp
 *
 */
public class ExtentManager{
	
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	public static String response="";
	public static String transactionID = "";
	static HttpConnect obj=new HttpConnect();
	private static String dbResult[];
	public static WebDriver driver;
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	public static Properties prop=getProperty();
	static String reportPath;
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd"); 
	SimpleDateFormat timeFormatter = new SimpleDateFormat("HHmmss"); 
	Date date = new Date();  
	public static Properties dbprop;
	static String targetURL="http://10.144.20.71:9095/UPIService?bridgeEndpoint=true";

	@BeforeSuite
	public void setUp()throws FileNotFoundException{
      	    log.info("Running UPI API Automation testing 1.0"+"\r\n"); 
        	File dir = new File(System.getProperty("user.dir")+"\\output\\ExtentReport\\"+dateFormatter.format(date));
        	if (!dir.exists())
        	{
        		dir.mkdirs();
        	}
        	reportPath= dir+"\\ExtentReport_"+timeFormatter.format(date)+".html";
			extent = new ExtentReports (reportPath, true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			prop =getProperty();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		extentLogger = extent.startTest(this.getClass().getSimpleName()+ " ::  " +method.getName(), method.getName()); 
		extentLogger.assignAuthor("Brantan sp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log( LogStatus.PASS, "Test started successfully");
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}extent.endTest(extentLogger);
	}
	
	@AfterSuite
	public void endReport(){
		 extent.flush();
          /*      Scanner sc = new Scanner (System.in);
                boolean loop = true;
                while (loop)
                {
                     System.out.println("Please enter y to Launch report and n to cancel");
                     String flag = sc.nextLine();
                     switch (flag)
                        {
                            case "y":
                            log.info("Launching report");
                            loop = false;
            	            launchReport();
                            break;
                            case "n":
                            log.info("Launching report canceled");
                            loop = false;
                            break;
                            default : 
                            log.info("Please select only y or n");
                            loop = true;
                        }
                } 
                loop = true;
                while (loop)
                {
                     System.out.println("Please enter y to send mail to Stakeholders or n to cancel");
                     String flag = sc.nextLine();
                     switch (flag)
                        {
                            case "y":
                            log.info("Sending mail");
                            loop = false;
                            SendEmail.sendEmail(dateFormatter.format(date));
                            break;
                            case "n":
                            log.info("Sending mail was canceled");
                            loop = false;
                            break;
                            default : 
                            log.info("Please select only y or n");
                            loop = true;
                        }
                } 
                sc.close();
    */}
	
	public static Properties getProperty()
	{
		prop=ExcelReader.getPropertyFromExcel("Data","InputData");
		return prop;
	}
	
	public static void main(String[] args) {
		launchReport();
	}
	
	public static void launchReport()
	{
		System.out.println("*******************");
		System.out.println("launching Report in browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver2.33.exe");
		driver = new ChromeDriver();
		System.setProperty("java.net.preferIPv4Stack", "true");
/*		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		driver.manage().window().maximize();
		driver.get(reportPath);
		System.out.println("*******************");
	}
	
	    public static String postXML(String urlParams) throws IOException
	    {
	    	log.info("******************************START******************************");
            log.info("Request : "+urlParams);
	        java.net.URL url;
	        HttpURLConnection connection = null;  
	        try {
	          url = new URL(targetURL);
	          connection = (HttpURLConnection)url.openConnection();
	          connection.setRequestMethod("POST");
	          connection.setRequestProperty("SOAPAction", "");
	          connection.setUseCaches (false);
	          connection.setDoInput(true);
	          connection.setDoOutput(true);
	          
	          //Send request
	          DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
	          wr.writeBytes (urlParams);
	          wr.flush ();
	          wr.close ();
	          //Get Response    
	          InputStream is ;
	          log.info("response code="+connection.getResponseCode());
	          if(connection.getResponseCode()<=400){
	              is=connection.getInputStream();
	          }else{
	              /* error from server */
	              is = connection.getErrorStream();
	        } 
	         // is= connection.getInputStream();
	          BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	          String line;
	          StringBuffer response = new StringBuffer(); 
	          while((line = rd.readLine()) != null) {
	            response.append(line);
	            response.append('\r');
	          }
	          rd.close();
	          log.info("response"+response.toString());
	          return response.toString();
	        } catch (Exception e) {
	        	log.info("here"+e);
	          return null;
	        } finally {
	          if(connection != null) {
	            connection.disconnect(); 
	          }
	      	log.info("******************************END********************************\r\n");
	        }
	    }

	    public static String getResCode (String response)
	    {
	    	String resCode = response.substring(response.lastIndexOf("<java:ResCode>")+14, response.lastIndexOf("</java:ResCode>"));
	    	return resCode;
	    }
	    

	    public static String getAccNo (String response)
	    {
	    	String accno = response.substring(response.lastIndexOf("<java:AccNo>")+12, response.lastIndexOf("</java:AccNo>"));
	    	return accno;
	    }
	   
	    public static String getTranID (String response)
	    {
	    	String tranID = response.substring(response.lastIndexOf("<java:MsgId>")+12, response.lastIndexOf("</java:MsgId>"));
	    	return tranID;
	    }
	    
}



