package simulator;

import java.util.TimerTask;

import misc.SimulationPresets;
import misc.Writer;
import ATM.ATM;
import ATM.IATM;
import client.AbstractClient;
import client.Client;

// chujowy komentarz
public class Simulation extends TimerTask {

    public static final int ITERATION_COUNT = 100;

    private int pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount;

    private IATM atm;

    private AbstractClient client;

    private Writer writer;

    public Simulation() {

        atm = new ATM();
        client = new Client();
        writer = new Writer();
    }

    @Override
    public void run() {

        atm.nextClient(client);
        writer.write("" + atm.getTransactionInformation());
    }

    public void setPreferences(SimulationPresets preferences) {
        client.setLowerWithdrawLimit(preferences.getWithdrawLowerLimit());
        client.setUpperWithdrawLimit(preferences.getWithdrawUpperLimit());
        pln200RefillCount = preferences.getPLN200();
        pln100RefillCount = preferences.getPLN100();
        pln50RefillCount = preferences.getPLN50();
        pln20RefillCount = preferences.getPLN20();
        pln10RefillCount = preferences.getPLN10();
    }

    public void fillATM() {
        atm.refillNotes(pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount);
    }

}
