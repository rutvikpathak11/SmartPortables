import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Savenewproduct extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String productname=request.getParameter("productname");
	int quantity=Integer.parseInt(request.getParameter("quantity"));
    double price = Double.parseDouble(request.getParameter("price"));
    String retailer=request.getParameter("retailer");
    double manrebate=Double.parseDouble(request.getParameter("manrebate"));
    String cond=request.getParameter("cond");
    int discount=Integer.parseInt(request.getParameter("discount"));
    String prodtype=request.getParameter("prodtype");
    
    MySqlDataStoreUtilities.addProduct(productname,"new.jpg", quantity, price, retailer, cond, discount, manrebate, prodtype);
    response.sendRedirect("Saveprodmsg");
	
	  }
}