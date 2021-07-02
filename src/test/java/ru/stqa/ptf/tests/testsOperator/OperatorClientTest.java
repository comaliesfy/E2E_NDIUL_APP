package ru.stqa.ptf.tests.testsOperator;

import Configs.ClientConfigs;
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

import static Configs.ClientConfigs.CLIENT_NUMBER;
import static Configs.UserConfigRoles.USR_NAME_OP_CLIENT;
import static Configs.UserConfigRoles.USR_UNP;
import static ru.stqa.ptf.pages.login.LoginPage.goToLoginPage;

@Epic("Роль-Оператор клиент")
@Feature("Смок оператор клиент")
public class OperatorClientTest extends TestBase {


    PrimaryDocDF pdDF = new PrimaryDocDF();
    PrimaryDocSF pdSF = new PrimaryDocSF();
    OperationsDF opDF = new OperationsDF();
    DownloadForm df = new DownloadForm();
    static REST rest = new REST();

    static LoginPage log = new LoginPage();

    @BeforeClass
    public static void start() {
        goToLoginPage();
        log.login(USR_NAME_OP_CLIENT);
        rest.createClient();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором ПД и подтвреждение")
    public void createPDClientByOperator() {
        pdSF.goToPDClientForm();
        pdDF.addPD();
        pdDF.fillNonresidenceInfo();
        pdDF.fillPDInfo(CLIENT_NUMBER);
        pdDF.addIncomeTypeOperator(ClientConfigs.CLIENT_INCOMEKIND);
        pdDF.saveUnicPD();
        goToLoginPage();
        log.login(USR_UNP);
        pdSF.goToPDClientForm();
        pdSF.findPrimaryDoc(CLIENT_NUMBER);
        pdSF.assertPDStatusPreview("Обновленный", "invalid");
        pdSF.openDetailFormPD();
        pdDF.approveIncomeKind();
        pdDF.saveUnicPD();
        pdSF.assertPDStatusPreview(ClientConfigs.PD_STATUS_ACTIVE, "");
        pdSF.deletePD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором операции")
    public void createOperClientByOperator() {
        rest.createPDClient(rest.findClient());
        opDF.createClientOper();
    }

    @Ignore
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций клиентов, удаление")
    public void downloadClientOper() throws IOException {
        rest.createPDClient(rest.findClient());
        df.openClientDownloadForm();
        df.uploadFileClient();
        df.findFileClient();
        df.deleteUploadFile();
    }

    @AfterClass
    public static void deleteData() {
        rest.deleteClient(rest.findClient());
    }
}
