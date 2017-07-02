package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad14")
@MultipartConfig
public class Brad14 extends HttpServlet {
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(
		HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = getServletContext().getInitParameter("upload-path");
//		System.out.println(uploadPath);
		Part part = request.getPart("upload");
		
		if(part != null)System.out.println("ok");
		else System.out.println("XX");
		String header = part.getHeader("Content-Disposition");
		String filname = BradAPI.getHeaderFilename(header);
			
		part.write(uploadPath + "/" +filname);
		out.println("Upload Success");
		
	}
}
