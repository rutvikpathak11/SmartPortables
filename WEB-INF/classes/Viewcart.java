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

public class Viewcart extends HttpServlet {
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
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'> ");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>");
			out.println("<script src='script.js'></script>");
			
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
		
	//request.getParameter("button");
	//System.out.println("ewfewrferfer");
	
	if(fname==null )				
				{
			out.println("<h1>Cart is Empty </h1>");
			out.println("<tr>");
			out.println("<td>");
			out.println("</td>");
			out.println("</tr>");
				
				}
					
else
{
	
	double totalamount=0;
	
	if(Cart.cartlist.size()!=0)
	{	
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Price</th>");
		out.println("<th>Edit</th>");
		out.println("</tr>");
		for(Object objincart: Cart.cartlist)
		{
			 
			out.println("<tr>");
			if(objincart instanceof Product)
			{
				double discountedprice =((((Product)objincart).getPrice()*((Product)objincart).getDiscount())/100);
				discountedprice = ((Product)objincart).getPrice()-discountedprice;
				totalamount=totalamount+discountedprice;
				out.println("<td>"+((Product)objincart).getName()+"</td>");
				out.println("<td>"+discountedprice+"</td>");
				out.println("<td>");
				out.println("<form id='removeitem' action='Removeitem'>");
				out.println("<input type='hidden' name='object' value="+objincart+"></input>");
				out.println("<button type='submit' name='button'>Remove</button>");
				out.println("</form>");
				out.println("</td>");
					
			}
			else if(objincart instanceof Accessory)
			{
				double discountedprice =((((Accessory)objincart).getPrice()*((Accessory)objincart).getDiscount())/100);
				discountedprice = ((Accessory)objincart).getPrice()-discountedprice;
				totalamount=totalamount+discountedprice;
				out.println("<td>"+((Accessory)objincart).getName()+"</td>");
				out.println("<td>"+discountedprice+"</td>");
				out.println("<td>");
				out.println("<form id='removeitem' action='Removeitem'>");
				out.println("<input type='hidden' name='object' value="+objincart+"></input>");
				out.println("<button type='submit' name='button'>Remove</button>");
				out.println("</form>");
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("<td colspan='3'>Total: $ "+totalamount+"</td>");
		//out.println();
		out.println("</table>");
		out.println("<form id='checkout' action='Checkout'>");
		//out.println("<input type='hidden' name='object' value="+objincart+"></input>");
		out.println("<button type='submit' name='button'>Checkout</button>");
		out.println("</form>");
		
	}
	
	//GET THE LAST PRODUCT OBJECT FROM CART 
	Object lastincart = null;
	for(int i=Cart.cartlist.size()-1;i>=0;i--)
	{
		
		if(Cart.cartlist.get(i) instanceof Product)
		{
			if(((Product)Cart.cartlist.get(i)).getAccessories().size()!=0)
			{
				lastincart= Cart.cartlist.get(i);
				break;
			}
			
		}
	}
	
	 if(lastincart!=null) //if condition to see if there is atleast one product in cart 
    {
    	ArrayList<Accessory> acclist = ((Product)lastincart).getAccessories();
		if(acclist.size()!=0)
			out.println("<h2>Accessories</h2>");
		
		
		//CAROUSEL
		
		if(acclist.size()!=0){
			out.println("<div align='center'>");
		out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
		 
			out.println("<ol class='carousel-indicators'>");
			out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
			out.println("</ol>");
			
		out.println("<div class='carousel-inner'>");
			
			out.println("<div class='item active'>");
			out.println("<img src =images/"+acclist.get(0).getImage()+" width='20%' height='20%' align='center'>");
			out.println("<h5 align='center'> Name: "+acclist.get(0).getName()+"</h5>");
			out.println("<h5 align='center'> Price: $"+acclist.get(0).getPrice()+"</h5>");
			out.println("<form id='accaddtocart' action='Addtocart'>");
			out.println("<input type='hidden' name='pagename' value='viewcart'></input>");
			out.println("<p align='center'>");
			out.println("<button type='submit' name='button' value="+acclist.get(0)+" >Add to cart</button>");
			out.println("</p>");
			out.println("</form>");
			out.println("</div>");
			
			
			for(int i=1;i<acclist.size();i++)
			{
				out.println("<div class='item'>");
				out.println("<img src =images/"+acclist.get(i).getImage()+" width='20%' height='20%' align='center'>");
				out.println("<h5 align='center'> Name: "+acclist.get(i).getName()+"</h5>");
				out.println("<h5 align='center'> Price: $"+acclist.get(i).getPrice()+"</h5>");
				out.println("<form id='accaddtocart' action='Addtocart'>");
				out.println("<input type='hidden' name='pagename' value='viewcart'></input>");
				out.println("<p align='center'>");
				out.println("<button type='submit' name='button' value="+acclist.get(i)+" >Add to cart</button>");
				out.println("</p>");
				out.println("</form>");
				out.println("</div>");
			}
			
		out.println("</div>");	
		
		out.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
		out.println("<span class='glyphicon glyphicon-chevron-left'></span>");
		out.println("<span class='sr-only'>Previous</span>");
		out.println("</a>");
		out.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
		out.println("<span class='glyphicon glyphicon-chevron-right'></span>");
		out.println("<span class='sr-only'>Next</span>");
		out.println("</a>");
		out.println("</div>");
		}
    }
}
	
	/*
	//GET THE LAST PRODUCT OBJECT FROM CART 
	Object lastincart = null;
	for(int i=Cart.cartlist.size()-1;i>=0;i--)
	{
		
		if(Cart.cartlist.get(i) instanceof Product)
		{
			if(((Product)Cart.cartlist.get(i)).getAccessories().size()!=0)
			{
				lastincart= Cart.cartlist.get(i);
				break;
			}
			
		}
	}
     
	
    if(lastincart!=null) //if condition to see if there is atleast one product in cart 
    {
    	ArrayList<Accessory> acclist = ((Product)lastincart).getAccessories();
		if(acclist.size()!=0)
			out.println("<h2>Accessories</h2>");
		
		
		//CAROUSEL to add last p
		if(acclist.size()!=0){
		out.println("<div id='myCarousel' class='carousel slide' data-ride='carousel'>");
		 
			out.println("<ol class='carousel-indicators'>");
			out.println("<li data-target='#myCarousel' data-slide-to='0' class='active'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='1'></li>");
			out.println("<li data-target='#myCarousel' data-slide-to='2'></li>");
			out.println("</ol>");
			
		out.println("<div class='carousel-inner'>");
			
			out.println("<div class='item active'>");
			out.println("<img src =images/"+acclist.get(0).getImage()+" width='20%' height='20%' align='center'>");
			out.println("<h5 align='center'> Name: "+acclist.get(0).getName()+"</h5>");
			out.println("<h5 align='center'> Price: $"+acclist.get(0).getPrice()+"</h5>");
			out.println("<form id='accaddtocart' action='AddToCartServlet'>");
			out.println("<input type='hidden' name='pagename' value='cartservlet'></input>");
			out.println("<p align='center'>");
			out.println("<button type='submit' name='button' value="+acclist.get(0)+" >Add to cart</button>");
			out.println("</p>");
			out.println("</form>");
			out.println("</div>");
			
			
			for(int i=1;i<acclist.size();i++)
			{
				out.println("<div class='item'>");
				out.println("<img src =images/"+acclist.get(i).getImage()+" width='20%' height='20%' align='center'>");
				out.println("<h5 align='center'> Name: "+acclist.get(i).getName()+"</h5>");
				out.println("<h5 align='center'> Price: $"+acclist.get(i).getPrice()+"</h5>");
				out.println("<form id='accaddtocart' action='AddToCartServlet'>");
				out.println("<input type='hidden' name='pagename' value='cartservlet'></input>");
				out.println("<p align='center'>");
				out.println("<button type='submit' name='button' value="+acclist.get(i)+" >Add to cart</button>");
				out.println("</p>");
				out.println("</form>");
				out.println("</div>");
			}
			
		out.println("</div>");	
		
		out.println("<a class='left carousel-control' href='#myCarousel' data-slide='prev'>");
		out.println("<span class='glyphicon glyphicon-chevron-left'></span>");
		out.println("<span class='sr-only'>Previous</span>");
		out.println("</a>");
		out.println("<a class='right carousel-control' href='#myCarousel' data-slide='next'>");
		out.println("<span class='glyphicon glyphicon-chevron-right'></span>");
		out.println("<span class='sr-only'>Next</span>");
		out.println("</a>");
		out.println("</div>");
		}
    }
	*/
	

	
	
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
