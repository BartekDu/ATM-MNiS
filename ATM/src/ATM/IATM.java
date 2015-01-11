package ATM;

import misc.IterarionLog;
import client.AbstractClient;

public interface IATM {

    public void nextClient(AbstractClient client);

    public void refillNotes(int additionalPLN200Count, int additionalPLN100Count, int additionalPLN50Count, int additionalPLN20Count,
            int additionalPLN10Count);

    public IterarionLog getTransactionInformation();
}
