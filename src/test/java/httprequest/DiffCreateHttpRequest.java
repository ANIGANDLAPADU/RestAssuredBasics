package httprequest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class DiffCreateHttpRequest {
	@Test(priority=1,enabled=false)
	public void creatingusingHashmap() {
		HashMap data = new HashMap();
		data.put("name", "seshu");
		data.put("address","vijayawada");
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name",equalTo("seshu"))
		.body("address", equalTo("vijayawada"))
		.log().all();

	}
	@Test(priority=4)
	public void deleteHashmap() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all()
		;
	}
	@Test(priority=3,enabled=false)
  public void creatingusingjsonobject() {
		JSONObject data = new JSONObject();
		data.put("name","seshu");
		data.put("address","vijayawada");
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name",equalTo("seshu"))
		.body("address", equalTo("vijayawada"))
		.log().all();
  
  }
	@Test(enabled=false)
	 public void creatingusingPojo() {
		     HttpPojo data = new HttpPojo();
		     data.setName("akhil");
		     data.setAddress("vijayawada");
			
			given()
			.contentType("application/json")
			.body(data)
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.body("name",equalTo("akhil"))
			.body("address", equalTo("vijayawada"))
			.log().all();
	  
	  }
	@Test
	 public void creatingusingexternaljson() throws FileNotFoundException {
		File file = new File("D:\\APITestingRestAssured\\body.json");
		FileReader fr = new FileReader(file);
		JSONObject data = new JSONObject(fr);
			
			given()
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201)
			.log().all();
	  
	  }
}
