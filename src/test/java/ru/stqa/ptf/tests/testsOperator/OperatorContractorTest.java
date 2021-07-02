package ru.stqa.ptf.tests.testsOperator;

import Configs.UserConfigRoles;
import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.login.LoginPage;
import ru.stqa.ptf.pages.operationDownloads.DownloadForm;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocDF;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import java.io.IOException;

import static Configs.ClientConfigs.*;
import static Configs.UserConfigRoles.USR_UNP;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

@Epic("Роль-Оператор контрагентов")
@Feature("Смок оператор контрагент")
public class OperatorContractorTest extends TestBase {

    OperationsDF opDF = new OperationsDF();
    PrimaryDocDF pdDF = new PrimaryDocDF();
    PrimaryDocSF pdSF = new PrimaryDocSF();
    DownloadForm df = new DownloadForm();
    static LoginPage log = new LoginPage();
    static REST rest = new REST();

    @BeforeClass
    public static void start() {
        goToLoginPage();
        log.login(UserConfigRoles.USR_NAME_OP_CONTR);
        rest.createClient();
    }

    @AfterClass
    public static void deleteData() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором ПД и подтвреждение")
    public void createPDContractorByOperator() {
        pdSF.goToPDContractorForm();
        pdDF.addPD();
        pdDF.fillNonresidenceInfo();
        pdDF.fillPDInfo(CONTRACTOR_NUMBER);
        pdDF.addIncomeContractor(CONTRACTOR_INCOMEKIND);
        pdDF.saveUnicPD();
        goToLoginPage();
        log.login(USR_UNP);
        pdSF.goToPDContractorForm();
        pdSF.findPrimaryDoc(CONTRACTOR_NUMBER);
        pdSF.assertPDStatusPreview(PD_STATUS_ACTIVE, "");
        pdSF.deletePD();
    }

    @Ignore
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором операции")
    public void createOperContractorByOperator() {
        rest.createClient();
        rest.createPDContract(rest.findClient());
        opDF.createContractorOper();
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций контрагентов, удаление")
    public void downloadContractorOper() throws IOException {
        rest.createPDContract(rest.findClient());
        df.openContractorDownloadForm();
        df.uploadFileContractor();
        df.findFileCont();
        df.deleteUploadFile();
    }

}
