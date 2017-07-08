package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Brad33")
public class Brad33 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			out.println("No Session");
			return;
		}
		try {
			Member member = (Member)session.getAttribute("who");
			out.println(member.getName()+" : " + member.getAge());
			
		}catch(Exception e) {
			out.print("Not Member");
		}
		
		
	}
}
