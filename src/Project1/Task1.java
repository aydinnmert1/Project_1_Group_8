package Project1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/MertAydin/Documents/Selenium/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Automation");

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("Testing@gmail.com");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("Testing Current Address");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by 2000 pixels
        js.executeScript("window.scrollBy(0,300)");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement nameText = driver.findElement(By.id("name"));
        String nameTextString = nameText.getText();

        System.out.println(nameTextString.substring(nameTextString.indexOf(':')+1));

        WebElement emailText = driver.findElement(By.id("email"));
        String emailTextString = emailText.getText();

        System.out.println(emailTextString.substring(emailTextString.indexOf(':')+1));

        WebElement currentAddressText = driver.findElement(By.cssSelector("#currentAddress.mb-1"));
        String currentAddressTextString = currentAddressText.getText();

        System.out.println(currentAddressTextString.substring(currentAddressTextString.indexOf(':')+1));

        WebElement permanentAddressText = driver.findElement(By.cssSelector("#permanentAddress.mb-1"));
        String permanentAddressTextString = permanentAddressText.getText();

        System.out.println(permanentAddressTextString.substring(permanentAddressTextString.indexOf(':')+1));

        driver.quit();

    }

}
