import java.io.*;
import java.util.*;

public class Orders {
	
	String orderid;
	SmartPortableUser user;
	ArrayList<Object> cartlist;
	String product_name;
	String address;
	int zipcode;
	long creditcardnumber;
	String orderdate;
	String deliverydate;
	
	public Orders(String orderid, SmartPortableUser user,String product_name, ArrayList<Object> cartlist,String address, int zipcode, long creditcardnumber)
	{
		this.orderid=orderid;
		this.user=user;
		this.product_name=product_name;
		this.cartlist=cartlist;
		
		this.address=address;
		this.zipcode=zipcode;
		this.creditcardnumber=creditcardnumber;
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.orderdate= date.toString();
		cal.add(Calendar.DATE, 14);
		this.deliverydate=(cal.getTime()).toString();
		
	}
	
		public String getOrderid() {
			return orderid;
		}

		public void setOrderid(String orderid) {
			this.orderid = orderid;
		}

		public SmartPortableUser getUser() {
			return user;
		}

		public void setUser(SmartPortableUser user) {
			this.user = user;
		}
		
		public String getProduct_Name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public ArrayList<Object> getCartlist() {
			return cartlist;
		}

		public void setCartlist(ArrayList<Object> getCartlist) {
			this.cartlist = cartlist;
		}

		
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getZipcode() {
			return zipcode;
		}

		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
				
		public long getCreditcardnumber() {
			return creditcardnumber;
		}

		public void setCreditcardnumber(long creditcardnumber) {
			this.creditcardnumber = creditcardnumber;
		}
		
		
		public String getOrderdate() {
			return orderdate;
		}

		public void setOrderdate(String orderdate) {
			this.orderdate = orderdate;
		}
		
		public String getDeliverydate() {
			return deliverydate;
		}

		public void setDeliverydate(String deliverydate) {
			this.deliverydate = deliverydate;
		}
		
}

	
	