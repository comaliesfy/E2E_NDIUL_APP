package ru.stqa.ptf.pages.primaryDoc;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ClientConfigs.*;
import static Configs.ReferencesConfig.ONL_FULLNAME;
import static Configs.ReferencesConfig.PRATE_RATE;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.GridHelpers.focusAndPush;

public class PrimaryDocDF {

    private final SelenideElement sectionPD = $x("//button[@id='current-primary-document']");
    private final SelenideElement sectionPDClient = $x("//a[contains(text(),'Первичные документы клиента')]");
    private final SelenideElement sectionPDContractor = $x("//a[contains(text(),'Первичные документы контрагента')]");
    private final SelenideElement sectionPDDepository = $x("//a[contains(text(),'Первичные документы депозитария')]");
    private final SelenideElement addContractButton = $x("//mat-icon[contains(text(),'add_circle')]");
    //Кнопки детальных форм ПД
    private final SelenideElement addNonresPd = $x("//button[@id='addNonresPd-cmxButton-id']");

    public void addPDDepository() {
        addContractButton.click();
        simpleDialogOK.click();
    }

    public void addPDDepositoryDoc() {
        sectionPD.click();
        sectionPDDepository.click();
        addContractButton.click();
        simpleDialogCancel.click();
    }

    public void addPD() {
      addContractButton.click();
    }
    //Сообщение
    private final SelenideElement notification = $x("//span[contains(text(),'Предупреждение')]");
    private final SelenideElement addIncomeType = $x("//span[contains(text(),'Добавить вид дохода')]");
    private final SelenideElement deleteIncomeType = $x("//button[@id='deleteIncomeType-cmxButton-id']");
    private final SelenideElement closePD = $x("//button[@id='closePd-cmxButton-id']");
    private final SelenideElement savePD = $x("//span[contains(text(),'Сохранить ПД')]");

    private final SelenideElement auditPD = $x("//button[@id='savePrimaryDocument-button-id']");
    private final SelenideElement cancelPD = $x("//button[@id='cancel-button-id']");
    // диалог сохранения
    private final SelenideElement dialogContent = $x("//p[contains(text(),'Первичный документ успешно сохранен.')]");
    // Ставка отправлена на утверждение Контролеру УНП ЦА
    private final SelenideElement approveMessage = $x("//div[@class='stretch display-table-cell cmx-notification-component_body_message']//span");

    //поля ввода
    private final SelenideElement countrySelect = $x("//select[@id='clientCountryId']");
    private final SelenideElement osbID = $x("//div[@class='mat-autocomplete-panel ng-star-inserted mat-autocomplete-visible']//label[contains(text(),'" + CLIENT_OSB + "')]");
    private final SelenideElement countryDepoSelect = $x("//autocomplete-dropdown[@id='countryId']/..//input");
    private final SelenideElement countryDepoID = $x("//div[@id='" + CLIENT_COUNTRY + "']");
    private final SelenideElement clientType = $x("//select[@id='clientKindId']");
    private final SelenideElement clientNameInput = $x("//autocomplete-dropdown[@id='dClientId']/..//input");
    private final SelenideElement clientNameInputDepo = $x("//autocomplete-dropdown[@id='clientId']/..//input");
    private final SelenideElement client = $x("//div[@id='" + CLIENT_NAMEdrop + "']");
    private final SelenideElement osbInput = $x("//input[@id='osb-autocompleteInput-id']");
    private final SelenideElement inputRateCountry = $x("//autocomplete-dropdown[@id='country']//input[@placeholder='Введите страну']");
    private final SelenideElement docTypeDropDown = $x("//autocomplete-dropdown[@id='docTypeId']//span[@id='dropdown-list']");
    private final SelenideElement docTypeID = $x("//div[@id='" + CLIENT_DOCTYPE + "']" + "");
    private final SelenideElement currencySelect = $x("//select[@id='currencyId']");
    private final SelenideElement statusPD = $x("//label[contains(text(),'Состояние*:')]/../..//input[@id='dStatusId']");
    private final SelenideElement st310 = $x("//input[@id='st.310']");
    private final SelenideElement st310Depo = $x("//mat-checkbox[@id='st.310-cmxCheckbox-id']//label");
    private final SelenideElement contractNumberPD = $x("//input[@id='contractNumber']");
    private final SelenideElement datePickerInput = $x("//cmx-datepicker-input[@id='id-crtDate']/..//input");

