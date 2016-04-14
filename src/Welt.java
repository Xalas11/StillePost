/**
 *
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class Welt {

    private int runde = 0;
    private HashSet<Person> population = new HashSet<Person>();
    private int rundenAnzahl;
    private Feld[][] spielFeld;

    private Berta berta;
    private Anton anton;
    private boolean bertaIstAhnungslos = true;

    /**
     *
     * @param breite
     * @param hoehe
     * @param populationsGroesse
     * @param runden
     */
    public Welt(int breite, int hoehe, int populationsGroesse, int runden) {

        this.spielFeld = new Feld[breite][hoehe];
        for(int x=0; x<breite; x++) {
            for(int y=0; y<hoehe; y++) {
                Koordinate koordinate = new Koordinate(x,y);
                this.spielFeld[x][y] = new Feld(koordinate);
            }
        }

        for(int x=0; x<breite; x++) {
            for(int y=0; y<hoehe; y++) {
                if (x > 0) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x-1][y]);
                }
                if (x < spielFeld.length-1) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x+1][y]);
                }
                if (y > 0) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x][y-1]);
                }
                if (y < spielFeld[0].length-1) {
                    this.spielFeld[x][y].addNachbarfeld(spielFeld[x][y+1]);
                }
            }
        }

        this.rundenAnzahl = runden;

        for(Integer n=1; n <= populationsGroesse; n++) {
            Random randomizer = new Random();
            int randomX = randomizer.nextInt(spielFeld.length);
            int randomY = randomizer.nextInt(spielFeld[0].length);
           // Person person = new Person(spielFeld[randomX][randomY]);
            Person person = new Person();
            spielFeld[randomX][randomY].addPerson(person);
            population.add(person);
            spielFeld[randomX][randomY].addPerson(person);
        }

        anton = new Anton();
        berta = new Berta();
        population.add(anton);
        population.add(berta);
        spielFeld[0][0].addPerson(anton);
        spielFeld[spielFeld.length-1][spielFeld[0].length-1].addPerson(berta);

        runde();
    }

    /**
     * diese Methode raepresentiert einen Zyklus, des Spiels, Meinung allerfelder Setzen, Personen bewegen, Ausgabe, Rekursion..
     */
    public void runde() {
        runde += 1;

    //    if(bertaIstAhnungslos) {
     //       if(berta.erfaehrtVomGeruecht()) {
      //          berta.setMeinung(Meinung.Berta);
      //          bertaIstAhnungslos = false;
      //      }
      //  }

        for(int x=0; x<spielFeld.length; x++) {
            for(int y=0; y<spielFeld[0].length; y++) {
                spielFeld[x][y].meinungBilden();
                spielFeld[x][y].wechselFeld1();
            }
        }

        //for(S n:population){
        //    n.wechsleFeld1();
        //}
        System.out.print(100/population.size());
        double antonProzent =  Person.antonAnhaenger;
        double bertaProzent = Person.bertaAnhaenger;
        double neutralProzent =  Person.neutralAnhaenger;
        System.out.println("Runde " + runde + ": Anton: " + antonProzent + "%, Berta: " + bertaProzent + "%, Neutral: " + neutralProzent +"%");

        //System.out.println("\nRunde " + runde + ": Anton: " + Person.antonAnhaenger + ", Berta: " + Person.bertaAnhaenger + ", Neutral: " + Person.neutralAnhaenger);

        if (runde < rundenAnzahl) {
            runde();
        }
    }

}
