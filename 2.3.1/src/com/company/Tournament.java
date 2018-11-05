package com.company;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.Timer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Tournament implements Observer {
    private static PriorityQueue<Cyclist> cyclistQueue;
    private JLabel[][] cyclistsLabels;
    private Logger logger;

    Tournament(JLabel[][] cyclistsLabels) {
        this.cyclistsLabels = cyclistsLabels;
        cyclistQueue = new PriorityQueue<>();
        logger = Logger.getLogger(Tournament.class.getName());
        FileHandler fh;
        try {
            fh = new FileHandler("Log.txt");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startTournament() {
        Stack<Cyclist> kolarze = new Stack<>();
        try {
            //zaladowanie kolarztow
            Scanner namesFile = new Scanner(new URL("http://szgrabowski.kis.p.lodz.pl/zpo18/nazwiska.txt").openStream());
            Set<Cyclist> cyclists = new LinkedHashSet<>(); //Set zeby wyeliminowac powtorki
            while (namesFile.hasNext()) {
                cyclists.add(new Cyclist(namesFile.nextLine()));
            }

            //przemieszanie kolarzow i dodanie do arraylist
            ArrayList<Cyclist> randomCyclists = new ArrayList<>(cyclists);
            Collections.shuffle(randomCyclists);

            //wrzucenie kazdego na stos i ustawienie obserwera
            for (Cyclist cyclist : randomCyclists) {
                kolarze.push(cyclist);
                cyclist.addObserver(this);
                if (kolarze.size() == 15)
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!kolarze.isEmpty()) {
                    logger.log(Level.INFO, kolarze.peek().getName() + " ruszyl");
                    kolarze.pop().start();
                } else
                    cancel();
            }
        }, 0, 60000 / 25); //co minute symulacji
        logger.log(Level.INFO, "Start");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Cyclist) {
            Cyclist cyclist = (Cyclist) o;
            cyclistQueue.add(cyclist);

            ArrayList<Cyclist> tmp = new ArrayList<>();

            for (int i = 0; i < Math.min(3, cyclistQueue.size()); i++) {
                if (cyclistQueue.isEmpty())
                    break;
                tmp.add(cyclistQueue.poll());//dodanie do listy
                cyclistsLabels[i][0].setText(tmp.get(i).getName());
                cyclistsLabels[i][1].setText(tmp.get(i).getTime() + "s");
            }
            logger.log(Level.INFO, cyclist.getName() + " " + cyclist.getTime() + "s.");
            cyclistQueue.addAll(tmp);
        }
    }
}
