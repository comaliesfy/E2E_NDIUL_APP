package ru.stqa.ptf.pages.dedublication;

import Configs.ClientConfigs;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Dedublication {
    private WebDriver driver;
    //принудительное слияние
    private final SelenideElement addToSimileButton = $x("//div[contains(text(),'Добавить к сравнению')]");
    private final SelenideElement simileButton = $x("//div[contains(text(),'Сравнить')]");
    private final SelenideElement functionButton = $x("//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']");
    private final SelenideElement clearFunctionButton = $x("//button[contains(text(),'Очистить')]");
    private final SelenideElement simileFunctionButton = $x("//button[contains(text(),'Сравнить')]");
    private final SelenideElement countOfEntityToSimile = $x("//cmx-button[@id='duplicates-add-to-compare-button-id']//span[@class='mat-badge-content mat-badge-active']");
    //Окно сравнения записей
    private final SelenideElement assertSimileDF = $x("//span[contains(text(),'Сравнение записей')]");
    //Форма записи 1
    private final SelenideElement entityOneCheckbox = $x("//cmx-duplicates-compare-client-details[@id='duplicates-compare-client-details-first_Id']//mat-checkbox//input");
    private final SelenideElement entityOneName = $x("//input[@id='duplicates-compare-details-clNameLat-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneCountry = $x("//input[@id='duplicates-compare-details-clCnt-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneType = $x("//input[@id='duplicates-compare-details-clType-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneINN = $x("//input[@id='duplicates-compare-details-clInn-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneINNRUS = $x(" //input[@id='duplicates-compare-details-clInnRf-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneSWIFT = $x(" //input[@id='duplicates-compare-details-clSwift-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneKIO = $x("//input[@id='duplicates-compare-details-clKio-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneKPP = $x("//input[@id='duplicates-compare-details-clKpp-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneAddress = $x(" //input[@id='duplicates-compare-details-clAddress-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOnePD = $x("//input[@id='duplicates-compare-details-clCrtCnt-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneOper = $x("//input[@id='duplicates-compare-details-clOpCnt-id_duplicates-compare-client-details-first_Id']");
    private final SelenideElement entityOneString = $x("//cmx-duplicates-compare-client-details[@id='duplicates-compare-client-details-first_Id']//input");
    private final SelenideElement entityTwoString = $x("//cmx-duplicates-compare-client-details[@id='duplicates-compare-client-details-second_Id']//input");

    //Форма Записи 2
    private final SelenideElement entityTwoCheckbox = $x("//cmx-duplicates-compare-client-details[@id='duplicates-compare-client-details-second_Id']//mat-checkbox//input");
    private final SelenideElement entityTwoName = $x("//input[@id='duplicates-compare-details-clNameLat-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoCountry = $x(" //input[@id='duplicates-compare-details-clCnt-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoType = $x("//input[@id='duplicates-compare-details-clType-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoINN = $x( "//input[@id='duplicates-compare-details-clInn-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoINNRUS = $x("//input[@id='duplicates-compare-details-clInnRf-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoSWIFT = $x("//input[@id='duplicates-compare-details-clSwift-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoKIO = $x("//input[@id='duplicates-compare-details-clKio-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoKPP = $x( "//input[@id='duplicates-compare-details-clKpp-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoAddress = $x("//input[@id='duplicates-compare-details-clAddress-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoPD = $x(" //input[@id='duplicates-compare-details-clCrtCnt-id_duplicates-compare-client-details-second_Id']");
    private final SelenideElement entityTwoOper = $x("//input[@id='duplicates-compare-details-clOpCnt-id_duplicates-compare-client-details-second_Id']");
    //Кнопки
    private final SelenideElement notSimileButton = $x("//div[@class='relative']//span[@class='mat-button-wrapper']");
    private final SelenideElement mergeButton = $x("//span[contains(text(),'Объединить')]");
    private final SelenideElement exitWindowButton = $x("//button[@id='simple-dialog_cancelBtn_Id']//span[@class='mat-button-wrapper']");
    private final SelenideElement assertConfirmDialog = $x("//span[contains(text(),'Вы уверены')]");//Диалог подтврежедния объединения
    private final SelenideElement okButton = $x("//cmx-simple-dialog[@id='removeOperation-cmxSimpleDialog-id']//cmx-button[@id='simple-dialog_OkBtn_Id']//span[@class='mat-button-wrapper']");//Подтрвеждние объединения
    private final SelenideElement assertConfirmMessage = $x("//div[@class='stretch display-table-cell cmx-notification-component_body_message']");//Сообщение о слиянии

    public void addToSimile(WebElement locator1, WebElement locator2) {
        locator1.click();
        addToSimileButton.click();
        Assert.assertEquals("1", countOfEntityToSimile.getText());
        locator2.click();
        addToSimileButton.click();
        Assert.assertEquals("2", countOfEntityToSimile.getText());
    }

    public void clearSimileInFunctionMenu() {
        functionButton.click();
        clearFunctionButton.click();
        Assert.assertEquals("", countOfEntityToSimile.getText());
    }

    public void simileInFunctionMenu() {
        functionButton.click();
        simileFunctionButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSimileDF));
    }

    public void simileByButton() {
        simileButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSimileDF));
    }

    public void closeSimileWindow() {
        exitWindowButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertSimileDF));
    }

    public void checkFields() {
        Assert.assertEquals(ClientConfigs.CLIENT_NAME, entityOneName.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.CLIENT_COUNTRY, entityOneCountry.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.CLIENT_BANK, entityOneType.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.CLIENT_INN, entityOneINN.getAttribute("value"));
        Assert.assertEquals("1", entityOnePD.getAttribute("value"));
        Assert.assertEquals("1", entityOneOper.getAttribute("value"));

        Assert.assertEquals(ClientConfigs.DEDUB_CLIENT_NAME, entityTwoName.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.DEDUB_CLIENT_COUNTRY, entityTwoCountry.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.CLIENT_BANK, entityTwoType.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.DEDUB_CLIENT_INN, entityTwoINN.getAttribute("value"));
        Assert.assertEquals(ClientConfigs.DEDUB_CLIENT_SWIFT, entityTwoSWIFT.getAttribute("value"));
    }

    public void chooseNote2() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", entityTwoCheckbox);
        Assert.assertFalse(entityOneName.isEnabled());
        Assert.assertFalse(entityOneCountry.isEnabled());
        Assert.assertFalse(entityOneType.isEnabled());
        Assert.assertFalse(entityOneINN.isEnabled());
        Assert.assertFalse(entityOneINNRUS.isEnabled());
        Assert.assertFalse(entityOneSWIFT.isEnabled());
        Assert.assertFalse(entityOneKIO.isEnabled());
        Assert.assertFalse(entityOneKPP.isEnabled());
        Assert.assertFalse(entityOneAddress.isEnabled());
    }

    public void mergeEntities() {
        mergeButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertConfirmDialog));
        okButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertConfirmMessage));
        Assert.assertTrue(assertConfirmMessage.getText().contains(ClientConfigs.DEDUB_CLIENT_NAME));
        Buttons.clickOKButton();
    }

    public void notASimile() {
        notSimileButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertSimileDF));
    }
}


