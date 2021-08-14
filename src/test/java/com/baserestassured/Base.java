package com.baserestassured;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	public static RequestSpecification httpRequest;
	public static Response response;

	@BeforeClass
	public void setup() {
		// specify base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        // Request Object
		httpRequest = RestAssured.given();
	}
}
