package RestAssuredAPITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingJSONResponse {

	@Test
	void getWeatherDetails() {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
	    // Request object	
		RequestSpecification httprequest = RestAssured.given();
		
		// Response object
		Response response = httprequest.request(Method.GET,"http://restapi.demoqa.com/utilities/weather/city/Delhi");
		
		// Print response in console window
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		Assert.assertEquals(responseBody.contains("Delhi"),true);
		
	}
}
