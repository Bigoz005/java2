package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] nrPesel = new int[10];
        int nrCheck;
        Scanner odczyt = new Scanner(System.in);
        String numer;

        do{
            System.out.print("Podaj nr PESEL: ");
            numer = odczyt.nextLine();
            for(int i = 0; i<10; i++) {
                nrPesel[i]=Integer.parseInt(numer.substring(i, i+1));
            }
            nrCheck= 9 * nrPesel[0] + 7 * nrPesel[1] + 3 * nrPesel[2] + 1 * nrPesel[3] + 9 * nrPesel[4] + 7 * nrPesel[5] + 3 * nrPesel[6] + 1 * nrPesel[7] + 9 * nrPesel[8] + 7 * nrPesel[9];
        }while(numer.length() != 11 || nrCheck % 10 != Integer.parseInt(numer.substring(10,11)) );

        Pesel pesel = new Pesel();

        try {
            pesel.fun(pesel, numer);
            System.out.print("data urodzenia(yyyy-mm-dd): " + pesel.dataUrodzenia);
            System.out.print("\nplec: " + pesel.plec);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
