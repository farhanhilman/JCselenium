package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //css Selector
        String headerTxt = driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > h1")).getText();
        System.out.println(headerTxt);

        driver.findElement(By.id("userName")).sendKeys("Farhan");
        driver.findElement(By.id("userEmail")).sendKeys("aanaja112233@gmail.com");

        js.executeScript("window.scrollBy(0, 500)");

        driver.findElement(By.id("currentAddress")).sendKeys("Palembang");
        driver.findElement(By.id("permanentAddress")).sendKeys("Palembang");

        js.executeScript("window.scrollBy(0, 200)");
        driver.findElement(By.id("submit")).click();

        System.out.println("Data Submit");

        String actual = driver.findElement(By.id("name")).getText();
        System.out.println(actual);

        String expected = "Name:Farhan";

        if (actual.equals(expected)){
            System.out.println("Cek name passed");
        }
        else {
            System.out.println("Cek name failed");
        }




        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
