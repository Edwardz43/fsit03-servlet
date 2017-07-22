package tw.ed.j2ee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServerListener implements ServletContextListener{
	private ServletContext servletContext;
	private Timer timer;
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("init");
		ServletContext servletContext = e.getServletContext();
		servletContext.setAttribute("key3", "value3");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/brad","root","root");
			String sql = "insert into member (account, pw, realname) values (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			servletContext.setAttribute("conn", conn);
			servletContext.setAttribute("pstmt", pstmt);
			servletContext.setAttribute("isConnection", true);
			System.out.println("connect ok");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			servletContext.setAttribute("isConnection", false);
			System.out.println("XX");
		}
		//timer = new Timer();
		//timer.schedule(new Mytask(),0, 1000);
		
		
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("destroyed");
		if((Boolean)(servletContext.getAttribute("isConnection"))&&
				servletContext.getAttribute("conn") != null) {
			Connection conn = (Connection)servletContext.getAttribute("conn");
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(timer != null) {
			timer.cancel();
			timer.purge();
			System.out.println("over");
		}
	}
	
	private class Mytask extends TimerTask{

		@Override
		public void run() {
			//System.out.println("Timer Task");
		}
	}
}
