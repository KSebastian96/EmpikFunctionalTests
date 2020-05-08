package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import page_object.BooksCategoryPage;
import page_object.MainPage;

import java.util.List;

public class SearchingSteps extends Base_Step {
    String enteredBookTitle;

    @Given("User is on home page")
    public void userIsOnHomePage() {
    }

    @When("User enter book (.*) in searching bar")
    public void userEnterBookTitleInSearchingBar(String bookTitle) {
        new MainPage(driver).FillSearchingBar(bookTitle);
        enteredBookTitle = bookTitle;
    }

    @And("User choose book category")
    public void userChooseBookCategory() {
        new MainPage(driver).CLickSearchingBarCategoryButton();
        new MainPage(driver).ClickSearchingBarBooksCategory();
    }

    @And("User click search button")
    public void userClickSearchButton() {
        new MainPage(driver).ClickSearchingButton();
    }

    @Then("Results should be books")
    public void resultsShouldBeBooks() {

    }

    @And("Results should contains entered phrase")
    public void resultsShouldContainsEnteredPhrase() {
        List<WebElement> booksTitles = new BooksCategoryPage(driver).getAdsTitles();
        for (int i = 0; i < booksTitles.size(); i++) {
            booksTitles.get(i).getText().toLowerCase().contains(enteredBookTitle);
        }
    }
}
