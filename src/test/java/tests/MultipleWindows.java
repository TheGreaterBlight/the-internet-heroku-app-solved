package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows extends BaseTest {
    private final By MULTI_WINDOWS = By.xpath(String.format(PRECISE_TEXT_XPATH, "Multiple Windows"));
    private final By CLICK_HERE_BUTT = By.xpath("//a[contains(@href,'windows')]");
    private final By HEADER = By.tagName("h3");
    private String ORIGINAL_WINDOW = "";
    private static final int TAB_NUMBER = 2;
    private final String EXPECTED_WINDOW = "New Window";

    @Test
    public void multipleWindowsTest() {
        driver.findElement(MULTI_WINDOWS).click();
        driver.findElement(CLICK_HERE_BUTT).click();
        ORIGINAL_WINDOW = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(TAB_NUMBER));

        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(ORIGINAL_WINDOW)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        WebElement headerElement = driver.findElement(HEADER);
        String headerText = headerElement.getText();
        Assert.assertEquals(headerText, EXPECTED_WINDOW);
    }

    @AfterMethod
    public void getBack() {
        driver.switchTo().window(ORIGINAL_WINDOW);
    }
}
