import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baserestassured.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteEmployee extends Base {
	@Test
	void deleteemployeedata() {
		// Response Object
		response = httpRequest.request(Method.GET, "/employees");

		JsonPath jsonPathEvaluator = response.jsonPath();
		String empID = jsonPathEvaluator.get("[0].id");

		httpRequest.request(Method.DELETE, "/delete/" + empID);

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
