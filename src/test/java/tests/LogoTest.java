package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoTest extends BaseTest {
    private final String NEW_URL = "https://practice-automation.com/iframes/";
    private final By NG_LOGO = By.xpath("//a[@title='National Geographic']");
    private final String IFRAME_ID = "frame2";

    @Test
    public void checkDisplayedLogo() {
        driver.navigate().to(NEW_URL);
        driver.switchTo().frame(driver.findElement(By.id(IFRAME_ID)));
        Assert.assertTrue(driver.findElement(NG_LOGO).isDisplayed());
    }
}

