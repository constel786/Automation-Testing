package petstore_smoketest;

import Utils.ObjectMapperUtils;
import base_urls.PetStoreBaseUrl;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Category;
import pojos.PetPojo;
import pojos.Tags;

import java.util.ArrayList;
import java.util.List;

import static Utils.ObjectMapperUtils.convertJsonToJava;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class C01_CreatePet extends PetStoreBaseUrl {
    /*
    Given
       https://petstore.swagger.io/v2/pet
    And
        {
        "id": 3465589,
        "category": {
            "id": 0,
            "name": "Bird"
        },
        "name": "Tweety",
        "photoUrls": [
            "string"
        ],
        "tags": [
            {
                "id": 0,
                "name": "string"
            }
        ],
        "status": "available"
        }
    When
        Send post request
    Then
        Status code is 200
    And
        Response body is:
                {
        "id": 3465589,
        "category": {
            "id": 0,
            "name": "Bird"
        },
        "name": "Tweety",
        "photoUrls": [
            "string"
        ],
        "tags": [
            {
                "id": 0,
                "name": "string"
            }
        ],
        "status": "available"
        }
     */

    protected static int petId;
    @Test
    public void post01() {
        //Set the url
        spec.pathParam("first", "pet");

        //Set the expected data
        Category category = new Category(0, "Bird");
        Tags tags = new Tags(0, "string");
        List<Tags> tagsList = new ArrayList<>();
        tagsList.add(tags);
        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add("string");
        petId = 3465589;
        PetPojo expectedData = new PetPojo(petId, category, "Tweety", photoUrlsList, tagsList, "available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = convertJsonToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(category.getId(), actualData.getCategory().getId());
        Assert.assertEquals(category.getName(), actualData.getCategory().getName());
        Assert.assertEquals(expectedData.getName(), actualData.getName());
        Assert.assertEquals(expectedData.getPhotoUrls().get(0), actualData.getPhotoUrls().get(0));
        Assert.assertEquals(expectedData.getTags().get(0).getId(), actualData.getTags().get(0).getId());
        Assert.assertEquals(expectedData.getTags().get(0).getName(), actualData.getTags().get(0).getName());
        Assert.assertEquals(expectedData.getStatus(), actualData.getStatus());

    }
}
