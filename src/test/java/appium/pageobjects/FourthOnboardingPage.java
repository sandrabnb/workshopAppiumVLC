package appium.pageobjects;

import io.appium.java_client.AppiumDriver;

public class FourthOnboardingPage extends BasePage {

    private String fourthOnboardingPageTitle = "Send anonymous data";

    public FourthOnboardingPage (AppiumDriver driver) {
        super(driver);
    }

    public boolean isTextShowing() {
        return onboardingTitle.getText().equals(fourthOnboardingPageTitle);
    }
}
