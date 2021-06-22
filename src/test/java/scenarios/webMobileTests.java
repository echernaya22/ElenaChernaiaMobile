package scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        getPo().getWelement("inputSearchField").sendKeys(getValue("searchWord"));
        getPo().getWelement("inputSearchField").sendKeys(Keys.ENTER);

        List<WebElement> resultedList = getPo().getListWelements("searchResultList");

        for (int i = 0; i < resultedList.size() / 2; i++) {
            assertThat(resultedList.get(i).getText().toUpperCase(),
                    containsString(getValue("searchWord")));
        }

        // Log that test finished
        System.out.println("Site opening done");
    }

}
