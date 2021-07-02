package ru.stqa.ptf.pages.administration;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import ru.stqa.ptf.helpers.GridHelpers;

import static com.codeborne.selenide.Selenide.$x;

public class Info {

    private final SelenideElement sectionInfo = $x("//a[contains(text(),'Информация')]");
    private final SelenideElement asssertSectionInfo = $x("//span[contains(text(),'Информация')]");

    public void openSection() {
        sectionInfo.click();
        Assert.assertTrue(GridHelpers.elementIsVisible(asssertSectionInfo));
    }
}

