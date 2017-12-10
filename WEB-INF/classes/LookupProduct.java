import java.io.*;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LookupProduct extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession();
	String fname=(String)session.getAttribute("fname");

		
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
			out.println("<li  class=''><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=phones'>Phones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
			
				
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

	
	out.println("<li class='' ><a href='Vieworder '>View Orders</a></li>");
						
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			//out.println("</div>");
			
	out.println("<div id='body'>");
	out.println("<section id='content'>");	
	
	Product p = null;
	String action=(String) request.getAttribute("action");
	String searchId = (String) request.getAttribute("searchId");
	
	try 
	{
		p = MySqlDataStoreUtilities.getProduct(searchId);

	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
	String product_type=MySqlDataStoreUtilities.getProductType(searchId);
	
	out.println("<div id='container'>");
	out.println("<h3> Name: "+p.getName()+"</h3>");
	out.println("<h5> Price: "+p.getPrice()+"</h5>");
	out.println("<img src =images/"+p.getImage()+" width='25%' height='25%'>");
	if(fname!=null)
	{
	out.println("<form id='prodaddtocart' merthod='get' action='Addtocart'>");
	out.println("<input type='hidden' name='pagename' value='viewcart'></input>");
	out.println("<button type='submit' name='button' value="+p.getName()+">Add to cart</button>");
	out.println("</form>");
	out.println("<br>");
	
	out.println("<form id='prodwritereview' action='WriteReview'>");
	out.println("<input type='hidden' name='product_type' value="+product_type+"></input>");
	out.println("<button type='submit' name='button' value="+p.getName()+">Write Review</button>");
	out.println("</form>");
	out.println("<br>");
	
	out.println("<form id='prodviewreview' action='ViewReview'>");
	out.println("<input type='hidden' name='product_name' value="+p.getName()+"></input>");
	out.println("<button type='submit' name='button' value="+p.getName()+">View Review</button>");
	out.println("</form>");
	}
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet'>Phones</a></li>");
	out.println("<li><a href='ProductServlet'>Laptop</a></li>");
	out.println("<li><a href='ProductServlet'>External Storage</a></li>");
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