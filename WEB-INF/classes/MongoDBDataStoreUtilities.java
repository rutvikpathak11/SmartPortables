import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.*;


public class MongoDBDataStoreUtilities
{
	static MongoClient mongo;
	static DBCollection myReviews;
	static DB db;
	static
	{
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		myReviews= db.getCollection("myReviews");
	}
	
	public void insertReview(String productName,String productCategory, String price, String retailerName, String retailerCity, 
	String retailerState, String retailerZip, String productOnSale,String manufacturerName,String manufacturerRebate,String userId,String userAge,
	String userGender, String userOccupation, String reviewRating, String reviewDate, String reviewText)
	{
		//getConnection();
		
		BasicDBObject doc = new BasicDBObject("title", "myReviews").
		append("userId", userId).
		append("productName", productName).
		append("productCategory", productCategory).
		append("price", price).
		append("retailerName", retailerName).
		append("retailerCity", retailerCity).
		append("retailerState", retailerState).
		append("retailerZip", retailerZip).
		append("productOnSale", productOnSale).
		append("manufacturerName", manufacturerName).
		append("manufacturerRebate", manufacturerRebate).
		append("userAge", userAge).
		append("userGender", userGender).
		append("userOccupation", userOccupation).
		append("reviewRating", reviewRating).
		append("reviewDate", reviewDate).
		append("reviewText", reviewText);
		myReviews.insert(doc);
	}
	
	public List<ProductReview> getReviews(String searchField, String searchParameter)
	{
		List<ProductReview> reviewList = new ArrayList<ProductReview>();
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);
			DBCursor cursor = myReviews.find(searchQuery);
			
			if(cursor.count() == 0)
				return null;
			else
			{
				while(cursor.hasNext())
				{
					BasicDBObject obj = (BasicDBObject) cursor.next();
					ProductReview p =new ProductReview();
					p.setProductModelName(obj.getString("productName"));
					p.setProductCategory(obj.getString("productCategory"));
					p.setProductPrice(obj.getString("price"));
					p.setRetailerName(obj.getString("retailerName"));
					p.setRetailerCity(obj.getString("retailerCity"));
					p.setRetailerState(obj.getString("retailerState"));
					p.setRetailerZip(obj.getString("retailerZip"));
					p.setProductOnSale(obj.getString("productOnSale"));
					p.setManufacturerName(obj.getString("manufacturerName"));
					p.setManufacturerRebate(obj.getString("manufacturerRebate"));
					p.setUserId(obj.getString("userId"));
					p.setUserAge(obj.getString("userAge"));
					p.setUserGender(obj.getString("userGender"));
					p.setUserOccupation(obj.getString("userOccupation"));
					p.setReviewRating(obj.getString("reviewRating"));
					p.setReviewDate(obj.getString("reviewDate"));
					p.setReviewText(obj.getString("reviewText"));
					reviewList.add(p);
				}
			}
		return reviewList;
	}
	
}