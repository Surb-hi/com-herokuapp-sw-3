package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {
    //This Method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //This method will send the keys
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
}
