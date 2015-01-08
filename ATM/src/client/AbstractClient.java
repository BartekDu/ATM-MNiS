package client;

public abstract class AbstractClient implements IClient {
    protected static final int withdrawLimit = ClientSimulationParameters.UPPER_WITHDRAW_LIMIT / 10;

    public AbstractClient() {
        // TODO Auto-generated constructor stub
    }

}
