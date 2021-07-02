package ru.stqa.ptf.helpers;

import org.openqa.selenium.WebElement;

public class FieldValidation {

    /**
     * Валидация полей
     */
    //true - валидное поле, false- невалидное поле
    public static boolean fieldIsValid(WebElement locator) {
        String locatorClass = locator.getAttribute("class");
        return !locatorClass.contains("invalid");
    }

    public static boolean checkBoxIsOn(WebElement locator) {
        String locatorClass = locator.getAttribute("class");
        return locatorClass.contains("checked");
    }
}
