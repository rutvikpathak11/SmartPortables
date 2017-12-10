import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class WriteReview extends HttpServlet {
	
	String manufacturerName="SmartPortables", retailerCity="Chicago", retailerState="Illinois", retailerZip="60616";
	String manufacturerRebate="No";
	String reviewDate = null;
		
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  {  
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
	
	//out.println("<article>");
	out.println("<h1>Write Review</h1>");
	//out.println("</article>");
	//out.println("</section>");
	
	//review data
	//Parsing param values.
	if(fname==null)
	{
		//out.println("<section id='content'>");
		//out.println("<article>");
		out.println("<h2>Please Login to Write Reviews!!</h2>");
		out.println("<a href='Login'><h3>Click here to login</h3>");
		//out.println("</article>");
		//out.println("</section>");
		out.println("");
	}
	else
	{
	
	String product_type =  request.getParameter("product_type");
	String product_name =  request.getParameter("button");
	//out.println(product_type);
	//out.println(product_name);
	HashMap<String,Product> map = new HashMap<String,Product>();
	HashMap<String, Accessory> map1 = new HashMap<String,Accessory>();
	
	
	if(product_type.equalsIgnoreCase("SmartWatches")){
		map=SmartPortablesSerializedDataStore.hm_smartwatches;
	//	out.println("<h1> SMART WATCHES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Speakers")){
		map=SmartPortablesSerializedDataStore.hm_speakers;
		//out.println("<h1> SPEAKERS </h1>");
	}
	else if(product_type.equalsIgnoreCase("Headphones")){
		map=SmartPortablesSerializedDataStore.hm_headphones;
	//	out.println("<h1> HEADPHONES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Phones")){
		map=SmartPortablesSerializedDataStore.hm_phones;
	//	out.println("<h1> PHONES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Laptops")){
		map=SmartPortablesSerializedDataStore.hm_laptops;
	//	out.println("<h1> LAPTOPS </h1>");
	}
	else if(product_type.equalsIgnoreCase("ExternalStorages")){
		map=SmartPortablesSerializedDataStore.hm_externalstorages;
		//System.out.println(map.size());
	//	out.println("<h1> EXTERNAL STORAGES </h1>");
	}
	else if(product_type.equalsIgnoreCase("Accessories")){
		map1=SmartPortablesSerializedDataStore.hm_accessories;
		//out.println("<h1> ACCESSORIES </h1>");
	}
		

/*		p=p.replaceAll("\\[","");
		 p=p.replaceAll("\\]","");
		  p=p.replaceAll("\\,","");
		List<String> accessoryList = new ArrayList<String>(); 
		String str[] = p.split(" ");
		Products p1 = new Products();
		
		p1.setName(str[0]);
		p1.setPrice(str[1]);
		p1.setImage(str[2]);
		p1.setManufacturer(str[3]);
		p1.setCondition(str[4]);
		p1.setDiscount(str[5]);
		
		for(int i=6 ; i<str.length; i++)
			accessoryList.add(str[i]);
		p1.setAccessoryList(accessoryList);
		
		/* String retailerName="SmartPortables", retailerCity="Chicago", retailerState="Illinois", retailerZip="60616";
		String productOnSale="Yes", manufacturerRebate="No"; */
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String DATE_FORMAT = "MM/dd/yyyy"; 
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);				
		reviewDate = sdf.format(date);
		//String productCategory = request.getParameter("productCategory");
		
		 //FOR PRODUCTS
	 for(String key:map.keySet())
		{
			if(map.get(key).getName().equals(product_name))
			{
				
						
			out.println("<form method='Post' action='WriteReview'>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Product Model Name</th>");
			out.println("<td>"+map.get(key).getName()+"</th>");
			out.println("<input type='hidden' name='productName' value='"+map.get(key).getName()+"'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Product Category</th>");
			out.println("<td>"+map.get(key).getId()+"</th>");
			out.println("<input type='hidden' name='productCategory' value='" +map.get(key).getId()+ "'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Product Price</th>");
			out.println("<td>"+map.get(key).getPrice()+"</th>");
			out.println("<input type='hidden' name='price' value='"+map.get(key).getPrice()+"'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Retailer Name</th>");
			out.println("<td>"+map.get(key).getRetailer()+"</th>");
			out.println("<input type='hidden' name='retailerName' value='"+map.get(key).getRetailer()+"'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Retailer Zip</th>");
			out.println("<td>"+retailerZip+"</th>");
			out.println("<input type='hidden' name='retailerZip' value='"+retailerZip+"'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Retailer City</th>");
			out.println("<td>"+retailerCity+"</th>");
			out.println("<input type='hidden' name='retailerCity' value='"+retailerCity+"'>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Retailer State</th>");
			out.println("<td>"+retailerState+"</th>");
			out.println("<input type='hidden' name='retailerState' value='"+retailerState+"'>");
			out.println("</tr>");
			
			if(map.get(key).getDiscount()==0)
			{
			out.println("<tr>");
			out.println("<th>Product On Sale</th>");
			out.println("<td>Yes</th>");
			out.println("<input type='hidden' name='productOnSale' value='Yes'>");
			out.println("</tr>");
			}
			else
			{
			out.println("<tr>");
			out.println("<th>Product On Sale</th>");
			out.println("<td>No</th>");
			out.println("<input type='hidden' name='productOnSale' value='No'>");
			out.println("</tr>");	
			}
			out.println("<tr>");
			out.println("<th>Manufacturer Name</th>");
			out.println("<td>"+manufacturerName+"</th>");
			out.println("<input type='hidden' name = 'manufacturerName' value = '" +manufacturerName +"'>");
			out.println("</tr>");
		
			out.println("<th>Manufacturer Rebate</th>");
			out.println("<td>"+manufacturerRebate+"</th>");
			out.println("<input type='hidden' name='manufacturerRebate' value='"+manufacturerRebate+"'>");
			out.println("</tr>");
			
			out.println("</table>");
			out.println("</tr>");
			out.println("</tr>");
			
			}
		}			
		
	 
		out.println("</br>");
		out.println("</br>");		
		out.println("<h1>Enter Product Review</h1>");
		out.println("</br>");
		//out.println("<div style='background-color:#f2f2f2; width:50%'>");
		out.println("<form method='Post' action='WriteReview'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("UserId : "+fname);
		out.println("<input type='hidden' name='fname' value='"+fname+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("UserAge : <input type='text' name='userAge' required></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("User Gender : ");
		out.println("<select name='userGender'>");
		out.println("<option value='Male' >Male</option>");
		out.println("<option value='Female' >Female</option>");
		out.println("</select>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("User Occupation : <input type='text' name='userOccupation'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Review Rating : ");
		out.println("<select name='reviewRating'>");
		out.println("<option value='1' >1</option>");
		out.println("<option value='2' >2</option>");
		out.println("<option value='3' >3</option>");
		out.println("<option value='4' >4</option>");
		out.println("<option value='5' >5</option>");
		out.println("</select>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Review Date : "+reviewDate);
		out.println("<input type='hidden' name='reviewDate' value='"+reviewDate+"'></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Review Text : <textarea name='reviewText' cols='40' rows='5'></textarea></td>");
		out.println("</tr>");
		
		out.println("<input type='hidden' name='product_name' value="+product_name+"></input>");
		out.println("<input type='hidden' name='product_type' value="+product_type+"></input>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type='submit' value='Submit Review'>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("</table/>");		
		out.println("</form>");
		out.println("</br>");
		//out.println("</div>");
	
		//out.println("</article>");
		//out.println("</section>");	
	}
  
	//end of review part.
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
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  {  
    PrintWriter out = response.getWriter();
	response.setContentType("text/html;charset=UTF-8");
  
		
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
	
	out.println("<article>");
	out.println("<h1>Write Review</h1>");
	out.println("</article>");
	out.println("</section>");
	
	//review data
	//Parsing param values.
	String productName = request.getParameter("productName");
	String productCategory = request.getParameter("productCategory");
	String price = request.getParameter("price");
	String retailerName = request.getParameter("retailerName");
	String retailerCity = request.getParameter("retailerCity");
	String retailerState = request.getParameter("retailerState");
	String retailerZip = request.getParameter("retailerZip");
	String productOnSale = request.getParameter("productOnSale");
	String manufacturerName = request.getParameter("manufacturerName");
	String manufacturerRebate = request.getParameter("manufacturerRebate");
	String userId = request.getParameter("fname");
	String userAge = request.getParameter("userAge");
	String userGender = request.getParameter("userGender");
	String userOccupation = request.getParameter("userOccupation");
	String reviewRating = request.getParameter("reviewRating");
	String reviewDate = request.getParameter("reviewDate");
	String reviewText = request.getParameter("reviewText");
	
	MongoDBDataStoreUtilities obj = new MongoDBDataStoreUtilities();
	obj.insertReview(productName, productCategory,  price,  retailerName,  retailerCity, 
					retailerState,  retailerZip,  productOnSale, manufacturerName, manufacturerRebate, userId, userAge,
					userGender,  userOccupation,  reviewRating,  reviewDate,  reviewText);
	
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>You have successfully stored review ! </h2>");
	out.println("</article>");
	out.println("</section>");
	//end of review part.
	
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
