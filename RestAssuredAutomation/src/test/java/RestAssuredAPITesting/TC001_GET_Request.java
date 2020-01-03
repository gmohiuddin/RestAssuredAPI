package RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//----- https://www.youtube.com/watch?v=yDdBOspPp_c&list=PLUDwpEzHYYLuMRzT6LFq4r8DwKZdcqHmY

public class TC001_GET_Request {

	@Test
	void getweatherDetails() {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
	    // Request object	
		RequestSpecification httprequest = RestAssured.given();
		
		// Response object
		Response response = httprequest.request(Method.GET,"/Hyderabad");
		
		// Print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// Status line varification
		String statusLine = response.getStatusLine();
		System.out.println("Status line is: "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
				
		
	}
}
/*
 * API/Webservices Testing using RestAssured 
Response 
statusCode statusLine ResponseTime 
Headers 
Reponse body Json 
Authnetication PIS's 
1) Define BaseURI 2) Request object 3) Response 4) ResponseBody 
validations 
-> status code 
-> status line
-> Response time 
-> headers (content-type,Content-Length,Content-Encoding etc...) 
 */










