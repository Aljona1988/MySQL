package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
  private SelenideElement loginField = $("[data-test-id=login] input");
  private SelenideElement passwordField = $("[data-test-id=password] input");
  private SelenideElement loginButton = $("[data-test-id=action-login]");
  private SelenideElement errorNotification = $("[data-test-id='error-notification']");

  public VerificationPage validLogin(DataHelper.AuthInfo info) {
    $("[data-test-id=login] input").setValue(info.getLogin());
    $("[data-test-id=password] input").setValue(info.getPassword());
    $("[data-test-id=action-login]").click();
    return new VerificationPage();
  }

  public void verifyErrorNotificationVisibility() {
    errorNotification.shouldBe(visible);
  }

}
