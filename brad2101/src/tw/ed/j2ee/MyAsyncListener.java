package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletResponse;

public class MyAsyncListener implements AsyncListener{

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		AsyncContext asyncContext = event.getAsyncContext();
		System.out.println("onComplete");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = 
				(List)asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
		
		HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("沒事兒");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("onStartAsync");
		
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = 
				(List)asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
		
		HttpServletResponse resp = (HttpServletResponse)asyncContext.getResponse(); 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("沒事兒");
	}

}
