package com.company;

/**
 * Klasa z funkcja do rysowania linijki
 */
public class Linijka {
    /**
     * Funkcja do tworzenia linijki.
     *
     * @param centymetry        jak duzo centymetrow ma byc narysowanych
     * @param poziomZagniezdzen liczba kresek przy liczbach
     */
    public static void Rysuj(int centymetry, int poziomZagniezdzen) {
        for (int j = 0; j <= centymetry; j++) {
            Linia(poziomZagniezdzen, j);                       // rysuje linie wraz z liczba
            if (j != centymetry)
                Podzialka(poziomZagniezdzen - 1);      // rysuje kreski bez liczb pomiedzy kreskami z liczbami (podzialke)
        }
    }

    /**
     * Rysuje podzialke pomiedzy glownymi liniami
     *
     * @param srodek ile kresek ma byc na srodku podzialki
     */
    private static void Podzialka(int srodek) {
        if (srodek >= 1) {
            Podzialka(srodek - 1);    // rysuje rekursywnie gorna czesc podzialki
            Linia(srodek);            // srodkowa podzialka bez numeru
            Podzialka(srodek - 1);    // rysuje rekursywnie dolna czesc podzialki
        }
    }

    /**
     * Rysuje linie z podana iloscia kresek, z liczba
     *
     * @param liczba            liczba pelnego centymetra
     * @param poziomZagniezdzen liczba kresek przy liczbach
     */
    private static void Linia(int poziomZagniezdzen, int liczba) {
        for (int j = 0; j < poziomZagniezdzen; j++)
            System.out.print("-");
        if (liczba >= 0)
            System.out.print(" " + liczba);
        System.out.print("\n");
    }

    /**
     * Rysuje linie z podana iloscia kresek, bez liczby
     *
     * @param poziomZagniezdzen liczba kresek na srodku podzialki
     */
    private static void Linia(int poziomZagniezdzen) {
        Linia(poziomZagniezdzen, -1);
    }
}