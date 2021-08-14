import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baserestassured.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployee extends Base {

	@Test
	void getemployeedetails() {
		// Response Object
		response = httpRequest.request(Method.GET, "/employees");
	}

	@Test
	void checkResponseBody() {
		try {
			// Response body verification
			String responsebody = response.getBody().asString();
			Assert.assertTrue(responsebody != null);
		} catch (Exception e) {

		}

	}

	@Test
	void statusCode() {
		// status code verification
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	void statusLine() {
		// status line verification
		String statusline = response.statusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

	@AfterClass
	void teardown() {
		System.out.print("Test case is finshed......");
	}
}
