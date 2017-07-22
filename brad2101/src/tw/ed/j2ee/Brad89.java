package tw.ed.j2ee;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad89")
public class Brad89 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		String v1 = (String)servletContext.getAttribute("key1");
		String value3 = (String)servletContext.getAttribute("key3");
		
		if(v1 != null) {
			servletContext.removeAttribute("key1");
			//System.out.println("null");
		}
	}
}
