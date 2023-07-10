package jsonandxmlschemavalidator;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

//json ---> jsonschema converter
//  https://jsonformatter.org/json-to-jsonschema
	
	


public class JSONSchemaValidation {

	@Test
	void jsonschemavalidation()
	{
		given()
		.pathParam("myuser", "users")
		.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/{myuser}")
		.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		
	}
	
	
}

