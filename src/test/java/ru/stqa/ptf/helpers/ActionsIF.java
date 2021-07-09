package ru.stqa.ptf.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ActionsIF {

    //метод обработки элементов - селектов для page object
    public static void select(SelenideElement element , String keys) {
        element.selectOption(keys);
    }

    //метод для секлектов ( выбор по тексту)
    public static void selectParameterByText(SelenideElement element , String keys) {
        element.selectOption(keys);
    }

    //воспроизводит двойной клик
    public static void doubleClick(SelenideElement element) {
       element.doubleClick();
    }

    //воспроизводит клик правой клавишей мыши
    public static void rightClick(SelenideElement element) {
        element.contextClick();
    }

    //ввод и выбор значения дл элемента типа cmx-autocomplete-input
    public static void fillInputAndSelect(SelenideElement element,String text, SelenideElement element1) {
        element.clear();
        element.click();
        GridHelpers.sendCharKeys(text,element,element1);
     }

    public static void pickAndSelect(SelenideElement element, SelenideElement element1) {
        element.click();
        element1.shouldBe(Condition.visible);
        element1.click();
    }

}


