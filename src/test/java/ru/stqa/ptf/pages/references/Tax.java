package ru.stqa.ptf.pages.references;

import Configs.ReferencesConfig;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.TAX_COUNTRY;
import static Configs.ReferencesConfig.TAX_NAME;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class Tax {

    private final SelenideElement sectionTax = $x("//a[@id='directory/tax']");
    private final SelenideElement assertTaxSF = $x("//h4[contains(text(),'Виды налогов')]");
    private final SelenideElement taxNameFilter = $x("//input[@placeholder='Налог']");
    private final SelenideElement taxName = $x("//div[@id='" + ReferencesConfig.TAX_NAME + "']");
    private final SelenideElement countryFilter = $x("//input[@id='country-autocompleteInput-id']");
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");
    private final SelenideElement addButton = $x("//span[contains(text(),'Добавить запись')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    private final SelenideElement entityTax = $x("//td[@id='/" + ReferencesConfig.TAX_NAME + "']");

    //Детальная форма
    private final SelenideElement taxNameInput = $x("//input[@id='taxName-input-id']");
    private final SelenideElement rateInput = $x("//input[@id='rate-input-id']");
    private final SelenideElement countryInput = $x("//input[@id='countryCreate-autocompleteInput-id']");
    private final SelenideElement country = $x("//label[contains(text(),'" + TAX_COUNTRY + "')]");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    public void taxCreate() {
        openSectionReferencesBook();
        sectionTax.click();
        Assert.assertTrue(assertTaxSF.isDisplayed());
        addButton.click();
        taxNameInput.sendKeys(ReferencesConfig.TAX_NAME);
        rateInput.sendKeys(ReferencesConfig.TAX_RATE);
        ActionsIF.fillInputAndSelect(countryInput, TAX_COUNTRY, country);
        saveButton.click();
    }

    public void taxFilter() {
        Assert.assertTrue(assertTaxSF.isDisplayed());
        ActionsIF.fillInputAndSelect(taxNameFilter, TAX_NAME, taxName);
        ActionsIF.fillInputAndSelect(countryFilter, TAX_COUNTRY, country);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(entityTax));
    }

    public void deleteTax() {
        entityTax.click();
        deleteButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(entityTax));
    }
}
