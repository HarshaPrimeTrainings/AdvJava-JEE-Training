import javax.servlet.http.*;
import java.io.*;

public class FirstServlet extends HttpServlet{
	
	@Override
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		 PrintWriter out  = resp.getWriter();
		 out.println("Hello There!");
		System.out.println("Hello Iam from Servelet");	
		
	}
}