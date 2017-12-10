import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/** Very simplistic servlet that generates plain text.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2000 Marty Hall; may be freely used or adapted.
 */

public class Removeitem extends HttpServlet {

 public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
	  String obj1 = request.getParameter("object");	  
	
	  
	  for (int i=0;i<Cart.cartlist.size();i++)
	  {	
		  Object o = Cart.cartlist.get(i);
		  if((o.toString()).equals(obj1))
		  {
			 Cart.cartlist.remove(i); 
		  }  
		
	  }
	  
	  response.sendRedirect("Viewcart");
	  
	  }


}