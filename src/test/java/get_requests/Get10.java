package get_requests;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static test_data.HerOkuAppTestData.bookingdatesMapMethod;
import static test_data.HerOkuAppTestData.expectedDataMethod;

public class Get10 extends HerOkuAppBaseUrl {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/34
        When
            I send GET Request to the url
        Then
            Response body should be like that;
                {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
     */

    @Test
    public void get10(){
        //Set the URL
        spec.pathParams("first","booking","second",34);

        //Set the expected data --> First prepare inner map then outer map
        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Jane");
        expectedData.put("lastname","Doe");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap);
        expectedData.put("additionalneeds","Extra pillows please");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        //Since all values are inside Object container, we need to do type casting to use it as original data type.
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

    }

    @Test//Recommended way
    public void get10b(){
        //Set the url
        spec.pathParams("first","booking","second",18);

        //Set the expected data --> First prepare inner map then outer map
        Map<String,String> bookingdatesMap = bookingdatesMapMethod("2018-01-01","2019-01-01");

        Map<String, Object> expectedData = expectedDataMethod("Jane","Doe",111,true,bookingdatesMap,"Extra pillows please");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));

        assertEquals(bookingdatesMap.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

    }
}