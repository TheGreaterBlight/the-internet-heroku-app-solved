package tests;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.awaitility.core.ConditionTimeoutException;

public class FileDownloadTest extends BaseTest {
    private final String FILE_NAME = "test.txt";
    private final String RELATIVE_RESOURCE_PATH = System.getProperty("user.home") + "\\Downloads";
    private final By FILE_DOWNLOAD = By.xpath(String.format(PRECISE_TEXT_XPATH, "File Download"));
    private final By FILE_NAME_XPATH = By.xpath(String.format(PRECISE_TEXT_XPATH, FILE_NAME));
    private final String FILE_PATH = RELATIVE_RESOURCE_PATH + "\\" + FILE_NAME;
    private final File downloadedFile = new File(FILE_PATH);
    private final long MAX_WAIT = 30;
    @Test
    public void fileUploadTest() {
        driver.findElement(FILE_DOWNLOAD).click();
        Assert.assertTrue(driver.findElement(FILE_NAME_XPATH).isDisplayed(), "File is not displayed");
        driver.findElement(FILE_NAME_XPATH).click();
        Assert.assertTrue(ifFileExists(downloadedFile), "FILE DO NOT EXISTS WITHIN THE FOLDER");
    }
    private boolean ifFileExists(File file){
        try{
          Awaitility.await().atMost(MAX_WAIT, TimeUnit.SECONDS).until(file::exists);
        }
        catch(ConditionTimeoutException exception){
            return false;
        }
        return true;
    }
    @AfterMethod
    public void DeleteF(){
        if(downloadedFile.exists()){
            downloadedFile.delete();
        }
    }
}
