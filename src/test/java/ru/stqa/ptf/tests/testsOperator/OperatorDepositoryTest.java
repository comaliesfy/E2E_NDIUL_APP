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

@Epic("Роль-Оператор депозитария")
@Feature("Смок оператор депозитария")
public class OperatorDepositoryTest extends TestBase {


    PrimaryDocDF pdDF = new PrimaryDocDF();
    PrimaryDocSF pdSF = new PrimaryDocSF();
    OperationsDF opDF = new OperationsDF();
    DownloadForm df = new DownloadForm();
    static REST rest = new REST();
    static LoginPage log = new LoginPage();

    @BeforeClass
    public static void start() {
        goToLoginPage();
        log.login(UserConfigRoles.USR_NAME_OP_DEPO);
        rest.createClient();
    }
    @AfterClass
    public static void deleteData() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором ПД и подтвреждение")
    public void createPDDepoByOperator() {
        pdSF.goToPDDepositoryForm();
        pdDF.addPDDepository();
        pdDF.fillNonresidenceInfo();
        pdDF.fillDepositoryPDInfo(DEPO_NUMBER);
        pdDF.addIncomeTypeOperator(DEPO_INCOMEKIND);
        pdDF.saveUnicPD();
        goToLoginPage();
        log.login(USR_UNP);
        pdSF.goToPDDepositoryForm();
        pdSF.findPrimaryDoc(DEPO_NUMBER);
        pdSF.assertPDStatusPreview("Обновленный", "invalid");
        pdSF.openDetailFormPD();
        pdDF.approveIncomeKind();
        pdDF.saveUnicPD();
        pdSF.assertPDStatusPreview(PD_STATUS_ACTIVE, "");
        pdSF.deletePD();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание оператором операции")
    public void createOperClientByOperator() {
        rest.createClient();
        rest.createPDDepository(rest.findClient());
        opDF.createDepoOper();
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций депозитария, удаление")
    public void downloadDepositoryOper() throws IOException {
        rest.createPDDepositoryCon(rest.findClient());
        df.openDepositoryDownloadForm();
        df.uploadFileDepository();
        df.findFileDepo();
        df.deleteUploadFile();
    }

}
