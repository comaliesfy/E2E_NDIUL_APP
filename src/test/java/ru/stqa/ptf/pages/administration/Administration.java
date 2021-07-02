package ru.stqa.ptf.pages.administration;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Administration {

    private final SelenideElement administrationSection = $x("//button[contains(text(),' Администрирование')]");
    private final SelenideElement systemLogsSection = $x("//a[contains(text(),'Системные логи')]");
    private final SelenideElement systemParamSection = $x("//a[contains(text(),'Системные параметры')]");
    private final SelenideElement information = $x("//a[contains(text(),'Информация')]");
    private final SelenideElement systemLogsSectionAssert = $x("//h4[contains(text(),'Системные логи')]");
    private final SelenideElement systemParamAssert = $x("//h4[contains(text(),'Системные параметры')]");
    private final SelenideElement entitySysLogs = $x("//ngx-datatable//datatable-body//datatable-row-wrapper");
    private final SelenideElement firstRow = $x("//datatable-row-wrapper[1]//datatable-body-row");
    private final SelenideElement systemParamDFAssert = $x("//div[@class='cmx-simple-dialog-component_body_content_form']");

    public void openAdminSection() {
        administrationSection.click();
    }

    public void openSysLogs() {
        systemLogsSection.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(systemLogsSectionAssert));
        Assert.assertTrue(GridHelpers.elementIsVisible(entitySysLogs));
    }

    public void openSysParam() {
        systemParamSection.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(systemParamAssert));
        Assert.assertTrue(GridHelpers.elementIsVisible(firstRow));
    }
}

