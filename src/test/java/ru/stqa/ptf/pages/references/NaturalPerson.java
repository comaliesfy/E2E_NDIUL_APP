package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;
import static ru.stqa.ptf.helpers.FieldValidation.fieldIsValid;

public class NaturalPerson {


    private final SelenideElement sectionNaturalPerson = $x("//a[@id='directory/natural-person']");
    //Списковая форма
    private final SelenideElement addButton = $x("//mat-icon[contains(text(),'add_circle')]");
    private final SelenideElement editButton = $x("//mat-icon[contains(text(),'edit')]");
    private final SelenideElement historyButton = $x("//mat-icon[contains(text(),'history')]");
    private final SelenideElement deleteButton = $x("//mat-icon[contains(text(),'delete')]");
    //Фильтры
    private final SelenideElement filterButton = $x("//mat-icon[contains(text(),'filter_list')]");
    private final SelenideElement surnameFilter = $x("//input[@id='surname-textInput-id']");
    private final SelenideElement innFilter = $x("//input[@id='inn-textInput-id']");
    private final SelenideElement dulSeriesFilter = $x("//input[@id='documentSeries-textInput-id']");
    private final SelenideElement dulNumberFilter = $x("//input[@id='documentNumber-textInput-id']");
    private final SelenideElement citizenshipFilter = $x("//input[@id='citizenshipCountry-autocompleteInput-id']");
    private final SelenideElement birthDateFilter = $x("//input[@id='birthDate-datepickerInput-id']");
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");

    //Детальная форма
    private final SelenideElement surnameInput = $x("//input[@id='surname-textInput-id']");
    private final SelenideElement nameInput = $x("//input[@id='name-textInput-id']");
    private final SelenideElement secondNameInput = $x("//input[@id='patronymic-textInput-id']");
    private final SelenideElement taxCodeInput = $x("//input[@id='taxCode-textInput-id']");
    private final SelenideElement innInput = $x("//input[@id='inn-textInput-id']");
    private final SelenideElement radioButton = $x("//div[contains(text(),' " + NP_RADIOBUTTON + " ')]/../..//div[@class='mat-radio-inner-circle']");
    private final SelenideElement birthDateInput = $x("//input[@id='birthDate-datepickerInput-id']");
    private final SelenideElement birthPlaceInput = $x("//input[@id='birthPlace-textInput-id']");

    private final SelenideElement citizenshipInput = $x("//input[@id='citizenshipCountry-autocompleteInput-id']");
    private final SelenideElement citizenshipCountry = $x("//label[contains(text(),'" + NP_CONTRY + "')]");
    private final SelenideElement docTypeInput = $x("//input[@id='documentType-autocompleteDropdownInput-id']");
    private final SelenideElement docType1 = $x("//label[contains(text(),'" + NP_DOCTYPE1 + "')]");
    private final SelenideElement docType2 = $x("//label[contains(text(),'" + NP_DOCTYPE2 + "')]");
    private final SelenideElement docDate = $x("//input[@id='documentDate-datepickerInput-id']");

    private final SelenideElement docSeriesInput = $x("//input[@id='documentSeries-textInput-id']");
    private final SelenideElement docNumberInput = $x("//input[@id='documentNumber-textInput-id']");
    //созданная запись
    private final SelenideElement entityNP = $x("//span[contains(text(),'" + NP_BIRTH_DATE + "')]");
    private final SelenideElement saveMessage = $x("//span[contains(text(),'Информация о физическом лице сохранена')]");
    private final SelenideElement deleteDialog = $x("//span[contains(text(),'Удаление физического лица')]");
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Данные ФЛ удалены')]");

    //кнопки детальной формы
    private final SelenideElement historyDFbutton = $x("//span[contains(text(),'История изменений')]");
    private final SelenideElement saveButton = $x("//button[@id='save-button-id']");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    public void selectCitizenCountry() {
        citizenshipInput.sendKeys(NP_CONTRY);
        citizenshipCountry.click();
    }

    public void selectDocType1() {
        docTypeInput.clear();
        docTypeInput.sendKeys(NP_DOCTYPE1);
        docType1.click();
    }

    public void selectDocType2() {
        docTypeInput.clear();
        docTypeInput.sendKeys(NP_DOCTYPE2);
        docType2.click();
    }

    public void openNaturalPersonRef() {
        openSectionReferencesBook();
        sectionNaturalPerson.click();
    }

    public void addButton() {
        addButton.click();
    }

    public void addNaturalPersonFillForm() {
        openNaturalPersonRef();
        addButton();
        surnameInput.sendKeys(NP_SURNAME);
        nameInput.sendKeys(NP_NAME);
        secondNameInput.sendKeys(NP_SECOND_NAME);
        radioButton.click();
        birthDateInput.sendKeys(NP_BIRTH_DATE);
        birthPlaceInput.sendKeys(NP_BIRTH_PLACE);
        selectCitizenCountry();
        selectDocType2();
        docNumberInput.sendKeys(NP_DOC_NUMBER);
        docDate.sendKeys(NP_DOC_DATE);
        docNumberInput.click();
    }

    public void saveNP() {
        //checkButtonIsActive(saveButton);
        saveButton.click();
        Buttons.clickOKButton();
    }

    public void naturalPersonFilter() {
        filterButton.click();
        resetButton.click();
        surnameFilter.sendKeys(NP_SURNAME);
        //innFilter.sendKeys();
        birthDateFilter.sendKeys(NP_BIRTH_DATE);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(entityNP));
    }

    public void naturalPersonDelete() {
        entityNP.click();
        deleteButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteDialog));
        clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        clickOKButton();
    }

    public void naturalPersonFieldValidation() {
        openNaturalPersonRef();
        addButton.click();
        assertFalse(fieldIsValid(surnameInput));
        assertFalse(fieldIsValid(nameInput));
        assertFalse(fieldIsValid(birthDateInput));
        assertFalse(fieldIsValid(birthPlaceInput));
        assertFalse(fieldIsValid(citizenshipInput));
        assertFalse(fieldIsValid(docTypeInput));
        assertFalse(fieldIsValid(docNumberInput));
        assertFalse(fieldIsValid(docDate));
        assertTrue(fieldIsValid(docSeriesInput));
        selectDocType1();
        String valid = docSeriesInput.getAttribute("class");
        assertTrue(valid.contains("required"));//поле невалидно при выборе "типа документа" = паспорт гр.".
        exitButton.click();
    }

    public void naturalPersonFieldValidationINN() {
        openNaturalPersonRef();
        addButton.click();
        assertTrue(fieldIsValid(innInput));
        innInput.sendKeys("189799678191");
        assertFalse(fieldIsValid(innInput));
        innInput.clear();
        innInput.sendKeys("189799678197");
        assertTrue(fieldIsValid(innInput));
    }
}

