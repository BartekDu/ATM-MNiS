package misc;

public class Preferences {

    private int pln200Count, pln100Count, pln50Count, pln20Count, pln10Count;

    private int UPPER_WITHDRAW_LIMIT;

    private int LOWER_WITHDRAW_LIMIT;

    public Preferences() {

    }

    public void setRefillNotesCount(int pln200, int pln100, int pln50, int pln20, int pln10) {
        this.pln200Count = pln200;
        this.pln100Count = pln100;
        this.pln50Count = pln50;
        this.pln20Count = pln20;
        this.pln10Count = pln10;
    }

    public int getUPPER_WITHDRAW_LIMIT() {
        return UPPER_WITHDRAW_LIMIT;
    }

    public void setUPPER_WITHDRAW_LIMIT(int uPPER_WITHDRAW_LIMIT) {
        UPPER_WITHDRAW_LIMIT = uPPER_WITHDRAW_LIMIT;
    }

    public int getLOWER_WITHDRAW_LIMIT() {
        return LOWER_WITHDRAW_LIMIT;
    }

    public void setLOWER_WITHDRAW_LIMIT(int lOWER_WITHDRAW_LIMIT) {
        LOWER_WITHDRAW_LIMIT = lOWER_WITHDRAW_LIMIT;
    }

    public int getPln200Count() {
        return pln200Count;
    }

    public int getPln100Count() {
        return pln100Count;
    }

    public int getPln50Count() {
        return pln50Count;
    }

    public int getPln20Count() {
        return pln20Count;
    }

    public int getPln10Count() {
        return pln10Count;
    }

}
