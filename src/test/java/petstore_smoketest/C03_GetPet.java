package petstore_smoketest;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Category;
import pojos.PetPojo;
import pojos.Tags;

import java.util.ArrayList;
import java.util.List;

import static Utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static petstore_smoketest.C01_CreatePet.petId;

public class C03_GetPet extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/3465589
    When
        Send get request
    Then
        Status code is 200
    And
        Response body is:
         {
          "id": 3465589,
          "category": {
            "id": 2,
            "name": "Lion"
          },
          "name": "Leo",
          "photoUrls": [
            "good photo"
          ],
          "tags": [
            {
              "id": 555,
              "name": "My Strong lion"
            }
          ],
          "status": "sold"
        }
     */

    @Test
    public void get01(){
        //Set the url
        spec.pathParams("first", "pet", "second", petId);

        //Set the expected data
        Category category = new Category(2, "Lion");
        Tags tags = new Tags(555, "My Strong lion");
        List<Tags> tagsList = new ArrayList<>();
        tagsList.add(tags);
        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add("good photo");
        PetPojo expectedData = new PetPojo(petId, category, "Leo", photoUrlsList, tagsList, "sold");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = convertJsonToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(category.getId(), actualData.getCategory().getId());
        assertEquals(category.getName(), actualData.getCategory().getName());
        assertEquals(expectedData.getName(), actualData.getName());
        assertEquals(expectedData.getPhotoUrls().get(0), actualData.getPhotoUrls().get(0));
        assertEquals(expectedData.getTags().get(0).getId(), actualData.getTags().get(0).getId());
        assertEquals(expectedData.getTags().get(0).getName(), actualData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(), actualData.getStatus());

    }
}