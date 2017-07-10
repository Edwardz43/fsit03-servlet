package tw.ed.j2ee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ed.beans.GuessNumModel;

@WebServlet("/GuessNumController")
public class GuessNumController extends HttpServlet {
	//建立一個 model 的class & hist歷史紀錄
	private GuessNumModel model = new GuessNumModel();
	public StringBuffer hist = new StringBuffer();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String guess = request.getParameter("guess");
		String op = request.getParameter("op");
		String create = request.getParameter("create");
		String check = request.getParameter("check");
		String giveup = request.getParameter("giveup");
		String ans = "", res = "", op3="", op4="", op5="";
		
		// init
		if (op == null) hist.delete(0, hist.length());
		
		// 長度不等於0且按下create鍵
		if(op != null && create != null) {
			//清空歷史紀錄
			hist.delete(0, hist.length());
			//製造新的答案並留下紀錄
			model.setAnswer(Integer.parseInt(op));
			ans = model.getAnswer();
			System.out.println(op+" : "+guess +" : "+ans+" : "+res);
		}
		//按下check & 有輸入數字
		if(check != null && guess != null) {
			//檢查結果並記錄
			res = model.getResult(guess);
			hist.append(guess +" : "+res+"<br>");
			//如果全中 就過關 結束遊戲
			if(res.equals(op+"A0B")) {
				hist.delete(0, hist.length());
				hist.append("Bingo ! Answer is \""+model.getAnswer()+"\"");
			}
			System.out.println(op+" : "+guess +" : "+ans+" : "+res);
		}
		//傳送op 紀錄option的位置
		if(op != null) {
			switch(op){
				case "3": op3 = "selected"; break;
				case "4": op4 = "selected"; break;
				case "5": op5 = "selected"; break;
			}
		}
		//放棄 直接公布答案
		if(giveup != null) {
			hist.append("Answer is \""+model.getAnswer()+"\" !");
		}
		
		//準備傳送
		request.setAttribute("op", op);
		request.setAttribute("op3", op3);
		request.setAttribute("op4", op4);
		request.setAttribute("op5", op5);
		request.setAttribute("hist", hist);
		try {
			request.getRequestDispatcher("GuessNumView.jsp").forward(request, response);
		}catch(Exception e) {System.out.println(e);}	
	}
}