    //Поля блока "Вид дохода" клиента и депо
    private final SelenideElement assertIncStatus = $x("(//h4[contains(text(),'Виды дохода')]/../../../..//tbody//td)[5] ");
    private final SelenideElement assertRate = $x("(//h4[contains(text(),'Виды дохода')]/../../../..//tbody//td)[4]");
    private final SelenideElement incomeKindClientDepoInput = $x(" //input[@id='income-autocomplete-id']");
    private final SelenideElement incomeKindContractorInput = $x("//input[@id='incomeContractor-autocomplete-id']");

    private final SelenideElement incomeKind = $x("//label[@class='stretch cmx-autocomplete-input_option_label']");
    private final SelenideElement incomeKindEntity = $x("//tbody[@class='ui-table-tbody']/tr/td");


    private final SelenideElement selectPrivelege = $x("//select[@id='incomeKindRate']");
    private final SelenideElement facilityInput = $x("//input[@id='rtFacility-input-id']");
    private final SelenideElement rateInput = $x("//label[contains(text(),'%*')]/../..//cmx-currency-input//input");
    private final SelenideElement simpleDialogOK = $x("//button[@id='simple-dialog_OkBtn_Id']");
    private final SelenideElement simpleDialogCancel = $x("//button[@id='simple-dialog_cancelBtn_Id']");
    private final SelenideElement saveIncomeKind = $x("//span[contains(text(),'Сохранить вид дохода')]");
    private final SelenideElement acceptIncomeKind = $x("//button[@id='accept-income-button-id']");

    //13 льгота
    private final SelenideElement legalRF = $x("//td[@id='/Юридическое лицо - резидент РФ']");
    private final SelenideElement indivRF = $x("//td[@id='/Физическое лицо - резидент РФ']");
    private final SelenideElement indiv = $x("//td[@id='/Юридическое лицо - нерезидент РФ']");
    private final SelenideElement foreign = $x("//td[@id='/Иностранная структура без образования ЮЛ']");
    private final SelenideElement factRecipient = $x("//td[@id='/Фактический получатель']");
    private final SelenideElement continueButton = $x("//span[contains(text(),'Продолжить')]");
    private final SelenideElement indivInput = $x("//input[@id='naturalPerson-autocompleteInput-id']");
    private final SelenideElement legalInput = $x("//input[@id='legalPerson-autocompleteInput-id']");
    private final SelenideElement crtFactRightInput = $x("//input[@id='crtFactRight-input-id']");
    private final SelenideElement crtFactRightSelect = $x("//select[@id='crtFactRight-select-id']");
    private final SelenideElement faceCodeInput = $x("//input[@id='faceCode-input-id']");
    //Банк - не налоговый агент
    private final SelenideElement bankNa = $x("//input[@id='taxAgentOrNot']");

    //Поля блока "Ставки по странам"
    private final SelenideElement contractNumberDepo = $x("//input[@id='contractNumber-cmxTextInput-id']");
    private final SelenideElement datePickerInputDepo = $x("//cmx-datepicker-input[@id='crtDate-datepicker-id']/..//input");
    private final SelenideElement rateBlock = $x("//h4[contains(text(),'%%')]");
    private final SelenideElement selectDepoAccout = $x("//select[@id='depositoryAccount']");
    private final SelenideElement incomeKindDepoInput = $x("//input[@id='incomeKind-autocomplete-id']");
    private final SelenideElement depoFacilityInput = $x("//input[@id='depoFacility']");
    private final SelenideElement rateCountry = $x("//div[@id='" + CLIENT_COUNTRY + "']");
    private final SelenideElement depoRateInput = $x("  //input[@id='taxRate']");
    private final SelenideElement assertDepoRate = $x("//td[@id='/Счет депозитарных программ']");

