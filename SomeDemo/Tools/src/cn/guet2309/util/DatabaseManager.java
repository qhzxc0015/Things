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
	//ע������
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
	 * executeQuery()����,��ѯSQL���
	 * 
	 * @param sqlwordsΪ����Ĳ�ѯ��sql���
	 * @return results��Ϊ���صĲ�ѯ�����
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
	 * executeUpdate()���������롢ɾ�����޸����ݿ��¼
	 * @param sqlwordsΪ����Ĳ�ѯ��sql��
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
	 * close()�������Ͽ����ݿ������
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
