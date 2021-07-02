package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.FieldValidation;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ClientConfigs.CLIENT_COUNTRY;
import static Configs.ClientConfigs.CLIENT_COUNTRYRUS;
import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class Issuer {

    private final SelenideElement issuerSection = $x("//a[@id='directory/issuers']");
    private final SelenideElement sectionReferencesBook = $x("//button[@id='reference-books']");

    //кнопки меню
    private final SelenideElement addButton = $x("//cmx-icon-button[@id='create-button-id']/button");
    private final SelenideElement editButton = $x("//cmx-icon-button[@id='edit-button-id']/button");
    private final SelenideElement historyButton = $x("//cmx-icon-button[@id='audit-button-id']/button");
    private final SelenideElement deleteButton = $x("//cmx-icon-button[@id='delete-button-id']/button");
    private final SelenideElement filterButton = $x("//cmx-icon-button[@id='filter-button-id']/button");

    //фильтры
    private final SelenideElement filterNameInput = $x("//input[@id='id-issuers-name-filter']");
    private final SelenideElement filterCountryInput = $x("//input[@class='mat-autocomplete-trigger cmx-text-input_field_input cmx-autocomplete-input_field_input ng-untouched ng-pristine ng-valid']");
    private final SelenideElement filterINNInput = $x("//input[@id='id-issuers-inn']");
    private final SelenideElement filterKPPInput = $x("//input[@id='id-issuers-digit-kpp']");
    private final SelenideElement filterIDInput = $x("//input[@id='id-issuers-id']");
    private final SelenideElement searchButton = $x("//button[@id='apply-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//button[@id='clear-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement entityIssuer = $x("//span[contains(text(),'" + IS_NAME + "')]");
    //Окно создания эмитента
    private final SelenideElement assertForm = $x("//span[contains(text(),'Данные ')]");
    //Поля окна "Данные эмитента"
    private final SelenideElement issuerNameInput = $x("//input[@id='id-issuer-details-name']");
    private final SelenideElement issuerCountryInput = $x("//input[@id='id-country']");
    private final SelenideElement issuerCountry = $x("//label[contains(text(),'" + CLIENT_COUNTRY + "')]");
    private final SelenideElement issuerCountryRus = $x("//label[contains(text(),'" + CLIENT_COUNTRYRUS + "')]");
    private final SelenideElement issuerINNInput = $x("//input[@id='id-issuer-details-inn']");
    private final SelenideElement issuerIDDInput = $x("//input[@id='id-issuer-details-idd']");
    private final SelenideElement issuerKPPInput = $x("//input[@id='id-issuer-details-kpp']");

    //Сообщение об успешном удалении
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Эмитент успешно удален')]");
    private final SelenideElement okButton = $x("//button[@id='simple-dialog_OkBtn_Id']");

    public void createIssuerNonRus() {
        goToIssuerReference();
        addButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertForm));
        issuerNameInput.sendKeys(IS_NAME);
        ActionsIF.fillInputAndSelect(issuerCountryInput, CLIENT_COUNTRY, issuerCountry);
        issuerINNInput.sendKeys(IS_INN);
        issuerKPPInput.sendKeys(IS_KPP);
        issuerIDDInput.sendKeys(IS_ID);
        //Добавить проверку на обязательное поле - ИНН
        clickOKButton();
    }

    public void findIssuerNonRus() {
        filterButton.click();
        filterNameInput.sendKeys(IS_NAME);
        ActionsIF.fillInputAndSelect(filterCountryInput, CLIENT_COUNTRY, issuerCountry);
        filterINNInput.sendKeys(IS_INN);
        filterKPPInput.sendKeys(IS_KPP);
        filterIDInput.sendKeys(IS_ID);
        searchButton.click();
        assertTrue(GridHelpers.elementIsVisible(entityIssuer));
    }

    public void deleteIssuerNonRus() {
        entityIssuer.click();
        deleteButton.click();
        clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
    }

    public void createIssuerRus() {
        goToIssuerReference();
        addButton.click();
        issuerNameInput.sendKeys(IS_NAME);
        issuerCountryInput.clear();
        GridHelpers.sendCharKeys(CLIENT_COUNTRYRUS, issuerCountryInput, issuerCountryRus);
        FieldValidation.fieldIsValid(issuerINNInput);
        FieldValidation.fieldIsValid(issuerKPPInput);
        issuerINNInput.sendKeys(IS_INN);
        issuerKPPInput.sendKeys(IS_KPP);
        issuerIDDInput.sendKeys(IS_ID);
        //checkButtonIsActive(okButton);
    }

    public void goToIssuerReference() {
        openSectionReferencesBook();
        issuerSection.click();
    }
}
