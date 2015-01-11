package simulator;

import java.util.Timer;

import misc.SimulationPresets;

public class SimulationController {
    // sadsad
    public static int ITERATION_TIME_MS = 1000;

    private Simulation simulationModule;

    private int clientsPerSecond;

    private Timer simulationTimer;

    public SimulationController() {

    }

    public void startSimulation() {
        simulationTimer = new Timer();
        int delayTimeMS = 1000 / clientsPerSecond;
        simulationTimer.scheduleAtFixedRate(simulationModule, 1000, delayTimeMS);
    }

    public void prepareSimulation(SimulationPresets simulationPresets) {
        simulationModule = new Simulation();
        simulationModule.setPreferences(simulationPresets);
        clientsPerSecond = simulationPresets.getClientsPerSecond();
        // simulationModule.fillATM();
    }

    public void stopSimulation() {

        simulationTimer.cancel();

    }
}
