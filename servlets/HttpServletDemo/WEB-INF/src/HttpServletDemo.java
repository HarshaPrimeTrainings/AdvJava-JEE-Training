import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HttpServletDemo extends  HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		System.out.println("Hello Iam 	service(HttpServletRequest req, HttpServletResponse resp)");
		// character Stream
		//PrintWriter out = resp.getWriter();
		//out.println("Hello There !!");
		
		// Byte Stream
		 ServletOutputStream sout = resp.getOutputStream();
		 sout.println("Hello IAm ServletOutputStream");
		
	}

}