import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Addproduct extends HttpServlet {
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	 
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
		
     out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			out.println("<title>Smart Portables</title>");
			out.println("<link rel='shortcut icon' href='images/title.png'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			//out.println(obj1.hm_smartwatches);
			out.println("<h1><a href='Home'>SMARTPORTABLES</a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a id='home' href='Home'>Home</a></li>");
			out.println("<li class=''><a href='Addproduct'>Add Product</a></li>");
			out.println("<li class=''><a href='Updateproduct'>Update Product</a></li>");
			out.println("<li class=''><a href='Deleteproduct'>Delete Product</a></li>");
			out.println("<li class=''><a href='Trending'>Trending</a></li>");
			out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
			out.println("<li class=''><a href='Salesreports'>Sales Reports</a></li>");
			
				HttpSession session = request.getSession();
				String fname=(String)session.getAttribute("fname");
	if (fname == null)
	{
	out.println("<li class=''><a href='Register'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	
	}
	  else if (fname.equals("StoreManager")){
		  out.println("<li class=''><a href='Register'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		  
		  
	  } else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='SignOut'>Sign Out</a></li>");
	}

	
	
		
			
			
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			//out.println("</div>");
			
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	
	out.println("<h3>Enter Product Details:</h3>");
	
	out.println("<form action='Savenewproduct'>");
	out.println("<table>");
	out.println("<tr>");
	out.println("<td>");
	out.println("Product Name :");
	out.println("<input type='text' name='productname'  required/></td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Quantity  :");
	out.println("<input type='text' name='quantity' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Price  :");
	out.println("<input type='text' name='price' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Retailer  :");
	out.println("<input type='text' name='retailer' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Manufacturer  :");
	out.println("<input type='text' name='manufacturer' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Condition  :");
	out.println("<input type='text' name='cond' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Discount  :");
	out.println("<input type='text' name='discount' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("Manufacture Rebate  :");
	out.println("<input type='text' name='manrebate' required/></td>");
	out.println("</tr>");
	out.println("<tr>");
	
		
	out.println("<tr>");
	out.println("<td>");
	out.println("Product Type  :");
	out.println("<input type='radio' name='prodtype' value='Product' required/> Product");
	out.println("<input type='radio' name='prodtype' value='Accessory' required/> Accessory");
	out.println("</tr>");
	out.println("<tr>");
	
	
	out.println("<tr><td ><input type='submit' value='Add Product'></td></tr>");
	out.println("</table>");
	out.println("</form>");
	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li class=''><a href='Addproduct'>Add Product</a></li>");
	out.println("<li class=''><a href='Updateproduct'>Update Product</a></li>");
	out.println("<li class=''><a href='Deleteproduct'>Delete Product</a></li>");
	out.println("<li class=''><a href='Trending'>Trending</a></li>");
	out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
	out.println("<li class=''><a href='Salesreports'>Sales Reports</a></li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>About us</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<p style='margin: 0;'>This is a sample website created to demonstrate a standard enterprise web page.</p>");
	out.println(" </li>");
	out.println("</ul>");
	out.println("</li>");	
	out.println("<li>");
	out.println("<h4>Search site</h4>");
	out.println("<ul>");
	out.println("<li class='text'>");
	out.println("<form method='get' class='searchform' action='#'>");
	out.println("<p>");
	out.println("<input type='text' size='25' value='' name='s' class='s' />");
	out.println("</p>");	
	out.println("</form></li></ul></li>");	     	
	out.println("<li>");	
	out.println("<h4>Helpful Links</h4>");	
	out.println("<ul>");	
	out.println("<li><a href='http://www.w3schools.com/html/default.asp' title='premium templates'>Learn HTML here</a></li>");	
	out.println("<li><a href='http://www.w3schools.com/css/default.asp' title='web hosting'>Learn CSS here</a></li>");	
	out.println("</ul></li></ul></aside>");	
	out.println("<div class='clear'></div>");
	out.println("</div>");	
	out.println("<footer>");	
	out.println("<div class='footer-content'>");	
	out.println("<div class='clear'></div>");	
	out.println("</div>");	
	out.println("<div class='footer-bottom'>");	
	out.println("<p>Smart Portables - Enterprise Web Application </p>");	
	out.println("</div>");	
	out.println("</footer>");	
	out.println("</div>");	
			
	out.println("</body>");
	out.println("</html>");
			
	 
 
}
	  
			
  
}

	
	