package ru.stqa.ptf.tests.testsUNP.Downloads;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.operationDownloads.DownloadForm;

import static Configs.ConfigsForSearchForm.UPLOADS_FILENAME_CONT;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Загрузка операций клиента- Списковая форма")
public class DownloadsSFContractorTest extends TestBase {
    DownloadForm df = new DownloadForm();

    @Before
    public void start() {
        df.openContractorDownloadForm();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Нерезидент")
    public void checkClientNameFilter() {
        df.checkContNameFilter();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Наименование файла ")
    public void checkFileNameFilter() {
        df.checkFileNameFilter(UPLOADS_FILENAME_CONT);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Проверка фильтра Загрузил пользователь")
    public void checkUserNameFilter() {
        df.checkUserNameFilter(8);
    }
}
