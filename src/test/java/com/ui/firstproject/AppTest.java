package com.ui.firstproject;

import static org.junit.Assert.assertTrue;

import net.sourceforge.tess4j.ITesseract;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class AppTest {
    @Test
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\elifse\\Desktop\\passoselenium\\Test\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //page maximize
        driver.manage().window().maximize();
        //BaseUrl değişkenine url bilgisi atanır.
        String baseUrl = "https://www.n11.com/";
        //Web sitesini browser da açar
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement warning = driver.findElement(By.xpath("//span[@class='btn btnBlack']"));
        warning.click();

        WebElement membership = driver.findElement(By.xpath("//a[.='Üye Ol']"));
        membership.click();

        WebElement registeragreetment = driver.findElement(By.xpath("//div[@id='userKvkkModal']//span[@class='closeBtn closePopup']"));
        registeragreetment.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='firstName']"));
        name.click();
        name.sendKeys("Test");

        WebElement surname = driver.findElement(By.xpath("//input[@id='lastName']"));
        surname.click();
        surname.sendKeys("Test");

        WebElement mail = driver.findElement(By.xpath("//input[@id='registrationEmail']"));
        mail.click();
        mail.sendKeys("testnetas@gmail.com");


        WebElement password = driver.findElement(By.xpath("//input[@id='registrationPassword']"));
        password.click();
        password.sendKeys("Test4566");

        WebElement passwordAgain = driver.findElement(By.xpath("//input[@id='passwordAgain']"));
        passwordAgain.click();
        passwordAgain.sendKeys("Test4566");

        WebElement number = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        number.sendKeys("555555555");

        WebElement gender = driver.findElement(By.xpath("//label[.='Kadın']"));
        gender.click();

        WebElement birtDay = driver.findElement(By.xpath("//select[@id='birthDay']"));
        birtDay.click();
        birtDay.sendKeys("24");
        birtDay.click();

        WebElement birthMonth = driver.findElement(By.id("birthMonth"));
        Select dropdown = new Select(birthMonth);
        dropdown.selectByIndex(11);


        WebElement birthYear = driver.findElement(By.id("birthYear"));
        Select dropdown2 = new Select(birthYear);
        dropdown2.selectByValue("1995");

        WebElement agreement = driver.findElement(By.xpath("//div[@class='inputfield buyerAgreement ']//label[1]"));
        agreement.click();

        WebElement smsorMailSend = driver.findElement(By.xpath("//label[contains(.,'Tarafımla pazarlama ve tanıtım amaçlı iletişime geçilmesine izin veriyorum.')]"));
        smsorMailSend.click();

        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        //Type the entered captcha to the text box
        driver.findElement(By.xpath("//input[@id='captchaText']")).sendKeys(captchaVal);

        WebElement registerbutton = driver.findElement(By.xpath("//div[@id='submitButton']"));
        registerbutton.click();
    }
}