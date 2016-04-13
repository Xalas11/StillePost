/**
 * Created by bjarne on 11.04.16.
 *
 */
public class Person {

    private Meinung meinung = Meinung.Neutral;
    protected Feld position;

    static int antonAnhaenger = 0;
    static int bertaAnhaenger = 0;
    static int neutralAnhaenger = 0;

    public Person(Feld feld) {
        this.position = feld;
        neutralAnhaenger += 1;
    }

    public static void reset() {
        antonAnhaenger = 0;
        bertaAnhaenger = 0;
        neutralAnhaenger = 0;
    }

    public void wechsleFeld() {
        Feld nachbar = position.getRandomNachbar();
        this.position.removePerson(this);
        this.position = nachbar;
        this.position.addPerson(this);
    }

    public void setMeinung(Meinung meinung) {
        if (meinung == this.meinung) {
            return;
        }
        if(this.meinung == Meinung.Anton) {
            antonAnhaenger -= 1;
        } else if(this.meinung == Meinung.Berta) {
            bertaAnhaenger -= 1;
        } else if(this.meinung == Meinung.Neutral) {
            neutralAnhaenger -= 1;
        }

        this.meinung = meinung;

        if(this.meinung == Meinung.Anton) {
            antonAnhaenger += 1;
        } else if(this.meinung == Meinung.Berta) {
            bertaAnhaenger += 1;
        } else if(this.meinung == Meinung.Neutral) {
            neutralAnhaenger += 1;
        }
    }

    public Meinung getMeinung() {
        return this.meinung;
    }
}
