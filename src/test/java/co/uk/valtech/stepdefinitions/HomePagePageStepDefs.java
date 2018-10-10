package co.uk.valtech.stepdefinitions;

import co.uk.valtech.pages.ValtechHomePage;
import co.uk.valtech.utils.SharedDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static co.uk.valtech.pages.ValtechHomePage.BLOG_ARTICLE_HEADER;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class HomePagePageStepDefs {

    private SharedDriver sharedDriver;
    private ValtechHomePage valtechHomePage = new ValtechHomePage(sharedDriver.driver);

    public HomePagePageStepDefs() {
        sharedDriver = new SharedDriver();
    }


    @Given("^user is in Valtech Homepage$")
    public void userIsInValtechHomepage() throws Throwable {
        sharedDriver.openURL();
        valtechHomePage.clickCookies();
    }

    @Then("^user should get \"([^\"]*)\" in Homepage$")
    public void userShouldGetInHomepage(String headerh2In) {
        assertTrue("Expected Header name is not displaying",valtechHomePage.valiateHeaderh2(headerh2In));
    }

    @When("^user clicks blog at position (\\d+)$")
    public void userClicksBlogAtPosition(int textInPosition) throws Throwable {
        valtechHomePage.customedRecentBlogs(textInPosition);
    }

    @Then("^user should get same position (\\d+) Blog as Header$")
    public void userShouldGetSamePositionBlogAsHeader(int arg0) {
        assertEquals("Expected Header is not displaying",BLOG_ARTICLE_HEADER,valtechHomePage.validateHeaderh1());
    }

    @When("^user clicks \"([^\"]*)\" in the Navigating menu bar$")
    public void userClicksInTheNavigatingMenuBar(String textInMenuItem){
        valtechHomePage.clickCustomedMenuItem(textInMenuItem);
    }

    @Then("^user should get header as \"([^\"]*)\"$")
    public void userShouldGetHeaderAs(String textInExpctedText) {
        assertEquals("Expected Text is not same as Actual Text",textInExpctedText, valtechHomePage.validateMenuHeader());
    }

}
