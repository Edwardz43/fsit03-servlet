package tw.ed.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gender = request.getParameter("gender");
		
		String[] hobby = request.getParameterValues("hobby");
		response.setContentType("text/html; charset=UTF-8");
		StringBuffer sb = new StringBuffer();
		for(String s : hobby) sb.append(s + " ");
			
		response.getWriter().write(sb.toString());
	}
}
