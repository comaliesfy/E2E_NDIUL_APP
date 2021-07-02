package ru.stqa.ptf.pages.primaryDoc;

import Configs.ClientConfigs;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.DateHelper;
import ru.stqa.ptf.helpers.GridHelpers;
import ru.stqa.ptf.pages.dedublication.Dedublication;

import java.util.ArrayList;
import java.util.List;

import static Configs.ClientConfigs.*;
import static Configs.ReferencesConfig.ONL_FULLNAME;
import static Configs.ReferencesConfig.PRATE_RATE;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static ru.stqa.ptf.helpers.GridHelpers.focusAndPush;

public class PrimaryDocSF {

    Dedublication dedub = new Dedublication();

    //Кнопки списковой формы ПД

    private final SelenideElement sectionPD = $x("//button[contains(text(),'Первичные документы')]");
    private final SelenideElement sectionPDClient = $x("//a[contains(text(),'Первичные документы клиента')]");
    private final SelenideElement sectionPDContractor = $x("//a[contains(text(),'Первичные документы контрагента')]");
    private final SelenideElement sectionPDDepository = $x("//a[contains(text(),'Первичные документы депозитария')]");
    private final SelenideElement addContractButton = $x("//button[@id='addContract-button-id']");
    private final SelenideElement historyButton = $x("//button[@id='contractBusinessAudit-button-id']");
    private final SelenideElement uploadButton = $x("//button[@id='downloadContractsExcel-button-id']");
    private final SelenideElement deleteContractButton = $x("//mat-icon[contains(text(),'delete_forever')]");

    // Фильтры
    private final SelenideElement filterButton = $x("//mat-icon[contains(text(),'filter_list')]");
    private final SelenideElement osbInput = $x("//input[@id='osb-autocompleteInput-id']");
    private final SelenideElement osb = $x("//label[contains(text(),'" + CLIENT_OSB + "')]");
    private final SelenideElement countryInput = $x("//input[@id='country-cmxAutocomplete-id']");
    private final SelenideElement country = $x("//label[contains(text(),'" + CLIENT_COUNTRY + "')]");
    //инпуты нерезидентов
    private final SelenideElement clientInput = $x("//input[@id='client-autocompleteInput-id']");
    private final SelenideElement contractorInput = $x("//input[@id='contractor-autocompleteInput-id']");
    private final SelenideElement depoInput = $x("//input[@id='depository-autocompleteInput-id']");
    private final SelenideElement client = $x("//label[contains(text(),'" + CLIENT_NAME + "')]");
    private final SelenideElement clientFilter = $x("//label[contains(text(),'" + CLIENT_NAME_FILTER + "')]");

    private final SelenideElement statusPDInput = $x("//input[@id='contractStatus-autocompleteInput-id']");
    private final SelenideElement statusPD = $x("//label[contains(text(),'" + PD_STATUS_ACTIVE + "')]");
    private final SelenideElement docTypeInput = $x("//input[@id='contractType-autocompleteInput-id']");
    private final SelenideElement docType = $x("//label[contains(text(),'" + CLIENT_DOCTYPE + "')]");
    private final SelenideElement docTypeDepo = $x("(//label[contains(text(),'Договор')])[1]");
    private final SelenideElement numPDInput = $x("//input[@id='contractNumber-textInput-id']");
    private final SelenideElement bankNA = $x("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");

    //Кнопки фильтров
    private final SelenideElement searchButton = $x("//button[@id='apply-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//button[@id='clear-button']//span[@class='mat-button-wrapper']");
    ;

    //Дейтпикеры фильтры
    private final SelenideElement concludeDateFrom = $x("//input[@id='id-concludeDateFrom']");
    private final SelenideElement concludeDateTo = $x("//input[@id='id-concludeDateTo']");
    private final SelenideElement inputDateFrom = $x("//input[@id='id-inputDateFrom']");
    private final SelenideElement inputDateTo = $x("//input[@id='id-inputDateTo']");
    private final SelenideElement correctDateFrom = $x("//input[@id='id-correctDateFrom']");
    private final SelenideElement correctDateTo = $x("//input[@id='id-correctDateTo']");

    //Созданная запись в таблице
    private final SelenideElement createEntityPD = $x("//span[contains(text(),'" + CLIENT_NAME + "')]");
    private final SelenideElement assertPDStatus = $x("//span[contains(text(),'" + CLIENT_NAME + "')]/../../..//datatable-body-cell[7]//span");
    private final SelenideElement assertPDRow = $x("//span[contains(text(),'" + CLIENT_NAME + "')]");
    private final SelenideElement assertFindResults = $x(" //div[@class='datatable-row-center datatable-row-group ng-star-inserted']");

    //Диалоги
    private final SelenideElement dialogContent = $x("//span[contains(text(),'успешно удален')]");
    private final SelenideElement listInput = $x("//input");
    private final SelenideElement container = $x("//div[@class='container']");

    //Кнопки диалогов
    private final SelenideElement simpleDialogOK = $x("//button[@id='simple-dialog_OkBtn_Id']");
    private final SelenideElement simpleDialogCancel = $x("//button[@id='simple-dialog_cancelBtn_Id']");

    public void goToPDClientForm() {
        sectionPD.click();
        sectionPDClient.click();
    }

    public void goToPDContractorForm() {
        sectionPD.click();
        sectionPDContractor.click();
    }

