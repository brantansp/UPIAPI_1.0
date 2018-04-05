package mBankingUtilityCenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author brantansp
 *
 */
public class Db extends ExtentManager {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	//private static final String DB_CONNECTION = "jdbc:oracle:thin:@//10.144.24.45:1527/ormpypre";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@//"+dbprop.getProperty("hostName")+":"+dbprop.getProperty("port")+"/"+dbprop.getProperty("serviceName")+"";
	private static final String DB_USER = dbprop.getProperty("userName");
	private static final String DB_PASSWORD =dbprop.getProperty("password");
	private static Connection dbConnection = null;
	private static Statement statement = null;
	private static String transactionID="735418241323";
	private static String result[]= new String [22];//= "";
	private static ResultSet resultSet;
	private static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());

	
	public static void main(String[] argv) {

		try {
			System.out.println(fetchTxn("VJB91D569AF1AEC4227B7D8B43D82A810BC"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String [] fetchTxn( String transactionID) throws SQLException {

		String selectTableSQL ="select TXN_ID, TXN_STATUS, RESPONSECODE,TXN_TYPE, DEL_ID, PAYER_MOBILE_NO, PAYER_ACCOUNT_NO, PAYER_ADDRESS, PAYEE_MOBILE_NO, PAYEE_ACCOUNT_NO, PAYEE_ADDRESS, BANK_ID, RESP_DESC, PAYEE_IFSC, TXN_EXPDATE, PAYER_TYPE, TXN_REF_ID, PAYER_IFSC, PAYER_CODE, PAYEE_CODE, MERCHANTID, TERMINALID "
				+ "from upi_transactionlog where "
				+ "txn_id = '"+transactionID+"'";
				log.info("Query Executed : " +selectTableSQL);
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			resultSet = statement.executeQuery(selectTableSQL);
			resultSet.next();

			result[0] = resultSet.getString("TXN_ID") ;
			result[1] = resultSet.getString("TXN_STATUS") ;
			result[2] = resultSet.getString("RESPONSECODE") ;
			result[3] = resultSet.getString("TXN_TYPE"); 
			result[4] = resultSet.getString("DEL_ID");
			result[5] = resultSet.getString("PAYER_MOBILE_NO");
			result[6] = resultSet.getString("PAYER_ACCOUNT_NO");
			result[7] = resultSet.getString("PAYER_ADDRESS");
			result[8] = resultSet.getString("PAYEE_MOBILE_NO");
			result[9] = resultSet.getString("PAYEE_ACCOUNT_NO") ;
			result[10] = resultSet.getString("PAYEE_ADDRESS");
			result[11] = resultSet.getString("BANK_ID") ;
			result[12] = resultSet.getString("RESP_DESC"); 
			result[13] = resultSet.getString("PAYEE_IFSC");
			result[14] = resultSet.getString("TXN_EXPDATE");
			result[15] = resultSet.getString("PAYER_TYPE");
			result[16] = resultSet.getString("TXN_REF_ID");
			result[17] = resultSet.getString("PAYER_IFSC");
			result[18] = resultSet.getString("PAYER_CODE");
			result[19] = resultSet.getString("PAYEE_CODE");
			result[20] = resultSet.getString("MERCHANTID");
			result[21] = resultSet.getString("TERMINALID");
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return result;
	}

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	 public void clear() {
	 		if (resultSet != null) {
	 			try {
	 				resultSet.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			resultSet = null;
	 		}
	 		if (statement != null) {
	 			try {
	 				statement.close();
	 			} catch (final SQLException e) {
	 				e.printStackTrace();
	 			}
	 			statement = null;
	 		}
	 	} 	

}










