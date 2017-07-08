package tw.ed.j2ee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.el.parser.TokenMgrError;


@WebServlet("/Brad27")
public class Brad27 extends HttpServlet {
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String imgPath = getServletContext().getInitParameter("upload-path");
		File imgFile = new File(imgPath, "DSC_0021.JPG");
		
		BufferedImage bimg = ImageIO.read(imgFile);
		Graphics2D g2d = bimg.createGraphics();
		
		Font font = new Font(null, Font.BOLD + Font.ITALIC, 48);
		
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(-30), 100, 0);
		Font newFont = font.deriveFont(tran);
		
		g2d.setFont(newFont);
		g2d.setColor(Color.GREEN);
		g2d.drawString("版權所有 翻印必究", 120, 220);
		
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg, "jpeg", out);
		
		
	}
}
