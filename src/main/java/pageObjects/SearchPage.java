package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(css = "[data-test='search-input']")
    List<WebElement> searchBox;

    @FindBy(css = "[data-test='search-form'] > button")
    WebElement searchButton;

    public void search(String searchTerm) {
        webUtils.waitTillElementIsVisible(searchBox.get(0));
        webUtils.enterText(searchBox.get(0), searchTerm, false);
    }

    public boolean checkSearchButtonEnabled() {
        webUtils.waitTillElementIsVisible(searchButton);
        try {
            return searchButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnSearchButton() {
        webUtils.waitTillElementIsClickable(searchButton);
        searchButton.click();
    }

    public boolean verifySearchBoxPresent() {
        webUtils.waitTillElementIsVisible(searchBox.get(2));
        return searchBox.get(2).isDisplayed();
    }
}
