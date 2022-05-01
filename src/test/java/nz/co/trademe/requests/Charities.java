package nz.co.trademe.requests;

import org.hamcrest.beans.PropertyUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import nz.co.trademe.lib.Properties;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Charities {

    public static List<String> getTheListOfAllCharities(String tag)
    {
        // extract the description tag values from the response body
        return given()
                .when()
                .get(Properties.getProperty("base_url"))
                .then()
                .extract()
                .path(tag);
    }
}
