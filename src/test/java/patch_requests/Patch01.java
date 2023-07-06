package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

import java.util.Map;

import static test_data.JsonPlaceHolderTestData.expectedDataMap;

public class Patch01 extends JsonPlaceHolderBaseUrl {

    /*
     Given
         1) https://jsonplaceholder.typicode.com/todos/198
         2) {
              "title": "Read the books"
            }
     When
          I send PATCH Request to the Url
     Then
           Status code is 200
           And response body is like   {
                                         "userId": 10,
                                         "title": "Read the books",
                                         "completed": true,
                                         "id": 198
                                        }
  */

    @Test
    public void patch01() {
        //Set the url
        spec.pathParams("first", "totods", "second", 198);

        //Set the expected data
        Map<String, Object> expectedData = expectedDataMap(null, "Read the books", null);

        //System.out.println("expectedData = " + expectedData);
//comment

    }
}