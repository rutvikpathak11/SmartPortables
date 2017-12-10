import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Salesreports extends HttpServlet {
	
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
	
	
	out.println("<h1>Sales Reports : </h1><br><br>");
	
	out.println("<form method = 'Post' action='Salesreports'>");
	out.println("Please select option : ");
		out.println("<select name='salesreports' required>");
		out.println("<option value='default' selected='selected' required>--Choose from below--</option>");
		out.println("<option value='totalproductssold' required>Products Sold</option>");
		out.println("<option value='totalsales' required>Graphical representation of total sales of every Products Sold</option>");
		out.println("<option value='dailysales' required>Daily Sales</option>");
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
	
	
	String salesreportstype = request.getParameter("salesreports");
	
	if(salesreportstype.equals("totalproductssold"))
	{
		// Products Sold
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<String> productnamescustorders = obj.getallproductnamescustorders();
		int totalproductssold = 0;
		double totalsalesofallproducts = 0.0;
		
		out.println("<h1>Total Products Sold</h1>");
		out.println("<table border='2'><tr><th width='30%'>Product Name</th><th width='30%'>No. of products sold</th><th width='30%'>Price</th><th width='30%'>Total Sales per product</th></tr>");
		for(String name:productnamescustorders)
		{
			int count = obj.getCount(name);
			double price = obj.getprice(name);
			out.println("<tr><td><h5>"+name+"</h5></td>");
			out.println("<td><h5>"+count+"</h5></td>");
			totalproductssold=totalproductssold+count;
			out.println("<td><h5> $ "+price+"</h5></td>");
			out.println("<td><h5> $ "+(count*price)+"</h5></td></tr>");
			totalsalesofallproducts = totalsalesofallproducts + (count*price);
		}
		out.println("</table>");
		out.println("</br>");
		
		out.println("<h3>Total No. of products sold : "+totalproductssold+"</h3>");
		out.println("</br>");
		out.println("</br>");
		out.println("<h3>Total sales of all products sold : $ "+totalsalesofallproducts+"</h3>");
		out.println("</br>");
		out.println("</br>");
	}
	
	else if(salesreportstype.equals("totalsales"))
	{
		// Bar Chart representation of total sales of every products sold
		out.println("<div id='product-bar-chart'></div>");
		out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>"+
		"<script type='text/javascript' src='https://www.google.com/jsapi'></script>");
		out.println("<script type='text/javascript' src='SalesBarChart.js'></script>");	
			
	}	
	
	else if(salesreportstype.equals("dailysales"))
	{
		// Daily Sales
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		TreeMap<String,Double> dailysalesamount = obj.getdailysalesamount();
		
		out.println("<h1>Daily Sales</h1>");
		out.println("<table border='2'><tr><th width='30%'>Date</th><th width='30%'>Total Sales ($)</th></tr>");
		
		 for (String key:dailysalesamount.keySet()) 
		 {
			out.println("<tr><td><h5>"+key+"</h5></td>");
			out.println("<td><h5> $ "+dailysalesamount.get(key)+"</h5></td></tr>");
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
