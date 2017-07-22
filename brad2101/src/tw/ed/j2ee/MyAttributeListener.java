package tw.ed.j2ee;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyAttributeListener implements ServletContextAttributeListener{
	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributeValue = (String)event.getValue();
		System.out.println("add : "+ attributeName);
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributeValue = (String)event.getValue();
		System.out.println("remove : "+attributeName);
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attributeName = event.getName();
		//String attributeValue = (String)event.getValue();
		System.out.println("replace : "+attributeName);
	}
}
