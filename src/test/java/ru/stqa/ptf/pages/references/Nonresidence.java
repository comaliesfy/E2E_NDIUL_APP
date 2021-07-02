package ru.stqa.ptf.pages.references;

import Configs.ConfigsForSearchForm;
import Configs.RepresentationConfig;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.DateHelper;
import ru.stqa.ptf.helpers.GridHelpers;

import java.util.List;

import static Configs.ClientConfigs.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.ActionsIF.doubleClick;
import static ru.stqa.ptf.helpers.ActionsIF.select;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;
import static ru.stqa.ptf.helpers.FieldValidation.checkBoxIsOn;
import static ru.stqa.ptf.helpers.FieldValidation.fieldIsValid;
import static ru.stqa.ptf.helpers.GridHelpers.elementIsVisible;


public class Nonresidence {

    //Тип нерезидента
    public final SelenideElement nonresTypeOrg = $x("//label[contains(text(),'Организация')]");
    //Секция справочник
    private final SelenideElement sectonNonresidence = $x("//a[@id='directory/non-residents']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Список заведенных Нерезидентов')]");
    //Поля фильтров
    private final SelenideElement countryFilter = $x("//input[@id='country-cmxAutocomplete-id']");// фильтр страна
    private final SelenideElement countrySF = $x("//div[@id='" + CLIENT_COUNTRY + "']");
    private final SelenideElement nameFilter = $x("//label[contains(text(),'Наименование:')]/../..//input[@maxlength=255]");
    private final SelenideElement innFilter = $x("//input[@id='inn-nonresident']");
    private final SelenideElement swiftFilter = $x("//label[contains(text(),'Наименование:')]/../..//input[@maxlength=11]");
    //тип нерезидента
    private final SelenideElement nonresTypeSelectFilter = $x("(//label[contains(text(),'Тип нерезидента:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
    // активность
    private final SelenideElement onoffSelectFilter = $x("(//label[contains(text(),'Активен:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
    //Подтверждение местонахождения:
    private final SelenideElement representationSelectFilter = $x("(//label[contains(text(),'Представительство:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]");
    private final SelenideElement locationSelectFilter = $x("(//label[contains(text(),'Подтверждение местонахождения:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]");
    //Особый налоговый статус:
    private final SelenideElement taxPrivilegiesSelectFilter = $x("(//label[contains(text(),'Особый налоговый статус:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]");
    //Подтверждение инф. источников:
    private final SelenideElement infSourceSelectFilter = $x("(//label[contains(text(),'Подтверждение инф. источников:')]/../..//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]");
    // фильтр-даты
    private final SelenideElement inputDateFrom = $x("//input[@id='id-startDateOfInput']");
    private final SelenideElement inputDateTo = $x("//input[@id='id-finalDateOfInput']");
    private final SelenideElement changeDateFrom = $x("//input[@id='id-startDateOfChange']");
    private final SelenideElement changeDateTo = $x("//input[@id='id-finalDateOfChange']");
    //Кнопки фильтра
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//button[@id='reset-button-id']");
    //Созданные запии нерездиента ( переписать)
    public final SelenideElement nonresidenceEntity = $x("//td[contains(text(),'Autotest')]");
    public final SelenideElement nonresidenceEntityDedub = $x("//td[contains(text(),'Autotest-Debulication')]");
    public final SelenideElement nonresidenceEntities = $x("//tr[@class='ui-selectable-row ng-star-inserted ui-state-highlight']");
    private final SelenideElement addButton = $x("//span[contains(text(),' Добавить запись ')]");

    //кнопки нижнего меню Списковой формы
    private final SelenideElement historyButton = $x("//span[contains(text(),' История изменений ')]");
    private final SelenideElement uploadButton = $x("//span[contains(text(),' Выгрузить в EXCEL ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    //Сообщения
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Нерезидент успешно удален')]");//успешное удаление

    //Детальная форма
    private final SelenideElement assertDetailForm = $x("//h4[contains(text(),'Сведения о нерезиденте')]");// подтвреждение отображения ДФ
    private final SelenideElement nonresTypeDropDown = $x("//cmx-autocomplete-input[@id='type-select-id']//span");

    public final SelenideElement nonresTypeBank = $x("//label[contains(text(),'Банк')]");
    private final SelenideElement fdeptTypeSelect = $x("//mat-checkbox[@id='fDept-select-id']/label/div");// чекбокс представительства
    private final SelenideElement activityInput = $x("//input[@id='activity-input-id']");//Статус активности
    //Наименование
    private final SelenideElement ruNameInput = $x("//input[@id='ruName-input-id']"); //русское
    private final SelenideElement latinNameInput = $x("//input[@id='latName-input-id']");//латинское

    private final SelenideElement countryInput = $x("//input[@id='country-dropdown-id']");
    private final SelenideElement country = $x("//label[contains(text(),'" + CLIENT_COUNTRY + "')]");
    private final SelenideElement countryRus = $x("//label[contains(text(),'РОССИЯ')]");
    //Поля - адрес
    private final SelenideElement adressInput = $x("//input[@id='address-cmxInput-id']");
    private final SelenideElement phoneInput = $x("//input[@id='phone-textInput-id']");
    private final SelenideElement indexInput = $x("//input[@id='index-input-id']");
    private final SelenideElement cityInput = $x("//input[@id='city-input-id']");
    private final SelenideElement streetInput = $x("//input[@id='street-input-id']");
    private final SelenideElement buildingInput = $x("//input[@id='building-input-id']");
    private final SelenideElement regionInput = $x("//input[@id='region-input-id']");
    private final SelenideElement distinctInput = $x("//input[@id='district-input-id']");
    private final SelenideElement houseInput = $x("//input[@id='house-input-id']");
    private final SelenideElement appartmentInput = $x("//input[@id='appartment-input-id']");

    //Код налогоплательщика
    private final SelenideElement innInput = $x("//input[@id='inn-input-id']");// ИНН в стране инкорпорации
    private final SelenideElement kioInput = $x("//input[@id='kio-input-id']");// КИО
    private final SelenideElement swiftInput = $x("//input[@id='swift-input-id']");// SWIFT
    private final SelenideElement innRfInput = $x("//input[@id='innRf-input-id']");// ИНН в РФ:
    private final SelenideElement kppInput = $x("//input[@id='kpp-input-id']"); // КПП:
    private final SelenideElement almanacInput = $x("//mat-checkbox[@id='almanac-input-id']/label/div");// Входит в The Banker's Almanac - чекбокс

    //Подтверждение резидентства
    private final SelenideElement locationProveCheckBox = $x("//mat-checkbox[@id='place-select-id']/label/div");
    private final SelenideElement specificStatusCheckBox = $x("//mat-checkbox[@id='status-select-id']/label/div");
    private final SelenideElement proveSelectCheckBox = $x("//mat-checkbox[@id='prove-select-id']");

    //Виды деятельности Представительства
    private final SelenideElement assertFDeptSection = $x("//h4[contains(text(),'Виды деятельности Представительства')]");// Подтврерждение отображения формы
    private final SelenideElement kindOfActivitySelect = $x("//select[@id='activityType-select-id']");
    private final SelenideElement saveKindActButton = $x("//button[@id='save-changes-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement deleteKindActButton = $x("//button[@id='delete-nonresident-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement kindOfActivity = $x("//td[@id='/1234']");
    private final SelenideElement representationEntity = $x("//td[@id='/" + CLIENT_NAMERUS + "']");


    public void createRepresentation() {
        fdeptTypeSelect.click();
        ruNameInput.sendKeys(CLIENT_NAMERUS);
        ActionsIF.fillInputAndSelect(countryInput, CLIENT_COUNTRY, country);
        innInput.sendKeys(CLIENT_INNRUS);
        ActionsIF.selectParameterByText(kindOfActivitySelect, RepresentationConfig.FDEPT_KIND_ACT1);
        saveKindActButton.click();
        saveButton.click();
        findNonResidenceByDate(CLIENT_NAMERUS);
        Assert.assertTrue(GridHelpers.elementIsVisible(representationEntity));
    }

    public void deleteNewActivityType() {
        fdeptTypeSelect.click();
        ActionsIF.selectParameterByText(kindOfActivitySelect, RepresentationConfig.FDEPT_KIND_ACT1);
        saveKindActButton.click();
        kindOfActivity.click();
        deleteKindActButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(kindOfActivity));
    }

    public void assertRepresentation() {
        fdeptTypeSelect.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertFDeptSection));
    }

    public void deleteRepresentation() {
        findNonResidenceByDate(CLIENT_NAMERUS);
        representationEntity.click();
        deleteButton.click();
        clickOKButton();
        assertTrue(deleteMessage.isDisplayed());
        clickOKButton();
        searchButton.click();
        Assert.assertFalse(elementIsVisible(nonresidenceEntity));
    }
    //кнопки нижнего меню детальной формы
    private final SelenideElement saveButton = $x("//button[@id='saveNonResident-button-id']");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    //Запонление полей адреса
    private void fillAdress() {
        adressInput.sendKeys(CLIENT_MAXFILL);
        phoneInput.sendKeys(CLIENT_PHONE);
        indexInput.sendKeys(CLIENT_MAXFILL);
        cityInput.sendKeys(CLIENT_MAXFILL);
        streetInput.sendKeys(CLIENT_MAXFILL);
        buildingInput.sendKeys(CLIENT_MAXFILL);
        regionInput.sendKeys(CLIENT_MAXFILL);
        distinctInput.sendKeys(CLIENT_MAXFILL);
        houseInput.sendKeys(CLIENT_MAXFILL);
        appartmentInput.sendKeys(CLIENT_MAXFILL);
    }

    public void openNonResidenceSection() {
        openSectionReferencesBook();
        sectonNonresidence.click();
    }

    //Создание нерезидента с типом банк/организация
    public void createNonresidence(WebElement nonresType) {
        addNonResidence();
        nonresTypeDropDown.click();
        nonresType.click();
        latinNameInput.sendKeys(CLIENT_NAME);
        ActionsIF.fillInputAndSelect(countryInput, CLIENT_COUNTRY, country);
        //fillAdress();
        innInput.sendKeys(CLIENT_INN);
        saveButton.click();
    }

    public void addNonResidence() {
        addButton.click();
    }

    public void assertFieldValidationCountryRus() {
        ActionsIF.fillInputAndSelect(countryInput, "РОССИЯ", countryRus);
        //должны быть валидны ИНН в стране, КИО, СВИФТ
        assertTrue(fieldIsValid(innInput));
        assertTrue(fieldIsValid(kioInput));
        assertTrue(fieldIsValid(swiftInput));
        //невалидны Наименование рус, Наименование лат, ИНН в РФ, КПП
        Assert.assertFalse(fieldIsValid(ruNameInput));
        Assert.assertFalse(fieldIsValid(latinNameInput));
        Assert.assertFalse(fieldIsValid(innRfInput));
        Assert.assertFalse(fieldIsValid(kppInput));
        //Assert.assertEquals(kioInput.getAttribute("value"), ClientConfigs.CLIENT_INNRUS.substring(0, 5));
        saveButton.click();
    }

    public void assertFieldValidationBankAlm() {
        almanacInput.click();
        //должны быть валидны Наименование рус, ИНН в стране, КИО, ИНН в РФ, КПП
        assertTrue(fieldIsValid(ruNameInput));
        assertTrue(fieldIsValid(innInput));
        assertTrue(fieldIsValid(kioInput));
        assertTrue(fieldIsValid(innRfInput));
        assertTrue(fieldIsValid(kppInput));
        //невалидны  Наименование лат,СВИФТ
        Assert.assertFalse(fieldIsValid(latinNameInput));
        Assert.assertFalse(fieldIsValid(swiftInput));
        //проверка, что чекбокс "Подтверждение информационных источников" проставлен
        assertTrue(checkBoxIsOn(proveSelectCheckBox));
        saveButton.click();
    }

    //проверка, что поле "Тип нерезидента" заполнено корректно
    public void assertFillFieldType(String nonResType) {
        Assert.assertEquals(nonResType, $x("//input[@id='type-select-id']").getAttribute("value"));
        saveButton.click();
    }

    public void openNonResidenceEntity() {
        doubleClick(nonresidenceEntity);
    }

    public void findNonResidence() {
        resetButton.shouldBe(Condition.visible);
        resetButton.click();
        nameFilter.sendKeys(CLIENT_NAME);
        innFilter.sendKeys(CLIENT_INN);
        searchButton.click();
        assertTrue(elementIsVisible(nonresidenceEntity));
    }

    public void findNonResidenceByDate(String name) {
        resetButton.click();
        nameFilter.sendKeys(name);
        inputDateFrom.sendKeys(DateHelper.factDate());
        searchButton.click();
    }

    public void deleteNonResidence() {
        nonresidenceEntity.click();
        deleteButton.click();
        clickOKButton();
        assertTrue(deleteMessage.isDisplayed());
        clickOKButton();
        searchButton.click();
        Assert.assertFalse(elementIsVisible(nonresidenceEntity));
    }


    //Списковая форма
    //Дейтпикеры
    public void checkFilterFieldDatePicker() {
        //Дейтпикеры "Дата ввода"
        findNonResidence();
        inputDateFrom.sendKeys(DateHelper.yesterdayDate());
        inputDateTo.sendKeys(DateHelper.factDate());
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(nonresidenceEntity));
        resetButton.click();

        //дейтпикеры "Дата изменения"
        findNonResidence();
        changeDateFrom.sendKeys(DateHelper.yesterdayDate());
        changeDateTo.sendKeys(DateHelper.factDate());
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(nonresidenceEntity));
        resetButton.click();
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

