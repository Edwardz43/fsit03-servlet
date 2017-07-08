package tw.ed.j2ee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad27")
public class Brad27 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		String imgPath = getServletContext().getInitParameter("upload-path");
//		System.out.println(imgPath);
		File imgFile = new File(imgPath, "dd.png");
		//if(imgFile != null) System.out.println("ok");
		
		BufferedImage bimg = ImageIO.read(imgFile);
		Graphics2D g2d = bimg.createGraphics();
		
		for(int i = 0; i < 4; i ++) {
			int num = (int)(Math.random()*10);
			Font font = new Font(null, Font.BOLD+Font.ITALIC, 48);
			g2d.setColor(Color.BLUE);
			
			AffineTransform tran = new AffineTransform();
			tran.rotate(Math.toRadians(20 + num), 100, 0);
			Font newFont = font.deriveFont(tran);
			
			g2d.setFont(newFont);
			g2d.setColor(Color.GREEN);
			g2d.drawString(""+num, 120+i*20, 120);
		}
		
		
		
		//Output
		OutputStream out = response.getOutputStream();
		File outFile = new File(imgPath, "ed.png");
		ImageIO.write(bimg, "png", out);
		ImageIO.write(bimg, "png", outFile);
		out.flush();
		out.close();
		
	}
}
