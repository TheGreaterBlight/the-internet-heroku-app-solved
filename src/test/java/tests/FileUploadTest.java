package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private final By CHOOSE_FILE = By.id("file-upload");
    private final By SUBMIT_FILE = By.id("file-submit");
    private final By UPLOADED_FILE = By.id("uploaded-files");
    private final String FILE_NAME = "file.json";
    private final String RELATIVE_RESOURCE_PATH = System.getProperty("user.home") + "\\Downloads";
    private final String FILE_PATH = RELATIVE_RESOURCE_PATH + "\\" + FILE_NAME;
    private final By FILE_UPLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Upload"));

    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_UPLOAD).click();
        File fileToUpload = new File(FILE_PATH);
        driver.findElement(CHOOSE_FILE).sendKeys(fileToUpload.getAbsolutePath());
        driver.findElement(SUBMIT_FILE).click();
        Assert.assertEquals(driver.findElement(UPLOADED_FILE).getText(), FILE_NAME, "CAN NOT REACH TO FILE");

    }
}
