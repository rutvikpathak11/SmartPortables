import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ProductServlet extends HttpServlet {
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
	out.println("<li class=''><a href='Registration'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	}
	  else if (fname.equals("StoreManager")){
		  out.println("<li class=''><a href='Registration'>Register Customer</a></li>");
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
		//	out.println("</div>");
			
	//out.println("<img class='header-image' src='images/combined.jpg' width = '100%' height = '100%' alt='Index Page Image' />");
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	
	//SaxParser4SmartPortableXMLdataStore obj1 = new SaxParser4SmartPortableXMLdataStore("ProductCatalog.xml");
	//obj.populateSerializedDataStore();
	//System.out.println("Ewfweew");
	SmartPortablesSerializedDataStore obj1=(SmartPortablesSerializedDataStore) request.getAttribute("obj1");
	//System.out.println(request.getParameterValues("param1"));
	String product_type=request.getParameter("param1");
	//out.println("<h5>"+s1+"</h5>");
	//obj1.hm_accessories.get("acc1").getPrice();
	//System.out.println(obj.hm_smartwatches);
	//System.out.println(obj.hm_smartwatches.get("SmartWatch1"));
	//out.println("<h5>"+obj1.hm_accessories.get("acc1").getName()+"</h5>");
	HashMap<String,Product> map = new HashMap<String,Product>();
	HashMap<String, Accessory> map1 = new HashMap<String,Accessory>();
	
	
	if(product_type.equalsIgnoreCase("SmartWatches")){
		map=obj1.hm_smartwatches;
		out.println("<h1> SMART WATCHES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Speakers")){
		map=obj1.hm_speakers;
		out.println("<h1> SPEAKERS </h1>");
	}
	else if(product_type.equalsIgnoreCase("Headphones")){
		map=obj1.hm_headphones;
		out.println("<h1> HEADPHONES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Phones")){
		map=obj1.hm_phones;
		out.println("<h1> PHONES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Laptops")){
		map=obj1.hm_laptops;
		out.println("<h1> LAPTOPS </h1>");
	}
	else if(product_type.equalsIgnoreCase("ExternalStorages")){
		map=obj1.hm_externalstorages;
		//System.out.println(map.size());
		out.println("<h1> EXTERNAL STORAGES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Accessories")){
		map1=obj1.hm_accessories;
		out.println("<h1> ACCESSORIES </h1>");
	}
	
	
	for(String key:map.keySet())
	{
		out.println("<div id='container'>");
		out.println("<h3> Name: "+map.get(key).getName()+"</h3>");
		out.println("<img src = 'images/"+map.get(key).getImage()+"' width='25%' height='25%'>");
		out.println("<h3> Price: $ "+map.get(key).getPrice()+"</h3>");
		out.println("<h3> Retailer: "+map.get(key).getRetailer()+"</h3>");
		out.println("<h3> Condition: "+map.get(key).getCondition()+"</h3>");
		out.println("<h3> Discount: "+map.get(key).getDiscount()+"</h3>");		
		out.println("<form id='addtocart' method='get' action='Addtocart'>");
		//out.println("<input class = 'submit-button' type = 'submit' value = 'Add to Cart' style='background-color:transparent'>");
		//out.println("<input type='hidden' name='name' value='"+map.get(key).getName()+"'>");
		//out.println("<input type='hidden' name='price' value='"+map.get(key).getPrice()+"'>");
		//out.println("<input type='hidden' name='retailer' value='"+map.get(key).getRetailer()+"'>");
		out.println("<input type='hidden' name='pagename' value="+product_type+"></input>");
		out.println("<button type='submit' name='button' value="+map.get(key)+">Add to cart</button>");
		out.println("<br>");
		out.println("<br>");
		out.println("</form>");
	
	//write reviews	
	out.println("<form id = 'prodwritereview' method = 'get' action = 'WriteReview'>");
	out.println("<input type='hidden' name='product_type' value="+product_type+"></input>");
	//out.println("<input type='hidden' name='product_name' value="+map.get(key).getName()+"></input>");
	out.println("<button type='submit' name='button' value="+map.get(key).getName()+">Write Review</button>");	  
	out.println("</form>");
	out.println("<br>");
	
	//view reviews	
	out.println("<form id = 'prodviewreview' method = 'get' action = 'ViewReview'>");
	out.println("<input type='hidden' name='product_name' value="+map.get(key).getName()+"></input>");
	out.println("<button type='submit' name='button' value="+map.get(key).getName()+">View Review</button>");	  
	out.println("</form>");
		
	
		//out.println("<button type='submit' name='button' value="+map.get(key)+">Write Review</button>");
		//out.println("<button type='submit' name='button' value="+map.get(key)+">View Review</button>");
		
		//out.println("<button type='submit' name='button'>Checkout</button>");
		
		//out.println("</div>");
		//out.println("<input type='submit' value='Add to cart' style='background-color:transparent'></input>");
				
		ArrayList<Accessory> acclist = map.get(key).getAccessories();
		if(acclist.size()!=0)
			out.println("<h2>Accessories</h2>");
		/*for(Accessory acc : acclist)
		{
			out.println("<h3> Name: "+acc.getName()+"</h3>");
			out.println("<img src =images/"+acc.getImage()+" width='20%' height='20%'>");
			out.println("<h5> Price: "+acc.getPrice()+"</h5>");
			out.println("<form id='prodaddtocart' action='ProductServlet'>");
			out.println("<input type='submit' value='Add to cart' style='background-color:transparent'></input>");
			out.println("</form>");
		}*/
		
		//Carousel
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
			
			out.println("<img src =images/"+acclist.get(0).getImage()+" width='20%' height='20%'>");
			out.println("<h1>"+acclist.get(0).getName()+"</h1>");
			out.println("<h1>$ "+acclist.get(0).getPrice()+"</h1>");
			out.println("<button onclick=Addtocart("+map1.get(key)+")><h4>Add to cart</h4></button>");
			
			out.println("</div>");
			
			
			for(int i=1;i<acclist.size();i++)
			{
				out.println("<div class='item'>");
				out.println("<img src =images/"+acclist.get(i).getImage()+" width='20%' height='20%'>");
				out.println("<h1>"+acclist.get(i).getName()+"</h1>");
				out.println("<h1>$ "+acclist.get(i).getPrice()+"</h1>");
				out.println("<button onclick=Addtocart("+map1.get(key)+")><h4>Add to cart</h4></button>");
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
		out.println("</div>");
		}
		
		
		out.println("</div>");
	}
	
	//DISPLAYING JUST ACCESSORIES
	for(String key:map1.keySet())
	{
		out.println("<div id='container'>");
		out.println("<h3> Name: "+map1.get(key).getName()+"</h3>");
		out.println("<img src =images/"+map1.get(key).getImage()+" width='25%' height='25%'>");
		out.println("<h5> Price:$ "+map1.get(key).getPrice()+"</h5>");
		out.println("<h5> Retailer: "+map1.get(key).getRetailer()+"</h5>");
		out.println("<h5> Condition: "+map1.get(key).getCondition()+"</h5>");
		out.println("<h5> Discount:$ "+map1.get(key).getDiscount()+"</h5>");
		out.println("<form id='prodaddtocart' action='Addtocart'>");
		out.println("<input type='hidden' name='pagename' value="+product_type+"></input>");
		out.println("<button type='submit' name='button' value="+map1.get(key)+">Add to cart</button>");
		out.println("</form>");
		out.println("</div>");
		
	}
	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=phones'>Phones</a></li>");
	out.println("<li><a href='ProductServlet?param1=laptops'>Laptop</a></li>");
	out.println("<li><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
	out.println("<li><a href='ProductServlet?param1=accessories'>Accessories</a></li>");
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
			out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='/'>Smart <span> Portables</span></a></h1>");
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
	out.println("<li class=''><a href='Registration'>Register</a></li>");
	out.println("<li class='' ><a href='Login'>Sign in</a></li>");
	}
	  else if (fname.equals("StoreManager")){
		  out.println("<li class=''><a href='Registration'>Register Customer</a></li>");
		  out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		  
		  
	  } else
	{
		out.println("<li class=''><a href='#'>Hello  "+fname+"</a></li>");
		out.println("<li class='' ><a href='SignOut'>Sign Out</a></li>");
	}

	
out.println("<li class='' ><a href='Vieworder '>View Orders</a></li>");
		
			
			
			out.println("<div align='right'>");
			out.println("<form action='ViewCart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			out.println("</div>");
			
	//out.println("<img class='header-image' src='images/combined.jpg' width = '100%' height = '100%' alt='Index Page Image' />");
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	
	//SaxParser4SmartPortableXMLdataStore obj1 = new SaxParser4SmartPortableXMLdataStore("ProductCatalog.xml");
	//obj.populateSerializedDataStore();
	//System.out.println("Ewfweew");
	SmartPortablesSerializedDataStore obj1=(SmartPortablesSerializedDataStore) request.getAttribute("obj1");
	//System.out.println(request.getParameterValues("param1"));
	String product_type=request.getParameter("param1");
	//out.println("<h5>"+s1+"</h5>");
	//obj1.hm_accessories.get("acc1").getPrice();
	//System.out.println(obj.hm_smartwatches);
	//System.out.println(obj.hm_smartwatches.get("SmartWatch1"));
	//out.println("<h5>"+obj1.hm_accessories.get("acc1").getName()+"</h5>");
	HashMap<String,Product> map = new HashMap<String,Product>();
	if(product_type.equalsIgnoreCase("SmartWatches"))
		map=obj1.hm_smartwatches;
	else if(product_type.equalsIgnoreCase("Speakers"))
		map=obj1.hm_speakers;
	else if(product_type.equalsIgnoreCase("Headphones"))
		map=obj1.hm_headphones;
	else if(product_type.equalsIgnoreCase("Phones"))
		map=obj1.hm_phones;
	else if(product_type.equalsIgnoreCase("Laptops"))
		map=obj1.hm_laptops;
	else if(product_type.equalsIgnoreCase("ExternalStorages"))
		map=obj1.hm_externalstorages;
	
	for(String key:map.keySet())
	{
		out.println("<div id='container'>");
		out.println("<h5> Name: "+map.get(key).getName()+"</h5>");
		out.println("<img src =images/"+map.get(key).getImage()+" width='25%' height='25%'>");
		out.println("<h5> Price: "+map.get(key).getPrice()+"</h5>");
		out.println("<h5> Retailer: "+map.get(key).getRetailer()+"</h5>");
		out.println("<h5> Condition: "+map.get(key).getCondition()+"</h5>");
		out.println("<h5> Discount: "+map.get(key).getDiscount()+"</h5>");
		out.println("<form id='addtocart' action='ProductServlet'>");
		out.println("<input type='submit' value='Add to cart' style='background-color:transparent'></input>");
		out.println("</form>");
		out.println("</div>");
	}
	
	
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	out.println("<li><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=phones'>Phones</a></li>");
	out.println("<li><a href='ProductServlet?param1=laptops'>Laptop</a></li>");
	out.println("<li><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
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
