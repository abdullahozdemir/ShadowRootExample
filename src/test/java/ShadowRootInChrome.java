import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRootInChrome {


    @Test
    public void test() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("chrome://downloads/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement search = (WebElement) jse.executeScript("return document.querySelector(\"downloads-manager\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#toolbar\").shadowRoot.querySelector(\"#search\").shadowRoot.querySelector(\"#searchInput\")");

        search.sendKeys("aozdemir");

        Thread.sleep(3000);


        driver.manage().window().maximize();

        driver.quit();

    }
}