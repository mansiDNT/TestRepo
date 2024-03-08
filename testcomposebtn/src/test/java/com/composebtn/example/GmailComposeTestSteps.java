package com.composebtn.example;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GmailComposeTestSteps {
	
	private WebDriver driver;
	public static  String userDir = System.getProperty("user.dir");
	
    @Given("User is on the Gmail login page")
    public void userIsOnGmailLoginPage() {
        // Set up WebDriver (you may need to adjust the path to your WebDriver executable)
        System.setProperty("webdriver.chrome.driver", userDir + "\\chromedriver.exe");
        driver = new ChromeDriver();

        // Navigate to Gmail login page
        driver.get("https://mail.google.com/");
    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
    	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("your email id");
    	driver.findElement(By.xpath("//span[text()='Next']")).click();
    	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("your password");
    	driver.findElement(By.xpath("//span[text()='Next']")).click(); 
  
        // For example, find username and password fields, enter credentials, and submit the form
    }

    @Then("User clicks on the Compose button")
    public void userClicksOnComposeButton() {
        // Find and click on the Compose button
        WebElement composeButton = driver.findElement(By.xpath("//div[text()='Compose']"));
        composeButton.click();
    }

    @Then("Compose window should be displayed")
    public void composeWindowShouldBeDisplayed() {
        // Verify that the Compose window is displayed
        WebElement composeWindow = driver.findElement(By.xpath("//div[@role='dialog' and @aria-labelledby=':31']"));
        assertTrue(composeWindow.isDisplayed());

        // Close the browser
        driver.quit();
    }

}
