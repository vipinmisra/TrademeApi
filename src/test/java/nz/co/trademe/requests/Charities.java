package nz.co.trademe.requests;

import nz.co.trademe.lib.Properties;
import java.util.List;
import static io.restassured.RestAssured.given;
import static nz.co.trademe.lib.SpecBuilder.*;

public class Charities {

    /**
     * This method extracts  description tag values from the response body
     * @param tag
     * @return String
     */
    public static List<String> getTheListOfAllCharities(String tag)
    {

        return given()
                    .spec(getRequestSpec())
                .when()
                    .get(Properties.getProperty("charities_endpoint"))
                .then()
                    .spec(getResponseSpec())
                    .extract()
                    .path(tag);
    }
}
