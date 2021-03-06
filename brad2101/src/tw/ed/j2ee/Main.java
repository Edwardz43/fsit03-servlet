package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
//		String account = request.getParameter("account");
//		String passwd = request.getParameter("passwd");
//		String id = request.getParameter("id");
		
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/iii", prop);
			
			
			String delid = request.getParameter("delid");
			if(delid != null) {
				conn.createStatement().executeUpdate(
						"delete from cust where id = "+ delid);
			}
			
			PreparedStatement pstmt =  conn.prepareStatement(
					"select * from cust ");
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {System.out.println(e);}
		
		
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		out.println("<a href='AddAccount'>Add</a>");
		out.println("<hr>");
		out.println("<table border='1' width='100%'>");
		out.println("<tr>");
		out.println("	<th>ID</th>\n" + 
				"		<th>Account</th>\n" + 
				"		<th>PassWord</th>\n"+
				"		<th>Update</th>\n"+
				"       <th>Delete</th>\n");
		out.println("</tr>");
		
		try {
			if(rs != null) {
				while(rs.next()) {
					String id = rs.getString("id");
					String account = rs.getString("account");
					out.print("<tr>");
					out.print("<td>"+rs.getString("id")+"</td>");
					out.print("<td>"+rs.getString("account")+"</td>");
					out.print("<td>"+rs.getString("passwd")+"</td>");
					out.print("<td><a href='"
							+ "UpdateAccount?id="+id+"'>Update</a></td>");
					out.print("<td><a href='?delid=" + id + "' onclick='return confirm(\"Delete "+account+"?\");'>Delete</a></td>");
					out.print("</tr>");
				}
			}
		}catch(Exception e) {}
		out.println("</table>");
	}

}
