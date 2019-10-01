package appium.pageobjects;

import io.appium.java_client.AppiumDriver;

public class SecondOnboardingPage extends BasePage {


    private String secondOnboardingPageTitle = "New ways to explore";

    public SecondOnboardingPage (AppiumDriver driver) {
        super(driver);
    }

    public boolean isTextShowing() {
        return onboardingTitle.getText().equals(secondOnboardingPageTitle);
    }
}
