package org.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class VerifyAmazonSearchField {
    public String generateText(){
        char[] chars = "pquvw xyz!@ #123 Dasd".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    @Test
    public void VerifyAmazonSearchField_01(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Asus\\Desktop\\Epam\\First_Selenium\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );

        WebDriver webdriver = new ChromeDriver();
        webdriver.get("https://www.amazon.com");
        webdriver.manage().window().maximize();

        WebElement searchInput = webdriver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys(generateText());

        WebElement searchButton = webdriver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        WebElement errorMessage = webdriver.findElement(By.id("d"));
        errorMessage.isDisplayed();

        webdriver.close();
        webdriver.quit();
    }
}
