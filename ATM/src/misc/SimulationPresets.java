package misc;

public class SimulationPresets {

    private String withdrawLowerLimit;

    private String withdrawUpperLimit;

    private String clientsPerDay;

    private String clientsPerSecond;

    private Integer PLN200;

    private Integer PLN100;

    private Integer PLN50;

    private Integer PLN20;

    private Integer PLN10;

    private String daysToRefill;

    public String getDaysToRefill() {
        return daysToRefill;
    }

    public int getDaysToRefillInt() {
        return Integer.parseInt(daysToRefill);
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

    public int getWithdrawLowerLimitInt() {
        return Integer.parseInt(withdrawLowerLimit);
    }

    public int getWithdrawUpperLimitInt() {
        return Integer.parseInt(withdrawUpperLimit);
    }

    public int getClientsPerDayInt() {
        return Integer.parseInt(clientsPerDay);
    }

    public int getClientsPerSecondInt() {
        return Integer.parseInt(clientsPerSecond);
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

    public Integer getPLN200() {
        return PLN200;
    }

    public void setPLN200(Integer pLN200) {
        PLN200 = pLN200;
    }

    public Integer getPLN100() {
        return PLN100;
    }

    public void setPLN100(Integer pLN100) {
        PLN100 = pLN100;
    }

    public Integer getPLN50() {
        return PLN50;
    }

    public void setPLN50(Integer pLN50) {
        PLN50 = pLN50;
    }

    public Integer getPLN20() {
        return PLN20;
    }

    public void setPLN20(Integer pLN20) {
        PLN20 = pLN20;
    }

    public Integer getPLN10() {
        return PLN10;
    }

    public void setPLN10(Integer pLN10) {
        PLN10 = pLN10;
    }
}
