package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class SomeWindow extends JDialog {
	private List<Integer> graphData = new ArrayList<Integer>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @param withdrawalHistory
	 */
	public SomeWindow(List<Integer> withdrawalHistory) {
		this.graphData = withdrawalHistory;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Chart(graphData));
		frame.pack();

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