    // Кнопки блока "Ставки по странам"
    private final SelenideElement addRate = $x("//button[@id='addRatePdDepoType-cmxButton-id']");
    private final SelenideElement deleteRate = $x("//button[@id='deleteRatePdDepoType-cmxButton-id']");
    private final SelenideElement saveRateDepo = $x("//button[@id='saveRateContractDepoType-cmxButton-id']");
    private final SelenideElement cancelRateDepo = $x("//button[@id='cancelRateContractDepoType-cmxButton-id']//span[@class='mat-button-wrapper']");

    private final SelenideElement divDropdown = $("#dropdown-list");
    //заполнение информации нерезидента
    public void fillNonresidenceInfo() {
        ActionsIF.select(countrySelect, CLIENT_COUNTRY);
        GridHelpers.sendCharKeys(CLIENT_NAME, clientNameInput, client);
        assertEquals(clientNameInput.getAttribute("value"), CLIENT_NAMEdrop);
    }

    //заполнение информации депонента с типом "Договор Депо".
    public void fillDepoConInfo() {
        ActionsIF.fillInputAndSelect(clientNameInputDepo, CLIENT_NAME, client);
        contractNumberDepo.clear();
        contractNumberDepo.sendKeys(DEPO_DOC_NUMBER);
        datePickerInputDepo.sendKeys(CLIENT_PDdate);
        rateBlock.click();
    }

    //заполнение полей ПД "Данные первичного документа"
    public void fillPDInfo(String number) {
        ActionsIF.fillInputAndSelect(osbInput, CLIENT_OSB, osbID);
        docTypeDropDown.click();
        docTypeID.click();
        ActionsIF.select(currencySelect, CLIENT_CURRENCY);
        contractNumberPD.clear();
        contractNumberPD.sendKeys(number);
        datePickerInput.sendKeys(CLIENT_PDdate);
        assertEquals(statusPD.getAttribute("value"), PD_STATUS_NEW);
    }

    //заполнение полей ПД "Данные первичного документа" ПД депозитария
    public void fillDepositoryPDInfo(String number) {
        ActionsIF.select(currencySelect, CLIENT_CURRENCY);
        contractNumberPD.clear();
        contractNumberPD.sendKeys(number);
        datePickerInput.sendKeys(CLIENT_PDdate);
        assertEquals(statusPD.getAttribute("value"), PD_STATUS_NEW);
    }

    //Добавление вида дохода и ставки
    public void addIncomeType(String rate, String incomeKindName) {
        focusAndPush(addIncomeType);
        focusAndPush(incomeKindClientDepoInput);
        ActionsIF.fillInputAndSelect(incomeKindClientDepoInput, incomeKindName, incomeKind);
        rateInput.clear();
        rateInput.sendKeys(rate);
    }

    public void addIncomeContractor(String incomeKindName) {
        focusAndPush(addIncomeType);
        focusAndPush(incomeKindContractorInput);
        ActionsIF.fillInputAndSelect(incomeKindContractorInput, incomeKindName, incomeKind);
    }

    public void acceptIncomeType() {
        focusAndPush(acceptIncomeKind);
        assertEquals(assertIncStatus.getText(), PD_STATUS_ACTIVE);
    }

    public void saveIncomeType() {
        focusAndPush(saveIncomeKind);
        assertEquals(assertIncStatus.getText(), PD_STATUS_ACTIVE);
    }

    //Добавление вида дохода и ставки оператор клиент/депо
    public void addIncomeTypeOperator(String incomeKindName) {
        focusAndPush(addIncomeType);
        focusAndPush(incomeKindClientDepoInput);
        ActionsIF.fillInputAndSelect(incomeKindClientDepoInput, incomeKindName, incomeKind);
        saveIncomeKind.click();
        assertTrue(approveMessage.isDisplayed());
        simpleDialogOK.click();
        assertEquals(assertIncStatus.getText(), PD_STATUS_NEW);
        assertEquals(PD_STATUS_UPDATED, statusPD.getAttribute("value"));
    }


