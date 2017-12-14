package cn.guet2309.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private Connection connection = null;
	private ResultSet results = null;
	private Statement stmt = null;
	
	private static String url = "jdbc:mysql://202.193.58.238:3306/qbh?useUnicode=true&characterEncoding=utf8";
	private static String username = "root";
	private static String  password = "root";
	//注册驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DatabaseManager() {
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			System.out.println("Connect Database is Ok!");
		} catch (SQLException e) {
			System.out.println("Connect Database Failed!:" + e);
		}
	}
	
	/**
	 * executeQuery()方法,查询SQL结果
	 * 
	 * @param sqlwords为传入的查询的sql语句
	 * @return results　为返回的查询结果集
	 */
	public ResultSet executeQuery(String sqlwords) {
		try {
			results = stmt.executeQuery(sqlwords);
		} catch (SQLException ex) {
			System.out.println("Execute Query Sql Failed!:" + ex.getMessage());
		}
		return results;
	}
	
	/**
	 * executeUpdate()方法，插入、删除、修改数据库记录
	 * @param sqlwords为传入的查询的sql语
	 * @return true|false
	 */
	public boolean executeUpdate(String sqlwords) {
		try {
			stmt.executeUpdate(sqlwords);
			return true;
		} catch (SQLException ex) {
			System.err.println("Execute Update Sql Failed!: " + ex.getMessage());
			return false;
		}
	}
	
	/**
	 * close()方法，断开数据库的连接
	 * 
	 * @return true|false
	 */
	public boolean close() {
		try {
			if (results != null) {
				results.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
			return true;
		} catch (Exception e) {
			System.out.print("Clost Database Connect Failed!:" + e);
			return false;
		}
	}
	
}
