import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new ChromeDriver(options);

            driver.get("https://bogpay.ge/ka/payments/sakomisios-gareshe/krokobeTi");
            WebElement searchBox = (WebElement) driver.findElement(By.cssSelector("div.form-elements-before-info"))
                    .getShadowRoot().findElement(By.cssSelector("bd-font#value")).getShadowRoot()
                    .findElement(By.cssSelector("bd-blank-input.input")).getShadowRoot()
                    .findElement(By.cssSelector("input#input"));
            searchBox.sendKeys("8016615");
            searchBox.sendKeys(Keys.RETURN);
            System.out.println(searchBox.getText());

            driver.quit();
        }catch (WebDriverException ex){
            System.out.println(ex);
        }

    }
}
