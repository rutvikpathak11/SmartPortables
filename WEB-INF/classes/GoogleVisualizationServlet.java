import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


public class GoogleVisualizationServlet extends HttpServlet 
{
	 private static final long serialVersionUID = 1L;
	 
	 public GoogleVisualizationServlet() 
	 {
	  super();
	 }

	 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	 {
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<AvailableProduct> availableproductslist = obj.availablequantity();
		
		  Gson gson = new Gson();
		  String jsonString = gson.toJson(availableproductslist);
		  response.setContentType("application/json");
		  response.getWriter().write(jsonString);
		
	 }
	 
	 
	  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	 {
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		List<String> productnamescustorders = obj.getallproductnamescustorders();
		List<forJsonSalesBarChart> obj1 = new ArrayList<forJsonSalesBarChart>();
		
		for(String name:productnamescustorders)
		{
			int count = obj.getCount(name);
			double price = obj.getprice(name);
			double totalsales = count*price;
			
			forJsonSalesBarChart forBarChartObj = new forJsonSalesBarChart();
			forBarChartObj.setproductName(name);
			forBarChartObj.setTotalSales(totalsales);
			obj1.add(forBarChartObj);		
			
		}
		 
		  Gson gson = new Gson();
		  String jsonString = gson.toJson(obj1);
		  response.setContentType("application/json");
		  response.getWriter().write(jsonString);
		
	 }
}


class forJsonSalesBarChart
{
	String productName; 
	double totalSales;
	
	public void setproductName(String productName)
	{
		this.productName = productName;
	}
	public void setTotalSales(double totalSales)
	{
		this.totalSales = totalSales;
	}
	
	public String getproductName()
	{
		return this.productName;
	}
	public double getTotalSales()
	{
		return this.totalSales;
	}
}