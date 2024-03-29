package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class DepartmentSB {

    private final SelenideElement sectionDepartment = $x("//a[@id='directory/osb']");
    private final SelenideElement assertSection = $x("//label[contains(text(),'Подразделение СБ: ')]");
    private final SelenideElement codeInput = $x("//input[@placeholder='код']");
    private final SelenideElement code = $x("//div[@id='123']");
    private final SelenideElement departmentInput = $x("//autocomplete-dropdown[@id='depSelect-autocomplete-id']//input[@placeholder='подразделение']");
    private final SelenideElement department = $x("//div[@id='108633']");

    private final SelenideElement entityAssert = $x("//td[@id='/РЦС ВОНУиФО г. Новосибирск']");
    private final SelenideElement searchButton = $x("//button[@id='search-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//button[@id='reset-button-id']//span[@class='mat-button-wrapper']");


    public void goToReferencePage() {
        Buttons.openSectionReferencesBook();
        sectionDepartment.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void findDepartmentEntity() {
        GridHelpers.sendCharKeys("123",codeInput,code);
        GridHelpers.sendCharKeys("108633",departmentInput,department);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(entityAssert));
    }
}
