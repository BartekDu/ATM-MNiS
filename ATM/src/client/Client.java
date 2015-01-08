package client;

import java.util.Random;

public class Client extends AbstractClient {

    public Client() {

    }

    @Override
    public PIN insertPIN() {
        double rolledValue = Math.random();
        if (rolledValue < ClientSimulationParameters.CORRECT_PIN_CHANCE) {
            return PIN.CORRECT;
        } else {
            return PIN.INCORRECT;
        }
    }

    @Override
    public int getWithdrawRequest() {
        Random rand = new Random();
        int request = rand.nextInt(upperWithdrawLimit) + 1;
        while (request < lowerWithdrawLimit) {
            request = rand.nextInt(upperWithdrawLimit) + 1;

        }
        request *= 10;
        System.out.println("Klient chce wyplacic: " + request);
        return request;
    }

}
