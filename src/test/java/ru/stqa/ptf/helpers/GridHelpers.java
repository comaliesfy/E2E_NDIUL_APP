package ru.stqa.ptf.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class GridHelpers {

    //вввод строки посимвольно до появления нужного элемента выпадающего списка
    public static void sendCharKeys(String string1, SelenideElement locatorInput, SelenideElement locator) {
        char[] symbol = string1.toCharArray();
        int i = 0;

        while (!elementIsVisible(locator)) {
            String d = String.valueOf(symbol[i]);
            locatorInput.sendKeys(d);
            i++;
        }
        locator.click();
    }

    //проверка есть ли элемент на странице
    public static boolean elementIsVisible(SelenideElement locator) {
        return  locator.is(Condition.exist);

    }

    public static void focusAndPush(SelenideElement locator1) {
        locator1.scrollIntoView(true).click();
    }
}

