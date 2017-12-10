import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class SignOut extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();
    /*
    for(int i=0;i<Cart.cartlist.size();i++)
    {
    	Cart.cartlist.remove(i);
    }
    for(String key : CreateOrder.hm_order.keySet())
    {
    	CreateOrder.hm_order.remove(key);
    }
	*/
    //Cart.cartlist.remove(0);
    session.invalidate();
    
    response.sendRedirect("Home");
    
    
  }
}