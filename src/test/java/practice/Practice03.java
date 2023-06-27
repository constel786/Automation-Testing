package practice;

import base_urls.ReqResBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Practice03 extends ReqResBaseUrl {
 /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get03(){
        spec.pathParams("first", "users", "second", 2);
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();
        //System.out.println("response = " + response);git
    }

}
