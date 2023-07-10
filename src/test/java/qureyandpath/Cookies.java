package qureyandpath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	// single cookie information
	@Test
	public void cookie() {
		Response res = given()
			    .when()
				.get("https://www.google.com/");
		String cookie_value = res.getCookie("AEC");
		System.out.println(cookie_value);
	}

	// multiple cookies information
	@Test
	public void cookies() {
		Response res = given()
				.when()
				.get("https://www.google.com/");
		Map<String, String> cookies_values = res.getCookies();
		// System.out.println(cookies_values.keySet());
		for (String COOKIE : cookies_values.keySet()) {
           String Cookie= res.getCookie(COOKIE);
           System.out.println(Cookie);
		}  

	}
}