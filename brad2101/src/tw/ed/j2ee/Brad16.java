package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher1 = 
				request.getRequestDispatcher("Brad17?name=Brad&status=OK");
		RequestDispatcher dispatcher2 = 
				request.getRequestDispatcher("Brad18?name=Brad&status=OK");
		
		
		out.println("<h1>Brad Big Company</h1>");
		out.println("<hr/>");
		
		// include
		dispatcher1.include(request, response);
		out.println("<hr/>");
		dispatcher2.include(request, response);
				
		out.println("<hr/>");
		out.print("copyleft");
	}


}
