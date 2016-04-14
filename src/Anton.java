/**
 *
 * Die Anton Klasse Erbt von der Personen Klasse
 */
public class Anton extends Person {
    public Anton() {
        super.setMeinung(Meinung.Anton);
    }

    /**
     *
     * Die Methode ändert nun die Meinung nicht mehr.
     */
    @Override public void setMeinung(Meinung meinung) {
    }
}
