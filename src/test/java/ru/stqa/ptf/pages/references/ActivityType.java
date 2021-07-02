package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import static Configs.ReferencesConfig.ACTTYPE_CODE;
import static Configs.ReferencesConfig.ACTTYPE_NAME;
import static com.codeborne.selenide.Selenide.$x;
import static ru.stqa.ptf.helpers.Buttons.clickOKButton;
import static ru.stqa.ptf.helpers.Buttons.openSectionReferencesBook;

public class ActivityType {
    private final SelenideElement sectionActivityTypes = $x( "//a[@id='directory/activityTypes']");
    private final SelenideElement addButton = $x("//button[@id='add-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement codeInput = $x("//input[@id='code']");
    private final SelenideElement nameInput = $x("//input[@id='name']");
    private final SelenideElement saveButton = $x("//button/..//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//button/..//span[contains(text(),'Выход')]");
    private final SelenideElement deleteButton = $x("//button[@id='delete-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement assertActType = $x("//td[@id='/" + ACTTYPE_CODE + "']");

    @Test
    public void activityTypeCreate() {
        openSectionReferencesBook();
        sectionActivityTypes.click();
        addButton.click();
        codeInput.sendKeys(ACTTYPE_CODE);
        nameInput.sendKeys(ACTTYPE_NAME);
        saveButton.click();
        Assert.assertTrue(assertActType.isDisplayed());
    }

    @Test
    public void activityTypeFilterDelete() {
        assertActType.click();
        deleteButton.click();
        clickOKButton();
    }
}
