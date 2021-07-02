package ru.stqa.ptf.pages.declaration;

import Configs.ClientConfigs;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.stqa.ptf.helpers.Buttons;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.GridHelpers.elementIsVisible;

public class KND56 {

    private final SelenideElement assertDFForm = $x("//h4[contains(text(),'Сведения о декларации')]");
    private final SelenideElement assertDocTab = $x("//h4[contains(text(),'Документы')]");
    //Кнопки детальной формы - Верхнее меню
    private final SelenideElement calculateButton = $x("//span[contains(text(),'Рассчитать')]");
    private final SelenideElement acceptButton = $x(" //span[contains(text(),'Принять')]");
    private final SelenideElement sendButton = $x("//span[contains(text(),'Отправить')]");
    private final SelenideElement declPDFButton = $x("//span[contains(text(),'Декларация в PDF')]");
    private final SelenideElement specifyButton = $x("//span[contains(text(),'Уточнить расчет')]");
    private final SelenideElement updateButton = $x("//span[contains(text(),'Обновить')]");
    //Поля статусов
    private final SelenideElement statusField = $x("(//label[contains(text(),'Статус:')]/../..//label[@class='cmx-label-info'])[1]");
    private final SelenideElement statusEDFiled = $x("(//label[contains(text(),'Статус ЭД:')]/../..//label[@class='cmx-label-info'])[1]");
    private final SelenideElement statusEditEDFiled = $x("//label[@class='stretch cmx-action-input_label']");

    //Формирование PDF
    private final SelenideElement assertPDFwindow = $x("//span[contains(text(),'1151056 (PDF)')]");
    private final SelenideElement inputPDFclient = $x("//input[@placeholder='Все']");
    private final SelenideElement clientPDF = $x("//div[@id='" + ClientConfigs.CLIENT_NAME + "']");
    //кнопки нижнего меню
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement historyButton = $x("//span[contains(text(),'История изменений')]");
    private final SelenideElement exportButton = $x("//span[contains(text(),'Выгрузить в Excel')]");
    private final SelenideElement exitButton = $x( "//span[contains(text(),'Выход')]");
    //спиннеры и сообщения
    private final SelenideElement progressBar = $x("//div[@class='container']");
    private final SelenideElement spinner = $x("//img[@class='cmx-wait-dialog-component_gif']"); //ПОМЕНЯТЬ
    private final SelenideElement infMessage = $x("//span[contains(text(),'Изменения успешно сохранены.')]");
    private final SelenideElement okButton = $x("//button[@id='simple-dialog_OkBtn_Id']");
    private final SelenideElement cancelButton = $x("//button[@id='simple-dialog_cancelBtn_Id']");
    //Документы
    private final SelenideElement downloadXML = $x("//span[contains(text(),'Транспортный файл XML')]/../../..//span[contains(text(),'Скачать')]");
    private final SelenideElement downloadExcel = $x("//span[contains(text(),'Отчет об ошибках')]/../../..//span[contains(text(),'Скачать')]");
    private final SelenideElement downloadOperList = $x("//span[contains(text(),'Операции декларации клиентов')]/../../..//span[contains(text(),'Скачать')]");
    private final SelenideElement clientTableResult = $x("//cmx-declarations-clients-table//datatable-row-wrapper");
    private final SelenideElement operationTableResult = $x("//cmx-declarations-operations-table//datatable-row-wrapper");

    public void calculateKND56() {
        calculateButton.click();
        clientTableResult.shouldBe(Condition.visible);
        assertTrue(elementIsVisible(operationTableResult));
    }

    public void saveKND56() {
        saveButton.click();
        infMessage.shouldBe(Condition.visible);
        Buttons.clickOKButton();
        assertTrue(elementIsVisible(assertDocTab));
        statusField.waitUntil(appear, 5000);
        statusField.shouldHave(Condition.text("Сформирован"));
        assertEquals("Рассчитана", statusField.getAttribute("innerText"));
        assertEquals("Сформирован", statusEDFiled.getAttribute("innerText"));
    }

    public void uploadDeclFiles() {
        downloadXML.click();
        downloadExcel.click();
        downloadOperList.click();
    }

    //очень долгая загрузка. Не использовать метод до оптимизации
    protected void uploadPDF() {
        declPDFButton.click();
        assertTrue(assertPDFwindow.isDisplayed());
        inputPDFclient.sendKeys(ClientConfigs.CLIENT_NAME);
        clientPDF.click();
        clickOKButton();
    }

    public void acceptKND56() {
        acceptButton.click();
        assertEquals("Принята", statusField.getAttribute("innerText"));
        assertEquals(" Готов к отправке ", statusEditEDFiled.getAttribute("innerText"));
    }

    public void backKND56() {
        acceptButton.click();
        assertEquals("Возвращена", statusField.getAttribute("innerText"));
        assertEquals(" Готов к отправке ", statusEditEDFiled.getAttribute("innerText"));
    }

    public void sendKND56() {
        sendButton.click();
        assertEquals("Принята", statusField.getAttribute("innerText"));
        assertEquals(" Отправлен в ЭДО ", statusEditEDFiled.getAttribute("innerText"));
    }
}
