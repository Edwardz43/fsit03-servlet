package tw.ed.beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MemberV2 implements Serializable{
	private String id, account, passwd, realname;
	private Connection conn;
	private PreparedStatement pstmt;
	public MemberV2() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
			"jdbc:mysql://127.0.0.1:3306/brad", "root", "root");
	}
	public String getAccount() {return account;}
	public String getPasswd() {return passwd;}
	public String getRealname() {return realname;}
	
	public void setAccount(String account) {this.account = account;}
	public void setPasswd(String passwd) {this.passwd = passwd;}
	public void setRealname(String name) {this.realname = name;}
	
	
	public boolean newInsert() throws Exception {
		
		pstmt = conn.prepareStatement(
			"insert into member (account, pw, realname) values (?, ?, ?) ");
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		pstmt.setString(3, realname);
		int n = pstmt.executeUpdate();
			
		return n > 0;
	}
	public boolean isVliadMember() throws Exception{
		String sql = "select * from member where account=? and pw=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, passwd);
		ResultSet rs = pstmt.executeQuery();
		boolean ret = rs.next();
		
		if(ret) {
			id = rs.getString("id");
			realname = rs.getString("realname");
		}
		return ret;
	}
}

