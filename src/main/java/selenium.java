import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class selenium {
    public static String main(String link){
        String message = "";
        // Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        FluentWait wait = new FluentWait(driver);
        driver.get(link);
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"service_input\"]"));
        searchBox.sendKeys("806615");

        searchBox.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebElement div = driver.findElement(By.xpath("/html/body/div[1]/main/main/div[1]/div[1]/div[3]/div[1]/div/div[1]/p"));

        System.out.println(div.getText());
        message =  "როგორც გადავამოწმე ყოლიფერი მუშაობს";

        return message;
    }
}
