package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertTest extends BaseTest {
    private final By JS_ALERT = By.xpath(String.format(PRECISE_TEXT_XPATH, "JavaScript Alerts"));
    private final By CLICK_FOR_JS_ALERT_BUTTON = By.xpath("//button[@onclick='jsAlert()']");
    private final By SUCCESS_MSG_ALLOCATOR = By.xpath(String.format(PRECISE_TEXT_XPATH, "You successfully clicked an alert"));


    @Test
    public void alertTest() {
        driver.findElement(JS_ALERT).click();
        driver.findElement(CLICK_FOR_JS_ALERT_BUTTON).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(SUCCESS_MSG_ALLOCATOR).isDisplayed(), "SUCCESS");

    }
}
