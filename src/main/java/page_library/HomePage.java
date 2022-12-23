package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "#twotabsearchtextbox")
    public WebElement searchBarInputField;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public SearchPage searchForProduct(String prodName) {
        sendKeysToElement(searchBarInputField, prodName);
        clickOnElement(searchButton);
        return new SearchPage();
    }




}
