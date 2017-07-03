package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddTeam")
public class AddTeam extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String win = request.getParameter("win");
		String loss = request.getParameter("loss");
		String players = request.getParameter("players");
		String url = request.getParameter("url");
		String logo = request.getParameter("logo");
		if(name != null) {
			//處理新增
			addTeam(name, win, loss, players, url, logo);
			response.sendRedirect("NBAteams");
		}
	
		out.println("<form>");
		out.println("Name : <input type='text' name='name' /> <br>");
		out.println("Win : <input type='text' name='win' /> <br>");
		out.println("Loss : <input type='text' name='loss' /> <br>");
		out.println("Players : <input type='text' name='players' /> <br>");
		out.println("URL : <input type='text' name='url' /> <br>");
		out.println("Logo : <input type='text' name='logo' /> <br>");
		out.println("<input type='submit' value='Add'>");
		out.println("</form>");
	}
	
	private void addTeam(
			String name, String win, String loss, 
			String players, String url, String logo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/nba", prop);
			
			PreparedStatement pstmt =  conn.prepareStatement(
					"insert into teams (name,win, loss, players, url, logo) values (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, win);
			pstmt.setString(3, loss);
			pstmt.setString(4, players);
			pstmt.setString(5, url);
			pstmt.setString(6, logo);
			pstmt.executeUpdate();
			
			System.out.println("Insert OK");
		} catch (Exception e) {System.out.println(e);}
	}
}
