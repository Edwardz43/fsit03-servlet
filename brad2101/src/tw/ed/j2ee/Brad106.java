package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad106")
public class Brad106 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		
		synchronized (asyncs) {
			for(AsyncContext asyncContext : asyncs) {
				PrintWriter out = asyncContext.getResponse().getWriter();
				out.print("mesg : "+ (int)(Math.random()*49 + 1)+"<br>");
				asyncContext.complete();
			}
			asyncs.clear();
		};
	}
}
