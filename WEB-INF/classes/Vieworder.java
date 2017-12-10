import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Vieworder extends HttpServlet {
	SmartPortableUser u=null;
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
			out.println("<li  class=''><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=phones'>Phones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
			
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

	/* for(String key:RegisterUserServlet.hm_user.keySet())
    {
    	
    	if(RegisterUserServlet.hm_user.get(key).getFname().equals(fname))
    	{
    		u = RegisterUserServlet.hm_user.get(key);
    	}
    } */
	u=MySqlDataStoreUtilities.selectUser(fname);
	
	if(session.getAttribute("orderid")!=null)
	{
	String orderid =  (String) session.getAttribute("orderid");

		if(!orderid.equals("A999999"))
		{
			out.println("<h2>Your Order "+orderid+" has been placed successfully.!");	
		}
	}
	
	//out.println("<br>");
	
	//get all orders from database
	
	ArrayList<Orders> orders=MySqlDataStoreUtilities.getOrder(fname);
	
	
	// if(CreateOrder.hm_order.size()!=0 )
	if(orders.size()!=0)
	{
		
		out.println("<table style='width:75%'>");
		out.println("<tr>");
		out.println("<th>User id</th>");
		out.println("<th>Order ID</th>");
		out.println("<th>Order Date</th>");
		out.println("<th>Delivery Date</th>");
		out.println("<th>Delete Order</th>");
		out.println("</tr>");
		// for(String uid: CreateOrder.hm_order.keySet())
		for(Orders o : orders)
		{
			//if(uid.equals(u.getUid()))
			 
			out.println("<tr>");
				/* out.println("<td>"+uid+"</td>");
				out.println("<td>"+CreateOrder.hm_order.get(uid).getCno()+"</td>");
				out.println("<td>"+CreateOrder.hm_order.get(uid).getOrderdate()+"</td>");
				out.println("<td>"+CreateOrder.hm_order.get(uid).getDeliverydate()+"</td>"); */
				out.println("<td>"+o.getUser().getUserid()+"</td>");
				out.println("<td>"+o.getOrderid()+"</td>");
				out.println("<td>"+o.getOrderdate()+"</td>");
				out.println("<td>"+o.getDeliverydate()+"</td>");
				out.println("<form id='editorder' action='Editorder'>");
				out.println("<input type='hidden' name='orderid' value="+o.getOrderid()+"></input>");
				out.println("<td><input type='submit' value='Delete'</td>");
				out.println("</form>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		
	  }
	
	else
	{
		out.println("<h1>You have No orders</h1>");
		 out.println("<a href='Login'><h3>Please login to view orders</h3>");
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
