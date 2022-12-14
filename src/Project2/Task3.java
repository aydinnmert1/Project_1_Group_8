package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3 {

    public static void main(String[] args) throws InterruptedException {

        String invalidVerify = "Invalid Email\n" +
                "Invalid Email\n" +
                "Invalid Billing Name";

        System.setProperty("webdriver.chrome.driver", "/Users/MertAydin/Documents/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement payCredit = driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        wait.until(ExpectedConditions.visibilityOf(payCredit));
        payCredit.click();

        WebElement payButton = driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        wait.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();

        //WebElement invalidPay = driver.findElement(By.xpath("//*[@id='SnackBar']/span"));
        //wait.until(ExpectedConditions.visibilityOf(invalidPay));

        WebElement invalidPay = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SnackBar']/span")));

        String invalidPayText = invalidPay.getText();

        if (invalidPayText.equals(invalidVerify)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        driver.quit();

    }

}
