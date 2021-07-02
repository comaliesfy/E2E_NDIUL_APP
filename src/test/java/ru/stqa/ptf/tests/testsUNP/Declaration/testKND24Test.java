package ru.stqa.ptf.tests.testsUNP.Declaration;

import io.qameta.allure.*;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.declaration.DeclarationSF;
import ru.stqa.ptf.pages.declaration.KND24;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Декларация КНД 1151024 Клиенты")
public class testKND24Test extends TestBase {
    DeclarationSF declSF = new DeclarationSF();
    REST rest = new REST();
    KND24 decl24 = new KND24();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, расчет, сохранение и отправка КНД24")
    public void KND24() {
        declSF.goToDeclarationForm();
        declSF.createKND24();
        decl24.saveKND24();
        decl24.uploadDeclFiles();
        decl24.acceptKND56();
        decl24.sendKND24();
        rest.deleteKND24(rest.findKND24());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление КНД24")
    public void deleteKND24() {
        rest.createKND24();
        declSF.goToDeclarationForm();
        declSF.findDeclaration24();
        declSF.deleteKND24();
    }


}
