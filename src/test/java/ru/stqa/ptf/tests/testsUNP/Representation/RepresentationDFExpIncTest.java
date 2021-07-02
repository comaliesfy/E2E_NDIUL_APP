package ru.stqa.ptf.tests.testsUNP.Representation;

import io.qameta.allure.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operations.RepresentationOper;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Детальные формы Доходы/Расходы представительств")
public class RepresentationDFExpIncTest extends TestBase {
    static REST rest = new REST();
    RepresentationOper fDept = new RepresentationOper();

    @BeforeClass
    public static void createData() {
        rest.createRepresentation();
    }

    @AfterClass
    public static void deleteData() {
        rest.deleteRepresentation(rest.findRepresentation());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание и удаление дохода представительств")
    public void createFdeptIncomeAndDelete() {
        fDept.goToFdeptIncome();
        fDept.addEntity();
        fDept.fillFDeptIncomeForm();
        fDept.saveFDept();
        fDept.findFDept();
        fDept.deleteFDept();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание и удаление расхода представительств")
    public void createFdeptExpenseAndDelete() {
        fDept.goToFdeptExpense();
        fDept.addEntity();
        fDept.fillFDeptExpenseForm();
        fDept.saveFDept();
        fDept.findFDept();
        fDept.deleteFDept();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка корректности отображения полей ДФ Расходы представительства")
    public void fillAndCheckFDeptExpenseForm() {
        fDept.goToFdeptExpense();
        fDept.addEntity();
        fDept.fillAndCheckFDeptExpenseForm();
    }

}
