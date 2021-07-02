package ru.stqa.ptf.tests.testsUNP.Downloads;

import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operationDownloads.DownloadForm;

import java.io.IOException;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Загрузка операций")
public class DownloadsOperTests extends TestBase {
    DownloadForm df = new DownloadForm();
    static REST rest = new REST();

    @BeforeClass
    public static void start() {
        rest.createClient();
        rest.createPDClient(rest.findClient());
        rest.createPDContract(rest.findClient());
        rest.createPDDepositoryCon(rest.findClient());
    }

    @AfterClass
    public static void deleteDATA() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций клиентов, удаление")
    public void downloadClientOper() throws IOException {
        df.openClientDownloadForm();
        df.uploadFileClient();
        df.findFileClient();
        df.deleteUploadFile();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций контрагентов, удаление")
    public void downloadContractorOper() throws IOException {
        df.openContractorDownloadForm();
        df.uploadFileContractor();
        df.findFileCont();
        df.deleteUploadFile();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Загрузка файла операций депозитария, удаление")
    public void downloadDepositoryOper() throws IOException {
        df.openDepositoryDownloadForm();
        df.uploadFileDepository();
        df.findFileDepo();
        df.deleteUploadFile();
    }
}
