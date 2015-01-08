package misc;

public class Preferences {

    int pln200Count, pln100Count, pln50Count, pln20Count, pln10Count;

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
