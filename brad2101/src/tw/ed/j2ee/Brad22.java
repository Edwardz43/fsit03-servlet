package tw.ed.j2ee;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// I am View
@WebServlet("/Brad22")
public class Brad22 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		Integer result = (Integer)request.getAttribute("result");
		Integer op = Integer.parseInt((String)request.getAttribute("op"));
		String op1 = op==1?"selected":"";
		String op2 = op==2?"selected":"";
		String op3 = op==3?"selected":"";
		String op4 = op==4?"selected":"";
		
		// Load Template View
		String html = loadView("mycal.html");
		html = String.format(html, x, op1, op2, op3, op4, y, result);
		out.println(html);
	}
	
	private String loadView(String file) {
		String tempPath = getServletContext().getInitParameter("template-path");
		File viewFile = new File(tempPath, file);
		int len = (int)viewFile.length();
		byte[] buf = new byte[len];
		
		try {
			BufferedInputStream bin;
			bin = new BufferedInputStream(new FileInputStream(viewFile));
			bin.read(buf);
			bin.close();
		} catch (Exception e) {e.printStackTrace();}
		
		return new String(buf);
	}
}
