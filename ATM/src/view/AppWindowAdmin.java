package view;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import misc.SimulationPresets;
import simulator.Presenter;

public class AppWindowAdmin {

	private JFrame frame;

	private JTextField lowerWithdrawal;

	private JTextField upperWithdrawal;

	private JTextField peoplePerDay;

	private JTextField peoplePerSecond;

	private Presenter presenter;

	private SimulationPresets simPreset;
	private JTextField textField;
	private JFrame frame_1;

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
		// TODO dlugos spinner dostosowana do int 3 digit
		JPanel runtime = new JPanel();
		runtime.setBounds(0, 0, 434, 305);
		frame_1.getContentPane().add(runtime);
		runtime.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Uzupe\u0142nij warto\u015Bci danych namina\u0142\u00F3w");
		panel_1.setBorder(new TitledBorder(null, "Dostêpne nomna³y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 11, 149, 244);
		runtime.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 19, 46, 114);
		panel_1.add(panel_2);

		JLabel label = new JLabel("200 PLN");
		label.setBounds(0, 0, 46, 14);
		panel_2.add(label);

		JLabel label_1 = new JLabel("100 PLN");
		label_1.setBounds(0, 25, 46, 14);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel("50 PLN");
		label_2.setBounds(0, 50, 46, 14);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("20 PLN");
		label_3.setBounds(0, 75, 46, 14);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel("10 PLN");
		label_4.setBounds(0, 100, 46, 14);
		panel_2.add(label_4);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(76, 19, 46, 120);
		panel_1.add(panel_3);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {

			}
		});
		spinner_1.setBounds(0, 0, 43, 20);

		panel_3.add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_2.setBounds(0, 25, 43, 20);
		panel_3.add(spinner_2);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_3.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_3.setBounds(0, 50, 43, 20);
		panel_3.add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_4.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_4.setBounds(0, 75, 43, 20);
		panel_3.add(spinner_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_5.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_5.setBounds(0, 100, 43, 20);
		panel_3.add(spinner_5);

		JButton button = new JButton("Resetuj");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spinner_1.setValue(new Integer(0));
				spinner_2.setValue(new Integer(0));
				spinner_3.setValue(new Integer(0));
				spinner_4.setValue(new Integer(0));
				spinner_5.setValue(new Integer(0));

			}
		});
		button.setBounds(16, 144, 89, 23);
		panel_1.add(button);

		JLabel lblUzupenijPo = new JLabel("Uzupe\u0142nij po");
		lblUzupenijPo.setBounds(7, 178, 59, 14);
		panel_1.add(lblUzupenijPo);

		JSpinner spinner_6 = new JSpinner();
		spinner_6.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		spinner_6.setBounds(67, 175, 38, 20);
		panel_1.add(spinner_6);

		JLabel lblDniach = new JLabel("dniach");
		lblDniach.setBounds(106, 178, 46, 14);
		panel_1.add(lblDniach);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(190, 11, 234, 68);
		runtime.add(panel_5);
		panel_5.setBorder(new TitledBorder(null, "Limit wyp³aty", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setLayout(null);

		JLabel lblGrnaGranicaWypaty = new JLabel("Dolny");
		lblGrnaGranicaWypaty.setBounds(95, 44, 37, 14);
		panel_5.add(lblGrnaGranicaWypaty);

		JLabel lblGrny = new JLabel("G\u00F3rny");
		lblGrny.setBounds(95, 19, 37, 14);
		panel_5.add(lblGrny);

		lowerWithdrawal = new JTextField();
		lowerWithdrawal.setBounds(142, 16, 86, 20);
		panel_5.add(lowerWithdrawal);
		lowerWithdrawal.setToolTipText("Najni\u017Csza dozwolona kwota wyp\u0142aty");
		lowerWithdrawal.setText("10");
		lowerWithdrawal.setColumns(10);

		upperWithdrawal = new JTextField();
		upperWithdrawal.setBounds(142, 41, 86, 20);
		panel_5.add(upperWithdrawal);
		upperWithdrawal.setText("3000");
		upperWithdrawal.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(190, 90, 234, 74);
		runtime.add(panel);
		panel.setBorder(new TitledBorder(null, "Iloœæ klientow na sekundê", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel.setLayout(null);

		JLabel lblLiczbaKlijentwNa = new JLabel("Minimalna");
		lblLiczbaKlijentwNa.setBounds(66, 19, 66, 14);
		panel.add(lblLiczbaKlijentwNa);

		peoplePerDay = new JTextField();
		peoplePerDay.setBounds(142, 16, 86, 20);
		panel.add(peoplePerDay);
		peoplePerDay.setText("100");
		peoplePerDay.setColumns(10);

		JLabel lblMaksymalna = new JLabel("Maksymalna");
		lblMaksymalna.setBounds(66, 50, 66, 14);
		panel.add(lblMaksymalna);

		textField = new JTextField();
		textField.setBounds(142, 47, 86, 20);
		panel.add(textField);
		textField.setText("100");
		textField.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(190, 175, 234, 43);
		runtime.add(panel_6);
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setLayout(null);

		JLabel lblIloKlientowNa = new JLabel("Ilo\u015B\u0107 klientow na sekund\u0119");
		lblIloKlientowNa.setBounds(6, 16, 126, 14);
		panel_6.add(lblIloKlientowNa);

		peoplePerSecond = new JTextField();
		peoplePerSecond.setBounds(142, 16, 86, 20);
		panel_6.add(peoplePerSecond);
		peoplePerSecond.setText("100");
		peoplePerSecond.setColumns(10);

		JButton btnWstrzymaj = new JButton("Wstrzymaj");
		btnWstrzymaj.setBounds(216, 248, 89, 27);
		btnWstrzymaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				presenter.stopSimulation();

			}
		});
		runtime.add(btnWstrzymaj);

		JButton btnNewButton_1 = new JButton("Wzn\u00F3w");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				simPreset = new SimulationPresets();
				simPreset.setClientsPerDay(peoplePerDay.getText());
				simPreset.setClientsPerSecond(peoplePerSecond.getText());
				simPreset.setWithdrawLowerLimit(lowerWithdrawal.getText());
				simPreset.setWithdrawUpperLimit(upperWithdrawal.getText());
				simPreset.setPLN200((Integer) spinner_1.getValue());
				simPreset.setPLN100((Integer) spinner_2.getValue());
				simPreset.setPLN50((Integer) spinner_3.getValue());
				simPreset.setPLN20((Integer) spinner_4.getValue());
				simPreset.setPLN10((Integer) spinner_5.getValue());
				simPreset.setDaysToRefill((Integer) spinner_6.getValue());
				presenter.setSimulationSettings(simPreset);
				presenter.startSimulation();

			}
		});
		btnNewButton_1.setBounds(321, 248, 89, 27);
		runtime.add(btnNewButton_1);

	}

	public SimulationPresets getSimulationPreset() {
		return simPreset;
	}

	public void setSimulationPreset(SimulationPresets simPreset) {
		this.simPreset = simPreset;
	}
}
