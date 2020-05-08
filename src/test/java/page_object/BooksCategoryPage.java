package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BooksCategoryPage {
    public BooksCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/ksiazki/informatyka,3173,s?hideUnavailable=true&sort=scoreDesc']")
    private WebElement itSubcategoryButton;
    @FindBy(css = ".ta-product-title")
    private List<WebElement> AdsTitles;

    public List<WebElement> getAdsTitles() {
        return AdsTitles;
    }

    public void ClickItSubcategoryButton() {
        itSubcategoryButton.click();
    }

}
