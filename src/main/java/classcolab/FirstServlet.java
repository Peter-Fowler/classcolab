package classcolab;

import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/Sample")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		
		rep.setContentType("text/html");//setting the content type
		PrintWriter pw = rep.getWriter();//get the stream to write the data
		
		pw.println("<title>Sample Text Tab</title>");
		pw.println("<h1>Sample Text!</h1>"); // Sysem.out.println("Sample Text!"); but to the screen not the Console
		
		pw.println("<p>Welcome to my website!</p>\r\n\r\n");
		//+ "  <img src=\"https://media.tumblr.com/tumblr_lya5pp4LEn1qcbanwo1_500.gif\" />\r\n"); 

		pw.println("<p>Test</p>");
		
		sb.append("<p>Test2</p>");
		
		String fileName = "testtext.txt";
		
		ServletContext context = getServletContext();
		
		InputStream is = context.getResourceAsStream(fileName);
		if(is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String text;
            
			while((text = reader.readLine()) != null) {
				sb.append("<p>" + text + "</p>");
			}
		}
		
		pw.println(sb);
		
		pw.close();
	}
}
