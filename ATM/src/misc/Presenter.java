package misc;

import java.util.ArrayList;
import java.util.List;

import simulator.SimulationController;
import view.AppWindowAdmin;

public class Presenter {
	private SimulationController simulationController;

	private AppWindowAdmin window;

	public Presenter(SimulationController simulationController) {
		this.simulationController = simulationController;
	}

	public Presenter() {
		// TODO Auto-generated constructor stub
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

	public void setElapsedDay(int i) {
		window.setTimer(i);

	}

	public List<Integer> getHistory() {
		List<Integer> l = new ArrayList<Integer>();
		for (Integer integer : simulationController.getBalanceHistory()) {
			l.add(integer);
		}
		return l;
	}

	public void setGui(AppWindowAdmin window) {
		this.window = window;

	}

	public AppWindowAdmin getWindow() {
		return window;
	}

}
