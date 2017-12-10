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

 public class DealMatches extends HttpServlet 
 {
	
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException 
	  {
 
		HttpSession session = request.getSession();
		String fname=(String)session.getAttribute("fname");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HashMap<String,Product> selectedProducts = new HashMap<String, Product>();
		HashMap<String,Product> productmap = new HashMap<String, Product>();
		
		String line = null;		
		
		try
		{			
				
			productmap = MySqlDataStoreUtilities.getData();
			out.println("<h2 align='center'>Deal Matches</h2><br>");
			for(Map.Entry<String,Product> entry : productmap.entrySet())
			{				
				
				if(selectedProducts.size()<2 && !selectedProducts.containsKey(entry.getKey()))
				{					
					BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\apache-tomcat-7.0.34\\webapps\\Assignment5\\DealMatches.txt")));
					line = reader.readLine();
					if(line == null)
					{
						out.println("<h2 align='center'>No Offers Found</h2>");
						break;
					}
					else
					{
						
						do
						{
							if(line.contains(entry.getKey().replace('_',' ')))
							{
								out.println("<h3>"+line+"</h3>");
								out.println("<br>");
								selectedProducts.put(entry.getKey(),entry.getValue());
								break;
							}
						}while((line= reader.readLine()) != null);
					}
					reader.close();
				}				
			}
			
										
			for(Map.Entry<String,Product> entry : selectedProducts.entrySet())
			{	
				out.println("<h3> Name: "+entry.getKey()+"</h3>");
				out.println("<h5> Price: "+entry.getValue().getPrice()+"</h5>");
				out.println("<img src =images/"+entry.getValue().getImage()+" width='25%' height='25%'>");
				
				if(fname!=null)
				{
				out.println("<form id='prodaddtocart' method='get' action='Addtocart'>");
				out.println("<input type='hidden' name='pagename' value='viewcart'></input>");
				out.println("<button type='submit' name='button' value="+entry.getKey()+">Add to cart</button>");
				out.println("</form>");
				out.println("<br>");
	
				out.println("<form id='prodwritereview' action='WriteReview'>");
				out.println("<input type='hidden' name='product_type' value="+entry.getValue().getType()+"></input>");
				out.println("<button type='submit' name='button' value="+entry.getValue().getName()+">Write Review</button>");
				out.println("</form>");
				out.println("<br>");
				
				out.println("<form id='prodviewreview' action='ViewReview'>");
				out.println("<input type='hidden' name='product_name' value="+entry.getValue().getName()+"></input>");
				out.println("<button type='submit' name='button' value="+entry.getValue().getName()+">View Review</button>");
				out.println("</form>");
				out.println("<br>");			
				}	
				
			}
					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
			
	}
 }


 