package co.uk.valtech.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String readDataFromProperties(String getPropertyName ) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/src/test/java/co/uk/valtech/utils/Config.properties"));
        return properties.getProperty(getPropertyName);
    }

    public static void waitForPageToBeLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        try {
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.assertFalse("Time is out for the - ValtechPage Load Request to complete.", true);

        }
    }

    public void scrollForElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public WebElement getCustomizedElement(String textInStrinPath){
        return driver.findElement(By.xpath(textInStrinPath));
    }

    public boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

}
