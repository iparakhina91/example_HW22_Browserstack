package tests.local;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("emulator")
@Owner("korovinaiyu")
@Severity(SeverityLevel.NORMAL)
public class GettingStartedScreenTests extends TestBase {

    @Test
    @DisplayName("Verify first screen")
    void gettingStartedFirstScreen() {
        step("Verify availability of button", () ->
                $(id("org.wikipedia.alpha:id/addLanguageButton")).shouldBe(visible));

        step("Verify button name", () ->
                $(id("org.wikipedia.alpha:id/addLanguageButton"))
                        .shouldHave(text("Add or edit languages")));
    }

    @Test
    @DisplayName("Verify second screen")
    void gettingStartedSecondScreen() {
        step("Skip to second screen", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Verify header text", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
    }

    @Test
    @DisplayName("Verify third screen")
    void gettingStartedThirdScreen() {
        step("Skip to third screen", () -> {
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Verify header text", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @DisplayName("Verify fourth screen")
    void gettingStartedFourthScreen() {
        step("Skip to fourth screen", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });

        step("Verify header text", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));

        step("Verify reject button name", () -> {
            $(id("org.wikipedia.alpha:id/rejectButton")).shouldBe(visible);
            $(id("org.wikipedia.alpha:id/rejectButton"))
                    .shouldHave(text("Reject"));
        });

        step("Verify accept button name", () -> {
            $(id("org.wikipedia.alpha:id/acceptButton")).shouldBe(visible);
            $(id("org.wikipedia.alpha:id/acceptButton"))
                    .shouldHave(text("Accept"));
        });
    }
}