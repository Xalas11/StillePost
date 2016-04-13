/**
 * Created by bjarne on 11.04.16.
 */
public class Anton extends Person {
    public Anton(Feld feld) {
        super(feld);
        super.setMeinung(Meinung.Anton);
    }

    @Override public void setMeinung(Meinung meinung) {
    }
}
