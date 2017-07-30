package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxForBrad05.jsp")
public class AjaxForBrad05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		int data1 = (int)(Math.random()*49 + 1);
		int data2 = (int)(Math.random()*39 + 1);
		int data3 = (int)(Math.random()*6 + 1);
		out.println(data1+" "+data2+" "+data3);
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse resbonse)throws ServletException,IOException{
//		doGet(request, resbonse);
//	}
}
