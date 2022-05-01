package nz.co.trademe.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import nz.co.trademe.requests.Listings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class ListingsSteps {

    @When("I create a new listing with the below details")
    public void i_create_a_new_listing_with_the_below_details(DataTable dataTable) throws IOException {
        Map<String, String> listingDetails = dataTable.asMap(String.class, String.class);
        Listings.getListingDetails(listingDetails);

    }
    @Then("I should see a {string}")
    public void i_should_see_a(String string) {

    }

}
