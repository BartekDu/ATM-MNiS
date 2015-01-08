package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import misc.SimulationPresets;
import simulator.Presenter;

public class AppWindowAdmin {

	private JFrame frame;
	private JTextField textField;
	private JLabel labelScroll;
	private JLabel labelChkBox;
	private JLabel labelTextField;
	private JLabel labelButton;
	private JLabel labelSpinner;
	private JPasswordField passwordField;
	private JTextField lowerWithdrawal;
	private JTextField upperWithdrawal;
	private JTextField peoplePerDay;
	private JTextField peoplePerSecond;
	private Presenter presenter;
	private SimulationPresets simPreset;

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
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 424, 294);
		frame.getContentPane().add(tabbedPane);

		JPanel misc = new JPanel();
		tabbedPane.addTab("New tab", null, misc, null);
		misc.setLayout(null);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				JCheckBox cb = (JCheckBox) arg0.getSource();
				setLabelChkBoxText("" + cb.isSelected());
			}
		});

		chckbxNewCheckBox.setBounds(23, 81, 97, 23);
		misc.add(chckbxNewCheckBox);

		textField = new JTextField();
		textField.setBounds(120, 82, 86, 20);
		misc.add(textField);

		textField.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			private int i;

			public void actionPerformed(ActionEvent arg0) {
				labelButton.setText("" + i);
				i++;

			}
		});
		btnNewButton.setBounds(216, 81, 89, 23);
		misc.add(btnNewButton);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				JScrollBar b = (JScrollBar) arg0.getSource();
				setLabelScrollText("" + b.getValue());
			}
		});

		scrollBar.setBounds(0, 0, 17, 217);
		misc.add(scrollBar);

		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});

		spinner.setBounds(314, 82, 29, 20);
		misc.add(spinner);

		JPanel panel = new JPanel();
		panel.setBounds(33, 114, 376, 133);
		misc.add(panel);
		panel.setBorder(new TitledBorder(null, "listeners results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		labelScroll = new JLabel("New label");
		labelScroll.setBounds(6, 21, 46, 14);
		panel.add(labelScroll);

		labelChkBox = new JLabel("New label");
		labelChkBox.setBounds(6, 46, 46, 14);
		panel.add(labelChkBox);

		labelTextField = new JLabel("New label");
		labelTextField.setBounds(6, 71, 46, 14);
		panel.add(labelTextField);

		labelButton = new JLabel("New label");
		labelButton.setBounds(247, 21, 46, 14);
		panel.add(labelButton);

		labelSpinner = new JLabel("New label");
		labelSpinner.setBounds(247, 46, 46, 14);
		panel.add(labelSpinner);

		passwordField = new JPasswordField();
		passwordField
				.setToolTipText("Poprawne podanie has\u0142a umo\u017Cliwia dost\u0119p do panelu adminiastratora");
		passwordField.setBounds(144, 29, 100, 20);
		misc.add(passwordField);

		JLabel lblInfo = new JLabel("Info...3 fails ==cooldown");
		lblInfo.setBounds(144, 11, 124, 14);
		misc.add(lblInfo);

		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchToAdminTab(tabbedPane);
			}
		});
		btnLogin.setBounds(254, 28, 89, 23);
		misc.add(btnLogin);

		JPanel admin = new JPanel();
		tabbedPane.addTab("Administracja", null, admin, null);
		tabbedPane.setEnabledAt(1, false);
		admin.setLayout(null);

		JButton btnSave = new JButton("Zapisz");
		btnSave.setToolTipText("Zapiszuje wprowadzone zmiany");
		btnSave.setBounds(320, 232, 89, 23);
		admin.add(btnSave);

		JButton btnDiscardAmends = new JButton("Odzrzu\u0107 zmiany");
		btnDiscardAmends.setToolTipText("Odrzuca zmiany");
		btnDiscardAmends.setBounds(203, 232, 107, 23);
		admin.add(btnDiscardAmends);
		// TODO dlugos spinner dostosowana do int 3 digit
		JPanel runtime = new JPanel();
		tabbedPane.addTab("New tab", null, runtime, null);
		runtime.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Uzupe\u0142nij warto\u015Bci danych namina\u0142\u00F3w");
		panel_1.setBorder(new TitledBorder(null, "Dostêpne nomna³y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 141, 244);
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
			public void stateChanged(ChangeEvent arg0) {

			}
		});
		spinner_1.setBounds(0, 0, 43, 20);

		panel_3.add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_2.setBounds(0, 25, 43, 20);
		panel_3.add(spinner_2);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_3.setBounds(0, 50, 43, 20);
		panel_3.add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_4.setBounds(0, 75, 43, 20);
		panel_3.add(spinner_4);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		spinner_5.setBounds(0, 100, 43, 20);
		panel_3.add(spinner_5);

		JButton button = new JButton("Resetuj");
		button.addActionListener(new ActionListener() {
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
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		spinner_6.setBounds(67, 175, 38, 20);
		panel_1.add(spinner_6);

		JLabel lblDniach = new JLabel("dniach");
		lblDniach.setBounds(106, 178, 46, 14);
		panel_1.add(lblDniach);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Sta³e œrodowiskowe", TitledBorder.LEADING, TitledBorder.TOP, null,
				null));
		panel_4.setBounds(161, 11, 248, 161);
		runtime.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblGrnaGranicaWypaty = new JLabel("G\u00F3rna granica wyp\u0142aty");
		lblGrnaGranicaWypaty.setBounds(16, 43, 109, 14);
		panel_4.add(lblGrnaGranicaWypaty);

		JLabel label_5 = new JLabel("Dolna granica wyp\u0142aty");
		label_5.setBounds(16, 18, 107, 14);
		panel_4.add(label_5);

		JLabel lblLiczbaKlijentwNa = new JLabel("Liczba klijent\u00F3w na dob\u0119");
		lblLiczbaKlijentwNa.setBounds(16, 68, 116, 14);
		panel_4.add(lblLiczbaKlijentwNa);

		lowerWithdrawal = new JTextField();
		lowerWithdrawal.setBounds(152, 18, 86, 20);
		panel_4.add(lowerWithdrawal);
		lowerWithdrawal.setColumns(10);

		upperWithdrawal = new JTextField();
		upperWithdrawal.setBounds(152, 43, 86, 20);
		panel_4.add(upperWithdrawal);
		upperWithdrawal.setColumns(10);

		peoplePerDay = new JTextField();
		peoplePerDay.setBounds(152, 68, 86, 20);
		panel_4.add(peoplePerDay);
		peoplePerDay.setColumns(10);

		JLabel lblIloKlientowNa = new JLabel("Ilo\u015B\u0107 klientow na sekund\u0119");
		lblIloKlientowNa.setBounds(16, 93, 126, 14);
		panel_4.add(lblIloKlientowNa);

		peoplePerSecond = new JTextField();
		peoplePerSecond.setBounds(152, 93, 86, 20);
		panel_4.add(peoplePerSecond);
		peoplePerSecond.setColumns(10);

		JButton btnWstrzymaj = new JButton("Wstrzymaj");
		btnWstrzymaj.setBounds(167, 183, 89, 51);
		runtime.add(btnWstrzymaj);

		JButton btnNewButton_1 = new JButton("Wzn\u00F3w");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				presenter.startSimulation();
				simPreset.setClientsPerDay(peoplePerDay.getText());
				simPreset.setClientsPerSecond(peoplePerSecond.getText());
				simPreset.setWithdrawLowerLimit(lowerWithdrawal.getText());
				simPreset.setWithdrawUpperLimit(upperWithdrawal.getText());
				simPreset.setPLN200((String) spinner_1.getValue());
				simPreset.setPLN100((String) spinner_2.getValue());
				simPreset.setPLN50((String) spinner_3.getValue());
				simPreset.setPLN20((String) spinner_4.getValue());
				simPreset.setPLN10((String) spinner_5.getValue());
				simPreset.setDaysToRefill((String) spinner_6.getValue());

			}
		});
		btnNewButton_1.setBounds(272, 183, 89, 51);
		runtime.add(btnNewButton_1);

	}

	public void switchToAdminTab(JTabbedPane tabbedPane) {
		tabbedPane.setEnabledAt(1, true);
	}

	public String getLabelScrollText() {
		return labelScroll.getText();
	}

	public void setLabelScrollText(String text) {
		labelScroll.setText(text);
		labelScroll.repaint();
	}

	public String getLabelChkBoxText() {
		return labelChkBox.getText();
	}

	public void setLabelChkBoxText(String text_1) {
		labelChkBox.setText(text_1);
	}

	public String getLabelTextFieldText() {
		return labelTextField.getText();
	}

	public void setLabelTextFieldText(String text_2) {
		labelTextField.setText(text_2);
	}

	public String getLabelButtonText() {
		return labelButton.getText();
	}

	public void setLabelButtonText(String text_3) {
		labelButton.setText(text_3);
	}

	public String getLabelSpinnerText() {
		return labelSpinner.getText();
	}

	public void setLabelSpinnerText(String text_4) {
		labelSpinner.setText(text_4);
	}
}
