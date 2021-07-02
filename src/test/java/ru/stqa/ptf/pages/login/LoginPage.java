package ru.stqa.ptf.pages.login;

import Configs.URLPages;
import com.codeborne.selenide.SelenideElement;

import static Configs.UserConfigRoles.USR_PASS;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement username = $("#username");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $("#login-button-id");

    public static void goToLoginPage() {
        open(URLPages.BASE_URL);
    }


    public void login(String name) {
        username.clear();
        username.sendKeys(name);
        password.clear();
        password.sendKeys(USR_PASS);
        loginButton.click();
    }
}
//    USR_NAME_ADMIN
//    USR_NAME_OP_DEPO
//    USR_NAME_OP_CONTR
//    USR_LOGIN
//    USR_NAME_OP_CLIENT
