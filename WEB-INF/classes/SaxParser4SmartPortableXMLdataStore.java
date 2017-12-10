
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


////////////////////////////////////////////////////////////

/**************

SAX parser use callback function  to notify client object of the XML document structure. 
You should extend DefaultHandler and override the method when parsin the XML document

***************/

////////////////////////////////////////////////////////////

public class SaxParser4SmartPortableXMLdataStore extends DefaultHandler {
    Product product;
    Accessory accessory;
    static List<Product> products;
    static List<Accessory> accessories;
    String productXmlFileName;
    String elementValueRead;
	String id;
	
	public SaxParser4SmartPortableXMLdataStore()
	{
	}
    
    public SaxParser4SmartPortableXMLdataStore(String productXmlFileName) {
        this.productXmlFileName = productXmlFileName;
        products = new ArrayList<Product>();
        accessories = new ArrayList<Accessory>();
        parseDocument();
        //prettyPrint();
		storeproductsinSQL();
    }


    private void parseDocument() {
    	//System.out.println("pardedoc");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
        	System.out.println(productXmlFileName);
            SAXParser parser = factory.newSAXParser();	
            parser.parse(productXmlFileName,this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

	 private void storeproductsinSQL() {
    	System.out.println("pardedoc"+products.size());
        
		Random r = new Random();
		MySqlDataStoreUtilities obj = new MySqlDataStoreUtilities();
		obj.deleteproductsfromsql();
		
        for(Product p: products)
		{
			
			int Low = 1;
			int High = 500;
			int R = r.nextInt(High-Low) + Low;
						
			obj.insertproductsinSQL(p.getName(),p.getImage(),p.getPrice(),p.getRetailer(),p.getCondition(),p.getDiscount(),R,p.getManrebate(),"Product");
		}
		
		for(Accessory a: accessories)
		{
		
			int Low = 1;
			int High = 500;
			int R = r.nextInt(High-Low) + Low;			
			
			obj.insertproductsinSQL(a.getName(),a.getImage(),a.getPrice(),a.getRetailer(),a.getCondition(),a.getDiscount(),R,a.getManrebate(),"Accessory");
		}
		
		


		
    }

   /* private void prettyPrint() {
    	//System.out.println("prettuprint");
        for (Product product: products) {
        System.out.println("\t\t image: " + product.image);
        System.out.println("\t\t id: " + product.id);
        System.out.println("\t\t name: " + product.name);
        System.out.println("\t\t condition: " + product.condition);
        System.out.println("\t\t price: " + product.price);	
		System.out.println("\t\t retailer: " + product.retailer);
		System.out.println("\t\t discount: " + product.discount);
		for (Accessory accessory: product.getAccessories()) {
			System.out.println("\t\t accessory: " + accessory.getName());
		}
        }
        for(Accessory accessory: accessories)
        {
        	System.out.println("\t\t a_image: " + accessory.image);
            System.out.println("\t\t a_name: " + accessory.name);
            System.out.println("\t\t a_condition: " + accessory.condition);
            System.out.println("\t\t a_price: " + accessory.price);	
    		System.out.println("\t\t a_retailer: " + accessory.retailer);
    		System.out.println("\t\t a_discount: " + accessory.discount);	
        }
    }*/





////////////////////////////////////////////////////////////

/*************

There are a number of methods to override in SAX handler  when parsing your XML document :

    Group 1. startDocument() and endDocument() :  Methods that are called at the start and end of an XML document. 
    Group 2. startElement() and endElement() :  Methods that are called  at the start and end of a document element.  
    Group 3. characters() : Method that is called with the text content in between the start and end tags of an XML document element.


There are few other methods that you could use for notification for different purposes, check the API at the following URL:

https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html

***************/

////////////////////////////////////////////////////////////

    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {
    	//System.out.println("startele");
        if (elementName.equalsIgnoreCase("productcategory")) {
        	id=attributes.getValue("id");
        }
        if(elementName.equalsIgnoreCase("product")) {
        	product = new Product();
        	if(attributes.getValue("id")!=null)
        		id=attributes.getValue("id");
        	product.setId(id);
        }
        if(elementName.equalsIgnoreCase("a_accessory")) {
        	accessory = new Accessory();
        }
        if(elementName.equalsIgnoreCase("a_name")) {
        	accessory.setName(attributes.getValue("a_name"));
        }
        if(elementName.equalsIgnoreCase("a_price")) {
        	//accessory.setPrice(Double.parseDouble(attributes.getValue("a_price")));
        }
        if(elementName.equalsIgnoreCase("a_condition")) {
        	//accessory.setCondition(attributes.getValue("a_condition"));
			accessory.setCondition(attributes.getValue("a_condition"));
        }
        if(elementName.equalsIgnoreCase("a_retailer")) {
        	accessory.setRetailer(attributes.getValue("a_retailer"));
        }
        if(elementName.equalsIgnoreCase("a_discount")) {
        	//accessory.setDiscount(Double.parseDouble(attributes.getValue("a_discount")));
			
			
        }
		
		 if(elementName.equalsIgnoreCase("a_manrebate")) {
        //	accessory.setManrebate(Double.parseDouble(attributes.getValue("a_manrebate")));
					
        }
        
        if(elementName.equalsIgnoreCase("name")) {
        	//System.out.println(attributes.getValue("name"));
        	product.setName(attributes.getValue("name"));
        }
        if(elementName.equalsIgnoreCase("price")) {
        	//product.setPrice(Integer.parseInt(attributes.getValue("price")));
        }
        if(elementName.equalsIgnoreCase("condition")) {
        	product.setCondition(attributes.getValue("condition"));
        }
        if(elementName.equalsIgnoreCase("retailer")) {
        	product.setRetailer(attributes.getValue("retailer"));
        }
        if(elementName.equalsIgnoreCase("discount")) {
        	//product.setDiscount(Double.parseDouble(attributes.getValue("discount")));
        }
        if(elementName.equalsIgnoreCase("accessory")){
        	String acc_name=attributes.getValue("accessory");
        	/*for(Accessory accessory: accessories)
        	{
        		System.out.println(attributes.getValue("accessory"));
        		if(accessory.getName().equals(acc_name))
        		{
        			System.out.println("fdf"+product.getName());
        			System.out.println(accessory.getName());
        			product.accessories.add(accessory);
        		}
        	}*/
        }
        

    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
    	//System.out.println("r4dr");
        if (element.equals("product")) {
            products.add(product);
	    return;
        }
        if (element.equals("productcategory")) {
	    return;
        }
        if (element.equals("a_accessory")) {
        	accessories.add(accessory);
    	    return;
        }
        if (element.equals("a_accessories")) {
    	    return;
        }
        if (element.equalsIgnoreCase("a_image")) {
            accessory.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("a_name")) {
            accessory.setName(elementValueRead);
	    return;
        }
		if(element.equalsIgnoreCase("a_condition"))
		{
			accessory.setCondition(elementValueRead);
		return;	
		}
        if(element.equalsIgnoreCase("a_price")){
            accessory.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
        if(element.equalsIgnoreCase("a_discount")){
            accessory.setDiscount(Integer.parseInt(elementValueRead));
	    return;
        }
		 if(element.equalsIgnoreCase("a_manrebate")) {
			accessory.setManrebate(Double.parseDouble(elementValueRead));
		return;			
        }
		if(element.equalsIgnoreCase("a_retailer")){
            accessory.setRetailer(elementValueRead);
	    return;
        }
        
        if (element.equalsIgnoreCase("image")) {
            product.setImage(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("id")) {
            product.setId(elementValueRead);
	    return;
        }
        if (element.equalsIgnoreCase("name")) {
            product.setName(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("accessory")){
        	String acc_name=elementValueRead;
        	for(Accessory accessory: accessories)
        	{
        		if(accessory.getName().equals(acc_name))
        		{
        			product.accessories.add(accessory);
        		}
        	}	
	    return;
        }
        if(element.equalsIgnoreCase("price")){
            product.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
        if(element.equalsIgnoreCase("discount")){
            product.setDiscount(Integer.parseInt(elementValueRead));
			//product.setDiscount(Integer.parseInt(elementValueRead));
	    return;
        }
		if(element.equalsIgnoreCase("manrebate")){
            product.setManrebate(Double.parseDouble(elementValueRead));
	    return;
        }
		if(element.equalsIgnoreCase("condition")){
			product.setCondition(elementValueRead);
		return;
		}	
        if(element.equalsIgnoreCase("retailer")){
            product.setRetailer(elementValueRead);
	    return;
        }

    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


    /////////////////////////////////////////
    // 	     Kick-Start SAX in main       //
    ////////////////////////////////////////

    /*public static void main(String[] args) {
        new SaxParser4SmartPortableXMLdataStore("ProductCatalog.xml");

    }*/

}
