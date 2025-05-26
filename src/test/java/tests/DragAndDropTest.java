package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest{
    private final By DRAG_N_DROP = By.xpath(String.format(PRECISE_TEXT_XPATH, "Drag and Drop"));
    private final By COLL_A = By.id("column-a");
    private final By COLL_B = By.id("column-b");
    private final String EXPECTED_COLUMN = "A";
    
    @Test
    public void moveColumns(){
        driver.findElement(DRAG_N_DROP).click();
        WebElement COLUMN_A = driver.findElement(COLL_A);
        WebElement COLUMN_B = driver.findElement(COLL_B);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(COLUMN_A, COLUMN_B).perform();
        String COL_TEXTB = COLUMN_B.getText();
        Assert.assertEquals(COL_TEXTB,EXPECTED_COLUMN);
    }
}

