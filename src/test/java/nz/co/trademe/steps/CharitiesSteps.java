package nz.co.trademe.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.co.trademe.requests.Charities;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class CharitiesSteps {

    List<String> allCharities = new ArrayList<String>();

    @When("I retrieve the list of all Charities using {string} tag")
    public void retrieveAllCharities(String tag) {
        allCharities = Charities.getTheListOfAllCharities(tag);
    }


    @Then("I should find {string} in the list of Charities")
    public void findCharityFroLIstOfCharities(String charity) {
        // verify that the list of charities contains "St John"
        assertTrue("Could not find " + charity + " charity from the list of charities!", allCharities.contains(charity));

    }


}
