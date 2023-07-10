package qureyandpath;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

public class QueryPath {
	@Test
	public void qureyandpath() {
		given()
		.pathParam("myuser","users")
		.queryParam("page",5)
		.queryParam("id",10)
		.when()
		.get("https://reqres.in/api/{myuser}")
		.then()
		.statusCode(200)
		.log().all()
		;
		
		

	}

}
