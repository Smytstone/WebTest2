package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.*;
import static org.openqa.selenium.Keys.ENTER;

public class CardDeliveryFormCalendarTest {
    @Test
    public void shouldTestForm() throws InterruptedException {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Вл");
        $("[data-test-id=city] input").sendKeys(ARROW_DOWN, ARROW_DOWN, ENTER);
        $(".input__icon").click();
        $(".calendar").sendKeys(ARROW_RIGHT,ARROW_RIGHT,ARROW_RIGHT,ARROW_RIGHT,ARROW_RIGHT,ARROW_RIGHT,ARROW_RIGHT, ENTER);
        $("[data-test-id=name] input").setValue("Александр");
        $("[data-test-id=phone] input").setValue("+79270000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));

    }
}
