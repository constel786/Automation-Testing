package practice;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Practice04 extends HerOkuAppBaseUrl {



 /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "John" and lastname is "Smith"

 */

    @Test
    public void get04(){

        spec.
                pathParam("first", "booking").
                queryParams("firstname","John", "lastname", "Smith");

        Response response= given(spec).get("{first}");
        response.prettyPrint();

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.asString().contains("bookingid"));







    }






}