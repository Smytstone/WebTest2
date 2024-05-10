package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.time.LocalDate.now;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.ENTER;

public class CardDeliveryFormCalendarTest {
    @Test
    public void shouldTestForm() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Вл");
        $$(".menu-item").find(exactText("Владивосток")).click();
        $(".input__icon").click();
        $(".calendar").sendKeys(ARROW_RIGHT, ARROW_RIGHT, ARROW_RIGHT, ARROW_RIGHT, ENTER);
        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=notification]").shouldHave(exactText("Успешно! Встреча успешно забронирована на " +
                now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));

    }
}
