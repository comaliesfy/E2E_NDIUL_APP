package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ClientConfigs.CLIENT_COUNTRY;
import static Configs.ReferencesConfig.ONL_FULLNAME;
import static Configs.ReferencesConfig.ONL_TYPE;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.ActionsIF.select;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class Onl {
    private final SelenideElement sectionOnl = $x("//a[@id='directory/onl']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Основания для налоговых льгот')]");
    private final SelenideElement countryFilter = $x("(//cmx-autocomplete-input[@id='country-cmxAutocomplete-id']//input)[1]");
    private final SelenideElement onlTypeSelectFilter = $x("//select[@id='typeInput1']");
    private final SelenideElement nameFilter = $x("//input[@id='nameInput1']");
    private final SelenideElement searchButton = $x("//button[@id='search-button-id']");
    private final SelenideElement resetButton = $x("//button[@id='reset-button-id']");
    private final SelenideElement addButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    private final SelenideElement countryInput = $x("(//cmx-autocomplete-input[@id='country-cmxAutocomplete-id']//input)[2]");
    private final SelenideElement fullNameInput = $x("//input[@id='name-input-id']");
    private final SelenideElement onlTypeSelect = $x(" //select[@id='type-select-id']");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");
    private final SelenideElement country = $x("//label[contains(text(),'" + CLIENT_COUNTRY + "')]");
    private final SelenideElement assertOnl = $x("//td[@id='/" + ONL_FULLNAME + "']");

    public void OnlCreate() {
        openSectionReferencesBook();
        sectionOnl.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        addButton.click();
        ActionsIF.fillInputAndSelect(countryInput, CLIENT_COUNTRY, country);
        //selectCountry();
        fullNameInput.sendKeys(ONL_FULLNAME);
        select(onlTypeSelect, ONL_TYPE);
        saveButton.click();
    }

    public void OnlFilter() {
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        ActionsIF.fillInputAndSelect(countryFilter, CLIENT_COUNTRY, country);
        select(onlTypeSelectFilter, ONL_TYPE);
        nameFilter.sendKeys(ONL_FULLNAME);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertOnl));
    }

    public void OnlDelete() {
        assertOnl.click();
        deleteButton.click();
        searchButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertOnl));
    }
}
