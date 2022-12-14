package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        String invalidVerify = "Invalid promo code";

        System.setProperty("webdriver.chrome.driver", "/Users/MertAydin/Documents/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://shopdemo.e-junkie.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='products']/div[1]/div/div[2]/a/div/div[2]/button"));
        addToCart.click();

        WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='EJIframeV3 EJOverlayV3'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(iFrame1));
        driver.switchTo().frame(iFrame1);

        WebElement addPromoButton = driver.findElement(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='Apply-Button Show-Promo-Code-Button']")));
        addPromoButton.click();

        WebElement promoInput = driver.findElement(By.cssSelector("input[class='Promo-Code-Value']"));
        wait.until(ExpectedConditions.visibilityOf(promoInput));
        promoInput.sendKeys("123456789");

        WebElement applyPromoButton = driver.findElement(By.cssSelector("button[class='Promo-Apply']"));
        wait.until(ExpectedConditions.visibilityOf(applyPromoButton));
        applyPromoButton.click();

//        WebElement invalidPromo = driver.findElement(By.xpath("//*[@id='SnackBar']//span[text()='Invalid promo code']"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='SnackBar']//span[text()='Invalid promo code']")));

        WebElement invalidPromo = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SnackBar']/span")));

        String invalidPromoText = invalidPromo.getText();

        if (invalidPromoText.equals(invalidVerify)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.quit();

    }

}
