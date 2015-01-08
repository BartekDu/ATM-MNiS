package simulator;

import java.util.Timer;

public class SimulationController {
    // sadsad
    public static int ITERATION_TIME_MS = 1000;

    private Simulation simulationModule;

    private Timer simulationTimer;

    public SimulationController() {
        simulationModule = new Simulation();
    }

    public void startSimulation() {
        simulationTimer = new Timer("Simaltion Timer Thread");
        simulationTimer.scheduleAtFixedRate(simulationModule, 1000, 10);
    }

    public void prepareSimulation() {

    }
}
