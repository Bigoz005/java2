package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JLabel[][] cyclistLabels = createWindow();
        Tournament tournament = new Tournament(cyclistLabels);
        tournament.startTournament();
    }

    private static JLabel[][] createWindow() {
        JFrame frame = new JFrame("Wyscig Kolarski");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(300, 200);
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        JPanel panel = new JPanel();
        panel.setSize(300, 200);
        GridLayout layout = new GridLayout(4, 3);

        JLabel[][] labels = new JLabel[3][2];
        for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++) {
                labels[i][j] = new JLabel();
            }
        }

        panel.add(new JLabel("Miejsce"));
        panel.add(new JLabel("Zawodnik"));
        panel.add(new JLabel("Czas"));

        panel.add(new JLabel("1."));
        panel.add(labels[0][0]);
        panel.add(labels[0][1]);

        panel.add(new JLabel("2."));
        panel.add(labels[1][0]);
        panel.add(labels[1][1]);

        panel.add(new JLabel("3."));
        panel.add(labels[2][0]);
        panel.add(labels[2][1]);

        panel.setLayout(layout);
        frame.add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        return labels;
    }
}