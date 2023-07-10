package qureyandpath;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class HeaderandHeaders {
	
	@Test(enabled=false)
	public void Header() {
		        given()
			    .when()
				.get("https://www.google.com/")
				.then()
				.header("X-Frame-Options","SAMEORIGIN")
				.and()
				.header("Transfer-Encoding", "chunked")
		;
	             
	}
	@Test(invocationCount=10)
	public void Headers() {
		     Response res=  given()
			    .when()
				.get("https://www.google.com/");
		     Headers    header=res.getHeaders();
		     for(Header H:header) {
		   System.out.println(H.getName());
		   System.out.println(H.getValue());
		     }
	}
}