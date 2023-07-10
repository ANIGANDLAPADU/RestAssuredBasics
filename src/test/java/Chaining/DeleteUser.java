package Chaining;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	@Test
	public void delete(ITestContext context) {
		int id =(Integer) context.getAttribute("user_id");
		given()
		.contentType("application/json")
		.pathParam("id",id)
		.when()
		.delete("https://reqres.in/api/{id}")
		.then()
		.statusCode(204)
		.log().all();
		
	}

}
