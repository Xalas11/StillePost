/**
 * Die Klasse Launcher stellt das Testprogramm
 */

import java.util.Scanner;

public class Launcher {
    public static void main(String args[]) {
        new Launcher().play();
    }

     public void play() {

        int breite = frageNachZahl("Gib eine Breite (>= 2) fuer das Spielfeld an: ", 2);
        int hoehe = frageNachZahl("Gib eine Hoehe (>= 2) fuer das Spielfeld an: ", 2);
        int population = frageNachZahl("Gib die Groesse der Population an (>=2): ", 2);
        int runden = frageNachZahl("Gib die Anzahl der Runden an (>0): ", 1);

        Welt welt = new Welt(breite,hoehe,population,runden);
         Person.reset();

        if(!beenden()) {
            play();
        }
    }

     public boolean beenden() {
        System.out.print("Tippe 'nochmal' ein, um das Spiel erneut zu spielen.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String str = sc.next();
            if (str.contains("nochmal")) {
                return false;
            }
        }
        return true;
    }

     public int frageNachZahl(String beschreibung, int kleinsteZahl) {
        boolean valid = false;
        int wert = 0;
        while (!valid) {
            System.out.print(beschreibung);
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int read = sc.nextInt();
                if (read >= kleinsteZahl) {
                    valid = true;
                    wert = read;
                }
            }
            if (!valid) {
                System.out.print("Deine Eingabe ist ungueltig!\n");
            }
        }
        return wert;
    }
}
