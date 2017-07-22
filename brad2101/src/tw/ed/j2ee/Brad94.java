package tw.ed.j2ee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Brad94")
public class Brad94 extends HttpServlet {
	private ServletContext context;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context = getServletContext();
		
		try {
			Connection conn = (Connection)context.getAttribute("conn");
			Statement stmt = conn.createStatement();
			
			HttpSession session = request.getSession();
			if(session != null) {
				String dbid = (String)session.getAttribute("dbid");
				stmt.executeUpdate(
						"update member set islogin=0 where id =" + dbid);
				session.invalidate();
			}
			System.out.println("ok2");
			
		} catch (SQLException e) {e.printStackTrace();}	
	}
}
