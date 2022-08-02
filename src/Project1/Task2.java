package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/MertAydin/Documents/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.applitools.com/");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("ttechno@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123");

        WebElement logIn = driver.findElement(By.id("log-in"));
        logIn.click();

        WebElement time = driver.findElement(By.id("time"));
        String timeString = time.getText();

        System.out.println(timeString.substring(timeString.indexOf(":")+2));

        String url = driver.getCurrentUrl();

        System.out.println(url);

        driver.quit();

    }

}
