package hw;

import base_urls.ReqResBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;


import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Task01 extends ReqResBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */
    @Test
    public void Task01(){
        /*
    i) Set the URL
    ii) Set the expected data
    iii) Send the request and get the response
    iv) Do Assertion
     */
        spec.pathParam("first", "unknown");

        Response response = given(spec).get("{first}");
        response.prettyPrint();

        assertEquals(200, response.statusCode()); // 1)

        JsonPath jsonPath = response.jsonPath();
        List<Integer> pantoneList = jsonPath.getList("findAll{it.pantone_values}");
        System.out.println("pantoneList = " + pantoneList);

        List<Integer> idsGreaterThan3 = jsonPath.getList("findAll{it.id>3}"); // it: item
        System.out.println("idsGreaterThan3 = " + idsGreaterThan3);
        assertEquals(3, idsGreaterThan3.size());

        List<Integer> idsLessThan3 = jsonPath.getList("findAll{it.id<3}.name");
        System.out.println("idsLessThan3 = " + idsLessThan3);
        assertEquals(2,idsLessThan3.size());
    }
}
