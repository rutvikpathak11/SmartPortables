import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Editorder extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
		
		String orderid =  (String) request.getParameter("orderid");
		
		MySqlDataStoreUtilities.deleteOrder(orderid);
		response.sendRedirect("Vieworder");
	  
	  }
}