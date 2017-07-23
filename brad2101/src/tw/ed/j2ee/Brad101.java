package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad101")
public class Brad101 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		try {
			Thread.sleep(10 * 60 * 1000);
		} catch (InterruptedException e) {e.printStackTrace();}
		for(int i = 0; i < 6; i ++)
		out.print((i+1)+" : "+ (int)(Math.random()*49 + 1)+"<br>");
	}
}
