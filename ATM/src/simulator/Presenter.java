package simulator;

public class Presenter {
	private SimulationController simulationController;

	public Presenter(SimulationController simulationController) {
		this.simulationController = simulationController;
	}

	public void startSimulation() {
		simulationController.startSimulation();
	}

}
