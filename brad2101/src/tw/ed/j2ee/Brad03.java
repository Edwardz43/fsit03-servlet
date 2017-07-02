package tw.ed.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public Brad03() {
        super();
        System.out.println("Brad03()");
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	super.service(request, response);
    	System.out.println("service()");
    	doGet(request, response);
    	doPost(request, response);
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}
