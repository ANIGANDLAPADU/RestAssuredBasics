package Chaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	@Test
	public void get(ITestContext context) {
		int id =(Integer) context.getAttribute("user_id");
	   	given()
	   	.contentType("application/json")
	   	.pathParam("id", id)
		.when()
		.get("https://reqres.in/api/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