    private void checkFilterFieldSelect(SelenideElement select, String key, int rowNum) {
        resetButton.click();
        select(select, key);
        searchButton.click();
        assertFindResultsForValue(key, rowNum);
    }

    private void checkFilterFieldInput(WebElement input, String key, int rowNum) {
        resetButton.click();
        input.sendKeys(key);
        searchButton.click();
        assertFindResultsForValue(key, rowNum);
    }

    public void checkCountryFilter() {
        checkFilterFieldDropDown(countryFilter, country, CLIENT_COUNTRY, 4);
    }

    public void checkNameFilter() {
        checkFilterFieldInput(nameFilter, ConfigsForSearchForm.CLIENT, 3);
    }

    public void checkNonresTypeFilter() {
        checkFilterFieldSelect(nonresTypeSelectFilter, CLIENT_BANK, 1);
    }

    public void checkActiveFilter() {
        checkFilterFieldSelect(onoffSelectFilter, "Не активен", 16);
    }

    public void checkRepresentationFilter() {
        checkFilterFieldSelect(representationSelectFilter, CLIENT_YES, 2);
    }

    public void checkLocationSelectFilter() {
        checkFilterFieldSelect(locationSelectFilter, CLIENT_NO, 13);
    }

    public void checkInfSourceSelectFilter() {
        checkFilterFieldSelect(infSourceSelectFilter, CLIENT_NO, 14);
    }

    public void checkTaxPrivilegiesSelectFilter() {
        checkFilterFieldSelect(taxPrivilegiesSelectFilter, CLIENT_NO, 15);
    }

    public void checkINNFilter() {
        checkFilterFieldInput(innFilter, ConfigsForSearchForm.INN_Filter, 6);
    }

    public void checkSWIFTFilter() {
        checkFilterFieldInput(swiftFilter, ConfigsForSearchForm.SWIFT_Filter, 8);
    }

}

