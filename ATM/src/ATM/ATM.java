package ATM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import client.AbstractClient;
import client.IClient;
import client.PIN;

public class ATM implements IATM {

    private int tryLimit = 3;

    private IClient client;

    private List<Integer> notesValues;

    private HashMap<Integer, Integer> notesCount; // klucz - wartosc banknotu, value - ilosc w banku

    public ATM() {

        prepareNotesCountMap();
        prepareSortedNotesValueList();
    }

    private void prepareSortedNotesValueList() {
        Collection<Integer> posibleNotes = notesCount.keySet();
        notesValues = asSortedList(posibleNotes);
        Collections.reverse(notesValues);
    }

    private void prepareNotesCountMap() {
        notesCount = new HashMap<>();
        notesCount.put(NotesValues.PLN200, NotesCount.PLN_200);
        notesCount.put(NotesValues.PLN100, NotesCount.PLN_100);
        notesCount.put(NotesValues.PLN50, NotesCount.PLN_50);
        notesCount.put(NotesValues.PLN20, NotesCount.PLN_20);
        notesCount.put(NotesValues.PLN10, NotesCount.PLN_10);
    }

    @Override
    public void nextClient(AbstractClient client) {

        this.client = client;

        if (isCorrectPIN()) {
            int withdrawAmmount = client.getWithdrawRequest();
            withdrawMoney(withdrawAmmount);
        } else {
            System.out.println("Klient poda³ niepoprawny PIN!");
        }
    }

    private boolean isCorrectPIN() {
        for (int tryNumber = 1; tryNumber <= tryLimit; tryNumber++) {
            PIN pin = client.insertPIN();
            if (pin == PIN.CORRECT) {
                return true;
            }

        }
        return false;
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
                    System.out.println("Bankomat nie ma banknotow do realizacji zadania");
                    break;
                }

            }
            System.out.println("Wyplacone banknoty: " + withdrawedNotes);
        } else {
            System.out.println("Bankomat nie ma banknotow do realizacji zadania");
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
        System.out.println("Stan banknotow w bankomacie: ");
        for (Integer noteValue : notesValues) {
            System.out.println(noteValue + "PLN" + " = " + notesCount.get(noteValue));
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
