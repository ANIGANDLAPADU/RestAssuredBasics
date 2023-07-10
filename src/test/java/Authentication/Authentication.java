package Authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authentication {
	@Test
	public void basicAuthentication() {

		given()
		.auth().basic("postman", "password")
		.pathParam("basic","basic-auth")
		.when()
		.get("https://postman-echo.com/{basic}")
		.then()
		.header("Connection", equalTo("keep-alive"));
	}
	@Test
	public void digestAuthentication() {

		given()
		.auth().digest("postman","password")
		.pathParam("digest","digest-auth")
		.when()
		.get("https://postman-echo.com/{digest}")
		.then()
		.header("Content-Length",equalTo("27"));
	}
	@Test
	public void preemptiveAuthentication() {

		given()
		.auth().preemptive().basic("postman","password")
		.pathParam("preemptive","basic-auth")
		.when()
		.get("https://postman-echo.com/{preemptive}")
		.then();
	}
       @Test	
       public void testBearerTokenAuthentication()
	{
		String bearerToken="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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
		
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
     @Test
  public void testOAuth1Authentication()
   	{
   		given()
   			.auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate") // this is for OAuth1.0 authentication
   		.when()
   			.get("url")
   		.then()
   			.statusCode(200)
   			.log().all();
   		
   	}
   @Test
 	void testOAuth2Authentication()
 	{
 		given()
 		.auth().oauth2("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")
 	.when()
 		.get("https://api.github.com/user/repos")
 	.then()
 		.statusCode(200)
 		.log().all();
 	}
}
