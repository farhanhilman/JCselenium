package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://demoqa.com/frames");
        System.out.println("Open Browser");

        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);

        //Sample Heading
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        driver.switchTo().defaultContent();

        String txtHeader = driver.findElement(By.cssSelector("#dramesWrapper > h1")).getText();
        System.out.println(txtHeader);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();



    }

}
