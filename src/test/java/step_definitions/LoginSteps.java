package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import page_object.LoginPage;
import page_object.MainPage;

public class LoginSteps extends Base_Step{
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.empik.com/logowanie?continue=%2F");

    }

    @When("User enter correct e-mail")
    public void userEnterCorrectEMail() {
        new LoginPage(driver).FillEmailField("**********");
    }

    @And("User enter incorrect password")
    public void userEnterIncorrectPassword() {
        new LoginPage(driver).FillPasswordField("**********");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        new LoginPage(driver).ClickLoginButton();
    }

    @Then("Error appeared")
    public void errorAppeared() {
    String errorMessage = new LoginPage(driver).getErrorMessage();
        Assert.assertEquals("Niepoprawne dane uwierzytelniające.", errorMessage);
        driver.quit();
    }

    @And("User enter correct password")
    public void userEnterCorrectPassword() {
        new LoginPage(driver).FillPasswordField("********");
    }

    @Then("Welcome message appeared on main page")
    public void welcomeMessageAppearedOnMainPage() {
        String userDropdownText = new MainPage(driver).getUserDropdownText();
        Assert.assertTrue(userDropdownText.contains("Witaj"));
        Assert.assertTrue(!userDropdownText.contains("zaloguj się"));
        driver.quit();
    }
}
