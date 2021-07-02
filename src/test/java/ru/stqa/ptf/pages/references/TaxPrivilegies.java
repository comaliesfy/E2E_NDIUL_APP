package ru.stqa.ptf.pages.references;

import Configs.ReferencesConfig;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class TaxPrivilegies {
    private final SelenideElement sectionTaxPrivilegies = $x("//a[@id='directory/taxPrivilegies']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Налоговые льготы')]");
    //кнопки СФ
    private final SelenideElement addButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    ///инпуты ДФ
    private final SelenideElement fullNameInput = $x("//input[@id='fullName-input-id']");
    private final SelenideElement shortNameInput = $x("//input[@id='shortName-input-id']");
    private final SelenideElement numberOfTaxPrivilegies = $x("//input[@id='order-input-id']");
    //кнопки ДФ
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x( "//span[contains(text(),'Выход')]");
    //сама запись
    private final SelenideElement assertTaxPrivilege = $x("//td[@id='/" + ReferencesConfig.TAXPR_FULLNAME + "']");

    public void taxPrivilegesCreate() {
        openSectionReferencesBook();
        sectionTaxPrivilegies.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        addButton.click();
        fullNameInput.sendKeys(ReferencesConfig.TAXPR_FULLNAME);
        shortNameInput.sendKeys(ReferencesConfig.TAXPR_SHORTNAME);
        numberOfTaxPrivilegies.sendKeys("14");
        saveButton.click();
    }

    public void taxPrivilegesFilter() {
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        Assert.assertTrue(GridHelpers.elementIsVisible(assertTaxPrivilege));
    }

    public void taxPrivilegesDelete() {
        assertTaxPrivilege.click();
        deleteButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertTaxPrivilege));
    }
}
