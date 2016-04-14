/**
 *
 *  Die Berta Klasse Erbt von der Personen Klasse
 */
public class Berta extends Person {
    public Berta(Feld feld) {
        super(feld);
    }

    /**
     * Die Methode ändert nun die Meinung nur noch in Berta
     */
    @Override public void setMeinung(Meinung meinung) {
        if (meinung == Meinung.Berta) {
            super.setMeinung(Meinung.Berta);
        }
    }

    /**
     *
     * @return
     */
    public boolean erfaehrtVomGeruecht() {
        return position.enthaeltGeruecht();
    }
}
