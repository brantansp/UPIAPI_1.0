package mBankingUtilityCenter;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//
public class dbTransactionlog extends ExtentManager{
	public static final String DB_DRIVER = prop.getProperty("DB_DRIVER") ;
	public static final String DB_CONNECTION = prop.getProperty("DB_CONNECTION");
	public static final String DB_USER = prop.getProperty("DB_USER");
	public static final String DB_PASSWORD = prop.getProperty("DB_PASSWORD");
	private static Connection dbConnection = null;
	private static Statement statement = null;
	private static String transactionID="735418241323";
	private static String result[]= new String [10];//= "";
	private static ResultSet resultSet;
	//check2
	public static void main(String[] argv) {
		try {
			fetchRecord(transactionID);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String [] fetchRecord( String transactionID) throws SQLException {

		String selectTableSQL = "select txnauthid, txndatetime, txntype ,  txnstatus , Error_Type, Errorcode, Error_Msg, Responsecode, Response_Description from Transactionlog WHERE TXNAUTHID ='"+transactionID+"'";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			resultSet = statement.executeQuery(selectTableSQL);
			//ResultSetMetaData rsmd = resultSet.getMetaData();
			resultSet.next();
			/*
			 result[20] = resultSet.getString("txnauthid") +"|"+
					 resultSet.getString("txntype") +"|"+
	                       resultSet.getString("txnstatus") +"|"+
	                       resultSet.getString("Error_Type")+"|"+
			  resultSet.getString("Errorcode")+"|"+
			  resultSet.getString("Responsecode")+"|"+
			  resultSet.getString("Response_Description")+"|"+
			  resultSet.getString("Errorcode");
			*/
			result[0] = resultSet.getString("txnauthid") ;
			result[1] = resultSet.getString("txndatetime") ;
			result[2] = resultSet.getString("txntype") ;
			result[3] = resultSet.getString("txnstatus");
			result[4] = resultSet.getString("Error_Type");
			result[5] = resultSet.getString("Errorcode");
			result[6] = resultSet.getString("Error_Msg");
			result[7] = resultSet.getString("Responsecode");
			result[8] = resultSet.getString("Response_Description");
			
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

	public static Connection getDBConnection() {
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

	public static Connection getDBConnection(String DB_USER, String DB_PASSWORD) {
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










