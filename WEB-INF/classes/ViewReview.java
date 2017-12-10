import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ViewReview extends HttpServlet 
{
	
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

	String product_name =  request.getParameter("button");

						
			MongoDBDataStoreUtilities obj = new MongoDBDataStoreUtilities();
			List<ProductReview> reviewList = obj.getReviews("productName", product_name);
			int c=1;
		out.println("<h1>View Reviews</h1>");
			for(ProductReview review:reviewList)
		{	
			out.println("<h2>"+c+"</h2>");
			out.println("<table>"+
			"<tr><td width='30%'>Product Name: </td><td>" +review.getProductModelName()+ "</td></tr>"+
			"<tr><td>Product Category: </td> <td>" +review.getProductCategory()+ "</td></tr>"+
			"<tr><td>Product Price: </td> <td>$" +review.getProductPrice()+ "</td></tr>"+
			"<tr><td>Retailer Name: </td> <td>" +review.getRetailerName()+ "</td></tr>"+
			"<tr><td>Retailer City: </td> <td>" +review.getRetailerCity()+ "</td></tr>"+
			"<tr><td>Retailer State: </td> <td>" +review.getRetailerState()+ "</td></tr>"+
			"<tr><td>Retailer Zip: </td> <td>" +review.getRetailerZip()+ "</td></tr>"+
			"<tr><td>ProductOnSale: </td> <td>" +review.getProductOnSale()+ "</td></tr>"+
			"<tr><td>Manufacturer Name: </td> <td>" +review.getManufacturerName()+ "</td></tr>"+
			"<tr><td>Manufacturer Rebate: </td> <td>" +review.getManufacturerRebate()+ "</td></tr>"+
			"<tr><td>User Id: </td> <td>" +review.getUserId()+ "</td></tr>"+
			"<tr><td>User Age: </td> <td>" +review.getUserAge()+ "</td></tr>"+
			"<tr><td>User Gender: </td> <td>" +review.getUserGender()+ "</td></tr>"+
			"<tr><td>User Occupation: </td> <td>" +review.getUserOccupation()+ "</td></tr>"+	
			"<tr><td>Review Rating: </td><td>" +review.getReviewRating()+ "</td></tr>"+
			"<tr><td>Review Date: </td> <td>" +review.getReviewDate()+ "</td></tr>"+
			"<tr><td>Review Text: </td> <td>" +review.getReviewText()+ "</td></tr>"+
			"</table><br>");
			c++;
			
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