package misc;

import java.util.ArrayList;
import java.util.List;

public class IterarionLog {

	private static int CLIENT_ID = 0;

	private List<String> notesCountBefor;

	private int clientWithdrawRequest;

	private List<Integer> withdrawedNotes;

	public IterarionLog() {
		CLIENT_ID++;
		notesCountBefor = new ArrayList<String>();
		withdrawedNotes = new ArrayList<Integer>();

	}

	public void addNotesCountInformation(String noteCount) {
		notesCountBefor.add(noteCount);
	}

	public void addWithdrawedNotesInformation(Integer withrawedNote) {
		withdrawedNotes.add(withrawedNote);
	}

	public int getClientWithdrawRequest() {
		return clientWithdrawRequest;
	}

	public void setClientWithdrawRequest(int clientWithdrawRequest) {
		this.clientWithdrawRequest = clientWithdrawRequest;
	}

	@Override
	public String toString() {
		String output = "Klient numer: " + CLIENT_ID + " od pocz¹tku symulacji"
				+ System.lineSeparator();
		output += "Iloœæ banknotów w bankomacie: " + System.lineSeparator();
		for (String string : notesCountBefor) {
			output += string + System.lineSeparator();
		}
		output += "Klient chce wyp³aciæ: " + clientWithdrawRequest
				+ System.lineSeparator();

		if (withdrawedNotes.size() == 0) {
			output += "Bankomat nie móg³ zrealizowaæ ¿¹dania z powodu braku œrodków.";
		} else {
			output += "Wyp³acone banknoty: " + System.lineSeparator();
			for (Integer note : withdrawedNotes) {
				output += note + ", ";

			}
		}
		output += System.lineSeparator() + "**************************"
				+ System.lineSeparator();
		return output;
	}

}
