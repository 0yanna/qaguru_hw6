package rambler.xx45x;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    public void checkIssues() {
        step("Открываем страницу", () -> {
            open("https://github.com/");
        });

        step("Ввести значение в поле поиска", ()-> {
            $("[data-test-selector='nav-search-input']").setValue(REPOSITORY).pressEnter();
        });

        step("Открыть вкладку ", ()-> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открыть Issues и проверить наличие 76", ()-> {
            $(partialLinkText("Issues")).click();
            $(withText("#76")).should(visible);
        });
    }
}
