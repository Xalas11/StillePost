import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by bjarne on 11.04.16.
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

    public void removePerson(Person person) {
        this.population.remove(person);
    }

    public void addPerson(Person person) {
        this.population.add(person);
    }

    public void addNachbarfeld(Feld nachbar) {
        this.nachbarFelder.add(nachbar);
    }

    public Feld getRandomNachbar() {
        Random randomizer = new Random();
        int random = randomizer.nextInt(nachbarFelder.size());
        return this.nachbarFelder.get(random);
    }

    public boolean enthaeltGeruecht() {
        for(Person n:population){
            if (n.getMeinung() != Meinung.Neutral) {
                return true;
            }
        }
        return false;
    }
}
