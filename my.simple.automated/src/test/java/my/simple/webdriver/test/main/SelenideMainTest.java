package my.simple.webdriver.test.main;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideMainTest {

    @BeforeClass
    public void setup() {
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void openPage() {
        open("http://mvnrepository.com");
        assertThat(title())
                .isEqualTo("Maven Reposiory: Search/Browse/Explore");
    }

}
