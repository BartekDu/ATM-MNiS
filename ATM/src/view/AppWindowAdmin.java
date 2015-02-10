package view;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import misc.Presenter;
import misc.SimulationPresets;

public class AppWindowAdmin {

	private JFrame frame;
	private JButton buttonStart = new JButton("Start");
	private JTextField lowerWithdrawal;

	private JTextField upperWithdrawal;

	private JTextField clientsPerDayMin;

	private JTextField clientsPerSecond;

	private Presenter presenter;

	private SimulationPresets simPreset;

	private JTextField clientsPerDayMax;

	private JFrame frame_1;

	private JSpinner spinnerRefillAfterNDays = new JSpinner();

	private JLabel labelTimer;

	private JTextField simulationLenght;
	private JButton btnStop = new JButton("Stop");

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// AppWindowAdmin window = new AppWindowAdmin();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 * 
	 * @param presenter
	 */
	public AppWindowAdmin(Presenter presenter) {
		this.presenter = presenter;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private JFrame createMainFrame() { // TODO smth like dis
		frame_1 = new JFrame();
		frame_1.setType(Type.POPUP);
		frame_1.setResizable(false);
		frame_1.setBounds(100, 100, 450, 343);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		return frame_1;
	}

	private void initialize() {
		frame = createMainFrame();

		JPanel panelMain = new JPanel();
		panelMain.setBounds(0, 0, 434, 315);
		frame_1.getContentPane().add(panelMain);
		panelMain.setLayout(null);

		JPanel panelAvNotesSettings = new JPanel();
		panelAvNotesSettings.setLayout(null);
		// TODO tutaj
		setDynamicIntervalInNominalSpinnersBorder(panelAvNotesSettings);
		panelAvNotesSettings.setBorder(new TitledBorder(null,
				"Dostêpne nomna³y", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panelAvNotesSettings.setBounds(21, 11, 149, 231);
		panelMain.add(panelAvNotesSettings);
		// JPanel panelAvNotesSettings = new JPanel();
		panelAvNotesSettings.setLayout(null);
		// TODO tutaj
		setDynamicIntervalInNominalSpinnersBorder(panelAvNotesSettings);
		panelAvNotesSettings.setBorder(new TitledBorder(null,
				"Dostêpne nomna³y", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panelAvNotesSettings.setBounds(21, 11, 149, 231);
		panelMain.add(panelAvNotesSettings);

		JPanel panelNotesLabels = new JPanel();
		panelNotesLabels.setLayout(null);
		panelNotesLabels.setBounds(10, 19, 46, 114);
		panelAvNotesSettings.add(panelNotesLabels);

		JLabel label = new JLabel("200 PLN");
		label.setBounds(0, 0, 46, 14);
		panelNotesLabels.add(label);

		JLabel label_1 = new JLabel("100 PLN");
		label_1.setBounds(0, 25, 46, 14);
		panelNotesLabels.add(label_1);

		JLabel label_2 = new JLabel("50 PLN");
		label_2.setBounds(0, 50, 46, 14);
		panelNotesLabels.add(label_2);

		JLabel label_3 = new JLabel("20 PLN");
		label_3.setBounds(0, 75, 46, 14);
		panelNotesLabels.add(label_3);

		JLabel label_4 = new JLabel("10 PLN");
		label_4.setBounds(0, 100, 46, 14);
		panelNotesLabels.add(label_4);

		JPanel panelSpinners = new JPanel();
		panelSpinners.setLayout(null);
		panelSpinners.setBounds(76, 19, 46, 120);
		panelAvNotesSettings.add(panelSpinners);

		JSpinner spinner200 = new JSpinner();
		spinner200.setModel(new SpinnerNumberModel(100, 0, 999, 1));
		spinner200.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {

			}
		});
		spinner200.setBounds(0, 0, 43, 20);

		panelSpinners.add(spinner200);

		JSpinner spinner100 = new JSpinner();
		spinner100.setModel(new SpinnerNumberModel(100, 0, 999, 1));
		spinner100.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner100.setBounds(0, 25, 43, 20);
		panelSpinners.add(spinner100);

		JSpinner spinner50 = new JSpinner();
		spinner50.setModel(new SpinnerNumberModel(100, 0, 999, 1));
		spinner50.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner50.setBounds(0, 50, 43, 20);
		panelSpinners.add(spinner50);

		JSpinner spinner20 = new JSpinner();
		spinner20.setModel(new SpinnerNumberModel(100, 0, 999, 1));
		spinner20.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner20.setBounds(0, 75, 43, 20);
		panelSpinners.add(spinner20);

		JSpinner spinner10 = new JSpinner();
		spinner10.setModel(new SpinnerNumberModel(100, 0, 999, 1));
		spinner10.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner10.setBounds(0, 100, 43, 20);
		panelSpinners.add(spinner10);

		JButton buttonRestAvNotes = new JButton("Resetuj");
		buttonRestAvNotes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spinner200.setValue(new Integer(100));
				spinner100.setValue(new Integer(100));
				spinner50.setValue(new Integer(100));
				spinner20.setValue(new Integer(100));
				spinner10.setValue(new Integer(100));

			}
		});
		buttonRestAvNotes.setBounds(16, 144, 89, 23);
		panelAvNotesSettings.add(buttonRestAvNotes);

		JLabel lblUzupenijPo = new JLabel("Uzupe\u0142nij po");
		lblUzupenijPo.setBounds(7, 178, 59, 14);
		panelAvNotesSettings.add(lblUzupenijPo);

		spinnerRefillAfterNDays.setModel(new SpinnerNumberModel(new Integer(1),
				new Integer(1), null, new Integer(1)));
		spinnerRefillAfterNDays.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setDynamicIntervalInNominalSpinnersBorder(panelAvNotesSettings);
			}
		});
		spinnerRefillAfterNDays.setBounds(67, 175, 38, 20);
		panelAvNotesSettings.add(spinnerRefillAfterNDays);

		JLabel lblDniach = new JLabel("dniach");
		lblDniach.setBounds(106, 178, 46, 14);
		panelAvNotesSettings.add(lblDniach);

		JPanel panelWithdrawalLimits = new JPanel();
		panelWithdrawalLimits.setBounds(190, 11, 234, 68);
		panelMain.add(panelWithdrawalLimits);
		panelWithdrawalLimits.setBorder(new TitledBorder(null, "Limit wyp³aty",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelWithdrawalLimits.setLayout(null);

		JLabel lblGrnaGranicaWypaty = new JLabel("G\u00F3rny");
		lblGrnaGranicaWypaty.setBounds(95, 44, 37, 14);
		panelWithdrawalLimits.add(lblGrnaGranicaWypaty);

		JLabel lblGrny = new JLabel("Dolny");
		lblGrny.setBounds(95, 19, 37, 14);
		panelWithdrawalLimits.add(lblGrny);

		lowerWithdrawal = new JTextField();
		lowerWithdrawal.setBounds(142, 16, 86, 20);
		panelWithdrawalLimits.add(lowerWithdrawal);
		lowerWithdrawal
				.setToolTipText("Najni\u017Csza dozwolona kwota wyp\u0142aty");
		lowerWithdrawal.setText("10");
		lowerWithdrawal.setColumns(10);

		upperWithdrawal = new JTextField();
		upperWithdrawal.setBounds(142, 41, 86, 20);
		panelWithdrawalLimits.add(upperWithdrawal);
		upperWithdrawal.setText("3000");
		upperWithdrawal.setColumns(10);

		JPanel panelClientsPerSecondLimits = new JPanel();
		panelClientsPerSecondLimits.setBounds(190, 90, 234, 74);
		panelMain.add(panelClientsPerSecondLimits);
		panelClientsPerSecondLimits.setBorder(new TitledBorder(null,
				"Iloœæ klientow na dobê", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelClientsPerSecondLimits.setLayout(null);

		JLabel lblLiczbaKlijentwNa = new JLabel("Minimalna");
		lblLiczbaKlijentwNa.setBounds(76, 19, 56, 14);
		panelClientsPerSecondLimits.add(lblLiczbaKlijentwNa);
		// TODO pawel tu masz te <x,y> uzywaj
		clientsPerDayMin = new JTextField();
		clientsPerDayMin.setBounds(142, 16, 86, 20);
		panelClientsPerSecondLimits.add(clientsPerDayMin);
		clientsPerDayMin.setText("25");
		clientsPerDayMin.setColumns(10);

		JLabel lblMaksymalna = new JLabel("Maksymalna");
		lblMaksymalna.setBounds(66, 50, 66, 14);
		panelClientsPerSecondLimits.add(lblMaksymalna);

		clientsPerDayMax = new JTextField();
		clientsPerDayMax.setBounds(142, 47, 86, 20);
		panelClientsPerSecondLimits.add(clientsPerDayMax);
		clientsPerDayMax.setText("200");
		clientsPerDayMax.setColumns(10);

		JPanel panelOtherConstants = new JPanel();
		panelOtherConstants.setBounds(190, 168, 234, 74);
		panelMain.add(panelOtherConstants);
		panelOtherConstants.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOtherConstants.setLayout(null);

		JLabel lblIloKlientowNa = new JLabel(
				"Ilo\u015B\u0107 klientow na sekund\u0119");
		lblIloKlientowNa.setBounds(6, 16, 126, 14);
		panelOtherConstants.add(lblIloKlientowNa);

		clientsPerSecond = new JTextField();
		clientsPerSecond.setBounds(142, 10, 86, 20);
		panelOtherConstants.add(clientsPerSecond);
		clientsPerSecond.setText("100");
		clientsPerSecond.setColumns(10);

		JLabel labelSimulationDays = new JLabel(
				"D\u0142ugo\u015B\u0107 symulacji");
		labelSimulationDays.setToolTipText("Dni");
		labelSimulationDays.setBounds(6, 42, 126, 14);
		panelOtherConstants.add(labelSimulationDays);

		simulationLenght = new JTextField();
		simulationLenght.setToolTipText("Dni");
		simulationLenght.setText("10");
		simulationLenght.setColumns(10);
		simulationLenght.setBounds(142, 39, 86, 20);
		panelOtherConstants.add(simulationLenght);

		btnStop.setEnabled(false);
		btnStop.setBounds(216, 248, 89, 27);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stopGUI();
				btnStop.setEnabled(false);
			}

		});
		panelMain.add(btnStop);

		buttonStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO tutaj masz co sie dzieje po nacisnieciu wznow
				simPreset = new SimulationPresets();
				simPreset.setClientsPerDayMin(clientsPerDayMin.getText());
				simPreset.setClientsPerDayMax(clientsPerDayMax.getText());
				simPreset.setClientsPerSecond(clientsPerSecond.getText());
				simPreset.setWithdrawLowerLimit(lowerWithdrawal.getText());
				simPreset.setWithdrawUpperLimit(upperWithdrawal.getText());
				simPreset.setPLN200((Integer) spinner200.getValue());
				simPreset.setPLN100((Integer) spinner100.getValue());
				simPreset.setPLN50((Integer) spinner50.getValue());
				simPreset.setPLN20((Integer) spinner20.getValue());
				simPreset.setPLN10((Integer) spinner10.getValue());
				simPreset.setDaysToRefill((Integer) spinnerRefillAfterNDays
						.getValue());
				simPreset.setSimulationLenght(simulationLenght.getText());
				presenter.setSimulationSettings(simPreset);
				presenter.startSimulation();
				btnStop.setEnabled(true);
				buttonStart.setEnabled(false);
			}
		});
		buttonStart.setBounds(321, 248, 89, 27);
		panelMain.add(buttonStart);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dzieñ symulacji",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 248, 161, 56);
		panelMain.add(panel);
		panel.setLayout(null);

		labelTimer = new JLabel("0");
		labelTimer.setBounds(6, 16, 149, 33);
		panel.add(labelTimer);
		labelTimer.setFont(new Font("Tahoma", Font.PLAIN, 18));

	}

	public void setDynamicIntervalInNominalSpinnersBorder(
			JPanel panelAvNotesSettings) {
		panelAvNotesSettings
				.setToolTipText("Uzupe\u0142nij warto\u015Bci danych namina\u0142\u00F3w, kt\u00F3re b\u0119d\u0105 dostaczone w "
						+ spinnerRefillAfterNDays.getValue()
						+ " dniowym interwale z mennicy");
	}

	public SimulationPresets getSimulationPreset() {
		return simPreset;
	}

	public void setSimulationPreset(SimulationPresets simPreset) {
		this.simPreset = simPreset;
	}

	protected String getLabelTimerText() {
		return labelTimer.getText();
	}

	protected void setLabelTimerText(String text) {
		labelTimer.setText(text);
	}

	public void setTimer(int i) {
		setLabelTimerText("" + i);

	}

	public void stopGUI() {
		List<Integer> withdrawalHistory = presenter.getHistory();
		presenter.stopSimulation();
		// TODO tutaj

		SomeWindow graphWindow = new SomeWindow(withdrawalHistory);
		graphWindow.getFrame().setVisible(true);
		graphWindow.setAlwaysOnTop(true);
		btnStop.setEnabled(false);
		buttonStart.setEnabled(true);
	}
	// TODO Klient w dobie: 1 ==>biez
	// TODO kwota wyplacona, pozostala
	// TODO kazdy k. osobny czas max 2 min => zaznaczyc przeliczenie
	// TODO tl k na d maks <min
}
