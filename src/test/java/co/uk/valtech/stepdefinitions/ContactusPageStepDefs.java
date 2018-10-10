package co.uk.valtech.stepdefinitions;

import co.uk.valtech.pages.ContactusPage;
import co.uk.valtech.utils.SharedDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactusPageStepDefs {

    private SharedDriver sharedDriver;
    ContactusPage contactusPage = new ContactusPage(sharedDriver.driver);

    public ContactusPageStepDefs() {
        sharedDriver = new SharedDriver();
    }

    @When("^user extends url as (.*)$")
    public void userExtendsUrlAsAboutContactUs(String textInURLEnpoint) throws Throwable {
        contactusPage.moveToContactUS(textInURLEnpoint);
    }

    @Then("^user should get number of offices$")
    public void userShouldGetNumberOfOffices(){
        System.out.println("Number of offices :: "+contactusPage.getOfficeCount());
    }
}
