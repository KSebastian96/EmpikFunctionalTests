package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = ".e-btn.e-btn--primary.e-btn--block.e-btn--higher.ng-binding")
    private WebElement loginButton;
    @FindBy(css = ".ne-system-message-stack__message.ng-binding.ng-scope.typeError")
    private WebElement errorLoginMessage;

    public String getErrorMessage(){
        return errorLoginMessage.getText();
    }
    public void FillEmailField(String email){
        emailField.click();
        emailField.sendKeys(email);
    }
    public void FillPasswordField(String password){
        passwordField.click();
        passwordField.sendKeys(password);
    }
    public void ClickLoginButton(){
        loginButton.click();
    }
}
