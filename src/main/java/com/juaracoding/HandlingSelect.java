package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSelect {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "D:\\My Tools\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement txtDropdown = driver.findElement(By.xpath("//*[@id=\"post-909\"]/div/div[1]/div/div[3]/div/div[1]/div[9]/div/div/h4/span"));
        js.executeScript("arguments[0].scrollIntoView();", txtDropdown);

        WebElement selectCar = driver.findElement(By.xpath("//*[@id=\"post-909\"]/div/div[1]/div/div[3]/div/div[1]/div[9]/div/div/div/select"));
        Select select = new Select(selectCar);

        select.selectByVisibleText("Audi");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
