package ru.stqa.ptf.pages.references;

import Configs.ReferencesConfig;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.DEFR_NAME;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

//Общестрановые льготы
public class DefaultRates {
    private final SelenideElement sectionDefaultRates = $x("//a[@id='directory/params/defaultRates']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Общестрановые льготы')]");
    private final SelenideElement assertSectionDF = $x("//span[contains(text(),'Льготы НК РФ')]");
    private final SelenideElement addButton = $x("//mat-icon[contains(text(),'add_circle')]");
    private final SelenideElement editButton = $x("//mat-icon[contains(text(),'edit')]");
    private final SelenideElement deleteButton = $x("//mat-icon[contains(text(),'delete')]");
    private final SelenideElement entity = $x("//span[contains(text(),'" + DEFR_NAME + "')]");

    //Детальная форма
    private final SelenideElement rateInput = $x( "//input[@id='id-default-rates-details-rate']");
    private final SelenideElement rateInputPrint = $x("//input[@id='id-default-rates-details-rate-pdf']");
    private final SelenideElement fullName = $x("//input[@id='id-default-rates-details-full-name']");
    private final SelenideElement shortName = $x("//input[@id='id-default-rates-details-name']");

    //сообщения
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Налоговая льгота успешно удалена')]");
    private final SelenideElement checkBox = $x("//input[@id='id-default-rates-details-is-tax-agent']");

    //кейс - нельзя удалить льготу
    public void goToDefRateRef() {
        openSectionReferencesBook();
        sectionDefaultRates.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void createDefRate() {
        addButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSectionDF));
        rateInput.sendKeys(ReferencesConfig.DEFR_RATE);
        rateInputPrint.sendKeys(ReferencesConfig.DEFR_PRINT_RATE);
        fullName.sendKeys(ReferencesConfig.DEFR_NAME);
        shortName.sendKeys(ReferencesConfig.DEFR_NAME);
        clickOKButton();
    }

    public void deleteDefRate() {
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
        entity.click();
        deleteButton.click();
        clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        clickOKButton();
    }
}
