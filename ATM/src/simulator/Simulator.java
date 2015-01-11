package simulator;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import misc.Presenter;
import view.AppWindowAdmin;

public class Simulator {

	public static void main(String[] args) {
		SimulationController simCont = new SimulationController();
		Presenter presenter = new Presenter(simCont);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					// Set cross-platform Java L&F (also called "Metal")
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (UnsupportedLookAndFeelException e) {
					// handle exception
				} catch (ClassNotFoundException e) {
					// handle exception
				} catch (InstantiationException e) {
					// handle exception
				} catch (IllegalAccessException e) {
					// handle exception
				}

				AppWindowAdmin window = new AppWindowAdmin(presenter);
				// TODO Auto-generated method stub

			}
		});
	}

}
