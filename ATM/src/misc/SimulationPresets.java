package misc;

public class SimulationPresets {

	private Integer withdrawLowerLimit;

	private Integer withdrawUpperLimit;

	private Integer clientsPerDayMin;

	private Integer clientsPerDayMax;

	private Integer clientsPerSecond;

	private Integer simulationLenght;

	private Integer PLN200;

	private Integer PLN100;

	private Integer PLN50;

	private Integer PLN20;

	private Integer PLN10;

	private Integer daysToRefill;

	public int getDaysToRefill() {
		return daysToRefill;
	}

	public void setDaysToRefill(Integer daysToRefill) {
		this.daysToRefill = daysToRefill;
	}

	public int getWithdrawLowerLimit() {
		return withdrawLowerLimit;
	}

	public int getWithdrawUpperLimit() {
		return withdrawUpperLimit;
	}

	public int getClientsPerDayMin() {
		return clientsPerDayMin;
	}

	public int getClientsPerDayMax() {
		return clientsPerDayMax;
	}

	public int getClientsPerSecond() {
		return clientsPerSecond;
	}

	public Integer getSimulationLenght() {
		return simulationLenght;
	}

	public void setSimulationLenght(String simulationLenght) {
		this.simulationLenght = Integer.parseInt(simulationLenght);
	}

	public void setWithdrawLowerLimit(String withdrawLowerLimit) {
		this.withdrawLowerLimit = Integer.parseInt(withdrawLowerLimit);
	}

	public void setWithdrawUpperLimit(String withdrawUpperLimit) {
		this.withdrawUpperLimit = Integer.parseInt(withdrawUpperLimit);
	}

	public void setClientsPerDayMax(String clientsPerDayMax) {
		this.clientsPerDayMax = Integer.parseInt(clientsPerDayMax);
	}

	public void setClientsPerDayMin(String string) {
		this.clientsPerDayMin = Integer.parseInt(string);
	}

	public void setClientsPerSecond(String string) {
		this.clientsPerSecond = Integer.parseInt(string);
	}

	public int getPLN200() {
		return PLN200;
	}

	public void setPLN200(Integer pLN200) {
		PLN200 = pLN200;
	}

	public int getPLN100() {
		return PLN100;
	}

	public void setPLN100(Integer pLN100) {
		PLN100 = pLN100;
	}

	public int getPLN50() {
		return PLN50;
	}

	public void setPLN50(Integer pLN50) {
		PLN50 = pLN50;
	}

	public int getPLN20() {
		return PLN20;
	}

	public void setPLN20(Integer pLN20) {
		PLN20 = pLN20;
	}

	public int getPLN10() {
		return PLN10;
	}

	public void setPLN10(Integer pLN10) {
		PLN10 = pLN10;
	}
}
