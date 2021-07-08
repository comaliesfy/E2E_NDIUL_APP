package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class IncomeKind {
    private final SelenideElement sectionIncomeKind = $x("//a[@id='directory/income']");
    private final SelenideElement assertSF = $x("//h4[contains(text(),'Виды дохода')]");

    //кнопки фильтры
    private final SelenideElement searchButton = $x("//button[@id='search-button-id']");
    private final SelenideElement resetButton = $x("//button[@id='reset-button-id']");

    //поля фильтра
    private final SelenideElement codeFilter = $x("//input[@id='codeFilter-cmxTextInput-id']");
    private final SelenideElement symbolFilter = $x("//input[@id='symbolFilter-cmxTextInput-id']");
    private final SelenideElement nameFilter = $x("//input[@id='shortNameFilter-cmxTextInput-id']");
    private final SelenideElement fullNameFilter = $x("//input[@id='fullNameFilter-cmxTextInput-id']");
    private final SelenideElement rateFilter = $x("//input[@id='rate-input-id']");
    private final SelenideElement sideFilter = $x("//input[@id='incomeSide-cmxAutocompleteInput-id']/..//span");//признак дохода
    private final SelenideElement typeFilter = $x("//input[@id='incomeKindFilter-autocomplete-id']/..//span");
    //кнопки нижнего меню
    private final SelenideElement addButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    private final SelenideElement assertIncKind = $x("td[@id='/" + INCKIND_FULLNAME+"']");
    //поля детальной формы
    private final SelenideElement codeInput = $x("//input[@id='code-cmxTextInput-id']");
    private final SelenideElement typeDropDown = $x("//input[@id='incomeKind-autocomplete-id']/..//span");
    private final SelenideElement type = $x("//label[contains(text(),'" + INCKIND_TYPE + "')]");
    private final SelenideElement rateInput = $x("//input[@id='rate-cmxTextInput-id']");
    private final SelenideElement income = $x("//label[contains(text(),'" + INCKIND_INCOMEFOR + "')]");//радиокнопка в ДФ/ значение выпадающего списка на СФ
    private final SelenideElement incomeInput = $x("//input[@id='incomeInput']");
    private final SelenideElement nameInput = $x("//input[@id='shortName-cmxTextInput-id']");
    private final SelenideElement fullNameInput = $x("//input[@id='fullName-cmxTextInput-id']");
    private final SelenideElement codesInput = $x("//input[@id='code5-cmxTextInput-id']");
    private final SelenideElement symbolInput = $x("//input[@id='symbolInput2-input-id']");
    private final SelenideElement kbkInput = $x("//input[@id='kbk-cmxTextInput-id']");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    public void incomeKindCreate() {
        openSectionReferencesBook();
        sectionIncomeKind.click();
        Assert.assertTrue(assertSF.isDisplayed());
        addButton.click();
        codeInput.sendKeys(INCKIND_CODE);
        typeDropDown.click();
        type.click();
        rateInput.sendKeys(INCKIND_RATE);
        nameInput.sendKeys(INCKIND_NAME);
        fullNameInput.sendKeys(INCKIND_FULLNAME);
        symbolInput.sendKeys(INCKIND_SYMBOL);
        kbkInput.sendKeys(INCKIND_KBK);
        saveButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSF));
    }

    public void incomeKindFilter() {
        codeFilter.sendKeys(INCKIND_CODE);
        rateFilter.sendKeys(INCKIND_RATE);
        symbolFilter.sendKeys(INCKIND_SYMBOL);
        nameFilter.sendKeys(INCKIND_NAME);
        fullNameFilter.sendKeys(INCKIND_FULLNAME);
        sideFilter.click();
        income.click();
        typeFilter.click();
        type.click();
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertIncKind));
    }

    public void incomeKindDelete() {
        assertIncKind.click();
        deleteButton.click();
        clickOKButton();
    }//добавить проверку удаления записи

    public void incomeKindValidation() {
        //добавить проверки на создание всех доходов ( КА/представительства)
    }
}

