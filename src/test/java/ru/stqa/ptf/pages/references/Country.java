package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Country {

    private final SelenideElement sectionCountry = $x( "//a[@id='directory/countries/grid']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Страны')]");
    private final SelenideElement createButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement historyButton = $x("//button[@id='listBusinessAudit-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    private final SelenideElement entity = $x("//td[@id='/Acountry']");

    //Детальная форма
    private final SelenideElement nameInput = $x("//input[@id='countryName']");
    private final SelenideElement code3Input = $x("//input[@id='countryCode3']");
    private final SelenideElement code2Input = $x("//input[@id='countryCode2']");
    private final SelenideElement freeCheckBox = $x("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");
    private final SelenideElement deleteMessage = $x(" //span[contains(text(),'Запись о Стране из справочника успешно удалена.')]");

    public void goToCountry() {
        Buttons.openSectionReferencesBook();
        sectionCountry.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void createCountry() {
        createButton.click();
        nameInput.sendKeys("Acountry");
        code2Input.sendKeys("AA");
        code3Input.sendKeys("159");
        freeCheckBox.click();
        saveButton.click();
    }

    public void deleteCountry() {
        entity.click();
        deleteButton.click();
        Buttons.clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        Buttons.clickOKButton();
        Assert.assertFalse(GridHelpers.elementIsVisible(entity));
    }
}
