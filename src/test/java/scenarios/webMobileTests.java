package scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.DataReader.*;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Test relevant google searching")
    public void googleSearchTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        getDriver().get(getValue("googleUrl"));

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        String platformName = (String) getDriver().getCapabilities().getCapability("platformName");

        getPo().getWelement("inputSearchField").sendKeys(getValue("searchWord"));
        if (platformName.equals("Android")) {
            getPo().getWelement("inputSearchField").sendKeys(Keys.ENTER);
        } else {
            getPo().getWelement("inputSearchField").submit();
        }

        List<WebElement> resultedList = getPo().getListWelements("searchResultList");

        int wordCounter = 0;

        for (WebElement webElement : resultedList) {
            if (webElement.getText().toUpperCase().contains(getValue("searchWord"))) {
                wordCounter++;
            }
        }

        Assert.assertTrue(wordCounter > 0);

        // Log that test finished
        System.out.println("Site opening done");
    }

}
