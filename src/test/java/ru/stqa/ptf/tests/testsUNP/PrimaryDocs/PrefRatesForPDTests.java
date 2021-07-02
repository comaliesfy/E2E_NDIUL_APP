package ru.stqa.ptf.tests.testsUNP.PrimaryDocs;

import io.qameta.allure.*;
import org.junit.*;
import ru.stqa.ptf.api.REST;
import ru.stqa.ptf.appmanager.TestBase;
import ru.stqa.ptf.helpers.Buttons;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocDF;
import ru.stqa.ptf.pages.primaryDoc.PrimaryDocSF;

import static Configs.ClientConfigs.CLIENT_NUMBER;

@Epic("Роль-Контролер УНП ЦА")
@Feature("Первичные документы -Детальные формы")
public class PrefRatesForPDTests extends TestBase {

    PrimaryDocSF pdSF = new PrimaryDocSF();
    PrimaryDocDF pdDF = new PrimaryDocDF();
    static REST rest = new REST();

    @BeforeClass
    public static void createDATA() {
        rest.createClient();
        rest.createPDClient(rest.findClient());
    }

    @Before
    public void prepareCondition() {
        pdSF.goToPDClientForm();
        pdSF.findPrimaryDoc(CLIENT_NUMBER);
        pdSF.openDetailFormPD();
        pdDF.openIncomeKind();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка работы налоговых льгот, корректное отображение полей льгот")
    public void checkClientPDprefRates() {
        pdDF.selectPrefRate(4);
        Buttons.clickOKButton();
        pdDF.selectPrefRate(5);
        pdDF.selectPrefRate(6);
        Assert.assertEquals("пп.1 п.2 ст.310 НК РФ", pdDF.checkFacility());
        pdDF.assertPrivelegeField("Нотариально заверенная копия свидетельства ");
        pdDF.selectPrefRate(7);
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
        pdDF.assertPrivelegeField("Внешнеторговый контракт");
        pdDF.selectPrefRate(7);
        pdDF.selectPrefRate(8);
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
        pdDF.assertPrivelegeField("Оказание услуг и выполнение работ");
        pdDF.selectPrefRate(8);
        pdDF.selectPrefRate(9);
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
        pdDF.assertPrivelegeField("Оказание услуг на нерегулярной (разовой)");
        pdDF.selectPrefRate(9);
        pdDF.selectPrefRate(10);
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
        pdDF.assertPrivelegeField("Менее 50% недвижимости в РФ");
        pdDF.selectPrefRate(10);
        pdDF.selectPrefRate(11);
        pdDF.assertPrivelegeField("Реализация обращающихся акций");
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
        pdDF.notTaxAgent();
        pdDF.assertPrivelegeField("не налоговый агент");
        Assert.assertEquals("п.2 ст.309 НК РФ", pdDF.checkFacility());
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("----------")
    public void checkPrivilegeField() {
        pdDF.selectPrefRate(10);
        pdDF.saveIncomeType();
        pdDF.saveUnicPD();
        pdSF.openDetailFormPD();
        pdDF.openIncomeKind();
        pdDF.assertPrivelegeField("Менее 50% недвижимости в РФ");
        pdDF.selectPrefRate(10);
        pdDF.saveIncomeType();
        pdDF.saveUnicPD();
    }

    @Ignore
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("----------")
    public void vv13() {
        pdDF.selectPrefRate(13);
        Buttons.clickOKButton();
        Assert.assertTrue(pdDF.rateIsSelect(12));
    }

}
