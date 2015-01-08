package misc;

public class SimulationPresets {

	private String withdrawLowerLimit;
	private String withdrawUpperLimit;
	private String clientsPerDay;
	private String clientsPerSecond;
	private String PLN200;
	private String PLN100;
	private String PLN50;
	private String PLN20;
	private String PLN10;
	private String daysToRefill;

	public String getPLN200() {
		return PLN200;
	}

	public String getPLN100() {
		return PLN100;
	}

	public String getPLN50() {
		return PLN50;
	}

	public String getPLN20() {
		return PLN20;
	}

	public String getPLN10() {
		return PLN10;
	}

	public String getDaysToRefill() {
		return daysToRefill;
	}

	public void setPLN200(String pLN200) {
		PLN200 = pLN200;
	}

	public void setPLN100(String pLN100) {
		PLN100 = pLN100;
	}

	public void setPLN50(String pLN50) {
		PLN50 = pLN50;
	}

	public void setPLN20(String pLN20) {
		PLN20 = pLN20;
	}

	public void setPLN10(String pLN10) {
		PLN10 = pLN10;
	}

	public void setDaysToRefill(String daysToRefill) {
		this.daysToRefill = daysToRefill;
	}

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
