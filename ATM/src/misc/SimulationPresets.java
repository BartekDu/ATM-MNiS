package misc;

public class SimulationPresets {

	private String withdrawLowerLimit;
	private String withdrawUpperLimit;
	private String clientsPerDay;
	private String clientsPerSecond;

	public String getWithdrawLowerLimit() {
		return withdrawLowerLimit;
	}

	public String getWithdrawUpperLimit() {
		return withdrawUpperLimit;
	}

	public String getClientsPerDay() {
		return clientsPerDay;
	}

	public String getClientsPerSecond() {
		return clientsPerSecond;
	}

	public void setWithdrawLowerLimit(String withdrawLowerLimit) {
		this.withdrawLowerLimit = withdrawLowerLimit;
	}

	public void setWithdrawUpperLimit(String withdrawUpperLimit) {
		this.withdrawUpperLimit = withdrawUpperLimit;
	}

	public void setClientsPerDay(String string) {
		this.clientsPerDay = string;
	}

	public void setClientsPerSecond(String string) {
		this.clientsPerSecond = string;
	}
}
