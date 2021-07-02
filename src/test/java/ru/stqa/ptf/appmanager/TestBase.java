package ru.stqa.ptf.appmanager;

import Configs.URLPages;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.pages.login.LoginPage;

import static Configs.UserConfigRoles.USR_UNP;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

public abstract class TestBase {

    public static StringBuffer verificationErrors = new StringBuffer();
    public static REST rest;
    static LoginPage login = new LoginPage();
    private static final InternetExplorerDriver driver = new InternetExplorerDriver();

    @BeforeClass
    public static void openBrowserPage() {
        Configuration.browser = "ie";
        Configuration.timeout = 6000;
        Configuration.startMaximized = true;
        setWebDriver(driver);
        goToLoginPage();
        login.login(USR_UNP);
    }

    @AfterClass
    public static void tearDown() {
        try {
            rest.deleteClient(rest.findClient());
            rest.deleteRepresentation(rest.findRepresentation());
        }
        catch (Exception e) {

        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        }
    }

    @After
    public void goToMenu() {
        open(URLPages.URL_home);
    }
}
