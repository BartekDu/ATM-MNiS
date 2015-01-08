package client;

import java.util.Random;

public class Client extends AbstractClient {

    public Client() {

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
