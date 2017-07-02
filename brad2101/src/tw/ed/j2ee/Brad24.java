package tw.ed.j2ee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad24")
public class Brad24 extends HttpServlet {
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String salt = BCrypt.gensalt(12);
		String newPassword = BCrypt.hashpw("123456", salt);
		System.out.println(newPassword);
		
		if(checkPasswd("123456",newPassword)) {
			System.out.println("ok");
		}else {
			System.out.println("XX");
		}
		
	}
	private static boolean  checkPasswd(String orgPasswd, String hashPasswd) {
		boolean isRight = false;
		if(hashPasswd == null || !hashPasswd.startsWith("$2a$")) {
			 isRight = false;
		}
		
		isRight = BCrypt.checkpw(orgPasswd, hashPasswd);
		return isRight;
	}
	
	
}
