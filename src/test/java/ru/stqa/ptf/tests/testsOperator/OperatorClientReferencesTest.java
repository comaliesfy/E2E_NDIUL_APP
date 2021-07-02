package ru.stqa.ptf.tests.testsOperator;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.certificates.Certificates;
import ru.stqa.ptf.pages.login.LoginPage;
import ru.stqa.ptf.pages.references.Issuer;
import ru.stqa.ptf.pages.references.NaturalPerson;

import static Configs.UserConfigRoles.USR_NAME_OP_CLIENT;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

@Epic("Роль-Оператор клиент")
@Feature("Раздел Справочники")
public class OperatorClientReferencesTest extends TestBase {

    NaturalPerson np = new NaturalPerson();
    Certificates certs = new Certificates();
    Issuer iss = new Issuer();
    LoginPage log = new LoginPage();

    @Before
    public void start() {
        goToLoginPage();
        log.login(USR_NAME_OP_CLIENT);
    }

    @Ignore
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

    @Ignore
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

    @Ignore
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, поиск и удаление записи справочника Эмитенты Страна!=Россия")
    public void issuerTest() {
        iss.createIssuerNonRus();
        iss.findIssuerNonRus();
        iss.deleteIssuerNonRus();
    }

    @Ignore
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Справочник Эмитенты - проверка валидации полей, если Страна = РОССИЯ")
    public void issuerTestRus() {
        iss.createIssuerRus();
    }


}
