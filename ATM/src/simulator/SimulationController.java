package simulator;

import ATM.ATM;
import ATM.IATM;
import client.AbstractClient;
import client.Client;

// chujowy komentarz
public class SimulationController {

    public static final int ITERATION_COUNT = 100;

    public SimulationController() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        IATM atm = new ATM();
        AbstractClient client = new Client();
        for (int iteration = 0; iteration < ITERATION_COUNT; iteration++) {
            System.out.println(iteration);
            atm.nextClient(client);
            System.out.println("***********");
            if (iteration == 20) {
                atm.refillNotes(20, 20, 20, 20, 20);
            }
        }
    }

}
