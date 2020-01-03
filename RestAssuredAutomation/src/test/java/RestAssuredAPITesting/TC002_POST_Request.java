package RestAssuredAPITesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void registrationSuccessful() {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
	    // Request object	
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		
		// Request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "PeterSUPER2");
		requestParams.put("LastName", "ZUPERPeter2");
		requestParams.put("UserName", "JOHNPETER2");
		requestParams.put("Password", "johnSUPERxyz");
		requestParams.put("Email", "PeterSUPER2@gmail.com");
		
		httpRequest.header("Content - Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		
		// Response object
		Response response = httpRequest.request(Method.POST,"/register");

		// Print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
		// Sussess code  varification
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");	
		
	}
}
