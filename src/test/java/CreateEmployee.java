import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baserestassured.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployee extends Base {
	@Test
	void postemployeedetails() {
		// Request payload sending along with post request
		JSONObject requestparams = new JSONObject();
		requestparams.put("name", "test");
		requestparams.put("salary", "123");
		requestparams.put("age", "23");

		httpRequest.header("Content-Type", "application/json");

		httpRequest.body(requestparams.toJSONString());

		// Response Object
		response = httpRequest.request(Method.POST, "/create");
	}

	@Test
	void statusCode() {
		// status code verification
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@AfterClass
	void teardown() {
		System.out.print("Test case is finshed......");
	}

}
