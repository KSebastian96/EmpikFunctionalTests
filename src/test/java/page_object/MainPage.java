package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simple-dropdown2")
    private WebElement userDropdown;
    @FindBy(xpath = "//li[@data-name='Książki']")
    private List<WebElement> booksCategoryButton;
    @FindBy(xpath = "//button[@class='cookies-accept__close--button js-cookies-accept--button']")
    private WebElement cookiesCloseButton;
    @FindBy(xpath = "//span[@class='close-placement']")
    private WebElement closeAdButton;
    @FindBy(id = "bq")
    private WebElement searchingBar;
    @FindBy(css = ".search-categories__trigger.js-sc-trigger")
    private WebElement searchingBarCategoryButton;
    @FindBy(xpath = "//label[contains(text(),'Książki')]")
    private WebElement searchingBarBooksCategory;
    @FindBy(css = ".search-field__button.inlineImage--search")
    private WebElement searchingButton;

    public String getCategoryText() {
        return searchingBarBooksCategory.getText();
    }

    public void ClickSearchingButton() {
        searchingButton.click();
    }

    public void ClickSearchingBarBooksCategory() {
        searchingBarBooksCategory.click();
    }

    public void CLickSearchingBarCategoryButton() {
        searchingBarCategoryButton.click();
    }

    public void FillSearchingBar(String bookTitle) {
        searchingBar.click();
        searchingBar.sendKeys(bookTitle);
    }

    public void ClickBooksCategoryButton() {
        booksCategoryButton.get(1).click();
    }

    public String getUserDropdownText() {
        return userDropdown.getText();
    }
}
