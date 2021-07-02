package ru.stqa.ptf.pages.operations;

import Configs.ClientConfigs;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.DateHelper;
import ru.stqa.ptf.helpers.GridHelpers;

import java.util.List;

import static Configs.ClientConfigs.CLIENT_COUNTRY;
import static Configs.ClientConfigs.CLIENT_NAME;
import static Configs.ConfigsForSearchForm.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;

public class OperationsSF {

    private final SelenideElement sectionOper = $x("//button[@id='current-operation-input']");
    private final SelenideElement sectionOperClient = $x("//a[@id='operations/client/grid']");
    private final SelenideElement sectionOperContractor = $x("//a[@id='operations/contractor/grid']");
    private final SelenideElement sectionOperDepo = $x("//a[@id='operations/depository/grid']");

    //СФ Операции клиента
    private final SelenideElement addButton = $x("//cmx-icon-button[@id='create-button-id']/button");
    private final SelenideElement historyButton = $x("//cmx-icon-button[@id='audit-button-id']/button");
    private final SelenideElement deleteButton = $x("//cmx-icon-button[@id='delete-button-id']/button");
    private final SelenideElement exportButton = $x("//cmx-icon-button[@id='export-button-id']/button");
    private final SelenideElement doneButton = $x("//cmx-icon-button[@id='done-button-id']/button");
    private final SelenideElement filterButton = $x("//cmx-icon-button[@id='filter-button-id']/button");
    private final SelenideElement checkBoxEntity = $x("//span[contains(text(),'Autotest')]/../../..//label[@class='mat-checkbox-layout']");
    //поля фильтра
    private final SelenideElement osbFilterInput = $x("//input[@id='osb-autocompleteInput-id']");
    private final SelenideElement osbFilter = $x("//label[contains(text(),'" + OSB + "')]");
    private final SelenideElement clientFilterInput = $x("//input[@id='client-autocompleteInput-id']");
    private final SelenideElement contractorFilterInput = $x("//input[@id='contractor-autocompleteInput-id']");
    private final SelenideElement depoFilterInput = $x("//input[@id='depository-autocompleteInput-id']");
    private final SelenideElement issuerFilterInput = $x("//input[@id='issuer-autocompleteInput-id']");
    private final SelenideElement issuer = $x("//label[contains(text(),'" + ISSUER + "')]");

    private final SelenideElement clientFilter = $x("//label[contains(text(),'" + CLIENT + "')]");
    private final SelenideElement client = $x("//label[contains(text(),'" + CLIENT_NAME + "')]");
    private final SelenideElement incomeNameFilterInput = $x("//input[@id='incomeName-autocompleteInput-id']");
    private final SelenideElement messageNumberFilterInput = $x("//input[@id='messageNumber-textInput-id']");
    private final SelenideElement numberPDFilterInput = $x("//input[@id='contractNumber-textInput-id']");

    private final SelenideElement fromDeclFilterInput = $x("//input[@id='period-autocompleteInput-id']");
    private final SelenideElement incomeCodeFilterInput = $x("//input[@id='incomeCode-autocompleteInput-id']");
    private final SelenideElement incomeCodeFilter = $x("//label[contains(text(),'" + INCOME_CODE + "')]");
    private final SelenideElement incomeCodeFilterContr = $x("//label[contains(text(),'" + INCOME_CODE_CONT + "')]");
    private final SelenideElement paymentCountry = $x("//input[@id='paymentCountry-autocompleteInput-id']");
    private final SelenideElement country = $x("//label[contains(text(),'" + CLIENT_COUNTRY + "')]");
    private final SelenideElement depoCountry = $x("//input[@id='depositoryCountry-autocompleteInput-id']");

