package ru.stqa.ptf.appmanager;

import Configs.URLPages;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.ILoggerFactory;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.pages.login.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static Configs.UserConfigRoles.USR_UNP;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

public abstract class TestBase {

    public static StringBuffer verificationErrors = new StringBuffer();
    public static REST rest;
    static LoginPage login = new LoginPage();
    private static final InternetExplorerDriver driver = new InternetExplorerDriver();
    private static final Logger log =Logger.getGlobal();

    @BeforeClass
    public static void openBrowserPage() {

        Configuration.browser = "ie";
        setWebDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        goToLoginPage();
        login.login(USR_UNP);
    }

    @AfterClass
    public static void tearDown() {
        log.info("Выполнен метод tear Down");
        try {
            rest.deleteClient(rest.findClient());

        }
        catch (Exception e) {
            log.info("Клиенты были удалены в процессе тестов");

        }
        try {

            rest.deleteRepresentation(rest.findRepresentation());

        }
        catch (Exception e) {
            log.info("Представительства были удалены в процессе тестов");
        }
        try {

            rest.deleteKND56(rest.findKND56());

        }
        catch (Exception e) {
            log.info("КДН56 были удалены в процессе тестов");
        }
        try {

            rest.deleteKND24(rest.findKND24());
        }
        catch (Exception e) {
            log.info("КНД24 были удалены в процессе тестов");
        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        }

    }

    @After
    public void goToMenu() {
        open(URLPages.URL_home);
        log.info("Выполнен возврат в меню ");
    }
}
