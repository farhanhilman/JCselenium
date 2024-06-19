package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 500)");

        //alert button
        driver.findElement(By.id("alertButton")).click();

        delay(2);

        driver.switchTo().alert().accept();
        System.out.println("Alert OK");

        driver.findElement(By.id("timerAlertButton")).click();

        delay(6);

        driver.switchTo().alert().accept();
        System.out.println("Timer Alert OK");

        delay(3);

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        System.out.println("Confirm OK");

        delay(3);

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Farhan");
        System.out.println("prompt OK");

        String actual = driver.findElement(By.id("promptResult")).getText();

        String expected = "Farhan";

        if (actual.equals(expected)){
            System.out.println("passed");
        }
        else {
            System.out.println("failed");
        }

        delay(10);

        driver.quit();

    }

    public static void delay(long detik){
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
