import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class bog {
    public static void main(String[] args){

        // Set the system property for Chrome driver
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            FluentWait wait = new FluentWait(driver);
            driver.get("https://bogpay.ge/ka/payments/sakomisios-gareshe/krokobeTi");
            WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"service_input\"]"));
            searchBox.sendKeys("806615");

            searchBox.sendKeys(Keys.RETURN);
            WebElement div = driver.findElement(By.xpath("/html/body/div[1]/main/main/div[1]/div[1]/div[3]/div[1]/div/div[1]/p"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            System.out.println(div.getText());


        } catch (WebDriverException ex) {
            System.out.println(ex);
        }

    }
}
