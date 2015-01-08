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
        atm.refillNotes(preferences.getPln200Count(), preferences.getPln100Count(), preferences.getPln50Count(), preferences.getPln20Count(),
                preferences.getPln10Count());

    }

}
