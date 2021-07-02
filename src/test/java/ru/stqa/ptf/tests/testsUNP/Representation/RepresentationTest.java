package ru.stqa.ptf.tests.testsUNP.Representation;

import io.qameta.allure.*;
import org.junit.Test;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.pages.references.Nonresidence;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Представительства")
public class RepresentationTest extends TestBase {
    REST rest = new REST();
    Nonresidence nres = new Nonresidence();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Создание и сохранение Представительства")
    public void createRepresentation() {
        nres.openNonResidenceSection();
        nres.addNonResidence();
        nres.createRepresentation();
        rest.deleteRepresentation(rest.findRepresentation());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Удаление в новом представительстве Вида деятельности")
    public void deleteNewActivityType() {
        nres.openNonResidenceSection();
        nres.addNonResidence();
        nres.deleteNewActivityType();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка соответстия полей по чекбоксу представительства")
    public void assertRepresentation() {
        nres.openNonResidenceSection();
        nres.addNonResidence();
        nres.assertRepresentation();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка удаления представительства")
    public void deleteRepresentation() {
        rest.createRepresentation();
        nres.openNonResidenceSection();
        nres.deleteRepresentation();
    }
}
