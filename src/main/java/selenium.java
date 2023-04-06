import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class selenium {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--port=8080");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://crocobet.com/#/");
        driver.quit();
    }
}
