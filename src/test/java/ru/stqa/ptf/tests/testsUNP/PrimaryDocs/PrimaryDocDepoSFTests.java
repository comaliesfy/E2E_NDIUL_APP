package ru.stqa.ptf.tests.testsUNP.PrimaryDocs;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import static Configs.ClientConfigs.*;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Первичные документы депозитария")
public class PrimaryDocDepoSFTests extends TestBase {

    PrimaryDocSF pdSF = new PrimaryDocSF();
    REST rest = new REST();

    @Before
    public void start() {
        pdSF.goToPDDepositoryForm();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Подразделение")
    public void checkOsbFilterFields() {
        pdSF.checkOsbFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Страна")
    public void checkCountryFilterFields() {
        pdSF.checkCountryFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Нерезидент")
    public void checkClientNameFilterFields() {
        pdSF.checkContractorNameFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Номер ПД")
    public void checkPDNumFilterFields() {
        pdSF.checkPDNumFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Тип документа-Договор")
    public void checkDocTypeFilterFields() {
        pdSF.checkDocTypeDepoFilterFields(DEPO_DOCTYPE);
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Тип документа-Договор Депо")
    public void checkDocTypeDepoFilterFields() {
        pdSF.checkDocTypeDepoFilterFields(DEPO_DOCTYPE01);
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Статус")
    public void checkStatusPDFilterFields() {
        pdSF.checkStatusPDFilterFields();
    }

    @Test// проверка работы кнопки "Сброс" фильтров ПД депозитария
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка очистки фильтров")
    public void checkDepoFiltersReset() {
        pdSF.checkPDFiltersAreClear();
    }

    @Test//проверка работы дейтпикеров ПД депозитария
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы полей фильтров-дат")
    public void checkDepoFiltersDatePickers() {
        rest.createClient();
        rest.createPDDepository(rest.findClient());
        pdSF.checkFilterFieldDatePicker(DEPO_NUMBER);
        rest.deleteClient(rest.findClient());
    }

}