    //Добавить %% Ставку по стране
    public void addDepoRate() {
        focusAndPush(addRate);
        inputRateCountry.sendKeys(CLIENT_COUNTRY);
        rateCountry.click();
        depoRateInput.sendKeys(PRATE_RATE);
        assertEquals(ONL_FULLNAME, depoFacilityInput.getAttribute("value"));
        saveRateDepo.click();
    }

    //Удаление Вида дохода
    public void deleteIncomeType() {
        focusAndPush(incomeKindEntity);
        deleteIncomeType.click();
        Buttons.clickOKButton();
        Assert.assertFalse(GridHelpers.elementIsVisible(incomeKind));
    }

    //удаление ставки
    public void deleteDepoRate() {
        assertDepoRate.click();
        deleteDepoRate();
        simpleDialogOK.click();
    }

    //подтержедние Вида дохода (для роли-Контроллер)
    public void approveIncomeKind() {
        Assert.assertTrue(GridHelpers.elementIsVisible(incomeKindEntity));
        openIncomeKind();
        acceptIncomeKind.click();
        assertEquals(assertIncStatus.getText(), PD_STATUS_ACTIVE);
        assertEquals(statusPD.getAttribute("value"), PD_STATUS_ACTIVE);
    }

    public void openIncomeKind() {
        focusAndPush(incomeKindEntity);
        ActionsIF.doubleClick(incomeKindEntity);
    }

    //льготные ставки
    public void selectPrefRate(Integer number) {
        SelenideElement element = $x("(//h4[contains(text(),'Перечень налог')]/../../../..//div[@class='col-md-1 col1']//input)[" + number + "]");
        focusAndPush(element);

    }

    public boolean rateIsSelect(Integer number) {
        return Boolean.parseBoolean($x("(//h4[contains(text(),'Перечень налог')]/../../../..//div[@class='col-md-1 col1']//input)[" + number + "]").getAttribute("checked"));
    }

    public void assertPrivelegeField(String privelege) {
        focusAndPush(selectPrivelege);
        Assert.assertTrue(selectPrivelege.getText().contains(privelege));
    }

    public String checkFacility() {
        return facilityInput.getAttribute("value");
    }

    public void notTaxAgent() {
        bankNa.click();
    }

    //сохранение уникального ПД
    public void saveUnicPD() {
        savePD.click();
        assertTrue(dialogContent.exists());
        simpleDialogCancel.click();
    }

    //Сохранение неуникального ПД
    public void saveEqualPD() {
        savePD.click();
        assertTrue(notification.isDisplayed());
        simpleDialogCancel.click();
        assertTrue(GridHelpers.elementIsVisible(dialogContent));
    }

    //Создать ПД клиента
    public void createPrimaryDocClient() {
        addPD();
        fillNonresidenceInfo();
        fillPDInfo(CLIENT_NUMBER);
        addIncomeType(CLIENT_RATE, CLIENT_INCOMEKIND);
        acceptIncomeType();
        saveUnicPD();
    }

    //Создать ПД контрагента
    public void createPrimaryDocContractor() {
        addPD();
        fillNonresidenceInfo();
        fillPDInfo(CONTRACTOR_NUMBER);
        addIncomeType(CONTRACTOR_Rate, CONTRACTOR_INCOMEKIND);
        saveIncomeType();
        saveUnicPD();
    }

    //Создать ПД депозитария с типом "Договор"
    public void createPrimaryDocDepository() {
        addPDDepository();
        fillNonresidenceInfo();
        fillDepositoryPDInfo(DEPO_NUMBER);
        addIncomeType(DEPO_RATE, DEPO_INCOMEKIND);
        acceptIncomeType();
        saveUnicPD();
    }

    //Создать ПД депозитария с типом "Договор депозитария"
    public void createPrimaryDocDepositoryCon() {
        addPDDepositoryDoc();
        fillDepoConInfo();
        addDepoRate();
        saveUnicPD();
    }
}