import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.payload;
public class DemoRestProject {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			
			//given-all the input details
			//when-submit API
			//Then-Validate response
			//First base url we need to set
			
			RestAssured.baseURI="https://rahulshettyacademy.com";
			given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
			.body(payload.AddPlace())
			.when().post("maps/api/place/add/json")
			.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
			.header("server","Apache/2.4.52 (Ubuntu)");
			

		}

	}



