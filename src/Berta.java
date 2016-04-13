/**
 * Created by bjarne on 11.04.16.
 */
public class Berta extends Person {
    public Berta(Feld feld) {
        super(feld);
    }

    @Override public void setMeinung(Meinung meinung) {
        if (meinung == Meinung.Berta) {
            super.setMeinung(Meinung.Berta);
            //hier war der doener unterwegs
            //was machen sachen
        }
    }

    public boolean erfaehrtVomGeruecht() {
        return position.enthaeltGeruecht();
    }
}
