package tw.ed.j2ee;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag3 extends SimpleTagSupport{
	StringWriter sw = new StringWriter();
	private String message;
	public void setMessage(String message){this.message = message;}
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		 if (message != null) {
	         /* Use message from attribute */
	         JspWriter out = getJspContext().getOut();
	         out.println( message );
	      } else {
	         /* use message from the body */
	         getJspBody().invoke(sw);
	         getJspContext().getOut().println(sw.toString());
	      }
	}
}
