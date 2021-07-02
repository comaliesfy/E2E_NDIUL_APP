package ru.stqa.ptf.tests.testsUNP.Operation;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.api.RESTPrimaryDocs;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.operations.OperationsSF;

import static Configs.ClientConfigs.CLIENTSUMMA;
import static Configs.ClientConfigs.DEPO_SUMM;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Операции - детальные формы")
public class OperationsDFTests extends TestBase {

    OperationsDF opDF = new OperationsDF();
    OperationsSF opSF = new OperationsSF();
    REST rest = new REST();
    RESTPrimaryDocs restpd = new RESTPrimaryDocs();

    @Before
    public void createDATA() {
        rest.createClient();
    }

    @After
    public void deleteDATA() {
        rest.deleteClient(rest.findClient());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции клиента")
    public void createOperClient() {
        rest.createPDClient(rest.findClient());
        opDF.createClientOper();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции контрагента")
    public void createOperCon() {
        rest.createPDContract(rest.findClient());
        opDF.createContractorOper();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции депозитария")
    public void createOperDepo() {
        rest.createPDDepository(rest.findClient());
        opDF.createDepoOper();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции клиента со ставкой 0%")
    public void createOperClientZeroRate() {
        restpd.createPDClientZero(rest.findClient());
        opDF.goToOperClientForm();
        opDF.addOperation();
        opDF.getPDForOper();
        opDF.fillIncomeInfo(CLIENTSUMMA);
        opDF.assertTaxFieldForZeroRate();
        opDF.saveOper();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции депозитария со ставкой 0%")
    public void createOperDepoZeroRate() {
        restpd.createPDDepoZero(rest.findClient());
        opDF.goToOperDepositoryForm();
        opDF.addOperation();
        opDF.getPDForOper();
        opDF.fillCurrency();
        opDF.fillIncomeInfo(DEPO_SUMM);
        opDF.assertTaxFieldForZeroRate();
        opDF.saveOper();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание операции депозитария со ставкой 13%")
    //@Stories("Проверка работы показателей Д1,Д2")
    public void createOperDepoThirteenRate() {
        restpd.createPDDepoThirteenRate(rest.findClient());
        opDF.goToOperDepositoryForm();
        opDF.addOperation();
        opDF.getPDForOper();
        opDF.fillIncomeInfo(DEPO_SUMM);
        opDF.fillTaxDate();
        opDF.d1d2AssertTaxFields();
        opDF.saveOper();
    }
}
