package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/MertAydin/Documents/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.snapdeal.com/");

        driver.manage().window().maximize();

        WebElement searchBar = driver.findElement(By.id("inputValEnter"));
        searchBar.sendKeys("teddy bear");

        WebElement searchButton = driver.findElement(By.className("searchTextSpan"));
        searchButton.click();

        Thread.sleep(5000);

        WebElement searchCountLocator = driver.findElement(By.cssSelector("#searchMessageContainer > div > span"));
        String searchCountText =  searchCountLocator.getText();

        System.out.println(searchCountText);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        WebElement logo = driver.findElement(By.cssSelector(".notIeLogoHeader.aspectRatioEqual.sdLogo.cur-pointer"));
        logo.click();

        String url2 = driver.getCurrentUrl();
        System.out.println(url2);

        Thread.sleep(3000);

        driver.navigate().back();

        WebElement searchBar2 = driver.findElement(By.className(".overlap"));
        String searchBar2Value = searchBar2.getAttribute("value");

        System.out.println(searchBar2Value);

    }

}
