package ru.stqa.ptf.tests.testsUNP.PrimaryDocs;

import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocDF;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import static Configs.ClientConfigs.*;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Первичные документы -Детальные формы")
public class PrimaryDocDFTests extends TestBase {
    PrimaryDocSF pdSF = new PrimaryDocSF();
    PrimaryDocDF pdDF = new PrimaryDocDF();
    static REST rest = new REST();

    @BeforeClass
    public static void createDATA() {
        rest.createClient();
    }

    @AfterClass
    public static void deleteDATA() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание ПД клиента")
    public void createPDClient() {
        pdSF.goToPDClientForm();
        pdDF.addPD();
        pdDF.fillNonresidenceInfo();
        pdDF.fillPDInfo(CLIENT_NUMBER);
        pdDF.addIncomeType(CLIENT_RATE, CLIENT_INCOMEKIND);
        pdDF.acceptIncomeType();
        pdDF.saveUnicPD();
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание ПД контрагента")
    public void createPDContractor() {
        pdSF.goToPDContractorForm();
        pdDF.addPD();
        pdDF.fillNonresidenceInfo();
        pdDF.fillPDInfo(CONTRACTOR_NUMBER);
        pdDF.addIncomeContractor(CONTRACTOR_INCOMEKIND);
        pdDF.saveIncomeType();
        pdDF.saveUnicPD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание ПД депозитария")
    public void createPDDepo() {
        pdSF.goToPDDepositoryForm();
        pdDF.addPDDepository();
        pdDF.fillNonresidenceInfo();
        pdDF.fillDepositoryPDInfo(DEPO_NUMBER);
        pdDF.addIncomeType(DEPO_RATE, DEPO_INCOMEKIND);
        pdDF.acceptIncomeType();
        pdDF.saveUnicPD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание ПД депоизтария с типом Договор депозитария")
    public void createPDDepoCon() {
        pdSF.goToPDDepositoryForm();
        pdDF.createPrimaryDocDepositoryCon();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка возможности удаления сущности Вид дохода при создании ПД")
    public void deleteIncomeKind() {
        pdSF.goToPDClientForm();
        pdDF.addPD();
        pdDF.fillNonresidenceInfo();
        pdDF.fillPDInfo(CONTRACTOR_NUMBER);
        pdDF.addIncomeType(CONTRACTOR_Rate, CLIENT_INCOMEKIND);
        pdDF.acceptIncomeType();
        pdDF.deleteIncomeType();
    }

    @Test
    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление ПД клиента")
    public void deletePDClient() {
        rest.createPDClient(rest.findClient());
        pdSF.goToPDClientForm();
        pdSF.findPrimaryDoc(CLIENT_NUMBER);
        pdSF.deletePD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление ПД контрагента")
    public void deletePDContractor() {
        rest.createPDContract(rest.findClient());
        pdSF.goToPDContractorForm();
        pdSF.findPrimaryDoc(CONTRACTOR_NUMBER);
        pdSF.deletePD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление ПД депозитария")
    public void deletePDDepo() {
        rest.createPDDepository(rest.findClient());
        pdSF.goToPDDepositoryForm();
        pdSF.findPrimaryDoc(DEPO_NUMBER);
        pdSF.deletePD();
    }


}
