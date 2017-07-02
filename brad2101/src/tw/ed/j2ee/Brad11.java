package tw.ed.j2ee;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.websocket.server.ServerContainer;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Brad11
 */
@WebServlet("/Brad11")
@MultipartConfig
public class Brad11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		counter++;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Part part = request.getPart("upload");
		Collection<String> cc = part.getHeaderNames();
		for(String header: cc) {
			String v = part.getHeader(header);
			out.println(header + ":"+ v +"<br>");
		}
		
		String filename = part.getSubmittedFileName();
		out.print(filename + "<br>");
		String name = part.getName();
		long size = part.getSize();
		out.println(name + ":"+size);
		
		//以下開始讀取資料
		byte[] buf = new byte[(int)size];
		BufferedInputStream bin = 
				new BufferedInputStream(part.getInputStream());
		bin.read(buf);
		bin.close();
		
	
		ServletContext context = getServletContext();
//		Enumeration<String> names = context.getInitParameterNames();
//		while(names.hasMoreElements()) {
//			String pname = names.nextElement();
//			out.println(pname+" = "+context.getInitParameter(pname)+"<br>");
//		}
		String uploadPath = context.getInitParameter("upload-path");
		
//		out.println(new String(buf));
		
		FileOutputStream fout = 
				new FileOutputStream(new File(uploadPath,filename));

		fout.write(buf);
		fout.flush();
		fout.close();
		
	}
	
	@Override
	protected void doPost(
			HttpServletRequest req, HttpServletResponse resp) 
					throws ServletException, IOException {
		doGet(req, resp);
	}


}
