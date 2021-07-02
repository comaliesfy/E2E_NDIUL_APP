package ru.stqa.ptf.tests.testsUNP.Declaration;


import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import ru.stqa.ptf.api.ControlRations;
import ru.stqa.ptf.appmanager.TestBase;

import java.io.IOException;

import static Configs.DeclarationsConfig.DECL_ID;

@Epic("Роль-система")
@Feature("Раздел Декларации- Контрольные соотношения")
public class ControlRationsTest extends TestBase {

    ControlRations cr = new ControlRations();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Работа контрольных соотношений")
    public void checkControlRations() throws IOException {
        cr.takeFile();
        cr.postXMLForAssert(DECL_ID, cr.takeFile());
        cr.postErrorReport(DECL_ID);
        //System.out.println(cr.checkExcelFile(cr.findExcelFile(DECL_ID)));
        Assert.assertEquals(7206, cr.checkExcelFile(cr.findExcelFile(DECL_ID)));
        // кол-во байтов excel соответствует для файла с ошибками по умолчанию, значит КС фиксируются
    }
}


