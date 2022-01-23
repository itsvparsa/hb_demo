package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(css = "[data-test='page-title']")
    WebElement searchPageTitle;

    @FindBy(css = "[data-test='product-title']")
    List<WebElement> products;

    @FindBy(css = "[data-test='no-search-results']>div>div>h1")
    WebElement validationMessage;

    public String getAfterSearchText() {
        webUtils.waitTillElementIsVisible(searchPageTitle);
        return searchPageTitle.getText();
    }

    public List<String> getProductTitles() {
        webUtils.pause(1);
        List<String> productTitlesText = new ArrayList<>();
        for (WebElement product : products) {
            productTitlesText.add(product.getText());
        }
        System.out.println(productTitlesText.size());
        return productTitlesText;
    }

    public String getValidationTextMessage(){
        webUtils.waitTillElementIsVisible(validationMessage);
        return validationMessage.getText();
    }
}
