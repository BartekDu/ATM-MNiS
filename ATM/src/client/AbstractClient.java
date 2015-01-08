package client;

public abstract class AbstractClient implements IClient {

    protected double correctPinChance;

    protected int upperWithdrawLimit;

    protected int lowerWithdrawLimit;

    public AbstractClient() {
        // TODO Auto-generated constructor stub
    }

    public double getCORRECT_PIN_CHANCE() {
        return correctPinChance;
    }

    public void setCORRECT_PIN_CHANCE(double cORRECT_PIN_CHANCE) {
        correctPinChance = cORRECT_PIN_CHANCE;
    }

    public int getUpperWithdrawLimit() {
        return upperWithdrawLimit;
    }

    public void setUpperWithdrawLimit(int upperWithdrawLimit) {
        this.upperWithdrawLimit = upperWithdrawLimit;
    }

    public int getLowerWithdrawLimit() {
        return lowerWithdrawLimit;
    }

    public void setLowerWithdrawLimit(int lowerWithdrawLimit) {
        this.lowerWithdrawLimit = lowerWithdrawLimit;
    }
}
