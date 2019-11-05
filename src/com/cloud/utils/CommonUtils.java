package com.cloud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import com.google.gson.Gson;

public class CommonUtils {

	public Connection connectToDB() {
		Connection con = null;
		try {
			//load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create the connection object
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "Kusuma_12");
			System.out.println("connected");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public Connection connectToAzure() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://perisetti.database.windows.net:1433;database=perisetti;user=kumar@perisetti;password=Kusuma_12;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			System.out.println("Connection Successful..!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

	public String buildResponse(Object input) {
		Gson gson = new Gson();
		String response = gson.toJson(input);
		return response;
	}

}
