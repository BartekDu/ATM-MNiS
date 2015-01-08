package client;

public abstract class AbstractClient implements IClient {

    protected int upperWithdrawLimit;

    protected int lowerWithdrawLimit;

    public AbstractClient() {
        // TODO Auto-generated constructor stub
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
