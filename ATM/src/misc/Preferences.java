package misc;

public class Preferences {

    private int pln200Count, pln100Count, pln50Count, pln20Count, pln10Count;

    private double CORRECT_PIN_CHANCE = 0.8;

    private int UPPER_WITHDRAW_LIMIT = 500;

    private int LOWER_WITHDRAW_LIMIT = 100;

    public Preferences() {

    }

    public void setRefillNotesCount(int pln200, int pln100, int pln50, int pln20, int pln10) {
        this.pln200Count = pln200;
        this.pln100Count = pln100;
        this.pln50Count = pln50;
        this.pln20Count = pln20;
        this.pln10Count = pln10;
    }

}
