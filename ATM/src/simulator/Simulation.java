package simulator;

import java.util.Random;
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

    private int upperClientLimit;

    private int lowetClientLimit;

    private int dailyClientsLimit;

    private int clientCount;

    private int dayCounter;

    private int refillFrequency;

    public Simulation() {

        atm = new ATM();
        client = new Client();
        writer = new Writer();

    }

    @Override
    public void run() {

        if (clientCount == 0 || clientCount > dailyClientsLimit - 1) {
            dailyClientsLimit = randomDailyClientLimit();
            clientCount = 0;

            if (dayCounter % refillFrequency == 0) {
                atm.refillNotes(pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount);
                writer.write(System.lineSeparator() + "$$$$$$$$$$$$$$$$" + System.lineSeparator() + "Uzupe³niono stan bankomatu"
                        + System.lineSeparator() + "$$$$$$$$$$$$$$$$" + System.lineSeparator());
            }
            writer.write(System.lineSeparator() + "Rozpoczeto " + (dayCounter + 1) + " dobê. Iloœæ klientów: " + dailyClientsLimit
                    + System.lineSeparator());
            dayCounter++;
        }
        atm.nextClient(client);

        clientCount++;
        writer.write("Klient w dobie: " + clientCount + System.lineSeparator());
        writer.write("" + atm.getTransactionInformation());
    }

    public void setPreferences(SimulationPresets preferences) {
        dayCounter = 0;
        clientCount = 0;
        client.setLowerWithdrawLimit(preferences.getWithdrawLowerLimit());
        client.setUpperWithdrawLimit(preferences.getWithdrawUpperLimit());
        setClientsLimits(preferences.getClientsPerDayMax(), preferences.getClientsPerDayMin());
        pln200RefillCount = preferences.getPLN200();
        pln100RefillCount = preferences.getPLN100();
        pln50RefillCount = preferences.getPLN50();
        pln20RefillCount = preferences.getPLN20();
        pln10RefillCount = preferences.getPLN10();
        refillFrequency = preferences.getDaysToRefill();
    }

    public void fillATM() {
        atm.refillNotes(pln200RefillCount, pln100RefillCount, pln50RefillCount, pln20RefillCount, pln10RefillCount);
    }

    private void setClientsLimits(int upperLimit, int lowerLimit) {
        this.upperClientLimit = upperLimit;
        this.lowetClientLimit = lowerLimit;
    }

    private int randomDailyClientLimit() {
        Random rand = new Random();
        int count = rand.nextInt(upperClientLimit) + 1;
        while (count < lowetClientLimit) {
            count = rand.nextInt(upperClientLimit) + 1;
        }

        return count;

    }
}
