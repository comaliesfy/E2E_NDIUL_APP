package ru.stqa.ptf.tests.testsUNP;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.references.Nonresidence;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Справочник Нерезиденты-Списковые формы")
public class NonResidenceSF extends TestBase {
    Nonresidence nres = new Nonresidence();
    REST rest = new REST();

    @Before
    public void beforeTest() {
        nres.openNonResidenceSection();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Страна")
    public void checkCountryFilter() {
        nres.checkCountryFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Наименование")
    public void checkNameFilter() {
        nres.checkNameFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Тип нерезидента")
    public void checkNonresTypeFilter() {
        nres.checkNonresTypeFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Активность")
    public void checkActiveFilter() {
        nres.checkActiveFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Представительство")
    public void checkRepresentationFilter() {
        nres.checkRepresentationFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Подтверждение местонахождения")
    public void checkLocationSelectFilter() {
        nres.checkLocationSelectFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Подтвреждение налоговых льгот")
    public void checkTaxPrivilegiesSelectFilter() {
        nres.checkTaxPrivilegiesSelectFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра Подтверждение инф. источниками")
    public void checkInfSourceSelectFilter() {
        nres.checkInfSourceSelectFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра ИНН")
    public void checkINNFilter() {
        nres.checkINNFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтра SWIFT")
    public void checkSWIFTFilter() {
        nres.checkSWIFTFilter();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтров-дат")
    public void checkDatePickers() {
        rest.createClient();
        nres.checkFilterFieldDatePicker();
        rest.deleteClient(rest.findClient());
    }

}
