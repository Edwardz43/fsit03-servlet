package tw.ed.j2ee;

import java.io.IOException;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/Brad105", asyncSupported=true)
public class Brad105 extends HttpServlet {
	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List)servletContext.getAttribute("asyncs");
		MyAsyncListener myAsyncListener = (MyAsyncListener)servletContext.getAttribute("myAsyncListener");
		AsyncContext async = request.startAsync();
		async.addListener(myAsyncListener);
		async.setTimeout(900000000);
		asyncs.add(async);
		
	}
}
