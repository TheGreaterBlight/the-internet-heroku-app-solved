package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {
    private final By DROP_DOWN_PAGE = By.xpath(String.format(PRECISE_TEXT_XPATH, "Dropdown"));
    private final String DROP_LIST = "dropdown";
    private final String SELECT_OPTION = "Option 2";
    private final By UNIQUE_ELEMENT = By.xpath("//div[contains(@class,'example')]");

    @Test
    void dropDownTest() {
        driver.findElement(DROP_DOWN_PAGE).click();
        Assert.assertTrue(driver.findElement(UNIQUE_ELEMENT).isDisplayed(), "Page is not open");
        Select dropDrown = new Select(driver.findElement(By.id(DROP_LIST)));
        dropDrown.selectByVisibleText(SELECT_OPTION);
        WebElement selected = dropDrown.getFirstSelectedOption();
        Assert.assertEquals(selected.getText(), SELECT_OPTION);
    }
}
