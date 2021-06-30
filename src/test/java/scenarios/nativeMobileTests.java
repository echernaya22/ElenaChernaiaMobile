package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import static utils.DataReader.*;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Register and login test")
    public void registerTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getPo().getWelement("loginRegisterButton").click();
        getPo().getWelement("registerEmailField").sendKeys(getValue("email"));
        getPo().getWelement("registerUsernameField").sendKeys(getValue("username"));
        getPo().getWelement("registerPasswordField").sendKeys(getValue("password"));
        getPo().getWelement("registerConfirmPasswordField").sendKeys(getValue("password"));
        getPo().getWelement("registerButton").click();

        getPo().getWelement("loginEmailField").sendKeys(getValue("email"));
        getPo().getWelement("loginPasswordField").sendKeys(getValue("password"));
        getPo().getWelement("signInButton").click();

        String platformName = (String) getDriver().getCapabilities().getCapability("platformName");

        if (platformName.equals("Android")) {
            Assert.assertEquals(getPo().getWelement("budgetTitle").getText(), getValue("budgetTitleAndroid"));
        } else {
            Assert.assertEquals(getPo().getWelement("budgetTitle").getText(), getValue("budgetTitleIos"));
        }

        //System.out.println("Simplest Android native test done");

    }

}
