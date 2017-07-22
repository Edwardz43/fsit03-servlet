package tw.ed.j2ee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad90")
public class Brad90 extends HttpServlet {
	private ServletContext servletContext;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletContext = getServletContext();
		try {
			PreparedStatement pstmt  = 
					(PreparedStatement)servletContext.getAttribute("pstmt");
			pstmt.setString(1, "Kobe24");
			pstmt.setString(2, "81bj4");
			pstmt.setString(3, "KobeBryant");
			pstmt.execute();
			System.out.println("insert ok");
		} catch (Exception e) {
			e.toString();
		}
	}
}
