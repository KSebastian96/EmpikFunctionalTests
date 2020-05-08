package page_object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItBooksSubcategoryPage {
    public ItBooksSubcategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".expandLink.contauthorFacet")
    private WebElement moreAuthorFilterButton;
    @FindBy(xpath = "//label[contains(@for,'authorFacet')]")
    private List<WebElement> authorFilterList;
    @FindBy(css = ".smartAuthorWrapper.ta-product-smartauthor")
    private List<WebElement> resultsAuthorList;
    @FindBy(xpath = "//label[contains(@for,'carrier')]")
    private List<WebElement> coverFilterList;
    @FindBy(css = ".productMainInfoSuffix.ta-product-carrier")
    private List<WebElement> resultsCoverList;
    @FindBy(xpath = "//label[contains(@for,'rateScore')]")
    private List<WebElement> scoreFilterList;
    @FindBy(xpath = "//div[@class='score']")
    private List<WebElement> scoreResultsList;
    @FindBy(css = ".field--slider__min")
    private WebElement minPriceField;
    @FindBy(css = ".field--slider__max")
    private WebElement maxPriceField;
    @FindBy(css = ".field--slider__apply.ta-approve-btn")
    private WebElement applyPriceButton;
    @FindBy(xpath = "//div[@class='price ta-price-tile ']")
    private List<WebElement> priceResultsList;

    public List<WebElement> getPriceResultsList() {
        return priceResultsList;
    }

    public void FillMaxPriceField(String maxPrice){
        maxPriceField.click();
        maxPriceField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        maxPriceField.sendKeys(maxPrice);
        applyPriceButton.click();
    }
    public void FillMinPriceField(String minPrice) {
        minPriceField.click();
       minPriceField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        minPriceField.sendKeys(minPrice);
    }

    public List<WebElement> getScoreResultsList() {
        return scoreResultsList;
    }

    public List<WebElement> getScoreFilterList() {
        return scoreFilterList;
    }

    public List<WebElement> getResultsCoverList() {
        return resultsCoverList;
    }

    public List<WebElement> getCoverFilterList() {
        return coverFilterList;
    }

    public List<WebElement> getResultsAuthorList() {
        return resultsAuthorList;
    }

    public List<WebElement> getAuthorFilterList() {
        return authorFilterList;
    }

    public void ClickMoreAuthorsButton() {
        moreAuthorFilterButton.click();
    }
}
