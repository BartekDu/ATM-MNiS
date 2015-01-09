package ATM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import misc.Writer;
import client.AbstractClient;
import client.IClient;

public class ATM implements IATM {

    private IClient client;

    private List<Integer> notesValues;

    private HashMap<Integer, Integer> notesCount; // klucz - wartosc banknotu,
                                                  // value - ilosc w banku

    private Writer write;

    public ATM() {

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

        int withdrawAmmount = client.getWithdrawRequest();
        withdrawMoney(withdrawAmmount);

    }

    public void withdrawMoney(int request) {
        printMoneyCountStatus();

        if (calculateATMBalance() >= request) {
            int restToWithdraw = request;
            ArrayList<Integer> withdrawedNotes = new ArrayList<Integer>();
            while (restToWithdraw > 0) {
                Integer noteValue = findHighestPossibleNote(restToWithdraw);
                if (noteValue != null) {
                    withdrawedNotes.add(noteValue);
                    restToWithdraw -= noteValue;
                    reduceNoteCount(noteValue);
                } else {
                    write.write("Bankomat nie ma banknotow do realizacji zadania");
                    break;
                }

            }
            write.write("Wyplacone banknoty: " + withdrawedNotes);
        } else {
            write.write("Bankomat nie ma banknotow do realizacji zadania");
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

    public void printMoneyCountStatus() {
        write.write("Stan banknotow w bankomacie: ");
        for (Integer noteValue : notesValues) {
            write.write(noteValue + "PLN" + " = " + notesCount.get(noteValue));
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
}
