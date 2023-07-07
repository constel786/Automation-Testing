package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static String generateToken(){

        String body = "{\n" + "  \"password\": \"Mark.123\",\n" + "  \"username\": \"Mark_Twain\"\n" + "}";

        Response response = given().body(body).contentType(ContentType.JSON).post("https://gmibank.com/api/authenticate");
        //response.prettyPrint();

        return response.jsonPath().getString("id_token");

    }
}
