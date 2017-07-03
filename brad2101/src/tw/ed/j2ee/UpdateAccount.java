package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String id = request.getParameter("id");
		System.out.println("id:"+id +", acc:"+account +", pw"+ passwd);
		if(account != null) {
			//處理新增
			addAccount(account, passwd, id);
			response.sendRedirect("Main");
		}
	
		out.println("<form>");
		out.println("<input type='hidden' name='id' value='"+id+"' /> <br>");
		out.println("Account : <input type='text' name='account' /> <br>");
		out.println("PassWord : <input type='password' name='passwd' /> <br>");
		out.println("<input type='submit' value='Update'>");
		out.println("</form>");
	}
	
	private void addAccount(String account, String passwd, String id) {
		try {
			String salt = BCrypt.gensalt(12);
			Class.forName("com.mysql.jdbc.Driver");
			Properties prop = new Properties();
			prop.setProperty("user", "root");
			prop.setProperty("password", "root");
			
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/iii", prop);
			
			PreparedStatement pstmt =  conn.prepareStatement(
					"update cust set account = ? , passwd = ? where ID = "+ id);
			pstmt.setString(1, account);
			pstmt.setString(2, BCrypt.hashpw("passwd", salt));
			pstmt.executeUpdate();
			
			System.out.println("Insert OK");
		} catch (Exception e) {System.out.println(e);}
	}
}
