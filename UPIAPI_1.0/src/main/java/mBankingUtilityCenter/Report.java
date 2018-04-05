package mBankingUtilityCenter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

/**
 * 
 * @author brantansp
 *
 */

public class Report {
	public static String result[] ;
	public static String TXN_ID ;
	public static String TXN_STATUS;
	public static String RESPONSECODE;
	public static String TXN_TYPE;
	public static String DEL_ID; 
	public static String PAYER_MOBILE_NO;
	public static String PAYER_ACCOUNT_NO; 
	public static String PAYER_ADDRESS;
	public static String PAYEE_MOBILE_NO;
	public static String PAYEE_ACCOUNT_NO; 
	public static String PAYEE_ADDRESS;
	public static String BANK_ID;
	public static String RESP_DESC; 
	public static String PAYEE_IFSC; 
	public static String TXN_EXPDATE; 
	public static String TXN_REF_ID;
	public static String PAYER_IFSC;
	public static String PAYER_CODE; 
	public static String PAYEE_CODE; 
	public static String MERCHANTID; 
	public static String TERMINALID;
	
    public static void main(String[]args) throws IOException, SQLException{
    	String transactionID= "VJB91D569AF1AEC4227B7D8B43D82A810BC";
    	String[] dbResult = Db.fetchTxn(transactionID);
    	Report.write(dbResult);
    }
    
    public static void write(String dbResult[]) throws FileNotFoundException
    {
    	result = dbResult;
    	File dir = new File(".\\reports");
    	if (!dir.exists())
    	{
    		dir.mkdirs();
    	}
    	String savestr = "Result.csv"; 
    	File file = new File(dir, savestr);
    	PrintWriter pw ;//new PrintWriter(file);
    	StringBuilder sb = new StringBuilder();
    	if(file.exists() )
    	{
    		pw = new PrintWriter(new FileOutputStream(file, true));
    	} else {
    		pw = new PrintWriter(file);
            sb.append("TXN_ID");
            sb.append(',');
            sb.append("TXN_STATUS");
            sb.append(',');
            sb.append("RESPONSECODE");
            sb.append(',');
            sb.append("TXN_TYPE");
            sb.append(',');
            sb.append("DEL_ID");
            sb.append(',');
            sb.append("PAYER_MOBILE_NO");
            sb.append(',');
            sb.append("PAYER_ACCOUNT_NO");
            sb.append(',');
            sb.append("PAYER_ADDRESS");
            sb.append(',');
            sb.append("PAYEE_MOBILE_NO");
            sb.append(',');
            sb.append("PAYEE_ACCOUNT_NO");
            sb.append(',');
            sb.append("PAYEE_ADDRESS");
            sb.append(',');           
            sb.append("BANK_ID");
            sb.append(',');
            sb.append("RESP_DESC");
            sb.append(',');
            sb.append("PAYEE_IFSC");
            sb.append(',');
            sb.append("TXN_EXPDATE");
            sb.append(',');
            sb.append("PAYER_TYPE");
            sb.append(',');
            sb.append("TXN_REF_ID");
            sb.append(',');
            sb.append("PAYER_IFSC");
            sb.append(',');
            sb.append("PAYER_CODE");
            sb.append(',');
            sb.append("PAYEE_CODE");
            sb.append(',');
            sb.append("MERCHANTID");
            sb.append(',');
            sb.append("TERMINALID");
            sb.append('\n');
    	}
        sb.append(result[0]); 
        sb.append(',');
        if (result[1].equals("C"))
        {
            sb.append("PASS"); 
        }else
        {
            sb.append("FAIL");  
        }
        sb.append(',');
        sb.append(result[2]); 
        sb.append(',');
        sb.append(result[3]); 
        sb.append(',');
        sb.append(result[4]); 
        sb.append(',');
        sb.append(result[5]);
        sb.append(',');
        sb.append(result[6]); 
        sb.append(',');
        sb.append(result[7]); 
        sb.append(',');
        sb.append(result[8]); 
        sb.append(',');
        sb.append(result[9]); 
        sb.append(',');
        sb.append(result[10]); 
        sb.append(',');
        sb.append(result[11]); 
        sb.append(',');
        sb.append(result[12]); 
        sb.append(',');
        sb.append(result[13]); 
        sb.append(',');
        sb.append(result[14]); 
        sb.append(',');
        sb.append(result[15]); 
        sb.append(',');
        sb.append(result[16]); 
        sb.append(',');
        sb.append(result[17]); 
        sb.append(',');
        sb.append(result[18]); 
        sb.append(',');
        sb.append(result[19]); 
        sb.append(',');
        sb.append(result[20]); 
        sb.append(',');
        sb.append(result[21]); 
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
    }

}
