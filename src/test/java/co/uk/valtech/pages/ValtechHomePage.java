package co.uk.valtech.pages;

import co.uk.valtech.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class ValtechHomePage extends PageObject {
    public static String BLOG_ARTICLE_HEADER;

    public ValtechHomePage(WebDriver driver)

    {
        super(driver);
    }

    @FindBy(tagName = "h2")
    private List<WebElement> headerh2;

    @FindBy(tagName = "h1")
    private WebElement headerh1;

    @FindBy(css = ".cookie__action>a")
    private WebElement cookiesBtn;

    @FindBy(xpath = "//*[@block-header__heading][3]")
    private WebElement recentBlogHeader;

    public boolean valiateHeaderh2(String headerh2In){
        for(WebElement ele:headerh2){
            if(ele.getText().equalsIgnoreCase(headerh2In)){
                //scrollForElement(ele);
                return true;
            }
        }
        return false;
    }

    public void clickCookies(){
        cookiesBtn.click();
    }

    public String validateHeaderh1(){
        return headerh1.getText();
    }

    private String customBlogLocator(int textInPosition){
        return ("//*[@class='bloglisting__item__heading ']["+textInPosition+"]");
    }

    public void customedRecentBlogs(int textInPosition) throws InterruptedException {
        WebElement blogElement = getCustomizedElement(customBlogLocator(textInPosition));
        moveToElement(blogElement);
        BLOG_ARTICLE_HEADER=blogElement.getText();
        if(isElementPresent(blogElement))
            blogElement.click();
    }

    public void clickCustomedMenuItem(String textInMenuItem){
        String customedPath="//*[@class=\"navigation__menu__item\"]//*[text()='"+textInMenuItem+"']";
       getCustomizedElement(customedPath).click();
    }

    public String validateMenuHeader(){
        return headerh1.getText();
    }
}
