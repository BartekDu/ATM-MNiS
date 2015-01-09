package simulator;

import java.util.TimerTask;

import misc.Preferences;
import ATM.ATM;
import ATM.IATM;
import client.AbstractClient;
import client.Client;

// chujowy komentarz
public class Simulation extends TimerTask {

    public static final int ITERATION_COUNT = 100;

    private int pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount;

    IATM atm;

    int i;

    AbstractClient client;

    public Simulation() {
        i = 0;
        atm = new ATM();
        client = new Client();
    }

    @Override
    public void run() {
        System.out.println(i++);
        System.out.println("Run");
        atm.nextClient(client);

    }

    public void setPreferences(Preferences preferences) {
        client.setLowerWithdrawLimit(preferences.getLOWER_WITHDRAW_LIMIT());
        client.setUpperWithdrawLimit(preferences.getUPPER_WITHDRAW_LIMIT());
        pln200RefillCount = preferences.getPln200Count();
        pln100RefillCount = preferences.getPln100Count();
        pln50RefillCount = preferences.getPln50Count();
        pln20RefillCount = preferences.getPln20Count();
        pln10RefillCount = preferences.getPln10Count();
    }

    public void fillATM() {
        atm.refillNotes(pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount);
    }

}
