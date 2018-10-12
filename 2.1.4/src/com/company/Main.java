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
            switch (c)
            case (c == '-'):
                wynik.append("minus ");
                break;
            case (c == '1'):
                wynik.append("jeden ");
                break;
            case (c == '2'):
                wynik.append("dwa ");
                break;
            case (c == '3'):
                wynik.append("trzy ");
                break;
            case: (c == '4'):
                wynik.append("cztery ");
                break;
            case (c == '5'):
                wynik.append("pięć ");
                break;
            case (c == '6'):
                wynik.append("sześć ");
                break;
            case (c == '7'):
                wynik.append("siedem ");
                break;
            case (c == '8'):
                wynik.append("osiem ");
                break;
            case (c == '9'):
                wynik.append("dziewięć ");
                break;
            case (c == '0'):
                wynik.append("zero ");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, wynik.toString());
    }
}
