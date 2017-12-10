import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class MySqlDataStoreUtilities
{
	static Connection con = null;
	static
	{
		try
		{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
		}
		catch(Exception ex)
		{
		}
	}
	static int new_count=0;
	//static int count=0;
		
	public static void insertUser(String fname,String lname,String email,String userid,String password,String category)
	{
		
	try{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
	
	String insertIntoCustomerRegisterQuery = "INSERT INTO Registration "+ "VALUES (?,?,?,?,?,?);";
	PreparedStatement pst = con.prepareStatement(insertIntoCustomerRegisterQuery);
	
	pst.setString(1,fname);
	pst.setString(2,lname);
	pst.setString(3,email);
	pst.setString(4,userid);
	pst.setString(5,password);
	pst.setString(6,category);
	pst.execute();
	
	pst.close();
	con.close();
	}
	catch(Exception e){}
	}
	
	public static boolean CheckUser(String userid,String password,String category) 
     {
      boolean st = false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
         PreparedStatement ps =con.prepareStatement("select * from registration where userid=? and password=? and category=?");
         ps.setString(1, userid);
         ps.setString(2, password);
		 ps.setString(3, category);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
		 
		//String fname=rs.getString("fname");
		//String type=rs.getString("category");
        
		rs.close();
		ps.close();
		con.close();
		
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }  
  
	public static String ViewUsername(String userid)
     {
      String fname1=null;
	  
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
		 
	 //creating query	
		 PreparedStatement ps =con.prepareStatement("select * from registration where userid=?");
         ps.setString(1, userid);
     
	 //executing query
		 ResultSet rs =ps.executeQuery();
		// fname1=rs;
        
		while(rs.next())
		{
		fname1=rs.getString("fname");  
		}
		//rs.close();
		ps.close();
		con.close();	
		
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return fname1;	   
	}  
	
	public static void insertOrder(String orderid,
								   String product_name,
								   String fname,
								   String address,
								   int zipcode,
								   long creditcardnumber,
								   String orderdate,
								   String deliverydate)
	{
		
	try{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
	
	String insertIntoCustomerOrdersRegisterQuery = "INSERT INTO customerorders "+ "VALUES (?,?,?,?,?,?,?,?);";
	PreparedStatement pst = con.prepareStatement(insertIntoCustomerOrdersRegisterQuery);
	
	pst.setString(1,orderid);
	pst.setString(2,product_name);
	pst.setString(3,fname);
	pst.setString(4,address);
	pst.setInt(5,zipcode);
	pst.setLong(6,creditcardnumber);
	pst.setString(7,orderdate);
	pst.setString(8,deliverydate);
	
	
	pst.execute();
	
	pst.close();
	con.close();
	}
	catch(Exception e){}
	}
  
  
	public static SmartPortableUser selectUser(String fname1)
	{
	SmartPortableUser user = null;	
      String fname2=null;
	  String lname2=null;
	  String userid2=null;
	  String password2=null;
	  String email2=null;
	  String category2=null;
	  
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
		 
	 //creating query	
		 PreparedStatement ps =con.prepareStatement("select * from registration where fname=?");
         ps.setString(1, fname1);
     
	 //executing query
		 ResultSet rs =ps.executeQuery();
		// fname1=rs;
        
		while(rs.next())
		{
		fname2=rs.getString("fname");  
		lname2=rs.getString("lname"); 
		userid2=rs.getString("userid"); 
		password2=rs.getString("password"); 
		email2=rs.getString("emailid"); 
		category2=rs.getString("category"); 
		}
		
		user = new SmartPortableUser(fname2,lname2,userid2,password2,email2,category2);
		
		//rs.close();
		ps.close();
		con.close();	
		
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return user;	   
	}  
	
	public static ArrayList<Orders> getOrder(String fname1)
	{
	
	ArrayList<Orders> orders=new ArrayList<Orders>();
	
		//SmartPortableUser user = null;	
		String orderid3=null;
		String product_name3=null;
		String fname3=null;
		
		String address3=null;
		int zipcode3;
		long creditcardnumber3;
		String orderdate3=null;
		String deliverydate3=null;
	  
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
		 
	 //creating query	
		 PreparedStatement ps =con.prepareStatement("select * from customerorders where fname=?");
         ps.setString(1, fname1);
     
	 //executing query
		 ResultSet rs =ps.executeQuery();
		// fname1=rs;
        
		while(rs.next())
		{
		orderid3=rs.getString("orderid");  
		product_name3=rs.getString("product_name"); 
		fname3=rs.getString("fname"); 
		
		address3=rs.getString("address"); 
		zipcode3=rs.getInt("zipcode"); 
		creditcardnumber3=rs.getLong("creditcardnumber");
		orderdate3=rs.getString("orderdate");
		deliverydate3=rs.getString("deliverydate");
		
		SmartPortableUser user1 = selectUser(fname3);
		Orders o = new Orders(orderid3,user1,product_name3,new ArrayList<Object>(),address3,zipcode3,creditcardnumber3);
		o.setOrderdate(orderdate3);
		o.setDeliverydate(deliverydate3);
		orders.add(o);		
		}
		
		//user = new SmartPortableUser(fname2,lname2,userid2,password2,email2,category2);
		
		//rs.close();
		ps.close();
		con.close();	
		
      }catch(Exception e)
      {
          e.printStackTrace();
      }
       return orders;	   
	}  

	public static void deleteOrder(String orderid)
	{
		
	try{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
	
	String deleteQuery = "DELETE FROM customerorders WHERE orderid = ?";
	PreparedStatement pst = con.prepareStatement(deleteQuery);
	
	pst.setString(1,orderid);
		
	pst.execute();
	
	pst.close();
	con.close();
	}
	catch(Exception e){}
	}
	
	
	public static List<Orders> getTopFiveSoldProducts()
	{
		List<Orders> orders = new ArrayList<Orders>();
		String orderid4=null;
		String product_name4=null;
		String fname4=null;
		
		String address4=null;
		int zipcode4;
		long creditcardnumber4;
		String orderdate4=null;
		String deliverydate4=null;
		
		try
		{
			
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
			String query = "select * from customerorders GROUP BY product_Name order by count(product_name) DESC LIMIT 5;";
			
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			
		
			int productCount=0;
			while(rs.next())
			{
				++productCount;
				if(productCount > 5)
					break;
				
		orderid4=rs.getString("orderid");
		//order.setUser(rs.getSmartPortableUser("user"));	
		product_name4=rs.getString("product_name"); 
		fname4=rs.getString("fname");		
		address4=rs.getString("address"); 
		zipcode4=rs.getInt("zipcode"); 
		creditcardnumber4=rs.getLong("creditcardnumber");
		orderdate4=rs.getString("orderdate");
		deliverydate4=rs.getString("deliverydate");
		
		SmartPortableUser user4 = selectUser(fname4);
		Orders o = new Orders(orderid4,user4,product_name4,new ArrayList<Object>(),address4,zipcode4,creditcardnumber4);
		o.setOrderdate(orderdate4);
		o.setDeliverydate(deliverydate4);
		orders.add(o);	

			
			}
			
			pst.close();
			con.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return orders;
	}
	
	public static List<Orders> getTopFiveZipCodes()
	{
		List<Orders> orders = new ArrayList<Orders>();
		String orderid4=null;
		String product_name4=null;
		String fname4=null;
		
		String address4=null;
		int zipcode4;
		long creditcardnumber4;
		String orderdate4=null;
		String deliverydate4=null;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
		//	OrderDetails order=null;		
		String query = "select * from customerorders "+
					   "group by zipcode "+
					   "order by count(zipcode) DESC LIMIT 5";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			int productCount=0;
			while(rs.next())
			{
				++productCount;
				if(productCount > 5)
					break;
				orderid4=rs.getString("orderid");
		//order.setUser(rs.getSmartPortableUser("user"));	
		product_name4=rs.getString("product_name"); 
		fname4=rs.getString("fname");		
		address4=rs.getString("address"); 
		zipcode4=rs.getInt("zipcode"); 
		creditcardnumber4=rs.getLong("creditcardnumber");
		orderdate4=rs.getString("orderdate");
		deliverydate4=rs.getString("deliverydate");
		
		SmartPortableUser user4 = selectUser(fname4);
		Orders o = new Orders(orderid4,user4,product_name4,new ArrayList<Object>(),address4,zipcode4,creditcardnumber4);
		o.setOrderdate(orderdate4);
		o.setDeliverydate(deliverydate4);
		orders.add(o);	

		pst.close();
		con.close();		
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return orders;
	}
	
	public static void addProduct(String productname,String image,int quantity,double price,String retailer,String cond,int discount,double manrebate, String prodtype)
	{
		
	try{
	Connection con = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
	
	String insertIntoProductRegisterQuery = "INSERT INTO Product "+ "VALUES (?,?,?,?,?,?,?,?,?);";
	PreparedStatement pst = con.prepareStatement(insertIntoProductRegisterQuery);
	
	pst.setString(1,productname);
	pst.setString(2,image);
	pst.setInt(3,quantity);
	pst.setDouble(4,price);
	pst.setString(5,retailer);
	pst.setString(6,cond);
	pst.setInt(7,discount);
	pst.setDouble(8,manrebate);
	pst.setString(9,prodtype);
	pst.execute();
	
	con.commit();
	pst.close();
	con.close();
	}
	catch(Exception e){}
	}
	
	
	public void insertproductsinSQL(String productname,String image,int price,String retailer,String cond,int discount,int quantity,double manrebate,String prodtype)
	{			
		
	try{
	Statement stmt = con.createStatement();
	String checkquery="SELECT * FROM Product";
	ResultSet rs =stmt.executeQuery(checkquery);
	
	while(rs.next())
	{
		new_count++;
	}
	
	
	if(true)//new_count<70)
	{
	
	String Query = "INSERT INTO Product "+ "VALUES (?,?,?,?,?,?,?,?,?);";
	PreparedStatement pst = con.prepareStatement(Query);	
	
	pst.setString(1,productname);
	pst.setString(2,image);
	pst.setInt(3,quantity);
	pst.setDouble(4,price);
	pst.setString(5,retailer);
	pst.setString(6,cond);
	pst.setInt(7,discount);
	pst.setDouble(8,manrebate);
	pst.setString(9,prodtype);
	pst.execute();
	
	con.commit();
	pst.close();		
	con.close();
	}
	}
	catch(Exception e){}
	}
	
	
	public static List<AvailableProduct> availablequantity()
	{
		List<AvailableProduct> availableproducts = new ArrayList<AvailableProduct>();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
		//	OrderDetails order=null;		
		String query = "select productname,quantity,price from Product";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
			AvailableProduct availableProduct = new AvailableProduct();	
			availableProduct.setProductname(rs.getString("productname"));
            availableProduct.setQuantity(rs.getInt("quantity"));
            availableProduct.setPrice(rs.getDouble("price"));
            availableproducts.add(availableProduct);				
			}
			pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return availableproducts;
	}
	
	public static List<String> getallproductnames()
	{
		List<String> productnames = new ArrayList<String>();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
		//	OrderDetails order=null;		
		String query = "select productname from Product";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				productnames.add(rs.getString("productname"));			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return productnames;
	}
	
	public static List<String> getallproductnameswithdiscount()
	{
		List<String> productnameswithdiscount = new ArrayList<String>();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
				
			String query = "select productname from Product where discount!=0.0";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				productnameswithdiscount.add(rs.getString("productname"))	;			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return productnameswithdiscount;
	}
	
	public static double getdiscount(String name)
	{
		double discount=0;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
						
					
			PreparedStatement pst =con.prepareStatement("SELECT discount from product where productname = ?");
			pst.setString(1, name);						
			
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				discount = rs.getInt("discount");			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return discount;
	}
	
	public static double getprice(String name)
	{
		double price=0;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
						
					
			PreparedStatement pst =con.prepareStatement("SELECT price from product where productname = ?");
			pst.setString(1, name);						
			
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				price = rs.getInt("price");			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return price;
	}
	
	public static List<String> getallproductnameswithrebate()
	{
		List<String> productnameswithrebate = new ArrayList<String>();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
				
			String query = "select productname from Product where manrebate!=0.0";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				productnameswithrebate.add(rs.getString("productname"))	;			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return productnameswithrebate;
	}
	
	public static double getrebate(String name)
	{
		double rebate=0;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
						
					
			PreparedStatement pst =con.prepareStatement("SELECT manrebate from product where productname = ?");
			pst.setString(1, name);						
			
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				rebate = rs.getInt("manrebate");			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return rebate;
	}
	
	public static List<String> getallproductnamescustorders()
	{
		List<String> productnamescustorders = new ArrayList<String>();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
				
			String query = "select distinct product_name from customerorders";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				productnamescustorders.add(rs.getString("product_name"))	;			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return productnamescustorders;
	}
	
	public static int getCount(String name)
	{
		int count=0;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
						
					
	PreparedStatement pst =con.prepareStatement("SELECT count(product_name) as count1 from customerorders where product_name = ? group by product_name");
	pst.setString(1, name);						
			
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				count = rs.getInt("count1");			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return count;
		
		
	}
	
	public static TreeMap<String,Double> getdailysalesamount()
	{
		TreeMap<String,Double> dailysalesamount = new TreeMap<String,Double>();
				
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
				
			String query =  "select CONCAT(substr(c.orderdate,4,7),substr(c.orderdate,24,5)) as 'Day',sum(p.price) as 'Total' "+
							"from customerorders c, product p "+
							"where p.productname=c.product_name "+
							"group by CONCAT(substr(c.orderdate,4,7),substr(c.orderdate,24,5))";
						
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				dailysalesamount.put(rs.getString("Day"),rs.getDouble("Total"))	;			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dailysalesamount;
	}
	
	public static void deleteproduct(String deleteproductname)
	{		
		try
		{				
			String query = "delete from product where productname = ? ;";
						
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,deleteproductname);			
			
			pst.execute();
			
		//con.commit();
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void updateproduct(String updateproductnameparam,String newprice,String newdiscount,String newmanrebate)
	{	
		int price = Integer.parseInt(newprice);
		int discount = Integer.parseInt(newdiscount);
		double manrebate = Double.parseDouble(newmanrebate);
		
		try
		{			
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
			String query = "Update product set price = ?, discount = ?, manrebate = ? where productname = ? ;";
						
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,price);			
			pst.setInt(2,discount);			
			pst.setDouble(3,manrebate);			
			pst.setString(4,updateproductnameparam);			
			
			pst.execute();
			
		//con.commit();
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static Product getProduct(String searchId)
	{
		Product p = new Product();
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
			
		//	OrderDetails order=null;		
		String query = "select * from Product where productname = ?";
						
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,searchId);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				p = new Product(rs.getString("productname"),rs.getString("productname"),rs.getInt("price"),rs.getString("image"),rs.getString("retailer"),rs.getString("cond"),rs.getInt("discount"),rs.getDouble("manrebate"),new ArrayList<Accessory>());			
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return p;
	}
	
	public static String getProductType(String searchId)
	{
		String prodtype=null;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
				
		String query = "select prodtype from Product where productname = ?";
						
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,searchId);
			ResultSet rs =pst.executeQuery();		
			
			while(rs.next())
			{
				prodtype=rs.getString("prodtype");
			}
			
			
		pst.close();
		con.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return prodtype;
	}
	
	public void deleteproductsfromsql()
	{
		
	try{
	
	String query = "delete from product; ";
	PreparedStatement pst = con.prepareStatement(query);
	
	pst.execute();
	con.commit();
	pst.close();
	con.close();
	}
	catch(Exception e){}
	}
	
	public static HashMap<String,Product> getData() throws SQLException
	{
		HashMap<String,Product> productmap = new HashMap<String,Product>();
		Product p=null;
		
		try
		{
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/example","root","Mysql@1991");
		
		PreparedStatement pst;
		String getallproducts="select * from product;";
		pst=con.prepareStatement(getallproducts);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			p = new Product(rs.getString("productname"),rs.getString("productname"),rs.getInt("price"),rs.getString("image"),rs.getString("retailer"),rs.getString("cond"),rs.getInt("discount"),rs.getDouble("manrebate"),new ArrayList<Accessory>());			
			productmap.put(rs.getString("productname"), p);
		}
		pst.close();
		con.close();	
		}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
			
		return productmap;
	}
}