package ru.stqa.ptf.tests.testsUNP.Downloads;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operationDownloads.DownloadForm;

import static Configs.ConfigsForSearchForm.UPLOADS_FILENAME_DEPO;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Загрузка операций депозитария- Списковая форма")
public class DownloadsSFDepoTest extends TestBase {
    DownloadForm df = new DownloadForm();

    @Before
    public void start() {
        df.openDepositoryDownloadForm();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Депонент")
    public void checkClientNameFilter() {
        df.checkDepoNameFilter();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Эмитент")
    public void checkIssueFilter() {
        df.checkIssueNameFilter();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Наименование файла ")
    public void checkFileNameFilter() {
        df.checkFileNameFilter(UPLOADS_FILENAME_DEPO);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Загрузил пользователь")
    public void checkUserNameFilter() {
        df.checkUserNameFilter(11);
    }
}
