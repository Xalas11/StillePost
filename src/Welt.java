/**
 * Created by bjarne on 11.04.16.
 */

import java.util.HashSet;
import java.util.Random;

public class Welt {
    private int runde = 0;
    private HashSet<Person> population = new HashSet<Person>();
    private int rundenAnzahl;
    private Feld[][] spielFeld;

    private Berta berta;
    private Anton anton;
    private boolean bertaIstAhnungslos = true;


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
            Person person = new Person(spielFeld[randomX][randomY]);
            population.add(person);
            spielFeld[randomX][randomY].addPerson(person);
        }

        anton = new Anton(spielFeld[0][0]);
        berta = new Berta(spielFeld[spielFeld.length-1][spielFeld[0].length-1]);
        population.add(anton);
        population.add(berta);
        spielFeld[0][0].addPerson(anton);
        spielFeld[spielFeld.length-1][spielFeld[0].length-1].addPerson(berta);

        runde();
    }

    public void runde() {
        runde += 1;

        if(bertaIstAhnungslos) {
            if(berta.erfaehrtVomGeruecht()) {
                berta.setMeinung(Meinung.Berta);
                bertaIstAhnungslos = false;
            }
        }

        for(int x=0; x<spielFeld.length; x++) {
            for(int y=0; y<spielFeld[0].length; y++) {
                spielFeld[x][y].meinungBilden();
            }
        }

        for(Person n:population){
            n.wechsleFeld();
        }
        System.out.print(100/population.size());
        double antonProzent = (100/population.size()) * Person.antonAnhaenger;
        double bertaProzent = (100/population.size()) * Person.bertaAnhaenger;
        double neutralProzent = (100/population.size()) * Person.neutralAnhaenger;
        System.out.println("Runde " + runde + ": Anton: " + antonProzent + "%, Berta: " + bertaProzent + "%, Neutral: " + neutralProzent +"%");

        //System.out.println("\nRunde " + runde + ": Anton: " + Person.antonAnhaenger + ", Berta: " + Person.bertaAnhaenger + ", Neutral: " + Person.neutralAnhaenger);

        if (runde < rundenAnzahl) {
            runde();
        }
    }

}