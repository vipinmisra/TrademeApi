package nz.co.trademe.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import nz.co.trademe.requests.Listings;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class ListingsSteps {

    @When("I create a new listing with the below details")
    public void i_create_a_new_listing_with_the_below_details(DataTable dataTable) throws IOException {
        Map<String, String> listingDetails = dataTable.asMap(String.class, String.class);
        Listings.getListingDetails(listingDetails);

    }
    @Then("I should get a response code {string}")
    public void validateResponseCode(String expectedStatusCode) {
        Assert.assertTrue("Expected the status code to be " + expectedStatusCode + ", but got " + System.getProperty("actualResponseCode"),
                System.getProperty("actualResponseCode").equals(expectedStatusCode));
    }

}
