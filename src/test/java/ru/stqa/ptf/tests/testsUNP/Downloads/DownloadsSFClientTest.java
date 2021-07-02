package ru.stqa.ptf.tests.testsUNP.Downloads;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operationDownloads.DownloadForm;

import static Configs.ConfigsForSearchForm.UPLOADS_FILENAME_CLIENT;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Загрузка операций контрагента- Списковая форма")
public class DownloadsSFClientTest extends TestBase {
    DownloadForm df = new DownloadForm();

    @Before
    public void start() {
        df.openClientDownloadForm();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Нерезидент")
    public void checkClientNameFilter() {
        df.checkClientNameFilter();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Наименование файла ")
    public void checkFileNameFilter() {
        df.checkFileNameFilter(UPLOADS_FILENAME_CLIENT);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Загрузил пользователь")
    public void checkUserNameFilter() {
        df.checkUserNameFilter(8);
    }
}