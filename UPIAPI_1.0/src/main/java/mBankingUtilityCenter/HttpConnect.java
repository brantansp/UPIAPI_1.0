package mBankingUtilityCenter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.reporters.jq.Main;

/**
 * 
 * @author brantansp
 *
 */

public class HttpConnect {

	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void main(String[] args) throws IOException {
		HttpConnect conn=new HttpConnect();	
	}
	
	static String targetURL="http://10.144.20.71:9095/UPIService?bridgeEndpoint=true";
	
	public static String postXML(String urlParams) throws IOException
	{
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
        }
	}

}
















