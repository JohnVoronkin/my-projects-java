package my.simple.webdriver.test.main;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumMainTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
       // driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void openPage() {
        driver.get("http://mvnrepository.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Maven Repository"));
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='query']")));
        element.clear();
        element.sendKeys("gradle");

        driver.findElement(By.xpath("//*[@id='search']/form/input[2]")).click();

        WebElement resultSearch =
                (new WebDriverWait(driver, 10))
                        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='maincontent']/div[3]/div[1]/h2/a[1]")));
        resultSearch.isDisplayed();
        final String textResultSearch = resultSearch.getText();

        Assert.assertTrue(textResultSearch.equals("Gradle Core"));

        final int amountElement = driver.findElements(By.xpath("//a[contains(text(), 'gradle')]")).size();

        Assert.assertEquals(amountElement, 16);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
