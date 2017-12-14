package cn.guet2309.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static String url = "jdbc:mysql://localhost:3306/testjdbc";
	private static String username = "root";
	private static String  password = "root";
	/*private static String url = null;
	private static String username = null;
	private static String  password = null;*/
	
	//×¢²áÇý¶¯
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*try {
			Properties  properties = new Properties();
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("testjdbc.properties"));
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
