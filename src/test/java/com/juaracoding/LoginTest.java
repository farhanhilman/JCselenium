package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");
    }

    @AfterClass
    public void finish(){
        delay(5);
        driver.quit();
    }

    @Test
    public void testLoginValid(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String txtLogo = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(txtLogo, "Swag Labs");
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }


    public static void delay(long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
