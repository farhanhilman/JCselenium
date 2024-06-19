package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class inputSimpleForm {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\My Tools\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Windows Maximize");
        driver.get("https://ultimateqa.com/complicated-page");
        System.out.println("Open Browser");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 1200)");

        driver.findElement(By.id("et_pb_contact_name_0")).sendKeys("Farhan");
        driver.findElement(By.id("et_pb_contact_email_0")).sendKeys("aanaja112233@gmail.com");
        driver.findElement(By.id("et_pb_contact_message_0")).sendKeys("good");

        String captcha = driver.findElement(By.className("et_pb_contact_captcha_question")).getText();
        System.out.println(captcha);

        String[] split = captcha.split(" ");

        int num1 = Integer.parseInt(split[0]);
        System.out.println(num1);
        int num2 = Integer.parseInt(split[2]);
        System.out.println(num2);

        int jumlah = num1 + num2;
        String str1 = Integer.toString(jumlah);
        System.out.println(captcha + " = " + str1);

        driver.findElement(By.name("et_pb_contact_captcha_0")).sendKeys(str1);

        driver.findElement(By.name("et_builder_submit_button")).click();

        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.name("log")).sendKeys("farhanhilman");
        driver.findElement(By.name("pwd")).sendKeys("farhan123");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }


}
