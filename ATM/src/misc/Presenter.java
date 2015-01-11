package misc;

import simulator.SimulationController;

public class Presenter {
    private SimulationController simulationController;

    public Presenter(SimulationController simulationController) {
        this.simulationController = simulationController;
    }

    public void startSimulation() {
        simulationController.startSimulation();
    }

    public void setSimulationSettings(SimulationPresets simulationPresets) {

        simulationController.prepareSimulation(simulationPresets);
    }

    public void stopSimulation() {
        simulationController.stopSimulation();
    }

}
