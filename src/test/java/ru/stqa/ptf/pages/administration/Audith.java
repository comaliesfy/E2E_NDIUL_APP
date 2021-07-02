package ru.stqa.ptf.pages.administration;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Audith {
    private final SelenideElement sectionAudith = $x("//a[contains(text(),'Аудит')]");
    private final SelenideElement assertSectionAudith = $x("//span[contains(text(),'Объект')]");

    public void openSection() {
        sectionAudith.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(assertSectionAudith));
    }
}

