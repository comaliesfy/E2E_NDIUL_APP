package ru.stqa.ptf.pages.certificates;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ClientConfigs.*;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;

public class Certificates {

    private final SelenideElement certificateButton = $x("//span[contains(text(),'Сертификаты')]");
    private final SelenideElement assertCertificateDate = $x("//input[@id='certificateDate-id']");
    private final SelenideElement assertCertificateName = $x("//input[@id='number-input-id']");

    private final SelenideElement assertCertificateWindow = $x("//span[contains(text(),'Сертификаты')]");
    private final SelenideElement assertCertificateWindowDF = $x("//span[contains(text(),'Данные сертификата')]");
    private final SelenideElement addCert = $x("//mat-icon[contains(text(),'add_circle')]");
    private final SelenideElement editCert = $x("//mat-icon[contains(text(),'edit')]");
    private final SelenideElement deleteCert = $x("//mat-icon[contains(text(),'delete')]");
    private final SelenideElement certificateNumber = $x("//div[@class='row']//input[@id='certificateNumber-textInput-id']");
    private final SelenideElement certificateDate = $x("//input[@id='certificateDate-textInput-id']");
    private final SelenideElement certificateEndDate = $x("//input[@id='certificateEndDate-textInput-id']");

    //сообщения формы
    private final SelenideElement certificateWarning = $x("//span[contains(text(),'Предупреждение')]");
    private final SelenideElement certificateError = $x("//span[contains(text(),'Ошибка')]");
    private final SelenideElement certificateDeleteMessage = $x("//span[contains(text(),'Сертификат удалён')]");

    //закрыть сообщение
    private final SelenideElement certificateMessageClose = $x("//cmx-simple-dialog[@id='notification-component-dialog_Id']//div[@class='cmx-simple-dialog-component_close_button ng-star-inserted']");

    //сертификат
    private final SelenideElement certificateEntity = $x("//span[contains(text(),'" + CERTNUM + "')]");
    private final SelenideElement certificateClose = $x("//div[@class='cmx-simple-dialog-component_close_button ng-star-inserted']");// крестик окна
    private final SelenideElement certificateDFClose = $x("//cmx-modal-dialog[@id='certificateDetails-modalDialog-id']//div[@class='cmx-simple-dialog-component_close_button ng-star-inserted']");

    //номер и дата сертификата на форме "Физ.лица"
    private final SelenideElement fieldCertNameNP = $x("//input[@id='certificateNumber-textInput-id']");
    private final SelenideElement fieldCertDateNP = $x("//input[@id='certificateDate-datepickerInput-id']");

    //Номер и дата сертификата на форме "нерезиденты"
    private final SelenideElement fieldCertNameNonres = $x("//input[@id='number-input-id']");
    private final SelenideElement fieldCertDateNonres = $x("//input[@id='certificateDate-id']");


    public void createCertificate() {
        certificateButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertCertificateWindow));
        addCert.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertCertificateWindowDF));
        certificateNumber.sendKeys(CERTNUM);
        certificateDate.sendKeys(CERT_FROM_DATE);
        certificateEndDate.sendKeys(CERT_TO_DATE);
        clickOKButton();//сохранение
        Assert.assertTrue(GridHelpers.elementIsVisible(certificateEntity));
        certificateClose.click();
    }

    //после создания основной записи сертификата
    public void checkMessageSameName() {
        certificateButton.click();
        addCert.click();
        certificateNumber.sendKeys(CERTNUM);
        Assert.assertTrue(GridHelpers.elementIsVisible(certificateWarning));
        closeMessageAndForm();
    }

    //после создания основной записи сертификата
    public void checkMessageSameDate() {
        certificateButton.click();
        addCert.click();
        certificateDate.sendKeys(CERT_NEW_DATE);
        certificateEndDate.sendKeys(CERT_TO_DATE);
        certificateNumber.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(certificateError));
        closeMessageAndForm();
    }

    //после создания основной записи сертификата
    public void checkMessageWrongDate() {
        certificateButton.click();
        addCert.click();
        certificateDate.sendKeys(CERT_TO_DATE);
        certificateEndDate.sendKeys(CERT_NEW_DATE);
        certificateNumber.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(certificateError));
        closeMessageAndForm();
    }

    public void deleteCertificate() {
        certificateButton.click();
        certificateEntity.click();
        deleteCert.click();
        clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(certificateDeleteMessage));
        Assert.assertFalse(GridHelpers.elementIsVisible(certificateEntity));
        clickOKButton();
    }

    private void closeMessageAndForm() {
        certificateMessageClose.click();
        certificateDFClose.click();
        certificateClose.click();
    }

    public void checkCertOnFormNP() {
        Assert.assertEquals(CERT_FROM_DATE, fieldCertDateNP.getAttribute("value"));
        Assert.assertEquals(CERTNUM, fieldCertNameNP.getAttribute("value"));
    }

    public void checkCertOnFormNonres() {
        Assert.assertEquals(CERT_FROM_DATE, fieldCertDateNonres.getAttribute("value"));
        Assert.assertEquals(CERTNUM, fieldCertNameNonres.getAttribute("value"));
    }
}

