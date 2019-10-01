package appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import javafx.scene.control.TextInputControl;

public class FirstOnboardingPage extends BasePage {

    private String firstOnboardingPageTitle = "The Free Encyclopedia\n" +
            "…in over 300 languages";

    public FirstOnboardingPage (AppiumDriver driver) {
        super(driver);

    }

    public boolean isTextShowing() {
        return onboardingTitle.getText().equals(firstOnboardingPageTitle);
    }

}
