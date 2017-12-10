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

public class Customerorder extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	SmartPortableUser user = null;	  
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
	
	//double totalamount=0;
	String product_name=null;
	String accessory_name;
	
	ArrayList<String> productnames = new ArrayList<String>();
	
	if(Cart.cartlist.size()!=0)
	{
		
		
		for(Object objincart: Cart.cartlist)
		{
			 
			out.println("<tr>");
			if(objincart instanceof Product)
			{
			//	double discountedprice =((((Product)objincart).getPrice()*((Product)objincart).getDiscount())/100);
			//	discountedprice = ((Product)objincart).getPrice()-discountedprice;
			//	totalamount=totalamount+discountedprice;
				productnames.add(((Product)objincart).getName());
				//out.println("<td>"+discountedprice+"</td>");
				//out.println("<td>");
				//out.println("</td>");
				
			}
			else if(objincart instanceof Accessory)
			{
			//	double discountedprice =((((Accessory)objincart).getPrice()*((Accessory)objincart).getDiscount())/100);
			//	discountedprice = ((Accessory)objincart).getPrice()-discountedprice;
			//	totalamount=totalamount+discountedprice;
				productnames.add(((Accessory)objincart).getName());
			//	out.println("<td>"+discountedprice+"</td>");
			//	out.println("<td>");
			//	out.println("</td>");
			}
			out.println("</tr>");
		}
	}
	//	out.println("<td colspan='2'>Total: $"+totalamount+"</td>");
		//out.println();
	//	out.println("</table>");
	
	//user = new SmartPortableUser;
	
	String address = request.getParameter("address");
	String prevpage = request.getParameter("prevpage");
   //String fullname = request.getParameter("fullname");
	request.setAttribute("prevpage",prevpage);
	String city = request.getParameter("city");
	String country = request.getParameter("country");
	int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	long creditcardnumber = Long.parseLong(request.getParameter("creditcardnumber"));
	double totalamount = Double.parseDouble(request.getParameter("totalamount"));

	//out.println(totalamount);
	//totalamount=session.getAttribute("totalamount");
	
	user = MySqlDataStoreUtilities.selectUser(fname);
	
	//s=s+request.getParameter("country") + "   ";
	Random r = new Random();
	int Low = 1;
	int High = 622653;
	int R = r.nextInt(High-Low) + Low;
	String orderid = "A#"+R;
	//Calendar cal = Calendar.getInstance();
	//cal.add(Calendar.DAY_OF_MONTH, 14);
	//Date date = cal.getTime();
	//String DATE_FORMAT = "MM/dd/yyyy"; 
	//SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);				
	//String deliverydate = sdf.format(date);    
	
	//out.println("before new order");
	Orders neworder = new Orders(orderid,user,product_name,Cart.cartlist,address,zipcode,creditcardnumber);
	//out.println("after new order");
	
	//out.println("before insert");
//	out.println(orderid);
	//insert into db
	
	for(String productname : productnames)
	{
	MySqlDataStoreUtilities.insertOrder(orderid,productname,fname,address,zipcode,creditcardnumber,neworder.getOrderdate(),neworder.getDeliverydate());
	}
	//out.println("after insert");
	//delete
	out.println(Cart.cartlist.size());
	for(int i=0;i<Cart.cartlist.size();i++)
	{
		Cart.cartlist.remove(i);
	}
	
	
	session.setAttribute("orderid",orderid);
	session.setAttribute("orderobject",neworder);
	response.sendRedirect("Vieworder");
	
	
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
	
	