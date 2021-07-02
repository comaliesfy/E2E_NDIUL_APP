package ru.stqa.ptf.pages.declaration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.ActionsIF;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.helpers.GridHelpers;

import java.util.ArrayList;
import java.util.List;

import static Configs.ConfigsForSearchForm.DECL_PERIOD_SF;
import static Configs.DeclarationsConfig.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertEquals;
import static ru.stqa.ptf.helpers.ActionsIF.selectParameterByText;
import static ru.stqa.ptf.helpers.GridHelpers.focusAndPush;

public class DeclarationSF {

    private final SelenideElement sectionDeclaration = $x("//button[contains(text(),'Декларации')]");

    //Фильтры
    //Год
    private final SelenideElement filterYear = $x("//cmx-select-input[@id='year-selectInput-id']//mat-select");
    private final SelenideElement setYear = $x("//mat-option//span[contains(text(),'" + DECL_YEAR + "')]");
    //Отчетный период
    private final SelenideElement filterPeriod = $x("//cmx-select-input[@id='period-selectInput-id']//mat-select");
    private final SelenideElement setPeriod = $x("//span[contains(text(),'" + DECL_PERIOD + "')]");
    private final SelenideElement setPeriodFilter = $x("//span[contains(text(),'" + DECL_PERIOD_SF + "')]");
    //Вид декларации
    private final SelenideElement filterDeclType = $x("//cmx-select-input[@id='declarationType-selectInput-id']//mat-select");
    private final SelenideElement setType56 = $x(" //span[contains(text(),'" + DECL_TYPE56 + "')]");
    private final SelenideElement setType24 = $x(" //span[contains(text(),'" + DECL_TYPE24 + "')]");
    //Статус
    private final SelenideElement filterDeclStatus = $x("//cmx-select-input[@id='declarationStatus-selectInput-id']//mat-select");
    private final SelenideElement setStatus = $x("//span[contains(text(),'" + DECL_Status + "')]");
    //Статус ЭД
    private final SelenideElement filterEDStatus = $x( "//cmx-select-input[@id='fileStatus-selectInput-id']//mat-select");
    private final SelenideElement setEDStatus = $x("//span[contains(text(),'" + DECL_ED_Status + "')]");
    //Сущности деклараций
    private final SelenideElement entityKND56 = $x("//td[@id='/КНД 1151056 Клиенты']");
    private final SelenideElement entityKND24 = $x("//td[@id='/КНД 1151024 Контрагенты']");
    //Кнопки раздела
    private final SelenideElement searchButton = $x("//span[contains(text(),'Поиск')]");
    private final SelenideElement resetButton = $x("//span[contains(text(),'Сброс')]");
    private final SelenideElement addDeclButton = $x("//span[contains(text(),' Добавить запись ')]");
    private final SelenideElement historyButton = $x("//span[contains(text(),' История изменений ')]");
    private final SelenideElement deleteButton = $x("//span[contains(text(),'Удалить запись')]");
    private final SelenideElement deleteMessage = $x("//span[contains(text(),'Декларация успешно удалена')]");
    //Форма создания декларации
    private final SelenideElement assertAddForm = $x("//span[contains(text(),'Создание декларации')]");
    private final SelenideElement addDeclType = $x("//select[@id='types']");
    private final SelenideElement addDeclYear = $x(" //select[@id='years']");
    private final SelenideElement addDeclPeriod = $x("//select[@id='periods']");
    private final SelenideElement createButton = $x("//span[contains(text(),'Создать')]");
    private final SelenideElement cancelButton = $x("//span[contains(text(),'Отмена')]");
    private final SelenideElement tableResult = $x("//tbody[@class='ui-table-tbody']//tr");

    public void goToDeclarationForm() {
        sectionDeclaration.click();
    }

    //найти КНД56
    public void findDeclaration56() {
        resetButton.click();
        ActionsIF.pickAndSelect(filterYear, setYear);
        ActionsIF.pickAndSelect(filterPeriod, setPeriod);
        ActionsIF.pickAndSelect(filterDeclType, setType56);
        searchButton.click();
    }

