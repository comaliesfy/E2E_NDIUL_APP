package ru.stqa.ptf.pages.operationDownloads;

import Configs.ClientConfigs;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.CreateUploadOperFile;
import ru.stqa.ptf.helpers.GridHelpers;

import java.io.IOException;
import java.util.List;

import static Configs.ConfigsForSearchForm.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.DateHelper.dateForUpload;
import static ru.stqa.ptf.helpers.FieldValidation.checkBoxIsOn;
import static ru.stqa.ptf.helpers.GridHelpers.elementIsVisible;
import static ru.stqa.ptf.helpers.GridHelpers.focusAndPush;

public class DownloadForm {

    private final SelenideElement sectionDownloads = $x("//button[contains(text(),'Загрузки')]");
    private final SelenideElement sectionClientDownload = $x("//a[contains(text(),'Загрузка операций клиента')]");
    private final SelenideElement sectionContractorDownload = $x("//a[contains(text(),'Загрузка операций контрагента')]");
    private final SelenideElement sectionDepositoryDownload = $x("//a[contains(text(),'Загрузка операций депозитария')]");
    private final SelenideElement sectionDownloadAssert = $x("//h4[contains(text(),'Список загруженных файлов')]");
    private final SelenideElement clientDownloadButton = $x("//input[@id='clientFileUpload-input-id']");
    private final SelenideElement contractorDownloadButton = $x("//input[@id='contractorFileUpload-input-id']");
    private final SelenideElement depositoryDownloadButton = $x("//input[@id='depositoryFileUpload-input-id']");
    private final SelenideElement deleteButton = $x("//mat-icon[contains(text(),'delete')]");
    private final SelenideElement filterButton = $x("//mat-icon[contains(text(),'filter_list')]");
    //Поля фильтров
    private final SelenideElement filterFileName = $x("//input[@name='name-operation-upload-file-name-input']");
    private final SelenideElement filterUserClient = $x("//input[@name='name-user']");
    private final SelenideElement filterUploadDateFrom = $("input[name='name-operation-upload-date-from-input-filter']");
    private final SelenideElement filterUploadDateTo = $("input[name='name-operation-upload-date-from-input-filter']");
    //клиент
    private final SelenideElement filterClient = $x("//input[@id='client-autocompleteInput-id']");
    private final SelenideElement label = $x("//label[@class='stretch cmx-autocomplete-input_option_label']"); // для выбора из списка
    //Поля фильтров-Контрагенты
    private final SelenideElement filterCont = $x(" //input[@id='contractor-autocompleteInput-id']");
    //Поля фильтров-Депозитарии
    private final SelenideElement filterDeponent = $x("//input[@id='depository-autocompleteInput-id']");
    private final SelenideElement filterIssuer = $x("//autocomplete-dropdown[@id='depoIssuer-autocompleteDropdown-id']//input");
    //Дейтпикеры
    private final SelenideElement filterDepoIncDateFrom = $x("//input[@id='depoIncomeDateFrom-filter-id']");
    private final SelenideElement filterDepoIncDateTo = $x("//input[@id='depoIncomeDateTo-filter-id']");
    private final SelenideElement filterDepoTaxDateFrom = $x("//input[@id='depoTaxDateFrom-filter-id']");
    private final SelenideElement filterDepoTaxDateTo = $x("//input[@id='depoTaxDateTo-filter-id']");
    //Кнопки
    private final SelenideElement searchButton = $x("//button[@id='apply-button']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//button[@id='clear-button']//span[@class='mat-button-wrapper']");

    private final SelenideElement checkBoxEntity = $x("//span[contains(text(),'" + ClientConfigs.CLIENT_NAME + "')]/../../..//mat-checkbox");
    private final SelenideElement checkBoxPush = $x("//span[contains(text(),'" + ClientConfigs.CLIENT_NAME + "')]/../../..//mat-checkbox//label//div");// ПЕРЕПИСАТЬ

    private final SelenideElement successMessage = $x("//span[contains(text(),'Успешно!')]");
    private final SelenideElement spinner = $x("img[@class='cmx-spinner_gif']");
    private final SelenideElement emptyGrid = $x("//div[@class='empty-row ng-star-inserted']");

