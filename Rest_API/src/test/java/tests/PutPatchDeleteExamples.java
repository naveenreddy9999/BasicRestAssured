package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	//@Test(priority = 4)
		public void testget() {

			baseURI="https://reqres.in/api";

			given().get("/users?page=2").then().
			statusCode(200).
			body("data.first_name",hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel")).
			body("data[4].first_name",equalTo("George")).log().all();


		}
	// @Test(priority = 1)
		public void testPut() {
			
    	
	    	JSONObject request=new JSONObject();
	    	request.put("name","reddy");
	    	request.put("job", "SE");
	    	
	    	System.out.println(request.toJSONString());
	    	
			baseURI="https://reqres.in/api";
	        
			given().
			  header("Content-Type","appication/json").
			  contentType(ContentType.JSON).
			  accept(ContentType.JSON).
		   	  body(request.toJSONString()).
			when().
			  put("/users/2").
		   then().
			  statusCode(200).
			  log().all();
	    	
	    	
	    	
		}
	 //@Test(priority = 2)
		public void testpatch() {
			
 	
	    	JSONObject request=new JSONObject();
	    	request.put("name","naveen");
	    	request.put("job", "SE");
	    	
	    	System.out.println(request.toJSONString());
	    	
			baseURI="https://reqres.in";
	        
			given().
			  header("Content-Type","appication/json").
			  contentType(ContentType.JSON).
			  accept(ContentType.JSON).
		   	  body(request.toJSONString()).
			when().
			  patch("/api/users/2").
		   then().
			  statusCode(200).
			  log().all();
	    	
	    	
	    	
		}
	 @Test(priority = 3)
		public void testDelete() {
		
			baseURI="https://reqres.in";
	    
			when().
			  delete("/api/users/2").
		   then().
			  statusCode(204).
			  log().all();
	    	
	    	
	    	
		}
	
}
