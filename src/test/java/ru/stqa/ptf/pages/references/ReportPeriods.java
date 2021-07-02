package ru.stqa.ptf.pages.references;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import static Configs.ReferencesConfig.*;
import static com.codeborne.selenide.Selenide.$x;

public class ReportPeriods {
    private WebDriver driver;


    private final SelenideElement sectionDepartment = $x("//a[@id='directory/period']");
    private final SelenideElement assertSection = $x("//h4[contains(text(),'Периоды')]");
    private final SelenideElement selectYearFilter = $x("//select[@id='yearSearch-select-id']");
    private final SelenideElement selectStatusFilter = $x("//select[@id='statusSearch-select-id']");
    private final SelenideElement selectPeriodityFilter = $x("//select[@id='perioditySearch-select-id']");
    private final SelenideElement selectPeriodFilter = $x("//select[@id='periodSearch-select-id']");

    private final SelenideElement startDatePeriodInput = $x("//input[@id='fDate-datepicker-input-id']");
    private final SelenideElement endDatePeriodInput = $x("//input[@id='ldateInput-input-id']");
    private final SelenideElement createButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement correction = $x("//span[contains(text(),' Сделать корректирующим ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),' Удалить запись ')]");
    private final SelenideElement searchButton = $x("//button[@id='search-button-id']//span[@class='mat-button-wrapper']");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");
    private final SelenideElement openClosePeriod = $x("//span[@class='ui-menuitem-text']");
    private final SelenideElement assertStatusEntity = $x("//tbody[@class='ui-table-tbody']//tr//td[4]");
    private final SelenideElement entity = $x(" //td[@id='/" + RP_REPORT_PERIOD + "']");
    //Детальная форма
    private final SelenideElement selectYear = $x("//select[@id='year-select-id']");
    private final SelenideElement selectStatus = $x("//select[@id='status-select-id']");
    private final SelenideElement selectPeriodity = $x("//select[@id='periodity-select-id']");
    private final SelenideElement selectPeriod = $x("//select[@id='period-select-id']");
    private final SelenideElement startDateInput = $x("//input[@id='fDate-input-id']");
    private final SelenideElement endDateInput = $x("//input[@id='ldate-input-id']");
    private final SelenideElement saveButton = $x("//span[contains(text(),'Сохранить')]");
    private final SelenideElement exitButton = $x("//span[contains(text(),'Выход')]");

    public void goToReferenceBook() {
        Buttons.openSectionReferencesBook();
        sectionDepartment.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void createPeriod() {
        createButton.click();
        ActionsIF.select(selectYear, RP_YEAR);
        ActionsIF.select(selectStatus, RP_STATUS);
        ActionsIF.select(selectPeriodity, RP_PERIODITY);
        ActionsIF.select(selectPeriod, RP_REPORT_PERIOD);
        startDateInput.sendKeys(RP_startDATE);
        endDateInput.sendKeys(RP_endDATE);
        saveButton.click();
        assertSection.shouldBe(Condition.visible);
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSection));
    }

    public void findPeriod() {
        resetButton.shouldBe(Condition.visible);
        resetButton.click();
        ActionsIF.selectParameterByText(selectYearFilter, RP_YEAR);
        ActionsIF.selectParameterByText(selectPeriodityFilter, RP_PERIODITY);
        ActionsIF.selectParameterByText(selectPeriodFilter, RP_REPORT_PERIOD);
        startDatePeriodInput.sendKeys(RP_startDATE);
        endDatePeriodInput.sendKeys(RP_endDATE);
        searchButton.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(entity));
    }


    public void changeStatusToCloseOpen() {
        entity.contextClick();
        openClosePeriod.click();
        Assert.assertEquals("Закрытый", assertStatusEntity.getText());
    }

    public void changeStatusToCorrection() {
        entity.click();
        correction.click();
        Assert.assertEquals("Корректирующий", assertStatusEntity.getText());
    }

    public void deletePeriod() {
        entity.click();
        deleteButton.click();
        Buttons.clickOKButton();
        Assert.assertFalse(GridHelpers.elementIsVisible(entity));
    }
}
