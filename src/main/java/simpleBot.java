import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class simpleBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println();
        String command = update.getMessage().getText();
        String message;
        SendMessage response = new SendMessage();
        //deposits
        if(command.contains("Bank of Georgia deposit")) {
            message = "Bank of Georgia deposit";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
                main(update.getMessage().getChatId(), "https://crocobet.com/#");
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }else if(command.contains("iPay Georgia deposit")){
            message = "iPay Georgia deposit";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
                main(update.getMessage().getChatId(), "https://bogpay.ge/ka/payments/sakomisios-gareshe/krokobeTi");
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }else if(command.contains("TBC Georgia deposit")){
            message = "TBC Georgia deposit";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);

            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }else if(command.contains("GeoPay Georgia deposit")){
            message = "GeoPay Georgia deposit გადავამოწმებ";
            response.setChatId(update.getMessage().getChatId().toString());
            response.setText(message);
            try {
                execute(response);
                main(update.getMessage().getChatId(), "https://tbcpay.ge/services/totalizatorebi-kazino-lataria/crocobet");
            } catch (TelegramApiException t) {
                t.printStackTrace();
            }
        }

    }

    public void main(Long chadID, String link){
        String username = "testDeposit12";
        String password = "testDeposit@12";
        String message;
        SendMessage response = new SendMessage();
        // Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        FluentWait wait = new FluentWait(driver);
        driver.get(link);
        if(link.equals("https://tbcpay.ge/services/totalizatorebi-kazino-lataria/crocobet")) {
            try {
                WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"service_input\"]"));
                searchBox.sendKeys("806615");

                searchBox.sendKeys(Keys.RETURN);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
                WebElement div = driver.findElement(By.xpath("/html/body/div[1]/main/main/div[1]/div[1]/div[3]/div[1]/div/div[1]/p"));
                System.out.println(div.getText());
                if (div.getText().contains("1************k")) {
                    message = "როგორც გადავამოწმე ყოლიფერი მუშაობს";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                } else {
                    message = "გაედოოო";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                }
                System.out.println(response);
                driver.quit();
            }catch (WebDriverException ex){
                System.out.println(ex.getMessage());
            }

        }
        if(link.equals("https://crocobet.com/#")){
            try {
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
                WebElement depositInput = driver.findElement(By.className("input"));
                depositInput.sendKeys("10");
                WebElement depositButton = driver.findElement(By.className("amount__btn"));
                depositButton.click();
                WebElement depositPageLink = driver.findElement(By.xpath("/html/body/crc-root/crc-layout/div/div[2]/ng-component/div/div/div[2]/div/crc-w-payment-container/crc-w-deposit-presentation/div/crc-w-shared-payment-container/crc-w-payment-popup-container/div/crc-w-payment-pay-container/crc-shared-popup/div/div/div[2]/crc-w-payment-pay-presentation/div/div/iframe"));
                driver.navigate().to(depositPageLink.getAttribute("src"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                WebElement depositInfo = (WebElement) driver.switchTo().frame("acsFrame").findElement(By.className("info-wrapper"));
                System.out.println(depositInfo.getText());
                if(depositInfo.getText().contains("0306")){
                    message = "როგორც გადავამოწმე ყოლიფერი მუშაობს";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                }else{
                    message = "გაედოოოო :დ";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                }
                driver.quit();
            }catch (WebDriverException we){
                System.out.println(we.getMessage());
            }

        }
        if(link.equals("https://bogpay.ge/ka/payments/sakomisios-gareshe/krokobeTi")){
            try {
                driver.manage().window().maximize();
                driver.get("https://bogpay.ge/ka/payments/sakomisios-gareshe/krokobeTi");
                WebElement shadowRoot = driver.findElement(By.tagName("ep-root"))
                        .getShadowRoot().findElement(By.id("outlet"))
                        .findElement(By.tagName("ep-app"))
                        .findElement(By.tagName("ep-payments")).getShadowRoot()
                        .findElement(By.className("wrapper__service-form")).findElement(By.id("form-wizard"))
                        .findElement(By.tagName("bd-page-wizard")).findElement(By.name("step1"))
                        .findElement(By.tagName("ep-service-form")).getShadowRoot()
                        .findElement(By.className("wrapper")).findElement(By.className("form-elements-wrapper"))
                        .findElement(By.className("form-elements-before-info"))
                        .findElement(By.id("customerIdComponentKey")).getShadowRoot()
                        .findElement(By.id("textField")).getShadowRoot()
                        .findElement(By.className("container")).findElement(By.tagName("bd-font"))
                        .findElement(By.tagName("bd-blank-input")).getShadowRoot()
                        .findElement(By.id("input"));

                shadowRoot.sendKeys("806615");
                shadowRoot.sendKeys(Keys.RETURN);

                WebElement ele = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].shadowRoot", shadowRoot);

                WebElement outsideElement = driver.findElement(By.tagName("ep-root"))
                        .getShadowRoot().findElement(By.id("outlet"))
                        .findElement(By.tagName("ep-app"))
                        .findElement(By.tagName("ep-payments")).getShadowRoot()
                        .findElement(By.className("wrapper__service-form")).findElement(By.id("form-wizard"))
                        .findElement(By.tagName("bd-page-wizard")).findElement(By.name("step1"))
                        .findElement(By.tagName("ep-service-form")).getShadowRoot()
                        .findElement(By.className("wrapper")).findElement(By.className("form-elements-wrapper"))
                        .findElement(By.className("form-elements-info"));

                Actions actions = new Actions(driver);
                actions.moveToElement(outsideElement).click().build().perform();
                if (outsideElement.getText().contains("1************k")) {
                    message = "როგორც გადავამოწმე ყოლიფერი მუშაობს";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
//                        MailSettings.main("mbigvava@crocobet.com","მუშაობს","ტესტინგ");
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                } else {
                    message = "გაედოოოო :დ";
                    response.setChatId(chadID);
                    response.setText(message);
                    try {
                        execute(response);
                    } catch (TelegramApiException t) {
                        t.printStackTrace();
                    }
                }
                driver.quit();
            }catch (WebDriverException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    //Telegram bot nickname
    @Override
    public String getBotUsername() {
        // TODO
        return "simpleTelegrBot";
    }

    //Telegram bot API
    @Override
    public String getBotToken() {
        // TODO
        return "6164660349:AAH3EdMD-B_14BMpFTe6P-mSUwzfViTrcTk";
    }
}
