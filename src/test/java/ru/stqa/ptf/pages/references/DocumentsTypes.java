package ru.stqa.ptf.pages.references;

import Configs.ReferencesConfig;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class DocumentsTypes {

    private final SelenideElement sectionDocTypes = $x("//a[@id='directory/primaryDocumentsTypes']");
    private final SelenideElement assertSF = $x("//h4[contains(text(),'Список заведенных «Типов первичных документов»')]");
    private final SelenideElement addButton = $x("//span[contains(text(),'Добавить запись')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),'Удалить запись')]");
    private final SelenideElement saveButton = $x("//span[contains(text(),' Сохранить ')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),' Выход ')]");
    private final SelenideElement assertDocType = $x("//td[@id='/" + ReferencesConfig.DOCTYPE_NAME + "']");
    private final SelenideElement nameInput = $x("//input[@id='name-input-id']");
    private final SelenideElement severalOperationBox = $x(" //input[@id='several-operations-input-id']");


    public void docTypesCreate() {
        Buttons.openSectionReferencesBook();
        sectionDocTypes.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSF));
        addButton.click();
        nameInput.sendKeys(ReferencesConfig.DOCTYPE_NAME);
        severalOperationBox.click();
        saveButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertDocType));
    }

    public void docTypesDelete() {
        assertDocType.click();
        deleteButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertDocType));
    }
}