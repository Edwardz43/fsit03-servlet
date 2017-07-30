package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jamesmurty.utils.XMLBuilder2;

@WebServlet("/AjaxForBrad051.jsp")
public class AjaxForBrad051 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml; charset=UTF-8");
		// must set this !
		response.setHeader("Content-type","application/xhtml+xml");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//from github  
		XMLBuilder2 builder = 
			XMLBuilder2.create("notes")
			    .e("note")
			        .e("title")
			            .t("Note1")
			        .up()    
			        .e("authors")
				        .e("name")
				        	.t("Brad")
				        .up()
				        .e("name")
				        	.t("Tony")
				        .up()
				    .up()
				    .e("price")
				    	.t("200")
				    .up()
				.up()
			    .e("note")
			        .e("title")
			            .t("Note2")
			        .up()      
			        .e("authors")
				        .e("name")
				        	.t("Kevin")
				        .up()	
				        .e("name")
				        	.t("Mary")
				        .up()
				        .e("name")
				        	.t("Eric")
				        .up()	
				    .up()          
				    .e("price").t("100");
		out.print(builder.asString());
	}
}
