package ru.stqa.ptf.tests.testsUNP.PrimaryDocs;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import static Configs.ClientConfigs.CLIENT_DOCTYPE;
import static Configs.ClientConfigs.CLIENT_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Первичные документы клиентов")
public class PrimaryDocClientSFTests extends TestBase {

    PrimaryDocSF pdSF = new PrimaryDocSF();
    REST rest = new REST();

    @Before
    public void start() {
        pdSF.goToPDClientForm();
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
        pdSF.checkClientNameFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Номер ПД")
    public void checkPDNumFilterFields() {
        pdSF.checkPDNumFilterFields();
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Тип документа")
    public void checkDocTypeFilterFields() {
        pdSF.checkDocTypeFilterFields(CLIENT_DOCTYPE);
    }

    @Test // проверка работы полей инпутов фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтра Статус")
    public void checkStatusPDFilterFields() {
        pdSF.checkStatusPDFilterFields();
    }

    @Test// проверка работы кнопки "Сброс" фильтров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка очистки фильтров")
    public void checkClientFiltersReset() {
        pdSF.checkPDFiltersAreClear();
    }


    @Test//проверка работы дейтпикеров ПД клиента
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы полей фильтров-дат")
    public void checkClientFiltersDatePickers() {
        rest.createClient();
        rest.createPDClient(rest.findClient());
        pdSF.checkFilterFieldDatePicker(CLIENT_NUMBER);
        rest.deleteClient(rest.findClient());
    }

}
