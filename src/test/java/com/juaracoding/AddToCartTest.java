package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Maximize Window");
        driver.get("https://www.saucedemo.com/");
        System.out.println("Open Browser");
    }

    @Test
    public void testAddToCart(){
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        String txtCartBadge = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        String txtRemove = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).getText();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String txtOnCart = driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        Assert.assertEquals(txtCartBadge, "1");
        Assert.assertEquals(txtRemove, "Remove");
        Assert.assertEquals(txtOnCart, "1");
    }

    @AfterClass
    public void finish(){
        delay(7);
        driver.quit();
    }

    public static void delay(long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
