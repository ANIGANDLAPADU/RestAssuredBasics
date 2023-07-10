import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class HttpRequest {
	int id;
	@Test(priority=1)
	public void PostUser() {
		JSONObject data = new JSONObject();
		data.put("name", "seshu");
		data.put("job", "automation");
		
		/*HashMap data = new HashMap();
		data.put("name", "seshu");
		data.put("job", "Tester");*/
		
	    	id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		/*.then()
		.statusCode(201)
		.log().all();*/
	}
	@Test(priority=2,dependsOnMethods= {"PostUser"})
	public void updateUser() {
		JSONObject data = new JSONObject();
		data.put("name", "seshu");
		data.put("job", "automation");
		
	/*	HashMap data = new HashMap();
		data.put("name", "babu");
		data.put("job", "AutomationTester");*/
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.patch("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
	@Test(priority=3)
	public void getUser() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	@Test(priority=4)
	public void deleteUser() {
		given()
		.when()
		.delete("https://reqres.in//api/users/2")
		.then()
		.log().all();
		;
		
		
	}
	
}