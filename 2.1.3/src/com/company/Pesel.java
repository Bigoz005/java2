package com.company;

class Pesel {
    String dataUrodzenia;
    char plec;

    Pesel fun(Pesel osoba, String numerPesel){

        if(numerPesel.charAt(2) == '2' )                   // Data urodzenia po 2000 roku mc-e 1-9
        {
            osoba.dataUrodzenia = "20" + numerPesel.substring(0,2) + "-0" + numerPesel.substring(3,4) + '-' + numerPesel.substring(4,6);
        }
        else if(numerPesel.charAt(2) == '3' )              // Data urodzenia po 2000 roku mc-e 10-12
        {
            osoba.dataUrodzenia = "20" + numerPesel.substring(0,2) + "-1" + numerPesel.substring(3,4) + '-' + numerPesel.substring(4,6);
        }
        else
        {
            osoba.dataUrodzenia = "19" + numerPesel.substring(0,2) + '-' + numerPesel.substring(2,4)+ '-' + numerPesel.substring(4,6);
        }

        if(numerPesel.charAt(9) % 2 == 0) {
            osoba.plec = 'K';
        }
        else {
            osoba.plec = 'M';
        }


    return osoba;
    }
}
