package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ECommerce {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        String url = driver.getCurrentUrl();
        assertEquals(url, "https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        String actual = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        assertEquals(actual, "Swag Labs");

        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();

        delay(3);

        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        assertEquals(error, "Epic sadface");

        //List
        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
        System.out.println(listInput.size());
        for (int i = 0; i < listInput.size(); i++) {
            System.out.println(listInput.get(i).getText());
        }

        //div[@class='inventory_item_name']

        // perform key press
        WebElement usernameContains = driver.findElement(By.xpath("//input[contains(@id,'user')]"));
        usernameContains.sendKeys("standard_user");
        usernameContains.sendKeys(Keys.CONTROL+"A");
        usernameContains.sendKeys(Keys.DELETE);

        delay(5);

        driver.quit();

    }

    static void assertEquals(String actual, String expected){
        if(actual.contains(expected)){
            System.out.println("passed");
        }
        else {
            System.out.println("failed");
        }
    }

    static void delay(long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
