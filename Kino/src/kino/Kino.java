package kino;

import java.util.Scanner;
import java.util.Random;

public class Kino {

    public static void main(String[] args) {

        // Deklaration und Initialisierung der Variablen
        boolean sitzplaetze[][] = new boolean[10][10];
        boolean frei = true;
        int freiePlaetze = 0;
        int doppelsitze = 0;
        int dreiersitze = 0;
        int vierersitze = 0;
        int fuenfersitze = 0;
        int sechsersitze = 0;
        int behindertenPlaetze = 0;
        int loggenPlaetze = 0;
        int n = 0;
        int zaehler = 1;
        int zahl = 0;

        // Es wird ein neues Objekt der Klasse Scanner erzeugt
        Scanner eingabe = new Scanner(System.in);

        // Es wird nach der Anzahl der Personen gefragt
        System.out.print("Wieviele Personen? \n");
        n = eingabe.nextInt();

        // Es wird ein neues Objekt der Klasse Random erzeugt
        Random zufall = new Random();

        // Befüllen des Arrays mit zufälligen booleschen Werten
        for (int i = 0; i < sitzplaetze.length; i++) {
            for (int j = 0; j < sitzplaetze[i].length; j++) {
                sitzplaetze[i][j] = zufall.nextBoolean();
            }
        }

        // Bei Wert true wird "o" ausgegeben, bei false wird "x" ausgegeben
        for (int i = 0; i < sitzplaetze.length; i++) {

            for (int j = 0; j < sitzplaetze[i].length; j++) {
                if (frei == sitzplaetze[i][j]) {
                    System.out.print("\033[42m" + "o ");
                    freiePlaetze++;
                } else {
                    System.out.print("\033[41m" + "x ");
                }

            }

            System.out.println(" ");
        }

        // Es wird die Anzahl der freien Behindertensitzplätze ermittelt
        // Behindertensitzplätze befinden sich in der ersten Reihe 
        for (int i = 0; i < 1; i++) {

            for (int j = 0; j < sitzplaetze[i].length; j++) {
                if (frei == sitzplaetze[i][j]) {
                    behindertenPlaetze++;
                }

            }

            System.out.println(" ");
        }

        // Es wird die Anzahl der freien Loggenplätze ermittelt 
        // Loggenplätze befinden sich in den letzten zwei Reihen
        for (int i = sitzplaetze.length - 2; i < sitzplaetze.length; i++) {

            for (int j = 0; j < sitzplaetze[i].length; j++) {
                if (frei == sitzplaetze[i][j]) {
                    loggenPlaetze++;
                }

            }

            System.out.println(" ");
        }

        // Es wird die Anzahl der freien Gruppenplätze ermittelt
        for (int i = 0; i < sitzplaetze.length; i++) {
            for (int j = 0; j < sitzplaetze[i].length - 1; j++) {
                while (j + zaehler < sitzplaetze[i].length) {
                    if (frei == sitzplaetze[i][j] && sitzplaetze[i][j] == sitzplaetze[i][j + zaehler]) {
                        zaehler++;
                    } else {
                        break;
                    }

                }
                
                
// Nachdem der Wert mit den benachbarten Werten verglichen wurde, 
// wird der Wert der Variable zaehler ausgewertet und je nach Größe des Wertes erhöht sich die Anzahl der jeweiligen Sitze
                switch (zaehler) {
                    case 2:
                        doppelsitze++;
                        break;
                    case 3:
                        dreiersitze++;
                        break;
                    case 4:
                        vierersitze++;
                        break;
                    case 5:
                        fuenfersitze++;
                        break;
                    case 6:
                        sechsersitze++;
                        break;

                }

                // Der Wert der Variable zaehler wird wieder auf 1 zurückgesetzt 
                zaehler = 1;
            }

        }

        // In Abhängigkeit von der Anzahl der Personen, die den Film sehen wollen, 
        // bekommt man unterschiedliche Ausgaben, welche Plätze noch frei sind 
        switch (n) {
            case 1:
                if (freiePlaetze > 0) {
                    System.out.print(
                            "Es sind noch " + freiePlaetze + " Plätze frei.");
                    System.out.println();
                    System.out.print("Davon sind " + behindertenPlaetze + " Behindertenplätze und " + loggenPlaetze + " Loggenplätze frei.");
                } else {
                    System.out.print("Es sind schon alle Plätze besetzt. \n");
                }
                break;
            case 2:
                if (doppelsitze > 0) {
                    System.out.print(
                            "Es sind noch " + doppelsitze + " Doppelsitze frei. \n");
                    
                } else {
                    System.out.print("Es gibt keine Doppelsitze mehr.\n");
                    System.out.print("Können Sie auch getrennt sitzen? \n");
                    System.out.print("Für ja drücken Sie die 1. \n");
                    System.out.print("Für nein drücken Sie die 2. \n");
                    zahl = eingabe.nextInt();

                    switch (zahl) {
                        case 1:
                            System.out.print("Es sind noch " + freiePlaetze + " Einzelsitze frei. \n");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.print("Falsche Eingabe.");
                    }
                }
                break;
            case 3:
                if (dreiersitze > 0) {
                    System.out.print(
                            "Es sind noch " + dreiersitze + " Dreiersitze frei. \n");

                } else {
                    System.out.print("Es gibt keine Dreiersitze mehr. \n");
                    System.out.print("Können Sie auch getrennt sitzen? \n");
                    System.out.print("Für ja drücken Sie die 1. \n");
                    System.out.print("Für nein drücken Sie die 2. \n");
                    zahl = eingabe.nextInt();

                    switch (zahl) {
                        case 1:
                            System.out.print("Es sind noch " + freiePlaetze + " Einzelsitze und " + doppelsitze + " Doppelsitze frei. \n");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.print("Falsche Eingabe.");

                    }
                }
                break;
            case 4:
                if (vierersitze > 0) {
                    System.out.print(
                            "Es sind noch " + vierersitze + " Vierersitze frei. \n");

                } else {
                    System.out.print("Es gibt keine Vierersitze mehr. \n");
                    System.out.print("Können Sie auch getrennt sitzen? \n");
                    System.out.print("Für ja drücken Sie die 1. \n");
                    System.out.print("Für nein drücken Sie die 2. \n");
                    zahl = eingabe.nextInt();

                    switch (zahl) {
                        case 1:
                            System.out.print("Es sind noch " + doppelsitze + " Doppelsitze frei. \n");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.print("Falsche Eingabe.");

                    }
                }

                break;
            case 5:
                if (fuenfersitze > 0) {
                    System.out.print(
                            "Es sind noch " + fuenfersitze + " Fuenfersitze frei. \n");
                } else {
                    System.out.print("Es gibt keine Fünfersitze mehr. \n");
                    System.out.print("Können Sie auch getrennt sitzen? \n");
                    System.out.print("Für ja drücken Sie die 1. \n");
                    System.out.print("Für nein drücken Sie die 2. \n");

                    zahl = eingabe.nextInt();

                    switch (zahl) {
                        case 1:
                            System.out.print("Es sind noch " + doppelsitze + " Doppelsitze und " + dreiersitze + " Dreiersitze frei. \n");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.print("Falsche Eingabe.");

                    }

                }
                break;
            case 6:
                if (sechsersitze > 0) {
                    System.out.print(
                            "Es sind noch " + sechsersitze + " Sechsersitze frei. \n");
                } else {
                    System.out.print("Es gibt keine Sechsersitze mehr. \n");
                    System.out.print("Können Sie auch getrennt sitzen? \n");
                    System.out.print("Für ja drücken Sie die 1. \n");
                    System.out.print("Für nein drücken Sie die 2. \n");

                    zahl = eingabe.nextInt();

                    switch (zahl) {
                        case 1:
                            System.out.print("Es sind noch " + dreiersitze + " Dreiersitze frei. \n");
                            break;
                        case 2:
                            break;
                        default:
                            System.out.print("Falsche Eingabe.");

                    }

                }

        }

    }
}