    //Найти КНД24
    public void findDeclaration24() {
        resetButton.click();
        ActionsIF.pickAndSelect(filterYear, setYear);
        ActionsIF.pickAndSelect(filterPeriod, setPeriod);
        ActionsIF.pickAndSelect(filterDeclType, setType24);
        searchButton.click();
    }

    //Создать КНД56
    public void createKND56() {
        createDeclaration(DECL_TYPE56);
    }

    //Создать КНД24
    public void createKND24() {
        createDeclaration(DECL_TYPE24);
    }

    //Настройка окна "Создание декларации".
    private void createDeclaration(String type) {
        addDeclButton.click();
        selectParameterByText(addDeclType, type);
        selectParameterByText(addDeclYear, DECL_YEAR);
        selectParameterByText(addDeclPeriod, DECL_PERIOD);
        createButton.click();
    }

    //открыть найденную КНД56
    public void openKND56() {
        ActionsIF.doubleClick(entityKND56);
    }

    //открыть найденную КНД24
    public void openKND24() {
        ActionsIF.doubleClick(entityKND24);
    }

    //Удалить КНД56
    public void deleteKND56() {
        entityKND56.click();
        deleteButton.click();
        Buttons.clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        Buttons.clickOKButton();
        Assert.assertFalse(GridHelpers.elementIsVisible(entityKND56));
    }

    //Удалить КНД24
    public void deleteKND24() {
        entityKND24.click();
        deleteButton.click();
        Buttons.clickOKButton();
        Assert.assertTrue(GridHelpers.elementIsVisible(deleteMessage));
        Buttons.clickOKButton();
        Assert.assertFalse(GridHelpers.elementIsVisible(entityKND24));
    }

    //Фильтры
    //метод проверки фильтров
    private void checkFilterFieldDropDown(SelenideElement input, SelenideElement value, String key) {
        resetButton.click();
        ActionsIF.pickAndSelect(input,value);
        searchButton.click();
        Buttons.spinner.shouldNotBe(Condition.visible);
        assertFindResults(key);
    }

    //метод поверки фильтра "отчетный период"
    private void checkFilterFieldDropDownPeriod(String key) {
        resetButton.click();
        ActionsIF.pickAndSelect(filterYear, setYear);
        ActionsIF.pickAndSelect(filterPeriod, setPeriodFilter);
        searchButton.click();
        assertFindResults(key);
    }

    //ассерт проверки фильтров - общее кол-во результатов равно результатам, содержащим значение cellName
    private void assertFindResults(String cellName) {
        List<SelenideElement> rows = $$x("//tbody[@class='ui-table-tbody']//tr");
        List<SelenideElement> cells = $$x("//td[contains(text(),'" + cellName + "')]");
        assertEquals(rows.size(), cells.size());
    }

    //Проверка фильтров
    public void checkYearFilter() {
        checkFilterFieldDropDown(filterYear, setYear, DECL_YEAR);
    }

    public void checkPeriodFilter() {
        checkFilterFieldDropDownPeriod("3 квартал 2020 года");
    }

    public void checkDeclTypeFilter() {
        checkFilterFieldDropDown(filterDeclType, setType56, DECL_TYPE56);
    }

    public void checkEDStatusFilter() {
        checkFilterFieldDropDown(filterEDStatus, setEDStatus, DECL_ED_Status);
    }

    public void checkStatusFilter() {
        checkFilterFieldDropDown(filterDeclStatus, setStatus, DECL_Status);
    }


    public void assertCreateFormDecl() {
        focusAndPush(addDeclButton);
        Assert.assertTrue(GridHelpers.elementIsVisible(assertAddForm));
        cancelButton.click();
        Assert.assertFalse(GridHelpers.elementIsVisible(assertAddForm));
    }

    public void checkDeclFiltersAreClear() {
        resetButton.click();
        List<String> terms = new ArrayList<>();
        for (int k = 1; k <= 5; k++) {
            terms.add($x("(//div[@class='mat-select-value'])[" + k + "]").getAttribute("innerText"));
        }
        String terms02 = terms.toString();
        assertEquals("[\n" +
                " , \n" +
                " , \n" +
                " , \n" +
                " , \n" +
                " ]", terms02);
    }

}