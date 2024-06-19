package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginHR {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 800)");

        driver.findElement(By.id("username")).sendKeys("Farhan");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("submit")).click();

        delay(3);

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        String url = driver.getCurrentUrl();
        System.out.println(url);
        String txtSuccessLogin = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
        System.out.println(txtSuccessLogin);
        String txtLogin = driver.findElement(By.xpath("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).getText();
        System.out.println(txtLogin);

        //Lengkapi Assertion IF
        assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        assertEquals(txtSuccessLogin, "Logged In Successfully");
        assertEquals(txtLogin, "Log out");

        delay(10);

        driver.quit();

    }

    public static void delay(long detik){
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void assertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("passed");
        }
        else {
            System.out.println("failed");
        }
    }

}
