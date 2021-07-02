package ru.stqa.ptf.tests.testsUNP;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.pages.administration.Administration;
import ru.stqa.ptf.pages.administration.Audith;
import ru.stqa.ptf.pages.administration.Dublicates;
import ru.stqa.ptf.pages.administration.Info;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Раздел Администрирование")
public class AdministrationUNPTest extends TestBase {
    Administration adm = new Administration();
    Audith audith = new Audith();
    Info info = new Info();
    Dublicates dub = new Dublicates();

    @Before
    public void firstStep() {
        adm.openAdminSection();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Переход на форму аудита")
    public void audithPage() {
        audith.openSection();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Переход на форму Дубликатов клиентов")
    public void dedublicationPage() {
        dub.openSection();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Открытие блока Информации")
    public void infoPage() {
        info.openSection();
        Buttons.clickOKButton();
    }
}
