package ru.stqa.ptf.tests.testsUNP.Operation;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.OperationsDF;
import ru.stqa.ptf.pages.operations.OperationsSF;

import static Configs.ClientConfigs.CONTRACTOR_NUMBER;
import static Configs.ConfigsForSearchForm.PD_CONT_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Операции контрагента")
public class OperationSFContractorTest extends TestBase {

    OperationsDF opDF = new OperationsDF();
    OperationsSF opSF = new OperationsSF();
    REST rest = new REST();

    @Before
    public void before() {
        opDF.goToOperContractorForm();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Подразделение")
    public void checkFiltersOSB() {
        opSF.checkFilterFieldOSB(); //WTF
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Нерезидент")
    public void checkFiltersContractor() {
        opSF.checkFilterFieldContractor(); //WTF
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Номер ПД")
    public void checkFiltersPDNum() {
        opSF.checkFilterFieldPDNum(PD_CONT_NUMBER, (char) 2);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Код дохода")
    public void checkFiltersIncomeCode() {
        opSF.checkFilterFieldIncomeCodeContr();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Пользователь")
    public void checkFiltersUser() {
        opSF.checkFilterFieldUser(15);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтров-дат")
    public void checkFiltersDatePickers() {
        rest.createOperContractor(rest.createPDContract(rest.createClient()));
        opSF.checkFilterFieldDatePicker(CONTRACTOR_NUMBER);
        rest.deleteClient(rest.findClient());
    }


}
