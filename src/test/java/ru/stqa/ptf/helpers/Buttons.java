
package ru.stqa.ptf.helpers;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class Buttons {

    private static final SelenideElement okButton = $x("//button[@id='simple-dialog_OkBtn_Id']");
    private static final SelenideElement cancelButton = $x("//button[@id='simple-dialog_cancelBtn_Id']");
    public static final SelenideElement spinner = $x("//div[@class='row col-md-12']//div//pd-table//img[@class='cmx-spinner_gif']");
    private static final SelenideElement sectionReferencesBook = $x("//button[@id='reference-books']");

    public static void openSectionReferencesBook() {
        sectionReferencesBook.click();
    }

    public static void clickOKButton() {
        okButton.click();
    }

    public static void clickCancelButton() {
        cancelButton.click();
    }

    public static void checkButtonIsActive(SelenideElement locator) {
        Assert.assertNull(locator.getAttribute("disabled"));
        //null - активна
        //true - неактивна
    }

}