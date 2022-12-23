package page_library;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#quantity")
    public WebElement quantityButton;

    @FindBy(xpath = "//span[@class = 'a-button-text a-declarative']")
    public WebElement quantityBox;

    @FindBy(xpath = "//input[@data-action = 'save-for-later' ]")
    public WebElement saveForLaterButton;

    @FindBy(xpath= "//input[@data-action = 'move-to-cart']")
    public WebElement moveToCartButton;




    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickSaveForLaterButton(){
        clickOnElement(saveForLaterButton);
    }
    public void clickMoveToCartButton(){
        clickOnElement(moveToCartButton);
    }


}
