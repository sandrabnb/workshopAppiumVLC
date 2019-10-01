package appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainPage extends BasePage {

    @AndroidFindBy (id = "org.wikipedia.alpha:id/search_container")
    private MobileElement searchContainer;

    public MainPage (AppiumDriver driver) {
        super(driver);
    }

    public boolean isSearchShowing() {

        return searchContainer.isDisplayed();
    }

}
