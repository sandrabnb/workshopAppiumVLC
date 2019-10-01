package appium.pageobjects;

import io.appium.java_client.AppiumDriver;

public class ThirdOnboardingPage extends BasePage {

    private String thirdOnboardingPageTitle = "Reading lists with sync";

    public ThirdOnboardingPage (AppiumDriver driver) {
        super(driver);
    }

    public boolean isTextShowing() {

        return onboardingTitle.getText().equals(thirdOnboardingPageTitle);
    }
}