    private final SelenideElement rateFilterInput = $x("//input[@id='rate-textInput-id']");
    private final SelenideElement userFilterInput = $x("//input[@id='user-autocompleteInput-id']");
    private final SelenideElement userFilter = $x("//label[contains(text(),'" + USER + "')]");
    private final SelenideElement NotTaxAgentFilter = $x("//mat-checkbox[@id='notTaxAgent-checkbox-id']//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");
    //дейтпикеры
    private final SelenideElement messageDateFromFilter = $x("//input[@id='messageDateFromString-input-id']");
    private final SelenideElement messageDateToFilter = $x("//input[@id='messageDateToString-input-id']");
    private final SelenideElement inputDateFromFilter = $x("//input[@id='fDateFromString-input-id']");
    private final SelenideElement inputDateToFilter = $x("//input[@id='fDateToString-input-id']");
    private final SelenideElement taxDateFromFilter = $x("//input[@id='taxDateFromString-input-id']");
    private final SelenideElement taxDateToFilter = $x("//input[@id='taxDateToString-input-id']");
    private final SelenideElement incomeDateFromFilter = $x("//input[@id='incDateFromString-input-id']");
    private final SelenideElement incomeDateToFilter = $x("//input[@id='incDateToString-input-id']");
    private final SelenideElement searchButton = $x("//button[@id='apply-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//button[@id='clear-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement assertClientRow = $x("//span[contains(text(),'" + CLIENT_NAME + "')]");
    private final SelenideElement assertFindResults = $x(" //div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
    private final SelenideElement assertRate = $x("//datatable-body-row//datatable-body-cell[11]//span[contains(text(),'10')]");


    //Сообщения
    private final SelenideElement confirmDelete = $x("//span[contains(text(),'удаления')]");
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Операции успешно удалены!')]");


    private void assertFindResultsForValue(String cellName, Integer rowNum) {
        List<SelenideElement> rows = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        List<SelenideElement> cells = $$x("//datatable-body-row//datatable-body-cell[" + rowNum + "]//span[contains(text(),'" + cellName + "')]");
        assertEquals(rows.size(), cells.size());
    }

    private void checkFilterFieldDropDown(SelenideElement input, SelenideElement value, String key, Integer rowNum) {
        filterButton.click();
        resetButton.click();
        ActionsIF.fillInputAndSelect(input, key, value);
        searchButton.click();
        assertFindResults.shouldBe(Condition.visible);
        assertFindResultsForValue(key, rowNum);
    }

    private void checkFilterFieldCount(WebElement input, String key, char count) {
        filterButton.click();
        resetButton.click();
        input.sendKeys(key);
        searchButton.click();
        assertFindResults.shouldBe(Condition.visible);
        List<SelenideElement> rows = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        assertEquals(count, rows.size());
    }

    private void checkFieldRate(WebElement input) {
        filterButton.click();
        resetButton.click();
        input.sendKeys(PD_RATE);
        searchButton.click();
        assertFindResults.shouldBe(Condition.visible);
        Assert.assertFalse(GridHelpers.elementIsVisible(assertRate));
    }

    private void checkDatePickerMessage(char count) {
        filterButton.click();
        resetButton.click();
        messageDateFromFilter.sendKeys(MessageDATE);
        messageDateToFilter.sendKeys(MessageDATE);
        searchButton.click();
         assertFindResults.shouldBe(Condition.visible);
        List<SelenideElement> rows = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        assertEquals(count, rows.size());
    }


    public void checkFilterFieldPDNum(String number, char count) {
        checkFilterFieldCount(numberPDFilterInput, number, (char) count); // фильтр Номер ПД
    }

    public void checkFilterFieldOSB() {
        checkFilterFieldDropDown(osbFilterInput, osbFilter, OSB, 3);//проверка фильтра Подразделение
    }

    public void checkFilterFieldClient() {
        checkFilterFieldDropDown(clientFilterInput, clientFilter, CLIENT, 4); // Проверка фильтра нерезидент-клиент
    }

    public void checkFilterFieldContractor() {
        checkFilterFieldDropDown(contractorFilterInput, clientFilter, CLIENT, 4); // Проверка фильтра нерезидент - контрагент
    }

    public void checkFilterFieldDepo() {
        checkFilterFieldDropDown(depoFilterInput, clientFilter, CLIENT, 3); // Проверка фильтра нерезидент - контрагент
    }

    public void checkFilterFieldIssuer() {
        checkFilterFieldDropDown(issuerFilterInput, issuer, ISSUER, 15); // Проверка фильтра нерезидент - контрагент
    }

    public void checkFilterFieldCountryPay() {
        checkFilterFieldDropDown(paymentCountry, country, CLIENT_COUNTRY, 14); // фильтр Страна выплаты
    }

    public void checkFilterFieldCountryDepo() {
        checkFilterFieldDropDown(depoCountry, country, CLIENT_COUNTRY, 4); // фильтр Страна депонента
    }

    public void checkFilterFieldIncomeCode(Integer row) {
        checkFilterFieldDropDown(incomeCodeFilterInput, incomeCodeFilter, INCOME_CODE, row); //фильтра код дохода
    }

    public void checkFilterFieldIncomeCodeContr() {
        checkFilterFieldDropDown(incomeCodeFilterInput, incomeCodeFilterContr, INCOME_CODE_CONT, 6); //фильтра код дохода
    }

    public void checkFilterFieldUser(Integer row) {
        checkFilterFieldDropDown(userFilterInput, userFilter, USER, row); // фильтр Пользователь
    }

    public void checkFilterFieldMessage() {
        checkFilterFieldCount(messageNumberFilterInput, MessageNUMBER, (char) 3); //фильтр номер сообщения
        checkDatePickerMessage((char) 3);
    }

    public void checkFilterFieldRate() {
        checkFieldRate(rateFilterInput); // фильтр ставка не равна
    }

    public void checkFilterFieldDatePicker(String PDNumber) {
        //Дейтпикеры "Дата ввода"
        findOperation(PDNumber);
        filterButton.click();
        inputDateFromFilter.sendKeys(DateHelper.yesterdayDate());
        inputDateToFilter.sendKeys(DateHelper.factDate());
        searchButton.click();
        assertTrue(GridHelpers.elementIsVisible(assertClientRow));

        //дейтпикеры "Дата уплаты"
        findOperation(PDNumber);
        filterButton.click();
        taxDateFromFilter.sendKeys(ClientConfigs.OPER_TAXDATE);
        taxDateToFilter.sendKeys(ClientConfigs.OPER_TAXDATE);
        searchButton.click();
        assertTrue(GridHelpers.elementIsVisible(assertClientRow));

        //Дейтпикеры "Дата дохода"
        findOperation(PDNumber);
        filterButton.click();
        incomeDateFromFilter.sendKeys(ClientConfigs.OPER_INDATE);
        incomeDateToFilter.sendKeys(ClientConfigs.OPER_INDATE);
        searchButton.click();
        assertTrue(GridHelpers.elementIsVisible(assertClientRow));
    }

    public void findOperation(String PDNumber) {
        filterButton.click();
        resetButton.click();
        numberPDFilterInput.sendKeys(PDNumber);
        searchButton.click();
    }

    public void deleteOperation() {
        checkBoxEntity.shouldBe(Condition.visible).click();
        deleteButton.click();
        assertTrue(GridHelpers.elementIsVisible(confirmDelete));
        clickOKButton();
        deleteMessage.shouldBe(Condition.visible);
        assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        clickOKButton();
    }
}
