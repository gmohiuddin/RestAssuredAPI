package RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_Authorization {

	@Test
	public void authorizationTest() {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		// Basic authentication
		PreemptiveBasicAuthScheme authescheme = new PreemptiveBasicAuthScheme();
		authescheme.setUserName("ToolsQA");
		authescheme.setPassword("TestPassword");

		RestAssured.authentication = authescheme;
		
		
	    // Request object	
		RequestSpecification httprequest = RestAssured.given();
		
		// Response object
		Response response = httprequest.request(Method.GET,"/");
				
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
	}
}