    public void openClientDownloadForm() {
        sectionDownloads.click();
        sectionClientDownload.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(sectionDownloadAssert));
    }

    public void openContractorDownloadForm() {
        sectionDownloads.click();
        sectionContractorDownload.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(sectionDownloadAssert));
    }

    public void openDepositoryDownloadForm() {
        sectionDownloads.click();
        sectionDepositoryDownload.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(sectionDownloadAssert));
    }

    public void checkDropDownFilter(SelenideElement locator, String value, int rowNum) {
        filterButton.click();
        resetButton.click();
        ActionsIF.fillInputAndSelect(locator, value, label);
        searchButton.click();
        assertFindResultsForValue(value, rowNum);
    }

    private void assertFindResultsForValue(String cellName, Integer rowNum) {
        List<SelenideElement> rows = $$x("//div[@class='datatable-row-center datatable-row-group ng-star-inserted']");
        List<SelenideElement> cells = $$x("//datatable-body-row//datatable-body-cell[" + rowNum + "]//span[contains(text(),'" + cellName + "')]");
        assertEquals(rows.size(), cells.size());
    }

    public void checkFileNameFilter(String filename) {
        filterButton.click();
        resetButton.click();
        filterFileName.sendKeys(filename);
        searchButton.click();
        assertFindResultsForValue(filename, 3);
    }

    public void checkUserNameFilter(int rowNum) {
        checkDropDownFilter(filterUserClient, UPLOADS_USER, rowNum);
    }

    public void checkClientNameFilter() {
        checkDropDownFilter(filterClient, UPLOADS_CLIENT, 4);
    }

    public void checkContNameFilter() {
        checkDropDownFilter(filterCont, UPLOADS_CLIENT, 4);
    }

    public void checkDepoNameFilter() {
        checkDropDownFilter(filterDeponent, UPLOADS_DEPO, 4);
    }

    public void checkIssueNameFilter() {
        checkDropDownFilter(filterIssuer, UPLOADS_ISSUE, 5);
    }

    public void findFileClient() {
        filterButton.click();
        resetButton.click();
        filterFileName.sendKeys("Реестр операций клиентов-" + dateForUpload());
        searchButton.click();
        checkBoxEntity.shouldBe(Condition.visible);
    }

    public void findFileCont() {
        filterButton.click();
        resetButton.click();
        filterFileName.sendKeys("Operations CA_" + dateForUpload());
        searchButton.click();
        checkBoxEntity.shouldBe(Condition.visible);
    }

    public void findFileDepo() {
        filterButton.click();
        resetButton.click();
        filterFileName.sendKeys("DEPO_autotests_" + dateForUpload());
        searchButton.click();
        checkBoxEntity.shouldBe(Condition.visible);
    }

    public void deleteUploadFile() {
        pushCheckBox();
        deleteButton.click();
        clickOKButton();
    }

    public void pushCheckBox() {
        checkBoxEntity.shouldBe(Condition.visible);
        while (!checkBoxIsOn(checkBoxEntity)) {
            try {
                focusAndPush(checkBoxPush);

            }
            catch (Exception e) {
            }
        }
    }

    public void uploadFileClient() throws IOException {
        CreateUploadOperFile.createFileWithOperations();
        clientDownloadButton.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads\\DownloadClient\\Реестр операций клиентов-" + dateForUpload() + ".xlsx");
        clickOKButton();
        spinner.waitWhile(Condition.exist,12000);
        successMessage.shouldBe(Condition.appears);
        assertTrue(successMessage.exists());
        clickOKButton();
    }

    public void uploadFileContractor() throws IOException {
        CreateUploadOperFile.createFileWithOperationsContractor();
        contractorDownloadButton.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads\\DownloadContractor\\Operations CA_" + dateForUpload() + ".xlsx");
        clickOKButton();
        spinner.waitWhile(Condition.exist,12000);
        successMessage.shouldBe(Condition.appears);
        assertTrue(successMessage.exists());
        clickOKButton();
    }

    public void uploadFileDepository() throws IOException {
        CreateUploadOperFile.createFileWithOperationsDepo();
        depositoryDownloadButton.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Downloads\\DownloadDepository\\DEPO_autotests_" + dateForUpload() + ".xlsx");
        clickOKButton();
        spinner.waitWhile(Condition.exist,12000);
        successMessage.shouldBe(Condition.appears);
        assertTrue(successMessage.exists());
        clickOKButton();
    }
}
