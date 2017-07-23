package tw.ed.j2ee;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyRequestAttributeListener implements ServletRequestAttributeListener{
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
//		String name = event.getName();
//		String value = (String)event.getValue();
//		System.out.println("request attribute replace add "+ name + "->"+value);
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
//		String name = event.getName();
//		String value = (String)event.getValue();
//		System.out.println("request attribute remove "+ name + "->"+value);
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
//		String name = event.getName();
//		System.out.println("request attribute replace " + name);
//		Boolean value = (Boolean)event.getValue();
//		System.out.println(value.getClass());
//		
//		if(name.equals("x")) {
//			
//			System.out.println("request attribute replace before "+ name + "->"+value);			
//			ServletRequest req = event.getServletRequest();
//			String v2 = (String)req.getAttribute(name);
//			System.out.println("request attribute replace after :"+ name + "->"+v2);
//		}
		
	}


}
