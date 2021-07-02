package ru.stqa.ptf.tests.testsUNP.Operation;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.operations.OperationsSF;

import static Configs.ClientConfigs.DEPO_NUMBER;
import static Configs.ConfigsForSearchForm.PD_DEPO_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Операции депозитария")
public class OperationSFDepoTest extends TestBase {
    OperationsDF opDF = new OperationsDF();
    OperationsSF opSF = new OperationsSF();
    REST rest = new REST();

    @Before
    public void before() {
        opDF.goToOperDepositoryForm();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Депозитарий")
    public void checkFiltersDepo() {
        opSF.checkFilterFieldDepo();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Эмитент")
    public void checkFiltersIssuer() {
        opSF.checkFilterFieldIssuer();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтров номер сообщения и дата сообщения")
    public void checkFiltersMessage() {
        opSF.checkFilterFieldMessage();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Номер ПД")
    public void checkFiltersPDNum() {
        opSF.checkFilterFieldPDNum(PD_DEPO_NUMBER, (char) 30);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Страна Выплаты")
    public void checkFiltersCountryPay() {
        opSF.checkFilterFieldCountryPay();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Страна депонента")
    public void checkFiltersCountryDepo() {
        opSF.checkFilterFieldCountryDepo();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Код дохода")
    public void checkFiltersIncomeCode() {
        opSF.checkFilterFieldIncomeCode(5);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Пользователь")
    public void checkFiltersUser() {
        opSF.checkFilterFieldUser(18);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтров-дат")
    public void checkFiltersDatePicker() {
        rest.createOperDepo(rest.createPDDepository(rest.createClient()));
        opSF.checkFilterFieldDatePicker(DEPO_NUMBER);
        rest.deleteClient(rest.findClient());
    }

    @Test
    public void vv(){
        rest.createClient();
    }
}
