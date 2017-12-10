import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Addtocart extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      		
	String prod=request.getParameter("button");
    String previouspage = request.getParameter("pagename");
    
    for(Product p: SaxParser4SmartPortableXMLdataStore.products)
    {
    	if(p.getName().equalsIgnoreCase(prod))
    	{
    		Cart.cartlist.add(p);
    	}
    }
    for(Accessory a: SaxParser4SmartPortableXMLdataStore.accessories)
    {
    	if(a.getName().equalsIgnoreCase(prod))
    	{
    		Cart.cartlist.add(a);
    	}
    }
    
    if(previouspage.equals("viewcart"))
    {
    	response.sendRedirect("Viewcart");
    }
    else
    {
    	response.sendRedirect("ProductServlet?param1="+previouspage);
    }
		
		
	
	
}
}