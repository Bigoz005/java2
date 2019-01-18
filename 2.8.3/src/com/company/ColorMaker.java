package com.company;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ColorMaker {

    public static List<Color> performColors() {
        List<Color> colors = new ArrayList<>();

        colors.add(Color.BLUE);
        colors.add(Color.BLACK);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);
        colors.add(Color.RED);
        colors.add(Color.PINK);
        colors.add(Color.ORANGE);
        colors.add(Color.MAGENTA);
        colors.add(Color.LIGHT_GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.DARK_GRAY);
        colors.add(Color.GRAY);

        return colors;
    }

    public static List<String> performColorNames() {
        List<String> colorNames = new ArrayList<>();

        colorNames.add("Blue");
        colorNames.add("Black");
        colorNames.add("Yellow");
        colorNames.add("White");
        colorNames.add("Red");
        colorNames.add("Pink");
        colorNames.add("Orange");
        colorNames.add("Magenta");
        colorNames.add("Light gray");
        colorNames.add("Green");
        colorNames.add("Cyan");
        colorNames.add("Dark gray");
        colorNames.add("Gray");

        return colorNames;
    }
}

