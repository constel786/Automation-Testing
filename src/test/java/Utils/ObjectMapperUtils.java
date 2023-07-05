package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    //This method will accept json as String and convert it into any data type
    public static <T> T convertJsonToJava(String json, Class<T> tClass){ //Generic Method
        try {
            return new ObjectMapper().readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
