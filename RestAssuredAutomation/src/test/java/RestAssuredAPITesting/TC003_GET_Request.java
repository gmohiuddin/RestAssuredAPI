package RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	@Test
	void googleMapTest() {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
	    // Request object	
		RequestSpecification httprequest = RestAssured.given();
		
		// Response object
		Response response = httprequest.request(Method.GET,"http://restapi.demoqa.com/utilities/weather/city/Charlotte");
		
		// Print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Capture details of headers from response
		
		String contentType = response.header("Content-Type"); // details of content type header
		System.out.println("Content Type is: "+ contentType );
		Assert.assertEquals(contentType, "application/json");
				
		String contentEncoding = response.header("Content-Encoding"); // details of content encoding header
		System.out.println("Content Encoding is: "+ contentEncoding );
		Assert.assertEquals(contentEncoding, "gzip");
		
	}
}
