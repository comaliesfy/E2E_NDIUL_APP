package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class Expenses {
    private final SelenideElement sectionExpenses = $x("//a[@id='directory/expenses']");
    private final SelenideElement assertSF = $x("//h4[contains(text(),'Виды расходов')]");
    private final SelenideElement nameExpensesFilter = $x("//input[@placeholder='Введите вид расхода']");
    private final SelenideElement name = $("#"+EXPENSE_SHORT_NAME);
    private final SelenideElement codeExpensesFilter = $x("//input[@placeholder='Введите код расхода']");
    private final SelenideElement code = $x("//div[@id='" + EXPENSE_CODE + "']");
    private final SelenideElement analiticCodeFilter = $x("//input[@placeholder='Введите код группы']");
    private final SelenideElement analiticCode = $x("//div[@id='" + EXPENSE_ANALITYCS_CODE + "']");
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");
    private final SelenideElement addButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement assertExpense = $x("//td[@id='/" + EXPENSE_NAME + "']");
    private final SelenideElement fullNameInput = $x("//input[@id='fullName-input-id']");
    private final SelenideElement shortNameInput = $x("//input[@id='shortName-input-id']");
    private final SelenideElement expCodeInput = $x("//input[@id='expCode-input-id']");
    private final SelenideElement expenseAnalyticalCodeSelect = $x(" //autocomplete-dropdown[@id='expenseAnalyticalCodeSelect-dropdown-id']//span[@id='dropdown-list']");
    private final SelenideElement expenseAnalyticalCode = $x("//div[@id='" + EXPENSE_ANALITYCS_CODE + "']");
    private final SelenideElement exSymbolIput = $x("//input[@id='expSymbol-input-id']");

    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    private void analyticalCodeSelect() {
        expenseAnalyticalCodeSelect.click();
        expenseAnalyticalCode.click();
    }

    private void expensesNameFilter() {
        GridHelpers.sendCharKeys(EXPENSE_SHORT_NAME, nameExpensesFilter, name);
    }

    private void expensesCodeFilter() {
        GridHelpers.sendCharKeys(EXPENSE_CODE, codeExpensesFilter, code);
    }

    private void expensesAnaliticCodeFilter() {
        GridHelpers.sendCharKeys(EXPENSE_ANALITYCS_CODE, analiticCodeFilter, analiticCode);
    }

    public void expenseCreate() {
        openSectionReferencesBook();
        sectionExpenses.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSF));
        addButton.click();
        fullNameInput.sendKeys(EXPENSE_NAME);
        shortNameInput.sendKeys(EXPENSE_SHORT_NAME);
        expCodeInput.sendKeys(EXPENSE_CODE);
        analyticalCodeSelect();
        exSymbolIput.sendKeys(EXPENSE_SYMBOL);
        saveButton.click();
    }


    public void expenseFilter() {
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSF));
        expensesNameFilter();
        expensesCodeFilter();
        expensesAnaliticCodeFilter();
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertExpense));
    }

}
