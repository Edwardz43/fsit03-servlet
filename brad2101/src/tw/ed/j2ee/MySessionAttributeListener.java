package tw.ed.j2ee;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		//HttpSession session = event.getSession();
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("Add : " +name + " : "+ value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("Remove : " +name + " : "+ value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		String name = event.getName();
		String value = (String)event.getValue();
		System.out.println("Replace : "+name + " : "+ value);
		
		HttpSession session = event.getSession();
		String v2 = (String)session.getAttribute(name);
		System.out.println("Replace2 : "+name + " : "+ v2);
	}

}
