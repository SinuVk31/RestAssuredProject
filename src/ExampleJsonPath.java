import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExampleJsonPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		String Response=given().log().all().queryParam("Key", "qaclick123").header("content-Type","application/json")
		.body(payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println("Response"+Response);
		
		JsonPath js=new JsonPath(Response);
		String placeId=js.getString("place_id");
		
		System.out.println("placeId"+placeId);
	}

}
