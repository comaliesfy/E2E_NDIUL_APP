package ru.stqa.ptf.tests.testsUNP.Operation;

import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.operations.OperationsSF;

import static Configs.ClientConfigs.*;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Операции - детальные формы")
public class OperationDeleteTest extends TestBase {

    static REST rest = new REST();
    OperationsDF opDF = new OperationsDF();
    OperationsSF opSF = new OperationsSF();

    @BeforeClass
    public static void createDATA() {
        rest.createClient();
        rest.createOperClient(rest.createPDClient(rest.findClient()));
        rest.createOperContractor(rest.createPDContract(rest.findClient()));
        rest.createOperDepo(rest.createPDDepository(rest.findClient()));
    }

    @AfterClass
    public static void deleteDATA() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление операции клиента")
    public void deleteOperClient() {
        opDF.goToOperClientForm();
        opSF.findOperation(CLIENT_NUMBER);
        opSF.deleteOperation();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление операции контрагента")
    public void deleteOperContract() {
        opDF.goToOperContractorForm();
        opSF.findOperation(CONTRACTOR_NUMBER);
        opSF.deleteOperation();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление операции депозитария")
    public void deleteOperDepo() {
        opDF.goToOperDepositoryForm();
        opSF.findOperation(DEPO_NUMBER);
        opSF.deleteOperation();
    }


}
