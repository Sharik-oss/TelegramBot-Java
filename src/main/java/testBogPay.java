import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import javax.ws.rs.WebApplicationException;
import java.time.Duration;

public class testBogPay {
    public static void main(String[] args){
        try {
            String username = "testDeposit12";
            String password = "testDeposit@12";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);
            driver.get("https://crocobet.com/#/");
            WebElement usernameBox = driver.findElement(By.xpath("/html/body/crc-root/crc-layout/div/div[2]/div/crc-header-container/div/crc-w-login-in-header-container/crc-login-in-header-presentation/div/form/div[1]/div[1]/crc-shared-input/div[1]/input"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            usernameBox.sendKeys(username);
            WebElement userPassBox = driver.findElement(By.xpath("/html/body/crc-root/crc-layout/div/div[2]/div/crc-header-container/div/crc-w-login-in-header-container/crc-login-in-header-presentation/div/form/div[1]/div[2]/crc-shared-input/div[1]/input"));
            userPassBox.sendKeys(password);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            WebElement button = driver.findElement(By.xpath("/html/body/crc-root/crc-layout/div/div[2]/div/crc-header-container/div/crc-w-login-in-header-container/crc-login-in-header-presentation/div/form/button"));
            button.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
            WebElement profile = driver.findElement(By.className("profile__info"));
            profile.click();
            WebElement profileInfo = driver.findElement(By.id("user.profile"));
            profileInfo.click();
            WebElement depositPage = driver.findElement(By.id("user.deposit"));
            depositPage.click();
            WebElement cardNumber = driver.findElement(By.className("card__footer--number"));
            System.out.println(cardNumber.getText());
            cardNumber.click();


            WebElement depositInput = driver.findElement(By.className("input"));
            depositInput.sendKeys("10");
            WebElement depositButton = driver.findElement(By.className("amount__btn"));
            depositButton.click();
            WebElement depositPageLink = driver.findElement(By.xpath("/html/body/crc-root/crc-layout/div/div[2]/ng-component/div/div/div[2]/div/crc-w-payment-container/crc-w-deposit-presentation/div/crc-w-shared-payment-container/crc-w-payment-popup-container/div/crc-w-payment-pay-container/crc-shared-popup/div/div/div[2]/crc-w-payment-pay-presentation/div/div/iframe"));
            driver.navigate().to(depositPageLink.getAttribute("src"));
            WebElement depositInfo = (WebElement) driver.switchTo().frame("acsFrame").findElement(By.className("info-wrapper"));
            System.out.println(depositInfo.getText());

        }catch (WebApplicationException we){
            System.out.println(we);
        }
    }
}