package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetandPostExp {
	//@Test
	public void testget() {

		baseURI="https://reqres.in/api";

		given().get("/users?page=2").then().
		statusCode(200).
		body("data.first_name",hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel")).
		body("data[4].first_name",equalTo("George")).log().all();


	}

   @Test
	public void testPost() {
		
//Map<String, Object>map=new HashMap<String, Object>();
    	
//    	map.put("name","naveen");
//    	map.put("job", "SE");
   	
//    	System.out.println(map);
    	
    	JSONObject request=new JSONObject();
    	request.put("name","naveen");
    	request.put("job", "SE");
    	
    	System.out.println(request.toJSONString());
    	
		baseURI="https://reqres.in/api";
        
		given().
		  header("Content-Type","appication/json").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
	   	  body(request.toJSONString()).
		when().
		  post("/users").
	   then().
		  statusCode(201).
		  log().all();
    	
    	
    	
	}



}
