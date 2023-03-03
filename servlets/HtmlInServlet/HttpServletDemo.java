import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HttpServletDemo extends  HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		// character Stream
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		
		out.println("<h1>Demo Page</h1>");
		
		out.println("<p>Hi Iam Paragraph</p>");
		
		out.println("<marquee style="+"color:red"+">Hi Iam Paragraph</marquee>");
		
		out.println("</html>");
		
		out.close();
		
	}

}