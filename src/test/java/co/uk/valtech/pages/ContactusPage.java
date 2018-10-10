package co.uk.valtech.pages;

import co.uk.valtech.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class ContactusPage extends PageObject {
    public ContactusPage(WebDriver driver)

    {
        super(driver);
    }

    @FindBy(css = ".office__heading ")
    private List<WebElement> officeLocation;

    public void moveToContactUS(String urlIn) throws IOException {
        driver.get(readDataFromProperties("BASE_URL").concat(urlIn));
    }

    public int getOfficeCount(){
        return officeLocation.size();
    }
}
