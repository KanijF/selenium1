package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Saucedemo {
    public static void main(String[] args) throws InterruptedException {

        //Initiate selenium WebDriver
        WebDriver driver;


        // Setup Chrome browser
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();


        // Open a Chrome browser
        driver = new ChromeDriver();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));


        //Navigate to the login page of saucedemo
        driver.get("https://www.saucedemo.com/");

        // Enter username
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

        // Enter password secret_sauce
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

        // Click on login button
        driver.findElement(By.cssSelector("#login-button")).click();

        //Verify that login was successfully
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.contains(expectedUrl);

        // Add first product to cart
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();

        // add second product to cart
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket")).click();

        // navigate to cart page
         driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).click();

         //Verify that the two products were added to the cart
        boolean cartIcon2Displayed = driver.findElement(By.cssSelector("#shopping_cart_container > a")).isDisplayed();
        if(cartIcon2Displayed){
            System.out.println("Icon is displayed");
        }else {
            System.out.println("Icon is NOT displayed");
        }

        // click checkout button
        driver.findElement(By.id("checkout")).click();

        // enter checkout information
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Kanij");

        driver.findElement(By.cssSelector("#last-name")).sendKeys("Fatema");

         driver.findElement(By.cssSelector("#postal-code")).sendKeys("H4N3G9");

     // click continue button
       driver.findElement(By.cssSelector("#continue")).click();

    // click finish button
      driver.findElement(By.cssSelector("#finish")).click();

      //Verify that checkout was successful
        boolean CheckoutCompleteDisplayed= driver.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).isDisplayed();
        if(CheckoutCompleteDisplayed){
            System.out.println("Checkout is successful");
        }else {
            System.out.println("Checkout is NOT successful");
        }

        //Click hamburger menu
        driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();

        // Logout
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

        // Wait 5 seconds
        Thread.sleep(5000);

        // Close the browser
        driver.quit();

    }
}
