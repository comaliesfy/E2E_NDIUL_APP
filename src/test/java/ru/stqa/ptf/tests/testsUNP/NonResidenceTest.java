package ru.stqa.ptf.tests.testsUNP;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.certificates.Certificates;
import ru.stqa.ptf.pages.references.Nonresidence;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Справочник Нерезиденты-Детальные формы")
public class NonResidenceTest extends TestBase {
    Nonresidence nres = new Nonresidence();
    Certificates certs = new Certificates();
    REST rest = new REST();

    @Before
    public void beforeTest() {
        nres.openNonResidenceSection();
    }

    @After
    public void deleteDate() {
        try {
            rest.deleteClient(rest.findClient());
        }
        catch (Exception e) {

        }
    }

    //Детальная форма
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка валидации при создании нерезидента с типом Банк-Bank.Alm.")
    public void checkValidationForBank() {
        nres.addNonResidence();
        nres.assertFieldValidationBankAlm();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка валидации при создании нерезидента с типом Организация (РОССИЯ)")
    public void checkValidationForRus() {
        nres.addNonResidence();
        nres.assertFieldValidationCountryRus();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка, что в поле Тип нерезидента отображается заведенное значение - Организация")
    public void checkFillTypeFieldOrg() {
        nres.createNonresidence(nres.nonresTypeOrg);
        nres.findNonResidence();
        nres.openNonResidenceEntity();
        nres.assertFillFieldType("Организация");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка, что в поле Тип нерезидента отображается заведенное значение - Банк")
    public void checkFillTypeFieldBank() {
        nres.createNonresidence(nres.nonresTypeBank);
        nres.findNonResidence();
        nres.openNonResidenceEntity();
        nres.assertFillFieldType("Банк");
    }


    @Test // проверка работы сертификатов
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание и удаление сертификата нерезидента. Проверка сообщений")
    public void checkCertificateNonResidence() {
        nres.addNonResidence();
        certs.createCertificate();
        certs.checkMessageSameName();
        certs.checkMessageSameDate();
        certs.checkMessageWrongDate();
        certs.checkCertOnFormNonres();
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление Нерезидента")
    public void deleteNonResidence() {
        rest.createClient();
        nres.findNonResidence();
        nres.deleteNonResidence();
    }

}