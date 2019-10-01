package appium.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BasePage {

    private final AppiumDriver driver;
    private final int width;
    private final int height;

    private int rightEdgeOfTheScreen;
    private int leftEdgeOfTheScreen;
    private int lowerEdgeOfTheScreen;
    private int upperEdgeOfTheScreen;

    @AndroidFindBy (id = "org.wikipedia.alpha:id/view_onboarding_page_image_centered")
    protected MobileElement onBoardingImage;

    @AndroidFindBy (id = "org.wikipedia.alpha:id/view_onboarding_page_primary_text")
    protected MobileElement onboardingTitle;

    @AndroidFindBy (id = "org.wikipedia.alpha:id/fragment_onboarding_forward_button")
    protected MobileElement nextPageButton;

    @AndroidFindBy (id = "org.wikipedia.alpha:id/fragment_onboarding_skip_button")
    protected MobileElement skipButton;

    @AndroidFindBy (id = "org.wikipedia.alpha:id/view_onboarding_page_switch")
    protected MobileElement sendUsageDataButton;

    public BasePage (AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        width = driver.manage().window().getSize().width;
        height = driver.manage().window().getSize().height;
        rightEdgeOfTheScreen = width - 100;
        leftEdgeOfTheScreen = 100;
        lowerEdgeOfTheScreen = height - 100;
        upperEdgeOfTheScreen = 100;

    }


    public boolean isOnboardingImageShowing() {
        return onBoardingImage.isDisplayed();
    }

    public boolean isUsageButtonShowing() {
        waitForElementToAppear(sendUsageDataButton);
        return true;
    }

    public void tapNextPageButton() {
        nextPageButton.click();
    }

    public MainPage tapSkipButton() {
        skipButton.click();
        return new MainPage(driver);
    }

    protected void swipeWithCoordinates(AppiumDriver driver, int x1, int y1, int x2, int y2) {
        PointOption pointOption = new PointOption();
        new TouchAction(driver).
                press(pointOption.withCoordinates (x1, y1)).
                moveTo(pointOption.withCoordinates(x2,y2)).
                release().perform();
    }

    protected void swipeLeft() {
        swipeWithCoordinates(driver,rightEdgeOfTheScreen,height/3, leftEdgeOfTheScreen, height/3
        );
    }

    protected void swipeRight() {
        swipeWithCoordinates(driver, leftEdgeOfTheScreen, height/3, rightEdgeOfTheScreen, height/3);

    }

    protected void waitForElementToDisappear(By by) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void waitForElementToAppear(MobileElement element) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void doubleTap(AppiumDriver driver, MobileElement element)  {
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withElement((ElementOption.element(element)))
                        .withTapsCount(2)).perform();
    }

    public void tapByCoordinates(AppiumDriver driver, int x, int y) {
        new TouchAction(driver)
                .tap(TapOptions.tapOptions()
                .withPosition(new PointOption().withCoordinates(x,y)))
                .perform();
    }

    //Take Screenshots


}