package nz.co.trademe.requests;

import java.io.*;
import java.util.Map;


import nz.co.trademe.lib.Properties;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Listings {


    public static void getListingDetails(Map<String, String> listingDetails) throws IOException {
        System.out.println(Properties.getProperty("base_url") + Properties.getProperty("listings_endpoint"));
        System.out.println(Properties.getProperty("consumer_key") + ", " +
                Properties.getProperty("consumer_secret") + ", " +
                Properties.getProperty("access_token") + ", " +
                Properties.getProperty("token_Secret"));

        //filename is filepath string
        String requestBody = xmlToString(System.getProperty("user.dir") + "\\src\\test\\resources\\Inputs\\listing.xml")
                .replace("{category}", listingDetails.get("Category"));
        System.out.println(requestBody);

        RestAssured.baseURI = Properties.getProperty("base_url");
        Response response =
                given()
                    .header("Content-Type", "text/xml")
                    .contentType(ContentType.XML)
                    .auth().oauth(
                        Properties.getProperty("consumer_key"),
                        Properties.getProperty("consumer_secret"),
                        Properties.getProperty("access_token"),
                        Properties.getProperty("token_Secret"))
                    .body(requestBody)
                .when()
                    .post("/Selling.xml")
                .then()
                    .extract()
                    .response();

        System.out.println("RESPONSE CODE: " + response.getStatusCode());
        System.out.println("RESPONSE: " + response.getBody().asString());
    }


    public static String xmlToString(String xmlFilePath) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader(xmlFilePath));
        String line;

        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferReader.readLine()) != null) {
            stringBuilder.append(line + "\r\n");
        }
        return stringBuilder.toString();
    }

}
