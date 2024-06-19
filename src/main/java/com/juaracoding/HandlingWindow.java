package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class HandlingWindow {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Open Browser");

        // tabButton
        driver.findElement(By.id("tabButton")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        // switch to tab 2
        driver.switchTo().window(tab.get(1));
        System.out.println(driver.getTitle());

        driver.switchTo().window(tab.get(0));
        System.out.println(driver.getTitle());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
