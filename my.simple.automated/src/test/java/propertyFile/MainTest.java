package propertyFile;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigProperties;

public class MainTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openPage() {
        driver.get(ConfigProperties.getTestProperty("url"));
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Maven Repository"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
