package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.opentelemetry.semconv.trace.attributes.SemanticAttributes.FaasDocumentOperationValues.INSERT;
import static java.time.LocalDate.now;
import static org.openqa.selenium.Keys.*;

public class CardDeliveryFormTest {

    @Test
    public void shouldTestForm() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id=date] input").sendKeys(LEFT_CONTROL, INSERT, BACK_SPACE);
        $("[data-test-id=date] input").setValue((now().plusDays( 4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! Встреча успешно забронирована на " +
                now().plusDays( 4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
    }
}
