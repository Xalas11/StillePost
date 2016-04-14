import java.util.Scanner;

/**
 * Die Klasse Launcher stellt das Testprogramm
 */
public class Launcher {
    public static void main(String args[]) {
        new Launcher().play();
    }

    public void play() {

        int breite = frageNachZahl("Gib eine Breite (2 <= breite <= 1000) fuer das Spielfeld an: ", 2, 1000);
        int hoehe = frageNachZahl("Gib eine Hoehe (2 <= hoehe <= 1000) fuer das Spielfeld an: ", 2, 1000);
        int population = frageNachZahl("Gib die Groesse der Population an (2 <= population <= 10000): ", 2, 10000);
        int runden = frageNachZahl("Gib die Anzahl der Runden an (1 <= runden <= 2000): ", 1, 2000);

        Welt welt = new Welt(breite, hoehe, population, runden);
        Person.reset();

        if (!beenden()) {
            play();
        }
    }

    public boolean beenden() {
        System.out.print("Gib 'nochmal' ein, um das Spiel erneut zu spielen oder irgendwas fuer Abbruch.\n");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String str = sc.next();
            if (str.contains("nochmal")) {
                return false;
            }
        }
        return true;
    }

    public int frageNachZahl(String beschreibung, int kleinsteZahl, int groessteZahl) {
        boolean valid = false;
        int wert = 0;
        while (!valid) {
            System.out.print(beschreibung);
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int read = sc.nextInt();
                if (read >= kleinsteZahl && read <= groessteZahl) {
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
