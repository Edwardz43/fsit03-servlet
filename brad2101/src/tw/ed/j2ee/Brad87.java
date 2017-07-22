package tw.ed.j2ee;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="Brad87" ,
	urlPatterns= {"/Brad87","/Brad87.php","/Brad87.aspx"},
	initParams={
		@WebInitParam(name="X", value="123"),
		@WebInitParam(name="y", value="456")
	}
)
public class Brad87 extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	@Override
	public void init() throws ServletException {
		//System.out.println("init");
		super.init();
		servletConfig = getServletConfig();
		servletContext = getServletContext();
		
	}
	
	@Override
	protected void service(
		HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException {
		super.service(req, resp);
		//System.out.println("service");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> params = servletConfig.getInitParameterNames();
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			System.out.println(param + " = "+ 
					servletConfig.getInitParameter(param));
		}
		
		String realPath = servletContext.getRealPath("./");
		System.out.println(realPath);
		
		Set<String> paths = servletContext.getResourcePaths("/");
		for(String path : paths) {
			System.out.println(path);
		}
	}
}
