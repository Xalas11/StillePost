/**
 * Die Personen Klasse modelliert eine Person mit Meinung und Feld Daten
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

    /**
     * Resetet die Meinungs Statistic
     */

    public static void reset() {
        antonAnhaenger = 0;
        bertaAnhaenger = 0;
        neutralAnhaenger = 0;
    }

    /**
     * Die Methode sucht ein zufälliges angrenzendes Feld, entfernt sie von diesem Feld und füg sie auf dem Neuen Feld ein.
     */
    public void wechsleFeld() {
        Feld nachbar = position.getRandomNachbar();
        if (nachbar == this.position) {
            return;
        }
        this.position.removePerson(this);
        this.position = nachbar;
        this.position.addPerson(this);
    }

    /**
     * Findet heraus welches die "alte Meinung" war und Setzt eine neue. und aktualiesiert die jeweiligen Anhänger.
     *
     * @param meinung
     */
    public void setMeinung(Meinung meinung) {
        if (meinung == this.meinung) {
            return;
        }
        if (this.meinung == Meinung.Anton) {
            antonAnhaenger -= 1;
        } else if (this.meinung == Meinung.Berta) {
            bertaAnhaenger -= 1;
        } else if (this.meinung == Meinung.Neutral) {
            neutralAnhaenger -= 1;
        }

        this.meinung = meinung;

        if (this.meinung == Meinung.Anton) {
            antonAnhaenger += 1;
        } else if (this.meinung == Meinung.Berta) {
            bertaAnhaenger += 1;
        } else if (this.meinung == Meinung.Neutral) {
            neutralAnhaenger += 1;
        }
    }

    /**
     * @return
     */
    public Meinung getMeinung() {
        return this.meinung;
    }
}
