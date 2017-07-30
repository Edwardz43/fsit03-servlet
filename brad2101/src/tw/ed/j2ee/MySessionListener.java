package tw.ed.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent event) {
//		System.out.println("Session Start : " + new Date().toString());
//		HttpSession session = event.getSession();
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
//		System.out.println("Session Destroy : "+ new Date().toString());
//		try {
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost/brad","root","root");
//			Statement stmt = conn.createStatement();
//			HttpSession session = event.getSession();
//			String dbid = (String)session.getAttribute("dbid");
//			stmt.executeUpdate(
//					"update member set islogin=0 where id =" + dbid);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.toString());
//		}
	}	
}
