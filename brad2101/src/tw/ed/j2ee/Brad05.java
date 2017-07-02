package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTask(request, response, "doGet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doTask(request, response, "doPost");
	}
	
	
	private void doTask(HttpServletRequest request,
			HttpServletResponse response,String what) 
				throws ServletException, IOException{
		
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		Enumeration<String> params = request.getParameterNames();
		 
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			String value = request.getParameter(param);
			
			pw.write(param +" : "+value +"<br>");
		}
		
		
		
		
		pw.flush();
		pw.close();
	}

}
