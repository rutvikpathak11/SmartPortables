import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Inventory extends HttpServlet {
	
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
	
	
	out.println("<h1>Inventory : </h1><br><br>");
	
	out.println("<form method = 'Post' action='Inventory'>");
	out.println("Please select option : ");
		out.println("<select name='inventorytype' required>");
		out.println("<option value='default' selected='selected' required>--Choose from below--</option>");
		out.println("<option value='availableproducts' required>Avaialability of products</option>");
		out.println("<option value='graphofavailableproducts' required>Graphical representation of avaialable products</option>");
		out.println("<option value='productsonsale' required>Products on sale</option>");
		out.println("<option value='productswithrebate' required>Products with Manufacturer Rebate</option>");
		out.println("</select><br><br>");
		out.println("<input type='submit' value='Submit'>");
	
	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li class=''><a href='Addproduct'>Add Product</a></li>");
	
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

 public void doPost(HttpServletRequest request,
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
	
	String inventorytype = request.getParameter("inventorytype");
	
			
	if(inventorytype.equals("availableproducts"))
	{
		// Availbale quantity
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<AvailableProduct> availableproductslist = obj.availablequantity();
		
		out.println("<h1>Available Products</h1>");
		out.println("<table border='2'><tr><th width='30%'>Product Name</th><th width='30%'>Quantity</th><th width='30%'>Price</th></tr>");
		for(AvailableProduct availableproduct:availableproductslist)
		{
			out.println("<tr><td><h5>"+availableproduct.getProductname()+"</h5></td>");
			out.println("<td><h5>"+availableproduct.getQuantity()+"</h5></td>");
			out.println("<td><h5> $ "+availableproduct.getPrice()+"</h5></td></tr>");
		}
		out.println("</table>");
		out.println("</br>");
		out.println("</br>");
		
	}
	
	else if(inventorytype.equals("graphofavailableproducts"))
	{
		// Bar Chart representation of available products
		out.println("<div id='product-bar-chart'></div>");
		out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>"+
		"<script type='text/javascript' src='https://www.google.com/jsapi'></script>");
		out.println("<script type='text/javascript' src='visualization-chart-script.js'></script>");
				
	}
	
	else if(inventorytype.equals("productsonsale"))
	{
		// Products on sale
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<String> productnameswithdiscount = obj.getallproductnameswithdiscount();
		
		out.println("<h1>Products on sale</h1>");
		out.println("<table border='2'><tr><th width='30%'>Product Name</th><th width='30%'>Discount</th><th width='30%'>Price</th></tr>");
		for(String name:productnameswithdiscount)
		{
			double discount = obj.getdiscount(name);
			double price = obj.getprice(name);
			out.println("<tr><td><h5>"+name+"</h5></td>");
			out.println("<td><h5>"+discount+" %</h5></td>");
			out.println("<td><h5> $ "+price+"</h5></td></tr>");
		}
		out.println("</table>");
		out.println("</br>");
		out.println("</br>");
		
	}

	else if(inventorytype.equals("productswithrebate"))
	{
		// Products with rebate
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<String> productnameswithrebate = obj.getallproductnameswithrebate();
		
		out.println("<h1>Products with manufacturer rebate</h1>");
		out.println("<table border='2'><tr><th width='30%'>Product Name</th><th width='30%'>Rebate</th><th width='30%'>Price</th></tr>");
		for(String name:productnameswithrebate)
		{
			double rebate = obj.getrebate(name);
			double price = obj.getprice(name);
			out.println("<tr><td><h5>"+name+"</h5></td>");
			out.println("<td><h5>"+rebate+" %</h5></td>");
			out.println("<td><h5> $ "+price+"</h5></td></tr>");
		}
		out.println("</table>");
		out.println("</br>");
		out.println("</br>");
		
	}

	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li class=''><a href='Addproduct'>Add Product</a></li>");
	
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
