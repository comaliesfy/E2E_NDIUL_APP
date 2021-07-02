package ru.stqa.ptf.tests.testsUNP.Representation;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.RepresentationOper;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Списковая форма Доходы представительств")
public class IncomeFdeptSFTest extends TestBase {

    RepresentationOper fDept = new RepresentationOper();

    @Before
    public void start() {
        fDept.goToFdeptIncome();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы фильтра Наименование Представительства")
    public void checkNameFDeptFilter() {
        fDept.checkNameFDeptFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы фильтра Страна")
    public void checkCountryFDeptFilter() {
        fDept.checkCountryFDeptFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы фильтра Дата дохода")
    public void checkDatePickers() {
        fDept.checkDatePickers();
    }

}
