package jsonandxmlschemavalidator;


import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

//https://jsonformatter.org/xml-formatter
public class XmlSchemaValidation {

	@Test
	void xmlSchemavalidation()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		   .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));	
		
	}
	
}

