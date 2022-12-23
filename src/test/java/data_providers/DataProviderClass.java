package data_providers;

import base.BasePage;
import org.testng.annotations.DataProvider;

public class DataProviderClass extends BasePage {

    @DataProvider(name = "Products")
    public static Object[][] searchForItems(){
        return excel.readStringArrays("Products");
    }
}
