package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Chao01")
public class Chao01 extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("doGet");
		response.setContentType("text/html; charset=UTF-8");
		try (PrintWriter writer = response.getWriter()){
			writer.write("Hello World !");
			writer.flush();
		}
		System.out.println("I'm Chao01");
	}
}
