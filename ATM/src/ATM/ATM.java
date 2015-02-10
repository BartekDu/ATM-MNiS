package ATM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import misc.IterarionLog;
import misc.Writer;
import client.AbstractClient;
import client.IClient;

public class ATM implements IATM {

    private IClient client;

    private List<Integer> notesValues;

    private HashMap<Integer, Integer> notesCount; // klucz - wartosc banknotu,
                                                  // value - ilosc w banku

    ArrayList<Integer> withdrawedNotes;

    int clientWithdrawRequest;

    private Writer write;

    private List<Integer> balanceHistory;

    private IterarionLog iterationLog;

    public ATM() {

        balanceHistory = new ArrayList<Integer>();
        prepareNotesCountMap();
        prepareSortedNotesValueList();
        write = new Writer();

    }

    private void prepareSortedNotesValueList() {
        Collection<Integer> posibleNotes = notesCount.keySet();
        notesValues = asSortedList(posibleNotes);
        Collections.reverse(notesValues);
    }

    private void prepareNotesCountMap() {
        notesCount = new HashMap<>();
        notesCount.put(NotesValues.PLN200, 0);
        notesCount.put(NotesValues.PLN100, 0);
        notesCount.put(NotesValues.PLN50, 0);
        notesCount.put(NotesValues.PLN20, 0);
        notesCount.put(NotesValues.PLN10, 0);
    }

    @Override
    public void nextClient(AbstractClient client) {

        this.client = client;
        iterationLog = new IterarionLog();
        int withdrawAmmount = client.getWithdrawRequest();
        withdrawMoney(withdrawAmmount);
        balanceHistory.add(calculateATMBalance());
        saveIterationInformation();
    }

    public void withdrawMoney(int request) {
        withdrawedNotes = new ArrayList<Integer>();
        clientWithdrawRequest = request;

        if (calculateATMBalance() >= request) {
            int restToWithdraw = request;

            while (restToWithdraw > 0) {
                Integer noteValue = findHighestPossibleNote(restToWithdraw);
                if (noteValue != null) {
                    withdrawedNotes.add(noteValue);

                    restToWithdraw -= noteValue;
                    reduceNoteCount(noteValue);
                } else {

                    break;
                }

            }

        }
    }

    private void reduceNoteCount(Integer noteValue) {
        Integer count = notesCount.get(noteValue);
        count--;
        notesCount.put(noteValue, count);
    }

    public boolean isEnought(Integer note) {
        Integer count = notesCount.get(note);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer findHighestPossibleNote(int request) {

        for (Integer noteValue : notesValues) {
            if (noteValue <= request && isEnought(noteValue)) {

                return noteValue;
            }

        }

        return null; // nie powinien cuz request zawsze >=10
    }

    public int calculateATMBalance()

    {
        int totalSum = 0;

        for (Integer noteValue : notesValues) {
            totalSum += noteValue * notesCount.get(noteValue);

        }
        return totalSum;
    }

    public void saveIterationInformation() {
        iterationLog.setClientWithdrawRequest(clientWithdrawRequest);
        for (Integer noteValue : notesValues) {
            iterationLog.addNotesCountInformation((noteValue + "PLN" + " = " + notesCount.get(noteValue)));
        }
        for (Integer note : withdrawedNotes) {
            iterationLog.addWithdrawedNotesInformation(note);
        }
    }

    // to do sortowania collectionow
    public static <T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
        List<T> list = new ArrayList<T>(c);
        java.util.Collections.sort(list);
        return list;
    }

    @Override
    public void refillNotes(int PLN200Count, int PLN100Count, int PLN50Count, int PLN20Count, int PLN10Count) {
        int[] additionalCountTab = { PLN200Count, PLN100Count, PLN50Count, PLN20Count, PLN10Count };
        for (int countIndex = 0; countIndex < additionalCountTab.length; countIndex++) {
            Integer mapKey = notesValues.get(countIndex);
            increaseNoteCount(mapKey, additionalCountTab[countIndex]);

        }

    }

    private void increaseNoteCount(Integer noteValue, int additionalCount) {
        Integer count = notesCount.get(noteValue);
        count += additionalCount;
        notesCount.put(noteValue, count);
    }

    @Override
    public IterarionLog getTransactionInformation() {
        return iterationLog;

    }

    @Override
    public List<Integer> getBalanceHistory() {
        return balanceHistory;
    }

    public void setBalanceHistory(List<Integer> balanceHistory) {
        this.balanceHistory = balanceHistory;
    }
}
