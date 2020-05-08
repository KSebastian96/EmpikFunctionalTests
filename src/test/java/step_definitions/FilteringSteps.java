package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import page_object.BooksCategoryPage;
import page_object.ItBooksSubcategoryPage;
import page_object.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FilteringSteps extends Base_Step {
    Random random = new Random();
    String author;
    String coverType;
    double score;
    String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
            + "var elementTop = arguments[0].getBoundingClientRect().top;"
            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
    double enteredMinPrice;
    double enteredMaxPrice;

    @Given("User is on main page")
    public void userIsOnMainPage() {
    }

    @When("User click book category")
    public void userClickBookCategory() {
        new MainPage(driver).ClickBooksCategoryButton();
    }

    @And("User click IT subcategory")
    public void userClickITSubcategory() throws InterruptedException {
        new BooksCategoryPage(driver).ClickItSubcategoryButton();
        Thread.sleep(5000);
    }

    @And("User randomly choose author filter")
    public void userRandomlyChooseAuthorFilter() throws InterruptedException {
        List<WebElement> authorList = new ItBooksSubcategoryPage(driver).getAuthorFilterList();
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, authorList.get(6));
        new ItBooksSubcategoryPage(driver).ClickMoreAuthorsButton();
        int randomAuthor = random.nextInt(authorList.size());
        authorList.get(randomAuthor).click();
        String authorArray[] = authorList.get(randomAuthor).getText().split(" ");
        author = authorArray[0] + " " + authorArray[1];
        Thread.sleep(2000);
    }

    @Then("Results should match author filter")
    public void resultsShouldMatchAuthorFilter() {
        List<WebElement> authorResultsList = new ItBooksSubcategoryPage(driver).getResultsAuthorList();
        for (int i = 0; i < authorResultsList.size(); i++) {
            Assert.assertTrue(authorResultsList.get(i).getText().toLowerCase().contains(author.toLowerCase()));
        }
        driver.quit();
    }

    @And("User randomly choose cover type filter")
    public void userRandomlyChooseCoverTypeFilter() throws InterruptedException {
        List<WebElement> coverFilters = new ItBooksSubcategoryPage(driver).getCoverFilterList();
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, coverFilters.get(0));
        int randomCover = random.nextInt(coverFilters.size());
        coverFilters.get(randomCover).click();
        String cover[] = coverFilters.get(randomCover).getText().split(" ");
        coverType = cover[0];
        Thread.sleep(2000);
    }

    @Then("Results should match cover filter")
    public void resultsShouldMatchCoverFilter() {
        List<WebElement> resultCoverList = new ItBooksSubcategoryPage(driver).getResultsCoverList();
        for (int i = 0; i < resultCoverList.size(); i++) {
            Assert.assertTrue(resultCoverList.get(i).getText().contains(coverType));
        }
        driver.quit();
    }

    @And("User randomly choose score filter")
    public void userRandomlyChooseScoreFilter() {
        List<WebElement> scoreFilterList = new ItBooksSubcategoryPage(driver).getScoreFilterList();
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, scoreFilterList.get(1));
        int randomScoreFilter = random.nextInt(scoreFilterList.size());
        scoreFilterList.get(randomScoreFilter).click();
        String scoreArray[] = scoreFilterList.get(randomScoreFilter).getText().split(" ");
        score = Double.parseDouble(scoreArray[0]);
    }

    @Then("Results should match score filter")
    public void resultsShouldMatchScoreFilter() {
        List<WebElement> scoreResultsList = new ItBooksSubcategoryPage(driver).getScoreResultsList();
        if (score == 1) {
            for (int i = 0; i < scoreResultsList.size(); i++) {
                double scoreResult = Double.parseDouble(scoreResultsList.get(i).getText());
                Assert.assertTrue(scoreResult > 2);
            }
        } else if (score == 2) {
            for (int i = 0; i < scoreResultsList.size(); i++) {
                double scoreResult = Double.parseDouble(scoreResultsList.get(i).getText());
                Assert.assertTrue(scoreResult > 1.5 || scoreResult < 3);
            }
        } else if (score == 3) {
            for (int i = 0; i < scoreResultsList.size(); i++) {
                double scoreResult = Double.parseDouble(scoreResultsList.get(i).getText());
                Assert.assertTrue(scoreResult > 2.5 || scoreResult < 4);
            }
        } else if (score == 4) {
            for (int i = 0; i < scoreResultsList.size(); i++) {
                double scoreResult = Double.parseDouble(scoreResultsList.get(i).getText());
                Assert.assertTrue(scoreResult > 3.5 || scoreResult < 5);
            }
        } else if (score == 5) {
            for (int i = 0; i < scoreResultsList.size(); i++) {
                double scoreResult = Double.parseDouble(scoreResultsList.get(i).getText());
                Assert.assertTrue(scoreResult > 4.4);
            }
        }
        driver.quit();
    }

    @And("User fill minimal price field with (.*)")
    public void userFillMinimalPriceFieldWithMinimalPrice(String minPrice){
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, driver.findElement(By.cssSelector(".field--slider__max")));
        new ItBooksSubcategoryPage(driver).FillMinPriceField(minPrice);
        enteredMinPrice = Double.parseDouble(minPrice);
    }

    @And("User fill maximal price field with (.*)")
    public void userFillMaximalPriceFieldWithMaximalPrice(String maxPrice) throws InterruptedException {
        new ItBooksSubcategoryPage(driver).FillMaxPriceField(maxPrice);
        enteredMaxPrice = Double.parseDouble(maxPrice);
        Thread.sleep(2000);
    }

    @Then("Results should match price filters")
    public void resultsShouldMatchPriceFilters() {
        List<WebElement> priceResultsList = new ItBooksSubcategoryPage(driver).getPriceResultsList();
        for (int i = 0; i < priceResultsList.size(); i++) {
            String resultPriceArray[] = priceResultsList.get(i).getText().split(" ");
            String resultPriceString = resultPriceArray[0].replace(",", ".");
            double resultPrice = Double.parseDouble(resultPriceString);
            Assert.assertTrue(resultPrice <= enteredMaxPrice || resultPrice >= enteredMinPrice);
        }
    }
}