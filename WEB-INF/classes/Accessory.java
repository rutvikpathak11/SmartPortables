


public class Accessory implements java.io.Serializable{
	 String name;
	 int price;
	 String image;
	 String retailer;
	 String condition;
	 int discount;
	 double manrebate;
	
	public Accessory(String name, int price, String image, String retailer,String condition,int discount,double manrebate){
		this.name=name;
		this.price=price;
		this.image=image;
		this.condition=condition;
		this.discount = discount;
		this.retailer = retailer;
		this.manrebate=manrebate;
	}
	
	
	public Accessory() {
		
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public double getManrebate() {
		return manrebate;
	}
	
	public void setManrebate(double manrebate) {
		this.manrebate = manrebate;
	}

}
