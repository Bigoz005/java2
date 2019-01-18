package com.company;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Controller {

    @FXML
    private Pane colorPane;

    @FXML
    private Slider redSlider, greenSlider, blueSlider;

    @FXML
    private CheckBox showColorCheckBox;

    @FXML
    private Label pickedColor;

    @FXML
    private Label redLabel, greenLabel, blueLabel;

    private List<java.awt.Color> colors;
    private List<String> colorNames;


    @FXML
    public void initialize() {
        colors = ColorMaker.performColors();
        colorNames = ColorMaker.performColorNames();
        pickedColor.setText("-");
        showColorCheckBox.setSelected(false);
        setNewBackgroundColorBasedOnSliders();
        initializeAllSliders();
    }

    private void setNewBackgroundColorBasedOnSliders() {
        colorPane.setBackground(new Background(
                new BackgroundFill(
                        Color.rgb(Integer.parseInt(redLabel.getText()), Integer.parseInt(greenLabel.getText()), Integer.parseInt(blueLabel.getText())), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    private void initializeAllSliders() {
        redSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                redLabel.setText(String.format("%.0f", redSlider.getValue()));
                setNewBackgroundColorBasedOnSliders();
                showPickedColorName();
            }
        });

        greenSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                greenLabel.setText(String.format("%.0f", greenSlider.getValue()));
                setNewBackgroundColorBasedOnSliders();
                showPickedColorName();
            }
        });

        blueSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                blueLabel.setText(String.format("%.0f", blueSlider.getValue()));
                setNewBackgroundColorBasedOnSliders();
                showPickedColorName();
            }
        });
    }

    private String findApproximation(int red, int green, int blue) {
        int minRed = 0, minGreen = 0, minBlue = 0, minDistance = 1000, i = 0;
        String result = "";
        java.awt.Color colorFromSlider = new java.awt.Color(red, green, blue);

        Method[] methods = colorFromSlider.getClass().getMethods();
        for (java.awt.Color color: colors) {
            for (Method method: methods) {
                if (method.getName().contains("getRed")) {
                    try {
                        minRed = (int) method.invoke(color);
                    } catch (InvocationTargetException e) {
                        e.getMessage();
                    } catch (IllegalAccessException e) {
                        e.getMessage();
                    }
                }

                if (method.getName().contains("getGreen")) {
                    try {
                        minGreen = (int) method.invoke(color);
                    } catch (InvocationTargetException e) {
                        e.getMessage();
                    } catch (IllegalAccessException e) {
                        e.getMessage();
                    }
                }

                if (method.getName().contains("getBlue")) {
                    try {
                        minBlue = (int) method.invoke(color);
                    } catch (InvocationTargetException e) {
                        e.getMessage();
                    } catch (IllegalAccessException e) {
                        e.getMessage();
                    }
                }
            }

            if (calculateDistance(minRed, minGreen, minBlue, red, green, blue) < minDistance) {
                minDistance = calculateDistance(minRed, minGreen, minBlue, red, green, blue);
                result = colorNames.get(i);
            }
            i++;
        }

        return result;
    }

    private int calculateDistance(int minRed, int minGreen, int minBlue, int red, int green, int blue) {
        return (Math.abs((minRed - red)) + (Math.abs(minGreen - green)) + (Math.abs(minBlue - blue)));
    }

    @FXML
    private void showPickedColorName() {
        if (showColorCheckBox.isSelected()) {
            updateLabelWithPickedColor();
        } else {
            this.pickedColor.setText("");
        }
    }

    private void updateLabelWithPickedColor() {
        this.pickedColor.setText(findApproximation(Integer.parseInt(redLabel.getText()), Integer.parseInt(greenLabel.getText()), Integer.parseInt(blueLabel.getText())));
    }
}
