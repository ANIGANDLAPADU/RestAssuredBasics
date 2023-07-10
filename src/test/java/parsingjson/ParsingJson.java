package parsingjson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJson {
	@Test(priority=1,invocationCount=5,dependsOnMethods="testJsonResponseBodyData")
	public	void testJsonResponse()
		{
			//Appoach1
			
			given()
				/*.contentType(ContentType.JSON)*/
			     .contentType("application/json")
				.pathParam("myuser","users")
				.queryParam("page",2)
			.when()
				.get("https://reqres.in/api/{myuser}")
			
			.then()
				.statusCode(200)
				/*.header("Content-Type","application/json; charset=utf-8")*/
				.body("data[3].email",equalTo("byron.fields@reqres.in"))
			    .log().all();
			
			//Approach2	
			
			Response res= 	given()
				.contentType(ContentType.JSON)
				.pathParam("myuser","users")
				.queryParam("page",2)
				
			.when()
				.get("https://reqres.in/api/{myuser}");
			
			Assert.assertEquals(res.getStatusCode(),200);    //validation 1
			/*Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");*/
			
			String bookname=res.jsonPath().get("data[0].first_name").toString();
			Assert.assertEquals(bookname,"Michael");
			
		}
		
		
		@Test(priority=2,invocationCount=5)
	public void testJsonResponseBodyData()
		{	
			Response res=
					given()
						/*.contentType(ContentType.JSON)*/
					     .contentType("application/json")
						.pathParam("myuser","users")
						.queryParam("page",2)
					.when()
						.get("https://reqres.in/api/{myuser}");
			
					
			//using JSONObject class
			JSONObject jo=new JSONObject(res.asString()); //converting response to JSON Object
			
			//print all titles of books
			/*for(int i=0; i<jo.getJSONArray("book").length();i++)
			{
				String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				System.out.println(bookTitle);
			}*/
			
			//search for title of the book in json  - validation 1
			boolean status=false;
			
			for(int i=0; i<jo.getJSONArray("data").length();i++)
			{
				String bookTitle=jo.getJSONArray("data").getJSONObject(i).get("email").toString();
				
				if(bookTitle.equals("lindsay.ferguson@reqres.in"))
				{
					status=true;
					break;
				}
			}
			
			Assert.assertEquals(status,true);
			
			
			//validate total price of books   - validation 2
			
			/*double totalprice=0;
			for(int i=0; i<jo.getJSONArray("book").length();i++)
			{
				String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				
				totalprice=totalprice+Double.parseDouble(price);
			
			}
			
			System.out.println("total price of books is:"+ totalprice);
			Assert.assertEquals(totalprice,53.92);  */
			
			
		}

}
