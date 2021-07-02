package ru.stqa.ptf.tests.testsUNP;

import io.qameta.allure.*;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.certificates.Certificates;
import ru.stqa.ptf.pages.references.*;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Справочники")
public class ReferenceBooksTests extends TestBase {

    Currency cur = new Currency();
    IncomeKind inc = new IncomeKind();
    ActivityType at = new ActivityType();
    Tax tax = new Tax();
    DocumentsTypes dt = new DocumentsTypes();
    Expenses exp = new Expenses();
    PrefRates pfr = new PrefRates();
    TaxPrivilegies taxp = new TaxPrivilegies();
    Onl onl = new Onl();
    NaturalPerson np = new NaturalPerson();
    Certificates certs = new Certificates();
    Issuer iss = new Issuer();
    DepartmentSB dpt = new DepartmentSB();
    ReportPeriods rp = new ReportPeriods();
    Country cnt = new Country();
    DefaultRates dftr = new DefaultRates();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Валюты")
    public void currencyRefTest() {
        cur.currencyBookCreate();
        cur.currencyBookFilter();
        cur.currencyBookDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Виды дохода")
    public void incomeKindRefTest() {
        inc.incomeKindCreate();
        inc.incomeKindFilter();
        inc.incomeKindDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Виды деятельности")
    public void activityTypesTest() {
        at.activityTypeCreate();
        at.activityTypeFilterDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Вид налогов")
    public void taxRefTest() {
        tax.taxCreate();
        tax.taxFilter();
        tax.deleteTax();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Типы документов")
    public void docTypesRefTest() {
        dt.docTypesCreate();
        dt.docTypesDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Виды расходов")
    public void expenseRefTest() {
        exp.expenseCreate();
        exp.expenseFilter();
    }

    @Test // изменить тест
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Льготные ставки")
    public void prefRateRefTest() {
        pfr.prefRateCreate();
        pfr.prefRateFilter();
        pfr.prefRateDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Налоговые льготы")
    public void taxPrivilegesRefTest() {
        taxp.taxPrivilegesCreate();
        taxp.taxPrivilegesFilter();
        taxp.taxPrivilegesDelete();
    }

    @Test //добавить связть между ОНЛ и льготной ставкой.
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Основания для налоговых льгот")
    public void OnlRefTest() {
        onl.OnlCreate();
        onl.OnlFilter();
        onl.OnlDelete();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Физические лица")
    public void NaturalPersonRefTest() {
        np.addNaturalPersonFillForm();
        np.saveNP();
        np.naturalPersonFilter();
        np.naturalPersonDelete();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Справочник Физические лица- проверка валидации полей")
    public void NaturalPersonCheckValidationDF() {
        np.naturalPersonFieldValidation();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Справочник Физические лица- проверка валидации поля ИНН")
    public void NaturalPersonCheckValidationINN() {
        np.naturalPersonFieldValidationINN();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Справочник Физические лица- создание.валидация и удаление сертификата")
    public void NaturalPersonCheckCertificate() {
        np.openNaturalPersonRef();
        np.addButton();
        certs.createCertificate();
        certs.checkMessageSameName();
        certs.checkMessageSameDate();
        certs.checkMessageWrongDate();
        certs.checkCertOnFormNP();
        certs.deleteCertificate();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Эмитенты Страна!=Россия")
    public void issuerTest() {
        iss.createIssuerNonRus();
        iss.findIssuerNonRus();
        iss.deleteIssuerNonRus();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Справочник Эмитенты - проверка валидации полей, если Страна = РОССИЯ")
    public void issuerTestRus() {
        iss.createIssuerRus();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка работы фильтров справочника Отделения СБ")
    public void departmentRef() {
        dpt.goToReferencePage();
        dpt.findDepartmentEntity();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Отчетные периоды")
    public void createPeriod() {
        rp.goToReferenceBook();
        rp.createPeriod();
        rp.findPeriod();
        rp.deletePeriod();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Справочник Отчетные периоды- проверка смены статусов")
    public void checkStatusPeriod() {
        rp.goToReferenceBook();
        rp.createPeriod();
        rp.findPeriod();
        rp.changeStatusToCloseOpen();
        rp.findPeriod();
        rp.changeStatusToCorrection();
        rp.deletePeriod();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Страны")
    public void countryCreateDelete() {
        cnt.goToCountry();
        cnt.createCountry();
        cnt.deleteCountry();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Общестрановые льготы")
    public void defaultRateRef() {
        dftr.goToDefRateRef();
        dftr.createDefRate();
        dftr.deleteDefRate();
    }
}
