package tw.ed.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Brad32")
public class Brad32 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); //create new one if not exist
		//HttpSession session = request.getSession(true); //same as above
		//HttpSession session = request.getSession(false); //if not exist, that's it
		Member member = new Member("Ed", 34);
		session.setAttribute("who", member);
	}
}
