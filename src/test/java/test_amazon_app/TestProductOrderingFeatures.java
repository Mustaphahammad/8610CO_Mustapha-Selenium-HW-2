package test_amazon_app;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.CartPage;
import page_library.HomePage;
import page_library.SearchPage;

public class TestProductOrderingFeatures extends BasePage {

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testSearchingForProd(String prod) {
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        Assert.assertTrue(sp.isResultsTextsEqual(prod));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testSelectFromSearchResults(String prod) {
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        sp.selectFromProductResult(0);
        Assert.assertTrue(isElementVisible(sp.addToCartButton));
    }



    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testAddProdToCart(String prod) {
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        sp.selectFromProductResult(0);
        sp.addProductToCart();
        fluentWait.until(ExpectedConditions.visibilityOf(sp.alertContainerBox));
        String expText = "Added to Cart";
        String actText = sp.alertContainerBox.getText();
        Assert.assertEquals(actText,expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testAddQuantity(String prod){
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        sp.selectFromProductResult(0);
        sp.addProductToCart();
        CartPage cartPage = sp.navigateToCartPage();
       // selectFromDropdownByIndex(cartPage.quantityButton,5);
        //selectFromDropdownByValue(cartPage.quantityButton, "8");
        selectFromDropdownByVisibleText(cartPage.quantityButton,"6");
        String expText = "Qty:6";
        String actText = cartPage.quantityBox.getText();
        Assert.assertEquals(actText,expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testSaveProductForLater(String prod){
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        sp.selectFromProductResult(2);
        sp.addProductToCart();
        CartPage cartPage = sp.navigateToCartPage();
        cartPage.clickSaveForLaterButton();
        Assert.assertTrue(isElementVisible(cartPage.moveToCartButton));
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class, dataProvider = "Products")
    public void testMoveToCart(String prod){
        HomePage homePage = new HomePage();
        SearchPage sp = homePage.searchForProduct(prod);
        sp.selectFromProductResult(2);
        sp.addProductToCart();
        CartPage cartPage = sp.navigateToCartPage();
        cartPage.clickSaveForLaterButton();
        cartPage.clickMoveToCartButton();
        Assert.assertTrue(isElementVisible(cartPage.saveForLaterButton));
    }






}
