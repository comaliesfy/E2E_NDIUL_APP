package ru.stqa.ptf.pages.declaration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.GridHelpers.elementIsVisible;

public class KND24 {
    //Вкладки
    private final SelenideElement assertDFForm = $x("//h4[contains(text(),'Сведения о декларации')]");
    private final SelenideElement assertDocTab = $x("//div[contains(text(),'Документы')]");
    private final SelenideElement assertRepresentationTab = $x("//div[contains(text(),'Доходы и расхо')]");
    //Кнопки верхнего раздела
    private final SelenideElement acceptButton = $x(" //span[contains(text(),'Принять')]");
    private final SelenideElement sendButton = $x("//span[contains(text(),'Отправить')]");
    private final SelenideElement returnButton = $x("//span[contains(text(),'Вернуть в работу')]");

    private final SelenideElement newReportButton = $x("//span[contains(text(),'Уточнить расчет')]");
    //Статусы
    private final SelenideElement statusField = $x("(//label[contains(text(),'Статус:')]/../..//label[@class='cmx-label-info'])[1]");
    private final SelenideElement statusEDFiled = $x("(//label[contains(text(),'Статус ЭД:')]/../..//label[@class='cmx-label-info'])[1]");
    private final SelenideElement statusEditEDFiled = $x("//label[@class='stretch cmx-action-input_label']");
    private final SelenideElement statusEDFormed = $x("//label[contains(text(),'Сформирован')]");
    //кнопки нижнего меню
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement historyButton = $x("//span[contains(text(),'История изменений')]");
    private final SelenideElement exportButton = $x("//span[contains(text(),'Выгрузить в Excel')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");
    //Спиннеры и сообщения
    private final SelenideElement progressBar = $x("//div[@class='container']");
    private final SelenideElement spinner = $x("//img[@class='cmx-wait-dialog-component_gif']");   //// ПОМЕНЯТЬ НА БАТТОН
    private final SelenideElement infMessage = $x("//span[contains(text(),'Изменения успешно сохранены')]");
    //Документы
    private final SelenideElement downloadTXT = $x("//span[contains(text(),'Транспортный файл TXT')]/../../..//span[contains(text(),'Скачать')]");
    private final SelenideElement downloadPDF = $x("//span[contains(text(),'Декларация в PDF')]/../../..//span[contains(text(),'Скачать')]");
    private final SelenideElement reloadDocs = $x("//span[contains(text(),'Обновить')]");
    //Строки в таблицах
    private final SelenideElement clientTableResult = $x("//cmx-declarations-24-clients-table//datatable-row-wrapper");
    private final SelenideElement operationTableResult = $x("//cmx-declarations-24-operations-table//datatable-row-wrapper");
    private final SelenideElement incomeFdeptTableResult = $x("//cmx-declarations-24-fdept-incomes//datatable-row-wrapper");
    private final SelenideElement expensesFdeptTableResult = $x("//cmx-declarations-24-fdept-expenses//datatable-row-wrapper");

    public void saveKND24() {
        saveButton.click();
        infMessage.shouldBe(Condition.visible);
        clickOKButton();
        assertTrue(elementIsVisible(assertDocTab));
        statusEDFormed.waitUntil(appear, 5000);
        statusEDFormed.shouldBe(Condition.visible);
        assertEquals("Рассчитана", statusField.getAttribute("innerText"));
        assertEquals("Сформирован", statusEDFiled.getAttribute("innerText"));
    }

    public void uploadDeclFiles() {
        downloadTXT.click();
        downloadPDF.click();
    }

    public void acceptKND56() {
        acceptButton.click();
        assertEquals("Принята", statusField.getAttribute("innerText"));
        assertEquals(" Готов к отправке ", statusEditEDFiled.getAttribute("innerText"));
    }

    public void backKND24() {
        acceptButton.click();
        assertEquals("Возвращена", statusField.getAttribute("innerText"));
        assertEquals(" Готов к отправке ", statusEditEDFiled.getAttribute("innerText"));
    }

    public void sendKND24() {
        sendButton.click();
        infMessage.shouldBe(Condition.visible);
        clickOKButton();
        assertEquals("Принята", statusField.getAttribute("innerText"));
        assertEquals(" Отправлен в ЭДО ", statusEditEDFiled.getAttribute("innerText"));
    }

}
