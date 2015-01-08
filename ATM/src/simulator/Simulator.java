package simulator;

public class Simulator {

    public static void main(String[] args) {
        SimulationController simCont = new SimulationController();
        Presenter presenter = new Presenter(simCont);
    }

}
