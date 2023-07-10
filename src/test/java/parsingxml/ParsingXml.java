package parsingxml;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXml {
	@Test(enabled=false)
	public void parsingxml() {
		// Approach 1
		given()
		.queryParam("page", "1")
		.pathParam("travel", "Traveler")

				.when()
				.get("http://restapi.adequateshop.com/api/{travel}")
				.then()
				.body("TravelerinformationResponse.travelers.Travelerinformation[1].adderes", equalTo("USA"));
		// Approach 2
		Response res = given().queryParam("page", "1").pathParam("travel", "Traveler")

				.when()
				.get("http://restapi.adequateshop.com/api/{travel}");
		        Assert.assertEquals(res.getHeader("Server"), "Microsoft-IIS/10.0");
		        Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Test(enabled=true)
	public void ParsingXmlusingXmlObject() {
		// Approach 3
		Response res = given()
				.queryParam("page", "1")
				.pathParam("travel", "Traveler")

				.when()
				.get("http://restapi.adequateshop.com/api/{travel}");
		XmlPath xmlpath = new XmlPath(res.asString());
	     String names= xmlpath.get("TravelerinformationResponse.travelers.Travelerinformation[2].name");
         Assert.assertEquals(names,"vano");
	
		List<String> listoftravellers = xmlpath.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(listoftravellers.size(), 10);
		List<String> listoftravellersname = xmlpath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	    for(String nameofthetravellersname:listoftravellersname) {
	    	if(nameofthetravellersname.equals("Vijay Bharath Reddy")) {
	    		
	    		break;
	    		
	    	}
	    	
	    	
	    }
	   
	}

}
