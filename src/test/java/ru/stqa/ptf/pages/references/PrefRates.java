package ru.stqa.ptf.pages.references;

import Configs.ReferencesConfig;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class PrefRates {

    private final SelenideElement sectionPrefRate = $x("//a[@id='directory/prefRates']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Льготные ставки')]");
    private final SelenideElement addButton = $x("//button[@id='add-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement deleteButton = $x("//button[@id='delete-button-id']//span[@class='mat-button-wrapper']");

    // поля фильтров
    private final SelenideElement incomeNameFilter = $x("//input[@placeholder='Наименование дохода']");
    private final SelenideElement countryFilter = $x("//input[@placeholder='Страна']");
    private final SelenideElement clientTypeFilter = $x("//input[@placeholder='Тип клиента']");
    private final SelenideElement showVisibleFilter = $x("//input[@id='showInvisible']");
    private final SelenideElement searchButton = $x("//button[@id='search-button-id']");
    private final SelenideElement resetButton = $x("//button[@id='reset-button-id']//span[@class='mat-button-wrapper']");
    // Детальная форма
    private final SelenideElement rateInput = $x("//input[@id='eRate-input-id']");
    private final SelenideElement incomeInput = $x(" //label[contains(text(),'Доход действия льготы*: ')]/../..//input");
    private final SelenideElement income = $x("//div[contains(text(),'"+PRATE_INCOME+"')]");
    private final SelenideElement countryInput = $x(" //label[contains(text(),'Страна действия льготы*: ')]/../..//input");
    private final SelenideElement country = $x("//div[@id='"+PRATE_COUNTRY+"']");
    private final SelenideElement clientTypeInput = $x("//label[contains(text(),'Тип клиента*:')]/../..//input");
    private final SelenideElement clientType = $x("//div[@id='"+PRATE_CLIENTTYPE+"']");
    private final SelenideElement countryFreeCheckBox = $x( "//input[@id='countryFreeCheckbox-input-id']");
    private final SelenideElement incomeTypeInput = $x("//label[contains(text(),'Тип дохода: ')]/../..//input");
    private final SelenideElement incomeShort = $x("//div[@id='"+PRATE_INCOMESHORT+"']");
    private final SelenideElement linkDocInput = $x("//label[contains(text(),'Связанный документ:')]/../..//input");
    private final SelenideElement linkDocEntity = $x("//div[@id='Основание АВТОТЕСТ']");
    private final SelenideElement definingDocInput = $x("//label[contains(text(),'Определяющий документ:')]/../..//input");
    private final SelenideElement docTypeInput = $x("//input[@id='documentType-input-id']");
    private final SelenideElement assertPrefRate = $x("//td[@id='/" + PRATE_COUNTRY + "']");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x( "//span[contains(text(),'Выход')]");

    public void prefRateCreate() {
        openSectionReferencesBook();
        sectionPrefRate.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        addButton.click();
        rateInput.sendKeys(ReferencesConfig.PRATE_RATE);
        ActionsIF.fillInputAndSelect(incomeInput, PRATE_INCOME, income);
        ActionsIF.fillInputAndSelect(countryInput, PRATE_COUNTRY, country);
        ActionsIF.fillInputAndSelect(clientTypeInput, PRATE_CLIENTTYPE, clientType);
        //linkDocInput.sendKeys(ReferencesConfig.ONL_FULLNAME);
        //linkDocEntity.click();
        //используется ставка, созданная в ONL тесте
        definingDocInput.sendKeys(ReferencesConfig.PRATE_DEFINING_DOC);
        saveButton.click();
    }


    public void prefRateFilter() {
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        ActionsIF.fillInputAndSelect(incomeNameFilter, PRATE_INCOMESHORT, incomeShort);
        ActionsIF.fillInputAndSelect(countryFilter, PRATE_COUNTRY, country);
        ActionsIF.fillInputAndSelect(clientTypeFilter, PRATE_CLIENTTYPE, clientType);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertPrefRate));
    }

    public void prefRateDelete() {
        assertPrefRate.click();
        deleteButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertPrefRate));
    }

}

