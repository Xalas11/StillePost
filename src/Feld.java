import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/**
 * Die Klasse Feld Modelliert ein Feld einer 2D Feldes, es enthält Koordinaten,
 * die Koordianten der Nachbar Felder und ein Hashset mit den Personen die auf diesem Feld stehen
 * und welche gesamt Meinung diese Besitzen.
 */
public class Feld {

    private Koordinate koordinate;
    private Meinung meinung = Meinung.Neutral;
    private ArrayList<Feld> nachbarFelder = new ArrayList<Feld>(); //max 5 felder oben unten rechts links und sich selbst
    private HashSet<Person> population = new HashSet<Person>();

    public Feld(Koordinate koordinate) {
        this.koordinate = koordinate;
        this.addNachbarfeld(this);
    }

    /**
     * Zaehlt wieviele Leute welcher Meinung sind und setzt die Mehrheitsmeinung als allgemein Meinung
     */
    public void meinungBilden() {

        int neutral = 0;
        int berta = 0;
        int anton = 0;
        //int counter = 0;
        for(Person n:population){
            if(n.getMeinung() == Meinung.Anton) {
                anton += 1;
            }
            else if(n.getMeinung() == Meinung.Berta) {
                berta += 1;
            }
            else if(n.getMeinung() == Meinung.Neutral) {
                neutral += 1;
            }
            //counter++;
         }
        //System.out.print(counter+"  Neut:"+neutral+" berta"+berta+" anton"+anton);
        //System.out.println("|| "+this.meinung);
        if (anton == berta) {
            this.meinung = Meinung.Neutral;
        }
        else if (anton > berta) {
            this.meinung = Meinung.Anton;
        }
        else if (anton < berta) {
            this.meinung = Meinung.Berta;
        }

        for(Person n:population){
            n.setMeinung(this.meinung);
        }
        //System.out.println(" || "+this.meinung);
    }

    /**
     *
     * @param person
     */
    public void removePerson(Person person) {
        this.population.remove(person);
    }

    /**
     *
     * @param person
     */
    public void addPerson(Person person) {
        this.population.add(person);
    }

    /**
     *
     * @param nachbar
     */
    public void addNachbarfeld(Feld nachbar) {
        this.nachbarFelder.add(nachbar);
    }

    /**
     *  Die Methode gibt eine Zufälliges Feld das and dieses Feld angrenzt aus
     * @return
     */
    public Feld getRandomNachbar() {
        Random randomizer = new Random();
        int random = randomizer.nextInt(nachbarFelder.size());
        return this.nachbarFelder.get(random);
    }

    /**
     * Die Methode schaut nach ob es eine Meinung auf diesem Feld gibt
     * @return
     */
    public boolean enthaeltGeruecht() {
        for(Person n:population){
            if (n.getMeinung() != Meinung.Neutral) {
                return true;
            }
        }
        return false;
    }
    public void wechselFeld1() {
        for(Person n:population){

                Person temp = n;
                removePerson(n);
                Feld nachbar = (getRandomNachbar());
            System.out.println(getRandomNachbar());
                nachbar.addPerson(temp);
            }
    }
}
