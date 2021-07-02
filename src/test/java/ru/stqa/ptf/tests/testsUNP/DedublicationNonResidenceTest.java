package ru.stqa.ptf.tests.testsUNP;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.dedublication.Dedublication;
import ru.stqa.ptf.pages.references.Nonresidence;

import static Configs.ClientConfigs.CLIENT_NAME;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Принудительное слияние записей справочника Нерезидента")
public class DedublicationNonResidenceTest extends TestBase {
    Nonresidence nres = new Nonresidence();
    Dedublication dedub = new Dedublication();
    REST rest = new REST();

    @Before
    public void before() {
        rest.createClient();
        rest.createClientDedub();
        nres.openNonResidenceSection();
    }

    @After
    public void after() {
        rest.deleteClient(rest.findClientDedub());
        try {

            rest.deleteClient(rest.findClient());
        }
        catch (Exception e) {

        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы кнопки Очистить из меню кнопки добавления записей к сравнению")
    public void dedublicationTestClearButton() {
        nres.findNonResidenceByDate(CLIENT_NAME);
        dedub.addToSimile(nres.nonresidenceEntity, nres.nonresidenceEntityDedub);
        dedub.clearSimileInFunctionMenu();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы кнопки Сравнить из меню кнопки добавления записей к сравнению")
    public void dedublicationTestSimileFunctionButton() {
        nres.findNonResidenceByDate(CLIENT_NAME);
        dedub.addToSimile(nres.nonresidenceEntity, nres.nonresidenceEntityDedub);
        dedub.simileInFunctionMenu();
        dedub.closeSimileWindow();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы кнопки Не дубликаты")
    public void dedublicationTestNotASimile() {
        nres.findNonResidenceByDate(CLIENT_NAME);
        dedub.addToSimile(nres.nonresidenceEntity, nres.nonresidenceEntityDedub);
        dedub.simileByButton();
        dedub.notASimile();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка корректного отображения полей окна Сравнение записей")
    public void dedublicationTestCheckFields() {
        rest.createOperClient(rest.createPDClient(rest.findClient()));
        nres.findNonResidenceByDate(CLIENT_NAME);
        dedub.addToSimile(nres.nonresidenceEntity, nres.nonresidenceEntityDedub);
        dedub.simileByButton();
        dedub.checkFields();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка слияния записей двух нерезидентов")
    public void dedublicationTestMerge() {
        rest.createOperClient(rest.createPDClient(rest.findClient()));
        nres.findNonResidenceByDate(CLIENT_NAME);
        dedub.addToSimile(nres.nonresidenceEntity, nres.nonresidenceEntityDedub);
        dedub.simileByButton();
        dedub.chooseNote2();
        dedub.mergeEntities();
    }
}
