package TestCase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTest {

    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        quitDriver();
    }

    protected WebDriver createDriver() {
        return new FirefoxDriver();
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    void loginSaucedemo() {
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");
        WebElement buttonLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        buttonLogin.click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    @Order(2)
    void orderSaucedemo() {
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        username.sendKeys("standard_user");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("secret_sauce");
        WebElement buttonLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        buttonLogin.click();
        System.out.println(driver.getCurrentUrl());
        WebElement backpack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        backpack.click();
        WebElement titleBackpack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div")));
        titleBackpack.getText();
        System.out.println(titleBackpack.getText());
        WebElement bikeLight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-bike-light")));
        bikeLight.click();
        WebElement titleBikeLight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_0_title_link")));
        titleBikeLight.getText();
        System.out.println(titleBikeLight.getText());
        WebElement cartContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
        cartContainer.click();
        System.out.println(driver.getCurrentUrl());
        WebElement checkout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        checkout.click();
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        firstname.sendKeys("Ujang");
        WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        lastname.sendKeys("lord");
        WebElement postalCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
        postalCode.sendKeys("10420");
        WebElement clickContinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        clickContinue.click();
        System.out.println(driver.getCurrentUrl());
        WebElement totalPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]")));
        totalPrice.getText();
        System.out.println(totalPrice.getText());
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        finish.click();
        WebElement checkoutComplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_complete_container")));
        checkoutComplete.getText();
        System.out.println(checkoutComplete.getText());
        System.out.println(driver.getCurrentUrl());
        WebElement backHome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
        backHome.click();
        System.out.println(driver.getCurrentUrl());
    }
}
