package ru.stqa.ptf.pages.administration;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Dublicates {

    private final SelenideElement sectionDedublication = $x("//a[contains(text(),'Дубликаты клиентов')]");
    private final SelenideElement assertSectionDedublication = $x("//h4[contains(text(),'Дубликаты клиентов')]");

    public void openSection() {
        sectionDedublication.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSectionDedublication));
    }
}



