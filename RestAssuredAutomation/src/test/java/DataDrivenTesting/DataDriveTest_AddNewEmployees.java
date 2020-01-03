package DataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriveTest_AddNewEmployees {
		
	@Test(dataProvider="empdataprovider")
	void postNewEmployees(String fname, String lname, String uname, String password, String email) {
		// Specify base URI		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
	    // Request object	
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		
		// Request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", fname);
		requestParams.put("LastName", lname);
		requestParams.put("UserName", uname);
		requestParams.put("Password", password);
		requestParams.put("Email", email);
		
		httpRequest.header("Content - Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		
		// Response object
		Response response = httpRequest.request(Method.POST,"/register");

		// Print response in console window

		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		Assert.assertEquals(responseBody.contains("completed successfully"), true);
		
		// Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		Assert.assertEquals(statusCode, 201);
		
	}

		@DataProvider(name="empdataprovider")
		String[][] getEmpData() throws IOException{
			
			// Read data from excel
			String path = System.getProperty("user.dir")+"/src/test/java/DataDrivenTesting/teserdata.xlsx";
			System.out.println("Path is: "+path);
			int rownum=XLUtils.getRowCount(path,"Sheet1"); 
			int colcount=XLUtils.getCellCount(path, "Sheet1",1); 
			String empdata[][] =new String[rownum][colcount]; 
			for (int i=1; i <= rownum; i++) { 

			for (int j = 0; j < colcount; j++) {  

				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
				
				}
			
			}

		return (empdata);
	}



}
