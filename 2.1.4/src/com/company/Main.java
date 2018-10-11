package com.company;

import javax.swing.JOptionPane;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        String number;
        StringBuilder wynik = new StringBuilder();
        number = JOptionPane.showInputDialog("Podaj liczbę całkowitą 3-cyfrową: ");

        if (number.length() == 4) {
            char minus = number.charAt(0);
            try {
                if (minus != '-') {
                    throw new DevError();
                }
            } catch (DevError n) {
                JOptionPane.showMessageDialog(null, "To nie jest minus!");
                System.exit(1);
            }
        }
        try {
            if (number.length() > 4 || number.length() < 3) {
                throw new DevError();
            }
        } catch (DevError e) {
            JOptionPane.showMessageDialog(null, "Złe dane wejściowe");
            System.exit(1);
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c == '-') {
                wynik.append("minus ");
            } else if (c == '1') {
                wynik.append("jeden ");
            } else if (c == '2') {
                wynik.append("dwa ");
            } else if (c == '3') {
                wynik.append("trzy ");
            } else if (c == '4') {
                wynik.append("cztery ");
            } else if (c == '5') {
                wynik.append("pięć ");
            } else if (c == '6') {
                wynik.append("sześć ");
            } else if (c == '7') {
                wynik.append("siedem ");
            } else if (c == '8') {
                wynik.append("osiem ");
            } else if (c == '9') {
                wynik.append("dziewięć ");
            } else if (c == '0') {
                wynik.append("zero ");
            }
        }
        JOptionPane.showMessageDialog(null, wynik.toString());
    }
}
