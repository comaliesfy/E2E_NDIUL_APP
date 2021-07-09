package ru.stqa.ptf.tests.testsAdmin;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.administration.Administration;
import ru.stqa.ptf.pages.login.LoginPage;

import static Configs.UserConfigRoles.USR_NAME_ADMIN;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

@Epic("Роль-администратор")
@Feature("Администрирование")
public class AdminTest extends TestBase {

    LoginPage log = new LoginPage();
    Administration admin = new Administration();

    @Before
    public void start() {
        goToLoginPage();
        log.login(USR_NAME_ADMIN);
        admin.openAdminSection();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка отображения логов раздела Сис.логи")
    public void assertLogsSection() {
        admin.openSysLogs();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка отображения параметров раздела Сис.параметры")
    public void assertParamsSection() {
        admin.openSysParam();
    }

}
