package rambler.xx45x;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.partialLinkText;

public class StepTest {

    @Step("Открыть старницу")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Ввести значение в поле поиска")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Открыть репозиторий")
    public void openPage(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Открываем вкладку Issue ")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем наличие Issues с неверным номером {number}")
    public void checkEmpty(String text) {
        $("#container-md").shouldHave(Condition.text(text));
    }

    @Test
    @Owner("yanna0")
    @Feature("Issues")
    @Story("Проверить наличие Issues")
    @DisplayName("Поиск наличия Issues")
    @Severity(SeverityLevel.BLOCKER)
    public void annotationTest() {
        StepTest steps = new StepTest();
        steps.openPage();
        steps.searchRepository("qa_guru");
        steps.openPage("autotests-cloud/qa_guru_first_course");
        steps.openIssueTab();
        steps.checkEmpty("There aren’t any open issues");
    }
}
