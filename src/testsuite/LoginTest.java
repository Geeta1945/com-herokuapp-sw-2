package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {


    @Before
    public void setUpHeroKuapp(){

        openBrowser_HeroKuapp(); // opening browser using BaseTest method and passing url as parameter
    }

    @Test
public void userSholdLoginSuccessfullyWithValidCredentials(){

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");// finding username element and sending username information

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword!");//finding password element and sending password information

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();// finding the login button and clicking that one
        String expectedMessage = "Secure Area";


        WebElement secureMessageElement = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']"));
       String actualMessage = secureMessageElement.getText();

        Assert.assertEquals(expectedMessage,actualMessage);


    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith1");//finding username element and sending username information

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword!");//finding password element and sending password information

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();// finding the login button and clicking that one

        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualMessage = (errorMessageElement.getText());// retrieving error message from web page
        Assert.assertTrue("",actualMessage.contains("Your username is invalid!"));


    }

    @Test
    public void verifyThePasswordErrorMessage(){

        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");//finding username element and sending username information

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("SuperSecretPassword");//finding password element and sending password information

        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();// finding the login button and clicking that one

        WebElement passwordErrorMessageElement = driver.findElement(By.id("flash"));
        System.out.println(passwordErrorMessageElement.getText());
        Assert.assertTrue("",passwordErrorMessageElement.getText().contains("Your password is invalid!"));



    }
@After

    public void closeBrowsers(){

        endProcedure();
}



}
