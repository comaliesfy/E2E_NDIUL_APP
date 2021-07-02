package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;


public class Currency {

    private final SelenideElement sectionCurrency = $x("//a[@id='directory/currencies']");
    private final SelenideElement addButton = $x("//button[@id='add-button-id']");
    private final SelenideElement deleteButton = $x("//cmx-button[@id='delete-button-id']");
    private final SelenideElement searchButton = $x( "//button[@id='searchInCurrencyDirectory-cmxButton-id']");
    private final SelenideElement curNameFilter = $x("//input[@id='nameTemplate']");
    private final SelenideElement currCodeFilter = $x("//input[@id='charCodeTemplate']");
    private final SelenideElement numCodeFilter = $x("//input[@id='numCodeTemplate']");

    //Детальная форма
    private final SelenideElement nameInput = $x("//input[@id='name']");
    private final SelenideElement charCodeInput = $x("//input[@id='charCode']");
    private final SelenideElement numCodeInput = $x("//input[@id='numCode']");
    private final SelenideElement saveButton = $x( "//button[@id='save-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement historyButton = $x("//button[@id='businessAudit-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement exitButton = $x("//button[@id='exit-button-id']");
    private final ElementsCollection newCurrencyAmount = $$x("//td[@id='/" + CURRENCY_NAME + "']");
    private final SelenideElement newCurrency = $x("//td[@id='/" + CURRENCY_NAME + "']");

    public void currencyBookCreate() {
        openSectionReferencesBook();
        sectionCurrency.click();
        addButton.click();
        nameInput.sendKeys(CURRENCY_NAME);
        charCodeInput.sendKeys(CURRENCY_CHAR_CODE);
        numCodeInput.sendKeys(CURRENCY_NUM_CODE);
        saveButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(newCurrency));
    }  //добавить проверку наименования полей.

    public void currencyBookFilter() {
        curNameFilter.sendKeys(CURRENCY_NAME);
        currCodeFilter.sendKeys(CURRENCY_NUM_CODE);
        numCodeFilter.sendKeys(CURRENCY_CHAR_CODE);
        searchButton.click();
        Assert.assertEquals(newCurrencyAmount.size(), 1);
        Assert.assertTrue(GridHelpers.elementIsVisible(newCurrency));
    }

    public void currencyBookDelete() {
        newCurrency.click();
        deleteButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(newCurrency));
    }
}

