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

@WebServlet("/Brad93")
public class Brad93 extends HttpServlet {
	private ServletContext context;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context = getServletContext();
		Connection conn = (Connection)context.getAttribute("conn");
		Statement stmt;
		try {
			stmt = conn.createStatement();
			HttpSession session = request.getSession();
			ResultSet rs  = stmt.executeQuery(
					"select * from member where account='brad' and islogin=0 ");
			if(rs.next()) {
				session.setMaxInactiveInterval(60);
				stmt.executeUpdate(
						"update member set islogin=1 where account = 'brad'");
				session.setAttribute("dbid", "1");
				System.out.println("New Login");
				
			}else {
				System.out.println("Login already");
			}
			
			System.out.println("ok1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
