package ru.stqa.ptf.pages.operations;

import Configs.ClientConfigs;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.DateHelper;

import static Configs.ClientConfigs.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.GridHelpers.elementIsVisible;
import static ru.stqa.ptf.helpers.GridHelpers.focusAndPush;

public class OperationsDF {

    private final SelenideElement sectionOper = $x("//button[contains(text(),'Операции')]");
    private final SelenideElement sectionOperClient = $x("//a[contains(text(),'Операции клиентов')]");
    private final SelenideElement sectionOperContractor = $x("//a[contains(text(),'Операции контрагентов')]");
    private final SelenideElement sectionOperDepo = $x("//a[contains(text(),'Операции депозитария')]");
    private final SelenideElement addButton = $x("//cmx-icon-button[@id='create-button-id']/button");

    //ассерты разделов:
    private final SelenideElement sectionOperClientAssert = $x("//h4[contains(text(),'Операции клиентов')]");
    private final SelenideElement sectionOperContractorAssert = $x("//h4[contains(text(),'Операции контрагентов')]");
    private final SelenideElement sectionOperDepoAssert = $x("//h4[contains(text(),'Операции депозитария')]");
    private final SelenideElement messageDate = $x("//input[@id='id-messageDate']");
    private final SelenideElement messageNumber = $x("//input[@id='messageNumber']");

    private final SelenideElement selectOSB = $x("//input[@placeholder='Подразделение']");
    private final SelenideElement selectCountry = $x("//input[@placeholder='Страна']");
    private final SelenideElement selectPDNumber = $x("//input[@placeholder='Номер']");
    private final SelenideElement PDNumber = $x("//div[contains(text(),'20')]");
    private final SelenideElement selectPDType = $x("//input[@placeholder='Тип']");
    private final SelenideElement selectClientType = $x("//select[@id='clientKindInput']");
    private final SelenideElement selectClient = $x("//input[@id='client-autocompleteInput-id']");
    private final SelenideElement client = $x("//label[contains(text(),'" + ClientConfigs.CLIENT_NAMEdrop + "')]");
    private final SelenideElement selectDeponent = $x("//input[@placeholder='Депонент']");
    private final SelenideElement addCrtDateFrom = $x("//input[@id='id-crtDateFromInput']");
    private final SelenideElement addCrtDateTo = $x("//input[@id='id-crtDateToInput']");
    private final SelenideElement addCrtCreateDateFrom = $x("//input[@id='id-crtCreationDateFromInput']");
    private final SelenideElement addCrtCreateDateTo = $x("//input[@id='id-crtCreationDateToInput']");
    private final SelenideElement searchPDButton = $x("//span[contains(text(),'Поиск')]/../..//button");
    private final SelenideElement clearPDButton = $x("//button[@id='clearPdSearchFilterInClientOperations-cmxButton-id']");
    private final SelenideElement choosePDButton = $x("//button[@id='select-contract-button-id']");
    private final SelenideElement editPDButton = $x("//span[text() ='Редактировать']/..//button");
    private final SelenideElement choosePDclient = $x("//td[@id='/" + CLIENT_NAME + "']");

    private final SelenideElement selectIncomeKind = $x("//select[@id='incInput']");
    private final SelenideElement currencyIncomeInput = $x("//input[@id='currencyIncome-cmxAutocompleteInput-id']");
    private final SelenideElement currencyTaxInput = $x("//input[@id='currency-cmxAutocompleteInput-id']");
    private final SelenideElement currency = $x("//label[@class='stretch cmx-autocomplete-input_option_label']");
    private final SelenideElement curRate = $x("//input[@id='currencyRate-cmxCurrencyInput-id']");

    //Дейтпикеры
    private final SelenideElement incDateInput = $x("//input[@id='id-incDateInput']");
    private final SelenideElement calcDateInput = $x("//input[@id='id-calcDateInput']");
    private final SelenideElement budgDateInput = $x("//input[@id='id-budgDateInput']");
    private final SelenideElement taxDateInput = $x("//input[@id='id-taxDateInput']");
    //Сумма дохода
    private final SelenideElement incSummInput = $x("//input[@id='incSumInput']");
    //Сумма налога в рублях
    private final SelenideElement taxSumInputRub = $x("//input[@id='taxSumInput']");
    private final SelenideElement taxSumInput = $x("//input[@id='taxCurSumInput']");
    //Эмитент:
    private final SelenideElement issuerInput = $x("//input[@id='issuer-autocompleteInput-id']");
    private final SelenideElement issuer = $x("//label[@class='stretch cmx-autocomplete-input_option_label'][contains(text(),'ForTestDepository2020')]");
    private final SelenideElement issuerINN = $x("//input[@id='innIssuer-cmxTextInput-id']");
    private final SelenideElement issuerKPP = $x("//input[@id='kppIssuer-cmxTextInput-id']");
    //Вид налога
    private final SelenideElement taxKindDropdown = $x("//cmx-autocomplete-input[@id='taxInput-cmxAutocompleteInput-id']//span");
    // дурацкий локатор, надо менять на универсальный
    private final SelenideElement selectTaxKind = $x("//label[contains(text(),' Налог тест Создание задачи ')]");
    //Д1,Д2
    private final SelenideElement useD1D2 = $x("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");
    private final SelenideElement d1Input = $x("//input[@id='d1-cmxCheckboxInput-id']");
    private final SelenideElement d2Input = $x("//input[@id='d2-cmxCheckboxInput-id']");

