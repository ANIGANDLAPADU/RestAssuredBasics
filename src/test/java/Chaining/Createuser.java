package Chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Createuser {
	@Test
	public void create(ITestContext context) {
		
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("firstname", faker.name().firstName());
		data.put("lastname", faker.name().lastName());
		data.put("email", faker.internet().emailAddress());
		
	int	id=given()
		.body(data.toString())
		 .contentType("application/json")
		.when()
		.post("https://reqres.in/api/users")
		 .jsonPath().getInt("id");
	System.out.println(" Generated User id "+id);
	context.setAttribute("user_id", id);
		
		

	}

}
