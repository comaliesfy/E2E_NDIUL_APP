package ru.stqa.ptf.tests.testsUNP.Declaration;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.declaration.DeclarationSF;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Декларации - Списковая форма")
public class DeclarationSFTests extends TestBase {

    DeclarationSF declSF = new DeclarationSF();

    @Before
    public void goToSection() {
        declSF.goToDeclarationForm();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Год")
    public void checkYearFilter() {
        declSF.checkYearFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Отчётный период")
    public void checkPeriodFilter() {
        declSF.checkPeriodFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Статус ЭД")
    public void checkEDStatusFilter() {
        declSF.checkEDStatusFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Вид декларации")
    public void checkDeclTypeFilter() {
        declSF.checkDeclTypeFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка фильтра Статус")
    public void checkStatusFilter() {
        declSF.checkStatusFilter();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка форма добавления декларации")
    public void checkCreateForm() {
        declSF.assertCreateFormDecl();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка что фильтры очищены по кнопке Сброс")
    public void checkFiltersReset() {
        declSF.checkDeclFiltersAreClear();
    }

}
