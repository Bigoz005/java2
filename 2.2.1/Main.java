package com.company;

public class Main {

    static double LevQWERTY(String s1, String s2) {
        int i, j, m, n, cost;
        int d[][];

        m = s1.length();
        n = s2.length();

        d = new int[m + 1][n + 1];

        for (i = 0; i <= m; i++)
            d[i][0] = i;
        for (j = 1; j <= n; j++)
            d[0][j] = j;

        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    cost = 0;
                else
                    cost = 1;

                d[i][j] = Math.min(d[i - 1][j] + 1,         /* remove */
                        Math.min(d[i][j - 1] + 1,         /* insert */
                                d[i - 1][j - 1] + cost));         /* change */
            }
        }

        return d[m][n];
    }

    public static void main(String[] args) {

        String s, t;

        s = "Cisowianka";
        t = "Naleczowianka";
        System.out.println("Odleglosc Levenshteina wynosi: " + LevQWERTY(s, t));
    }

}
