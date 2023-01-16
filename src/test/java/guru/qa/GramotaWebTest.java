package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GramotaWebTest {
    @BeforeEach
    void setUp(){
        open("https://dictionary.cambridge.org/");

    }
    @CsvSource (value = {
            "Set, set",
            "over, over"
    })
    @ParameterizedTest(name = "Проверка выдачи результата {1}" +
            "в результатах выдачи словаря по запросу {0}")
    void cambridgeSearchTest(String searchQuery, String expectedLabel) {
        $("#searchword").setValue(searchQuery).pressEnter();
        $("#hw dhw").shouldHave(text(expectedLabel));
    }

}
