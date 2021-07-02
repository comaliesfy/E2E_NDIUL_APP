package ru.stqa.ptf.tests.testsUNP.Operation;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.operations.OperationsSF;

import static Configs.ClientConfigs.CLIENT_NUMBER;
import static Configs.ConfigsForSearchForm.PD_CLIENT_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Операции клиента")
public class OperationSFClientTest extends TestBase {
    OperationsDF opDF = new OperationsDF();
    OperationsSF opSF = new OperationsSF();
    REST rest = new REST();

    @Before
    public void before() {
        opDF.goToOperClientForm();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Подразделение")
    public void checkFilterOSBClient() {
        opSF.checkFilterFieldOSB();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Нерезидент")
    public void checkFilterClient() {
        opSF.checkFilterFieldClient();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Номер ПД")
    public void checkFilterPDNumber() {
        opSF.checkFilterFieldPDNum(PD_CLIENT_NUMBER, (char) 34);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Вид дохода")
    public void checkFilterIncomeCode() {
        opSF.checkFilterFieldIncomeCode(6);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтров Номер сообщения и дата сообщения")
    public void checkFilterMessage() {
        opSF.checkFilterFieldMessage();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Ставка не равна")
    public void checkFilterRate() {
        opSF.checkFilterFieldRate();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Пользователь")
    public void checkFilterUser() {
        opSF.checkFilterFieldUser(15);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтров-дат")
    public void checkDatePickers() {
        rest.createOperClient(rest.createPDClient(rest.createClient()));
        opSF.checkFilterFieldDatePicker(CLIENT_NUMBER);
        rest.deleteClient(rest.findClient());
    }
}
