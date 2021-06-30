package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebPageObject  {

    @FindBy(xpath = "//input[@name='q']")
    WebElement inputSearchField;
    //@FindBy(xpath = "//*[@id='rso']//div[@role='heading'][@aria-level='3']")
    @FindBy(xpath = "//div[@id='rso']/div")
    List<WebElement> searchResultList;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }


}
