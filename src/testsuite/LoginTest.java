package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid username
       sendTextToElement(By.name("username"),"abc12345@gmail.com");
        //Enter valid password
        sendTextToElement(By.name("password"),"abc12345");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@class='button']"));
        //Verify the ‘Accounts Overview’ text is display
        //Expected text
        String expectedText = "Accounts Overview";
        //find the actual message and get text
        String actualText = driver.findElement(By.xpath("//a[contains(text(),'Accounts Overview')]")).getText();
        //Validate actual and expected
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Enter invalid username
        sendTextToElement(By.name("username"),"Chiku");
        //Enter invalid password
        sendTextToElement(By.name("password"),"chiku123456");
        //Click on Login button
        clickOnElement(By.xpath("//input[@class='button']"));
        //Verify the error message ‘The username and password could not be verified.’
        //Expected text
        String expectedText = "An internal error has occurred and has been logged.";
        //find the actual message and get text
        String actualText = driver.findElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]")).getText();
        //Validate actual and expected text
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        sendTextToElement(By.name("username"),"abc12345@gmail.com");
        //Enter valid password
        sendTextToElement(By.name("password"),"abc12345");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@class='button']"));
        // Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        // Verify the text ‘Customer Login’
        //Expected text
        String expectedText = "Customer Login";
        //find the actual message and get text
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]")).getText();
        //Validate actual and expected text
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void tearDown(){
        closeBrowser();
    }
    }