    //Кнопки нижней формы
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]/../..//button");
    private final SelenideElement history = $x("//button[@id='businessAudit-button-id']");
    private final SelenideElement cancel = $x("//button[@id='cancel-button-id']");

    //Кнопки диалога сохранения
    private final SelenideElement dialogExit = $x("//button[@id='exit-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement continueWithCurrentContract = $x("//button[@id='continueWithCurrentContract-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement continueWithNewContract = $x("//button[@id='continueWithNewContract-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement saveDialog = $x("//*[normalize-space(text()) = 'Операция успешно сохранена!']");//диалог сохранения

    public void createClientOper() {
        goToOperClientForm();
        addOperation();
        getPDForOper();
        fillIncomeInfo(CLIENTSUMMA);
        assertCurrencyCurrencyInput();
        fillClientTaxDate();
        saveOper();
    }

    public void createContractorOper() {
        goToOperContractorForm();
        addOperation();
        getPDForOper();
        fillIncomeInfo(CONTR_SUMM);
        fillTaxKind();
        assertCurrencyCurrencyInput();
        fillTaxDate();
        fillContractorTaxSumm(CONTR_TAXSUMM);
        saveOperContract();
    }

    public void createDepoOper() {
        goToOperDepositoryForm();
        addOperation();
        getPDForOper();
        fillIncomeInfo(DEPO_SUMM);
        assertCurrencyCurrencyInput();
        fillTaxDate();
        saveOper();
    }

    //Выбрать ПД для операции
    public void getPDForOper() {
        ActionsIF.fillInputAndSelect(selectClient, CLIENT_NAME, client);
        addCrtDateFrom.sendKeys(ClientConfigs.CLIENT_PDdate);
        addCrtCreateDateFrom.sendKeys(DateHelper.factDate());
        searchPDButton.click();
        choosePDclient.click();
        choosePDButton.click();
    }

    //заполнить поля сообщения ( клиента/депо)
    public void fillMessageInfo() {
        messageDate.sendKeys();
        messageNumber.sendKeys();
    }

    public void fillCurrency() {
        ActionsIF.fillInputAndSelect(currencyIncomeInput, CLIENT_CURRENCY_NUM, currency);
    }

    //проверить, что валюта налога - рубли.
    public void assertCurrencyCurrencyInput() {
        assertTrue(currencyTaxInput.getAttribute("value").contains("Российские рубли"));
    }

    //заполнить сумму и дату дохода
    public void fillIncomeInfo(String summa) {
        incSummInput.sendKeys(summa);
        incDateInput.sendKeys(ClientConfigs.OPER_INDATE);
    }

    //заполнить Вид налога ( для КА)
    public void fillTaxKind() {
        taxKindDropdown.click();
        selectTaxKind.click();
    }

    //заполнение дат налога и проверка автозаполнения для клиентских операций
    public void fillClientTaxDate() {
        taxDateInput.sendKeys(OPER_TAXDATE);
        assertEquals(calcDateInput.getAttribute("value"), ClientConfigs.OPER_CALCDATE);
        assertEquals(budgDateInput.getAttribute("value"), ClientConfigs.OPER_BUDGET);
    }

    //заполнить дату налога (депо/КА)
    public void fillTaxDate() {
        taxDateInput.sendKeys(OPER_TAXDATE);
    }

    public void fillIssuer() {

    }

    //Заполнить сумму налога операции контрагента
    public void fillContractorTaxSumm(String taxSumma) {
        taxSumInputRub.sendKeys(taxSumma);
    }

    public void saveOper() {
        incSummInput.click();
        focusAndPush(saveButton);
        assertTrue(elementIsVisible(saveDialog));
        dialogExit.click();
    }

    public void saveOperContract() {
        incSummInput.click();
        focusAndPush(saveButton);
        assertTrue(elementIsVisible(saveDialog));
        dialogExit.click();
    }

    public void assertTaxFieldForZeroRate() {
        incSummInput.click();
        assertEquals("0", taxSumInputRub.getAttribute("value"));
        assertEquals("0", taxSumInput.getAttribute("value"));
    }

    public void d1d2AssertTaxFields() {
        focusAndPush(useD1D2);
        d1Input.sendKeys("11");
        d2Input.sendKeys("9.65");
        assertEquals("19", taxSumInputRub.getAttribute("value"));
    }

    //Сохранить операцию и продолжить тем же ПД
    public void saveOperStreamSamePD() {
        continueWithCurrentContract.click();
    }

    //Сохранить операцию и продолжить с новым ПД
    public void saveOperStreamNewPD() {
        continueWithNewContract.click();
    }

    //переход на формы операций.
    public void goToOperClientForm() {
        sectionOper.click();
        sectionOperClient.click();
        Assert.assertTrue(elementIsVisible(sectionOperClientAssert));
    }

    public void goToOperContractorForm() {
        sectionOper.click();
        sectionOperContractor.click();
        Assert.assertTrue(elementIsVisible(sectionOperContractorAssert));
    }

    public void goToOperDepositoryForm() {
        sectionOper.click();
        sectionOperDepo.click();
        Assert.assertTrue(elementIsVisible(sectionOperDepoAssert));
    }

    //добавить операцию
    public void addOperation() {
        addButton.click();
    }

}

