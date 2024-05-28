package testsuite;
/**
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 *
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 *
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        //actual result
        WebElement actualResult = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMsg = actualResult.getText();
        System.out.println(actualMsg);

        //expectedResult
        String expectedMsg = "Products";

        //match actual and expected result
        Assert.assertEquals(actualMsg, expectedMsg);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameField.sendKeys("standard_user");

        //Password element
        WebElement PasswordField = driver.findElement(By.id("password"));
        PasswordField.sendKeys("secret_sauce");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//input[@id='login-button']"));
        LoginField.click();

        // actualMsg
        List<WebElement> productNo = driver.findElements(By.className("inventory_item"));
        int Size = productNo.size();
        System.out.println(Size);

        //expectedMsg
        int expectedMsg = 6;

        //match actual and expectedMsg
        Assert.assertEquals("product number match", expectedMsg, Size);

    }

    @After
    //Here After method for close the browser
    public void tearDown() {
        closeBrowser();

    }
}