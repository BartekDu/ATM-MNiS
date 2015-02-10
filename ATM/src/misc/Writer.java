package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {

	private PrintWriter out;

	public Writer() {
		String path = System.getProperty("user.home") + "/Desktop/";
		File f = new File(path + "simulationLog.txt");
		try {
			out = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void write(String s) {

		out.println(s);
		out.flush(); // TODO napraw

	}
}
