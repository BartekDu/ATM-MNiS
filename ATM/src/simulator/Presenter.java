package simulator;

import misc.Preferences;
import misc.SimulationPresets;

public class Presenter {
    private SimulationController simulationController;

    private SimulationPresets simulationPresets;

    public Presenter(SimulationController simulationController) {
        this.simulationController = simulationController;
    }

    public void startSimulation() {
        simulationController.startSimulation();
    }

    public void setSimulationSettings(SimulationPresets simulationPresets) {
        this.simulationPresets = simulationPresets;
        Preferences modelPreferences = new Preferences(simulationPresets);
        simulationController.prepareSimulation(modelPreferences);
    }

}
