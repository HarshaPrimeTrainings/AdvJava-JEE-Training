import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;


@WebServlet("/user")
public class UserServlet extends  HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		// character Stream
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		
		out.println("<h1>User Servlet</h1>");
		
		out.println("</html>");
		
		out.close();
		
	}

}