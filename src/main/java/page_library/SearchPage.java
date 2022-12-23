package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class = 's-main-slot s-result-list s-search-results sg-row']/div//div[@class = 'sg-col sg-col-4-of-12 sg-col-8-of-16 sg-col-12-of-20 s-list-col-right']//h2[@class ='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a")
    public List<WebElement> searchResultsList;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@id = 'attachDisplayAddBaseAlert']//div[@class = 'a-box-inner a-alert-container']")
    public WebElement alertContainerBox;

    @FindBy(id = "nav-cart-count-container")
    public WebElement cartButton;





    public SearchPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isResultsTextsEqual(String expText) {
        String actText;
        for (WebElement ele : searchResultsList) {
            fluentWait.until(ExpectedConditions.visibilityOf(ele));
            actText = ele.getText();
            if (!(actText.contains(expText))) {
                return false;
            }
        }
        return true;
    }

    public void selectFromProductResult(int index){
        clickOnElement(searchResultsList.get(index));
    }

    public void addProductToCart(){
        clickOnElement(addToCartButton);
    }

    public CartPage navigateToCartPage(){
        isElementVisible(cartButton);
        clickOnElement(cartButton);
        return new CartPage();
    }
}
