package my.simple.webdriver.test.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideMainTest {

    /*
    1. Настройка теста
    2. Вызов тестируемого метода
    3. Утверждение
    */

    @BeforeClass
    public void setup() {
        Configuration.browser = WebDriverRunner.CHROME;
        open("http://mvnrepository.com");
    }

    @Test
    public void openPage() {
        assertThat(title())
                .isEqualTo("Maven Repository: Search/Browse/Explore");
        $x("//*[@id='query']").setValue("gradle");
        $x("//*[@id='search']/form/input[2]").click();
        $x("//*[@id='maincontent']/div[3]/div[1]/h2/a[1]").shouldHave(Condition.exactText("Gradle Core"));
        $$x("//a[contains(text(), 'gradle')]")
                .shouldHave(size(16));
    }

}
