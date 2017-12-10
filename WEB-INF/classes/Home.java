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

public class Home extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
		  
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
	
	SmartPortablesSerializedDataStore obj1 = new SmartPortablesSerializedDataStore();
    obj1.populateSerializedDataStore();
	
	HttpSession session = request.getSession();
   
	String fname=(String)session.getAttribute("fname");
	String type =(String)session.getAttribute("type");
	//out.println("In home-"+fname);
	//Header starts from here
	
     out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			//out.println("<script  type='text/javascript' src='javascript.js'></script>");
			out.println("<script  type='text/javascript'>");
			out.println("function init(){completeField=document.getElementById('searchId');completeTable=document.getElementById('complete-table');autoRow=document.getElementById('auto-row');}");
			out.println("function doCompletion(){var url='autocomplete?action=complete&searchId='+escape(searchId.value);req=initRequest();req.open('GET',url,true);req.onreadystatechange=callback;req.send();}");
			out.println("function initRequest(){if(window.XMLHttpRequest){if(navigator.userAgent.indexOf('MSIE')!=-1){isIE=true;}return new XMLHttpRequest();}else if(window.ActiveXObject){isIE=true;return new ActiveXObject('Microsoft.XMLHTTP');}}");
			out.println("function appendProduct(productName,productId){var row;var cell;var linkElement;if(true){completeTable.style.display='block';row=completeTable.insertRow(completeTable.rows.length);cell=row.insertCell(0);}else{completeTable.style.display='table';row=document.createElement('tr');cell=document.createElement('td');row.appendChild(cell);completeTable.appendChild(row);}cell.className='popupCell';linkElement=document.createElement('a');linkElement.className='popupItem';linkElement.setAttribute('href','autocomplete?action=lookup&searchId='+productId);linkElement.appendChild(document.createTextNode(productName));cell.appendChild(linkElement);}");
			out.println("function parseMessages(responseXML){if(responseXML==null){return false;}else{var products=responseXML.getElementsByTagName('products')[0];if(products.childNodes.length>0){completeTable.setAttribute('bordercolor','black');completeTable.setAttribute('border', '1');for(loop=0;loop<products.childNodes.length;loop++){var product=products.childNodes[loop];var productName=product.getElementsByTagName('productName')[0];	var productId=product.getElementsByTagName('id')[0];appendProduct(productName.childNodes[0].nodeValue,productId.childNodes[0].nodeValue);}}}}");
			out.println("function callback(){clearTable();if(req.readyState==4){if(req.status==200){parseMessages(req.responseXML);}}}");
			out.println("function clearTable(){if(completeTable.getElementsByTagName('tr').length>0){completeTable.style.display='none';for(loop=completeTable.childNodes.length-1;loop>=0;loop--){completeTable.removeChild(completeTable.childNodes[loop]);}}}");
			out.println("</script>");
			out.println("<title>Smart Portables</title>");
			out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
			out.println("<link rel='stylesheet' href='styles.css' type='text/css' />");
		out.println("</head>");
		out.println("<body>");
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='Home'>SMARTPORTABLES</span></a></h1>");
			
			if(fname!=null)
			{
				out.println("<h3 align='right' color:'black'>Welcome, "+fname+"</h3>");
				out.println("<div align='right'>");
				out.println("<a href='SignOut'>Sign out</a>");
				out.println("</div>");
			}
			
			out.println("<body onload='init()'>");
			out.println("<div name='autofillform' align='left'>");
			out.println("<h4>Search Product</h4>");
			out.println("<input type='text' name='searchId' value='' class='searchform' id='searchId' onkeyup='doCompletion()' placeholder='search here..' style='padding:5px;font-size:16px;' />");
			out.println("<div id='auto-row'>");			
			out.println("<table id='complete-table' style='position:absolute;width:315px;background-color:yellow'></table>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
		//out.println("</form>");	
		
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
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
			
				if (fname== null)
			{
			out.println("<li class=''><a href='Register'>Register</a></li>");
			out.println("<li class='' ><a href='Login'>Sign in</a></li>");
			}
				else
				{
					if(type.equals("storemanager"))
					response.sendRedirect("Managestore");
				
				/*out.println("<li class=''><a href='Addproduct'>Add Product</a></li>");
					out.println("<li class=''><a href='Inventory'>Inventory</a></li>");
					out.println("<li class=''><a href='Salesreports'>Sales Reports</a></li>");	*/				
				}
			out.println("<li class='' ><a href='Vieworder'>View Orders</a></li>");
					
			
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			
		
			
	//Content starts from here
	
	out.println("<img class='header-image' src='images/home.jpg' width = '100%' height = '100%' alt='Index Page Image' />");
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offer variety of electronics gadgets</p>");
	out.println("<p>Shop at the best market rate</p>");
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Products Available</h2>");
	out.println("<p>Smart Watches</p>");
	out.println("<p>Speakers</p>");
	out.println("<p>Headphones</p>");
	out.println("<h2>Accessories Available</h2>");
	out.println("<p>Mobile Cover</p>");
	out.println("<p>Laptop Bag</p>");
	out.println("<p>Take two Interactive</p>");
	out.println("</article>");
	
	//Deal-match starts
	
	out.println("<article class='expanded'>");
	out.println("<h2>The world trusts us to deliver SPEEDY service for electronic items</h2><br>");
	out.println("<h2>We beat our competitors in all aspects. Price-match Guaranteed</h2><br>");
	RequestDispatcher rd=request.getRequestDispatcher("DealMatches");  
    rd.include(request, response);
	out.println("</article>");
	
	//Deal-match ends
	
	out.println("</section>");
	out.println("<aside class='sidebar'>");
	out.println("<ul>");	
	out.println("<li>");
	out.println("<h4>Products</h4>");
	out.println("<ul>");
	
	//Left Navigation area
	
	out.println("<li><a href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
	out.println("<li><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
	out.println("<li><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
	out.println("<li><a href='ProductServlet?param1=phones'>Phones</a></li>");
	out.println("<li><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
	out.println("<li><a href='ProductServlet?param1=accessories'>Accessories</a></li>");
	out.println("<li  class=''><a href='Trending'>Trending</a></li>");
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
	
	//Footer
	
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
	SmartPortablesSerializedDataStore obj1 = new SmartPortablesSerializedDataStore();
    obj1.populateSerializedDataStore();
    PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession();
   
	String fname =(String)session.getAttribute("fname");
	String type = (String)session.getAttribute("type");
	
	
	//Header 
	
    out.println("<html>");
		out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' content='no-cache'/>");
			out.println("<title>Smart Portables</title>");
			
			
			if(fname !=null)
			{
				out.println("<h3 align='right' color:'black'>Hello  "+fname +"</h3>");
				out.println("<div align='right'>");
				out.println("<a href='SignOut'>Sign out</a>");
				out.println("</div>");
			}
			
			out.println("<link rel='shortcut icon' href='cart/icon.jpg'/>");
			
		
			out.println("<div id='container'>");
			out.println("<header>");
			out.println("<h1><a href='Home'>SMARTPORTABLES</a></h1>");
			out.println("</header>");
			out.println("<nav>");
			out.println("<ul>");
			out.println("<li  class='start selected'><a id='home' href='Home'>Home</a></li>");
			out.println("<li  class=''><a id='smartwatches' href='ProductServlet?param1=smartwatches'>Smart Watches</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=speakers'>Speakers</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=headphones'>Headphones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=phones'>Phones</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
			out.println("<li  class=''><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
			out.println("<li  class=''><a href='Trending'>Trending</a></li>");
			
				if(fname !=null)
			{
				out.println("<h3 align='right' color:'black'>Hello  "+fname +"</h3>");
				out.println("<div align='right'>");
				out.println("<a href='SignOut'>Sign out</a>");
				out.println("</div>");
			}
			
			if (fname  == null)
			{
			out.println("<li class=''><a href='Register'>Register</a></li>");
			out.println("<li class='' ><a href='Login'>Sign in</a></li>");
			} 

	
	out.println("<li class='' ><a href='Vieworder'>View Orders</a></li>");
		
			
			
			out.println("<div align='right'>");
			out.println("<form action='Viewcart'>");
			out.println("<button type='submit' style='background-color:transparent'><img src='images/cart.png' width = '60px' height = '63px'></button>");
			out.println("</form>");
			out.println("</ul>");
			out.println("</nav>");
			out.println("</div>");
			
	out.println("<img class='header-image' src='images/combined.jpg' width = '100%' height = '100%' alt='Index Page Image' />");
	out.println("<div id='body'>");
	out.println("<section id='content'>");
	out.println("<article>");
	out.println("<h2>Welcome to Smart Portables</h2>");
	out.println("<p>Smart Portables offer variety of electronics gadgets</p>");
	out.println("<p>Shop at the best market rate</p>");
	out.println("</article>");
	out.println("<article class='expanded'>");
	out.println("<h2>Products Available</h2>");
	out.println("<p>Smart Watches</p>");
	out.println("<p>Speakers</p>");
	out.println("<p>Headphones</p>");
	out.println("<h2>Accessories Available</h2>");
	out.println("<p>Mobile Cover</p>");
	out.println("<p>Laptop Bag</p>");
	out.println("<p>Take two Interactive</p>");
	out.println("</article>");
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
	out.println("<li><a href='ProductServlet?param1=laptops'>Laptops</a></li>");
	out.println("<li><a href='ProductServlet?param1=externalstorages'>External Storage</a></li>");
	out.println("<li  class=''><a href='Trending'>Trending</a></li>");
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
