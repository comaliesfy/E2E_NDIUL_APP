package ru.stqa.ptf.tests.testsUNP.PrimaryDocs;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import static Configs.ClientConfigs.CLIENT_DOCTYPE;
import static Configs.ClientConfigs.CONTRACTOR_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Первичные документы контрагента")
public class PrimaryDocContractorSFTests extends TestBase {

    PrimaryDocSF pdSF = new PrimaryDocSF();
    REST rest = new REST();

    @Before
    public void start() {
        pdSF.goToPDContractorForm();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Подразделение")
    public void checkOsbFilterFields() {
        pdSF.checkOsbFilterFields();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Страна")
    public void checkCountryFilterFields() {
        pdSF.checkCountryFilterFields();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Нерезидент")
    public void checkClientNameFilterFields() {
        pdSF.checkContractorNameFilterFields();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Номер ПД")
    public void checkPDNumFilterFields() {
        pdSF.checkPDNumFilterFields();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Тип документа")
    public void checkDocTypeFilterFields() {
        pdSF.checkDocTypeFilterFields(CLIENT_DOCTYPE);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Статус")
    public void checkStatusPDFilterFields() {
        pdSF.checkStatusPDFilterFields();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка очистки фильтров")
    public void checkContractorFiltersReset() {
        pdSF.checkPDFiltersAreClear();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы полей фильтров-дат")
    public void checkContractorFiltersDatePickers() {
        rest.createClient();
        rest.createPDContract(rest.findClient());
        pdSF.checkFilterFieldDatePicker(CONTRACTOR_NUMBER);
        rest.deleteClient(rest.findClient());
    }
}
