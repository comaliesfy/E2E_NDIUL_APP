package ru.stqa.ptf.pages.menu;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainScreen {

    public String mainMenuButtons() {
        ElementsCollection
                elements = $$x("//s-button");
        int i = elements.size();
        List<String> nameButton = new ArrayList<>();
        for (int k = 1; k <= i; k++) {
            nameButton.add($x("(//s-button)[" + k + "]").getText());
        }
        return nameButton.toString();
    }

    public String upperMenuButtons() {
        ElementsCollection
                elements =
                $$x("//button[@class='btn btn-toolbar dropdown-toggle']");
        int i = elements.size();
        List<String> nameButton = new ArrayList<>();
        for (int k = 1; k <= i; k++) {
            nameButton.add($x("(//button[@class='btn btn-toolbar dropdown-toggle'])[" + k + "]").getText());
        }
        return nameButton.toString();
    }

}
