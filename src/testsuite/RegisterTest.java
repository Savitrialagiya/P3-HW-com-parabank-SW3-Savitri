package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Verify the text ‘Signing up is easy!’
        //Expected text
        String expectedText = "Signing up is easy!";
        //Actual Text
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")).getText();
        //Verify actual and expected text
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter First name
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"),"Adam");
        //Enter Last name
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"),"Smith");
        // Enter Address
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"),"1,chalrie road");
        // Enter City
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"),"Harrow");
        // Enter State
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"),"London");
        // Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"),"HA1 5NN");
        // Enter Phone
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"),"1234567890");
        // Enter SSN
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"),"11111");
        // Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"abc12345@gmail.com");
        //Enter Password
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"abc12345");
        // Enter Confirm
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"),"abc12345");
        //click on register button
        clickOnElement(By.xpath("//input[@value='Register']"));
        //Verify the text 'Your account was created successfully. You are now logged in.'
        String expectedText = "Your account was created successfully. You are now logged in.";
        //Actual text
        String actualText = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]")).getText();
        //Verify actual and expected text
        Assert.assertEquals(expectedText,actualText);

    }
    @After
    //close browser
    public void tearDown(){
        closeBrowser();
    }
}
