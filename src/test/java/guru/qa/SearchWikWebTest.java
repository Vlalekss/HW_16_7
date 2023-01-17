package guru.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchWikWebTest {
    @BeforeEach
    void setUp(){
        open("https://ru.wikipedia.org/");

    }
    @CsvSource (value = {
            "viking, Viking",
            "oculus, Oculus"
    })
    @ParameterizedTest(name = "Проверка выдачи результата {1}" +
            "в результатах выдачи словаря по запросу {0}")
    void cambridgeSearchTest(String searchQuery, String expectedLabel) {
        $("#searchInput").setValue(searchQuery).pressEnter();
        $(".mw-search-results-container").shouldHave(text(expectedLabel));
    }

}
