package nz.co.trademe.requests;

import java.io.*;
import java.util.Map;
import nz.co.trademe.lib.Properties;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import static nz.co.trademe.lib.SpecBuilder.*;

public class Listings {

    /**
     * It reads the xml body input from the file and replace category with the value passed from the feature file
     * @param listingDetails
     * @throws IOException
     */
    public static void getListingDetails(Map<String, String> listingDetails) throws IOException {


        String requestBody = xmlToString(System.getProperty("user.dir") + "/src/test/resources/Inputs/listing.xml")
                .replace("{category}", listingDetails.get("Category"));

        Response responseData =
                 given()
                    .spec(getRequestSpec())
                    .contentType(ContentType.XML)
                    .auth().oauth(
                        Properties.getProperty("consumer_key"),
                        Properties.getProperty("consumer_secret"),
                        Properties.getProperty("access_token"),
                        Properties.getProperty("token_Secret"))
                    .contentType("text/xml; charset=utf-8")
                    .body(requestBody)
                .when()
                    .post(Properties.getProperty("listings_endpoint"))
                .then()
                    .spec(getResponseSpec())
                         .assertThat()
                         .statusCode(HttpStatus.SC_OK)
                         .body("ListingResponse.Success", Matchers.equalTo("true"))
                         .body("ListingResponse.Description", Matchers.containsString("created."))
                    .extract()
                    .response();

        System.setProperty("actualResponseCode", Integer.toString(responseData.getStatusCode()));
    }

    /**
     * This method reads from the XML file and returns its contents as a String
     * @param xmlFilePath: This is the path to the XML file
     * @return String: returns the contents of the XML file as a String
     * @throws IOException
     */
    public static String xmlToString(String xmlFilePath) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader(xmlFilePath));
        String line;

        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

}
