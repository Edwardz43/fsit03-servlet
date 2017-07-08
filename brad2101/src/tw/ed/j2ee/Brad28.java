package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad28")
public class Brad28 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		Cookie cookieRemember = new Cookie("remember", "true");
		cookieRemember.setMaxAge(1*60);
		response.addCookie(cookieRemember);
		
		Cookie cookieAccount = new Cookie("account", "Ed");
		cookieAccount.setMaxAge(1*60);
		response.addCookie(cookieAccount);
		
		Cookie cookiePasswd = new Cookie("passwd", "123456");
		cookiePasswd.setMaxAge(1*60);
		response.addCookie(cookiePasswd);
		
	}
}
