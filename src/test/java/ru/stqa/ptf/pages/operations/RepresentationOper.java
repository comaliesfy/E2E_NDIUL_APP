package ru.stqa.ptf.pages.operations;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import java.util.List;

import static Configs.ClientConfigs.CLIENT_COUNTRY;
import static Configs.ConfigsForSearchForm.*;
import static Configs.RepresentationConfig.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class RepresentationOper {
    private final SelenideElement sectionOper = $x("//button[@id='current-operation-input']");
    private final SelenideElement sectionRepresentIncome = $x("//a[contains(text(),'Доходы представительств')]");
    private final SelenideElement sectionRepresentExpense = $x("//a[contains(text(),'Расходы представительств')]");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Входные параметры')]");

    //Списковая форма
    private final SelenideElement nameFilter = $x("//autocomplete-dropdown[@id='fdept']//input");
    private final SelenideElement country = $x("//label[@class='stretch cmx-autocomplete-input_option_label']");
    private final SelenideElement countryFilter = $x("//cmx-autocomplete-input[@id='country-cmxAutocomplete-id']//input");
    private final SelenideElement dateFromFilter = $x(" //input[@id='id-dateFrom']");
    private final SelenideElement dateToFilter = $x("//input[@id='id-dateTo']");
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");
    private final SelenideElement addButton = $x("//span[contains(text(),'Добавить запись')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),'Удалить запись')]");
    private final SelenideElement historyButton = $x("//span[contains(text(),'История изменений')]");
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Операция успешно удалена')]");

    //Детальная форма Расходы представительств
    private final SelenideElement countryInputExpense = $x("//autocomplete-dropdown[@id='country-dropdown-id']//input");
    private final SelenideElement representationInputExpense = $x("//autocomplete-dropdown[@id='fDept-dropdown-id']//input");
    private final SelenideElement expenseDate = $x("//input[@id='expDate-datepicker-id']");
    private final SelenideElement expenseMark = $x("//select[@id='expMark-select-id']");
    private final SelenideElement expenseType = $x("//select[@id='expType-select-id']");
    private final SelenideElement kindOfExpense = $x("//autocomplete-dropdown[@id='tax-dropdown-id']//input");
    private final SelenideElement factExpense = $x("//input[@id='factExpense-input-id']");
    private final SelenideElement primaryPrice = $x("//input[@id='primaryPrice-input-id']");
    private final SelenideElement includedForeign = $x("//input[@id='includedForeign-input-id']");
    private final SelenideElement includedRussian = $x("//input[@id='includedRussian-input-id']");

    //Детальная форма доходы
    private final SelenideElement countryInputIncome = $x("//autocomplete-dropdown[@id='country']//input");
    private final SelenideElement representationInputIncome = $x("(//autocomplete-dropdown[@id='fdept']//input)[2]");
    private final SelenideElement activityTypeInput = $x("//autocomplete-dropdown[@id='activity']//input");
    private final SelenideElement tax = $x("//autocomplete-dropdown[@id='tax']//input");
    private final SelenideElement rateInput = $x("//input[@id='taxRate']");
    private final SelenideElement taxInput = $x("//input[@id='taxForeign']");
    private final SelenideElement incDate = $x("//input[@id='incDate-datepicker-id']");
    private final SelenideElement incomeKind = $x("//autocomplete-dropdown[@id='income']//input");
    private final SelenideElement incSumInput = $x("//input[@id='incSum']");
    private final SelenideElement incProfitInput = $x("//input[@id='incProfit']");

    //Кнопки детальной формы
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    private final SelenideElement dropDownEntity = $x("//div[@class='element-row ng-star-inserted']");
    private final SelenideElement newEntity = $x("//td[@id='/" + FDEPT_NAME + "']");
    private final SelenideElement entityFilter = $x("//td[@id='/КИРИБАТИ']");

    public void goToFdeptExpense() {
        sectionOper.click();
        sectionRepresentExpense.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void goToFdeptIncome() {
        sectionOper.click();
        sectionRepresentIncome.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void addEntity() {
        addButton.click();
    }

    public void fillFDeptIncomeForm() {
        GridHelpers.sendCharKeys(CLIENT_COUNTRY, countryInputIncome, dropDownEntity);
        //ActionsIF.fillInputAndSelect(countryInputIncome, CLIENT_COUNTRY, dropDownEntity);
        ActionsIF.fillInputAndSelect(representationInputIncome, FDEPT_NAME, dropDownEntity);
        ActionsIF.fillInputAndSelect(activityTypeInput, FDEPT_KIND_ACT2, dropDownEntity);
        ActionsIF.fillInputAndSelect(tax, FDEPT_TAX_KIND, dropDownEntity);
        rateInput.sendKeys(FDEPT_RATE);
        taxInput.sendKeys(FDEPT_SUMM_INPUT);
        incDate.sendKeys(FDEPT_DATE);
        ActionsIF.fillInputAndSelect(incomeKind, FDEPT_INC_KIND, dropDownEntity);
        incSumInput.sendKeys(FDEPT_SUMM_INPUT);
        incProfitInput.sendKeys(FDEPT_SUMM_INPUT);
    }

    public void fillFDeptExpenseForm() {
        GridHelpers.sendCharKeys(CLIENT_COUNTRY, countryInputExpense, dropDownEntity);
        //ActionsIF.fillInputAndSelect(countryInputExpense, CLIENT_COUNTRY, dropDownEntity);
        ActionsIF.fillInputAndSelect(representationInputExpense, FDEPT_NAME, dropDownEntity);
        expenseDate.sendKeys(FDEPT_DATE);
        ActionsIF.select(expenseMark, FDEPT_EXP_MARK_OUT);
        ActionsIF.select(expenseType, FDEPT_EXP_TYPE01);
        ActionsIF.fillInputAndSelect(kindOfExpense, FDEPT_EXP_KIND, dropDownEntity);
        factExpense.sendKeys(FDEPT_SUMM_INPUT);
        includedForeign.sendKeys(FDEPT_SUMM_INPUT);
        includedForeign.click();
        Assert.assertEquals("0.00", includedRussian.getAttribute("value"));
    }

    public void fillAndCheckFDeptExpenseForm() {
        ActionsIF.select(expenseMark, FDEPT_EXP_MARK_OUT);
        ActionsIF.select(expenseType, FDEPT_EXP_TYPE01);
        Assert.assertTrue(GridHelpers.elementIsVisible(factExpense));
        Assert.assertTrue(GridHelpers.elementIsVisible(includedForeign));
        Assert.assertTrue(GridHelpers.elementIsVisible(includedRussian));

        ActionsIF.select(expenseMark, FDEPT_EXP_MARK_OUT);
        ActionsIF.select(expenseType, FDEPT_EXP_TYPE03);
        Assert.assertTrue(GridHelpers.elementIsVisible(factExpense));
        Assert.assertTrue(GridHelpers.elementIsVisible(includedForeign));
        Assert.assertTrue(GridHelpers.elementIsVisible(includedRussian));
        Assert.assertTrue(GridHelpers.elementIsVisible(primaryPrice));

        ActionsIF.select(expenseMark, FDEPT_EXP_MARK_IN);
        ActionsIF.select(expenseType, FDEPT_EXP_TYPE03);
        Assert.assertTrue(GridHelpers.elementIsVisible(factExpense));
        Assert.assertTrue(GridHelpers.elementIsVisible(includedRussian));
        Assert.assertTrue(GridHelpers.elementIsVisible(primaryPrice));
    }

    public void saveFDept() {
        saveButton.click();
    }

    public void deleteFDept() {
        newEntity.click();
        deleteButton.click();
        Buttons.clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        Buttons.clickOKButton();
    }

    public void checkNameFDeptFilter() {
        checkFilterFieldDropDown(nameFilter, dropDownEntity, FDEPT_NAME_FILTER, 1);
    }

    public void checkCountryFDeptFilter() {
        checkFilterFieldDropDown(countryFilter, country, FDEPT_COUNTRY_FILTER, 2);
    }

    public void checkDatePickers() {
        //Дейтпикеры "Дата дохода/расхода"
        dateFromFilter.sendKeys(FDEPT_DATE_FILTER);
        dateToFilter.sendKeys(FDEPT_DATE_FILTER);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(entityFilter));
    }

    public void findFDept() {
        resetButton.click();
        ActionsIF.fillInputAndSelect(nameFilter, FDEPT_NAME, dropDownEntity);
        ActionsIF.fillInputAndSelect(countryFilter, CLIENT_COUNTRY, country);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(newEntity));
    }

    private void assertFindResultsForValue(String cellName, int rowNum) {
        int count = 1;
        int i = 1;
        List<SelenideElement> rows = $$x("//tr[@class='ui-selectable-row ng-star-inserted']");
        while (i < rows.size()) {
            String a = $x("(//tr[@class='ui-selectable-row ng-star-inserted']//td[" + rowNum + "])[" + i + "]").getAttribute("innerText");
            if (a.contains(cellName)) {
                count++;
            }
            i++;
        }
        Assert.assertEquals(rows.size(), count);
    }

    private void checkFilterFieldDropDown(SelenideElement input, SelenideElement value, String key, int rowNum) {
        resetButton.click();
        ActionsIF.fillInputAndSelect(input, key, value);
        searchButton.click();
        assertFindResultsForValue(key, rowNum);
    }
}
