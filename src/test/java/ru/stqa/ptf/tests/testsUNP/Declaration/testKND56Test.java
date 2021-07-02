package ru.stqa.ptf.tests.testsUNP.Declaration;

import io.qameta.allure.*;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.declaration.DeclarationSF;
import ru.stqa.ptf.pages.declaration.KND56;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Декларация КНД 1151056 Клиенты")
public class testKND56Test extends TestBase {

    DeclarationSF declSF = new DeclarationSF();
    REST rest = new REST();
    KND56 decl56 = new KND56();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание, расчет, сохранение и отправка КНД56")
    public void KND56() {
        declSF.goToDeclarationForm();
        declSF.createKND56();
        decl56.calculateKND56();
        decl56.saveKND56();
        decl56.uploadDeclFiles();
        decl56.acceptKND56();
        decl56.sendKND56();
        rest.deleteKND56(rest.findKND56());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Удаление КНД56")
    public void deleteKND56() {
        rest.createKND56();
        declSF.goToDeclarationForm();
        declSF.findDeclaration56();
        declSF.deleteKND56();
    }

}