    public void goToPDDepositoryForm() {
        sectionPD.click();
        sectionPDDepository.click();
    }

    public void addContract() {
        addContractButton.click();
    }

    // поиск ПД по номеру
    public void findPrimaryDoc(String PDNumber) {
        focusAndPush(filterButton);
        resetButton.click();
        countryInput.sendKeys(CLIENT_COUNTRY);
        country.click();
        numPDInput.sendKeys(PDNumber);
        searchButton.click();
    }

    //открыть найденную детальную форму Пд
    public void openDetailFormPD() {
        ActionsIF.doubleClick(createEntityPD);
    }

    //Удалить найденный ПД
    public void deletePD() {
        createEntityPD.click();
        deleteContractButton.click();
        simpleDialogOK.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(dialogContent));
        simpleDialogOK.click();
    }

    public void checkPDFiltersAreClear() {
        filterButton.click();
        numPDInput.sendKeys("002");
        resetButton.click();
        List<String> terms = new ArrayList<>();
        for (int k = 1; k < 16; k++) {
            terms.add($x("(//div[@class='stretch display-table-row cmx-filter-content_inner']//input)[" + k + "]").getAttribute("value"));
        }
        String terms02 = terms.toString();
        assertEquals("[, , , , , , , on, , , , , , , ]", terms02);
    }

    public void assertPDStatusPreview(String status, String trValidation) {
        //Assert.assertTrue(assertPDRow.getAttribute("className").contains(trValidation));
        assertEquals(assertPDStatus.getText(), status);
    }

    private void checkFilterFieldDropDown(SelenideElement input, SelenideElement value, String key) {
        filterButton.click();
        resetButton.click();
        ActionsIF.fillInputAndSelect(input, key, value);
        searchButton.click();
        assertFindResults.shouldBe(Condition.visible);
        assertFindResults(key);
    }

    private void checkFilterFieldInput(String key) {
        filterButton.click();
        resetButton.click();
        numPDInput.sendKeys(key);
        searchButton.click();
        assertFindResults.shouldBe(Condition.visible);
        assertFindResults(key);
    }

    public void checkOsbFilterFields() {
        checkFilterFieldDropDown(osbInput, osb, CLIENT_OSB);
    }

    public void checkCountryFilterFields() {
        checkFilterFieldDropDown(countryInput, country, CLIENT_COUNTRY);
    }

    public void checkClientNameFilterFields() {
        checkFilterFieldDropDown(clientInput, clientFilter, CLIENT_NAME_FILTER);
    }

    public void checkContractorNameFilterFields() {
        checkFilterFieldDropDown(contractorInput, clientFilter, CLIENT_NAME_FILTER);
    }

    public void checkDepositoryNameFilterFields() {
        checkFilterFieldDropDown(depoInput, clientFilter, CLIENT_NAME_FILTER);
    }

    public void checkStatusPDFilterFields() {
        checkFilterFieldDropDown(statusPDInput, statusPD, PD_STATUS_ACTIVE);
    }

    public void checkDocTypeDepoFilterFields(String type) {
        checkFilterFieldDropDown(docTypeInput, docTypeDepo, type);
    }

    public void checkDocTypeFilterFields(String type) {
        checkFilterFieldDropDown(docTypeInput, docType, type);
    }

    public void checkPDNumFilterFields() {
        checkFilterFieldInput("002");
    }

    //проверка результатов поиска на соответствие фильтру
    public void assertFindResults(String cellName) {
        List<SelenideElement> rows = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        List<SelenideElement> cells = $$x("//span[contains(text(),'" + cellName + "')]");
        assertEquals(rows.size(), cells.size());
    }


    public void checkFilterFieldDatePicker(String PDNumber) {
        findPrimaryDoc(PDNumber);
        //Дейтпикеры "Дата заключения ПД"
        filterButton.click();
        concludeDateFrom.sendKeys(ClientConfigs.CLIENT_PDdate);
        concludeDateTo.sendKeys(ClientConfigs.CLIENT_PDdate);
        searchButton.click();
        Assert.assertTrue(createEntityPD.isDisplayed());

        //Дейтпикеры "Дата ввода"

        findPrimaryDoc(PDNumber);
        filterButton.click();
        inputDateFrom.sendKeys(DateHelper.yesterdayDate());
        inputDateTo.sendKeys(DateHelper.factDate());
        searchButton.click();
        Assert.assertTrue(createEntityPD.isDisplayed());
        //дейтпикеры "Дата корректировки"

        findPrimaryDoc(PDNumber);
        filterButton.click();
        correctDateFrom.sendKeys(DateHelper.yesterdayDate());
        correctDateTo.sendKeys(DateHelper.factDate());
        searchButton.click();
        Assert.assertTrue(createEntityPD.isDisplayed());
    }

    public void checkCountryRateForDepoCon() {
        findPrimaryDoc(DEPO_DOC_NUMBER);
        ActionsIF.doubleClick(createEntityPD);
        List<String> element = new ArrayList<>();
        for (int k = 1; k < 7; k++) {
            element.add($x("(//tr[@class='ui-selectable-row ng-star-inserted']//td)[" + k + "]").getAttribute("innerText"));
        }
        String depoRate = element.toString();
        Assert.assertTrue(depoRate.contains(CLIENT_COUNTRY));
        Assert.assertTrue(depoRate.contains(PRATE_RATE));
        Assert.assertTrue(depoRate.contains(ONL_FULLNAME));
    }
}
