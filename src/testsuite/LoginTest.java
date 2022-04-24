package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //username element
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");

        //Password element
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");

        //Login element
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

        //actual result
        String actualmsg = getTextFromElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));

        //expectedresult
        String expectedmsg="Secure Area";

        //match actual and expected result
        Assert.assertEquals(actualmsg,expectedmsg);
    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //username element
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith1");

        //Password element
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");

        //Login element
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

        //actual result
        String actualmsg=getTextFromElement(By.id("flash"));

        //expected result
        String expectedresult="Your username is invalid!\n" +
                "×";

        //match actual and expected result
        Assert.assertEquals("Invalid inpute",actualmsg,expectedresult);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //username element
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith1");

        //Password element
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword");

        //Login element
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

        //actual result
        String actualmsg=getTextFromElement(By.id("flash"));

        //expected result
        String expectedmsg="Your username is invalid!\n" +
                "×";

        //match actual and expected result
        Assert.assertEquals("Invalid password",actualmsg,expectedmsg);

    }
    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();
    }
}
