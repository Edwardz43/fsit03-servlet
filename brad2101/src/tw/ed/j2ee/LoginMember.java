package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.ed.beans.MemberV2;

@WebServlet("/LoginMember")
public class LoginMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		// 1. prepare
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		
		// 2. Model
		MemberV2 member;
		try {
			member = new MemberV2();
			member = new MemberV2();
			member.setAccount(account);
			member.setPasswd(passwd);
			if(member.isVliadMember()) {
				//Login Success
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("Main2");
			}else {
				//Login Failure
				response.sendRedirect("Register");
			}
		} catch (Exception e) {out.println(e);}
	
		
		
	}
}
