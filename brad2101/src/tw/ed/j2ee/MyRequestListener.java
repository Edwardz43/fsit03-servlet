package tw.ed.j2ee;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestListener implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent event) {
//		ServletRequest req = event.getServletRequest();
//		String remoteIP = req.getRemoteAddr();
//		System.out.println("new request from "+remoteIP);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		
	}
}
