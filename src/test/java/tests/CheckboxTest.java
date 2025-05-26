package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    private final By CHECK_BOX_PAGE = By.xpath(String.format(PRECISE_TEXT_XPATH, "Checkboxes"));
    private final By CHECKBOX_2 = By.xpath("//form/input[2]");

    @Test
    public void testCheckboxes() {
        driver.findElement(CHECK_BOX_PAGE).click();
        WebElement checkbox2 = driver.findElement(CHECKBOX_2);
        Assert.assertTrue(checkbox2.isSelected());
        //.getAttribute("checked")
    }
}

