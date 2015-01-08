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
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AppWindowAdmin {

	private JFrame frame;
	private JTextField textField;
	private JLabel labelScroll;
	private JLabel labelChkBox;
	private JLabel labelTextField;
	private JLabel labelButton;
	private JLabel labelSpinner;
	private JPasswordField passwordField;

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
	 */
	public AppWindowAdmin() {
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

		JPanel Status = new JPanel();
		Status.setToolTipText("Uzupe\u0142nij warto\u015Bci danych namina\u0142\u00F3w");
		Status.setBorder(new TitledBorder(null, "Dostêpne nomna³y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Status.setBounds(6, 11, 113, 179);
		admin.add(Status);
		Status.setLayout(null);

		JPanel SpinnerLabels = new JPanel();
		SpinnerLabels.setBounds(10, 19, 46, 114);
		Status.add(SpinnerLabels);
		SpinnerLabels.setLayout(null);

		JLabel lblPln200 = new JLabel("200 PLN");
		lblPln200.setBounds(0, 0, 46, 14);
		SpinnerLabels.add(lblPln200);

		JLabel lblPln100 = new JLabel("100 PLN");
		lblPln100.setBounds(0, 25, 46, 14);
		SpinnerLabels.add(lblPln100);

		JLabel lblPln50 = new JLabel("50 PLN");
		lblPln50.setBounds(0, 50, 46, 14);
		SpinnerLabels.add(lblPln50);

		JLabel lblPln20 = new JLabel("20 PLN");
		lblPln20.setBounds(0, 75, 46, 14);
		SpinnerLabels.add(lblPln20);

		JLabel lblPln10 = new JLabel("10 PLN");
		lblPln10.setBounds(0, 100, 46, 14);
		SpinnerLabels.add(lblPln10);

		JPanel Spiners = new JPanel();
		Spiners.setBounds(76, 19, 29, 120);
		Status.add(Spiners);
		Spiners.setLayout(null);

		JSpinner spinner_200 = new JSpinner();
		spinner_200.setBounds(0, 0, 29, 20);
		Spiners.add(spinner_200);

		JSpinner spinner_100 = new JSpinner();
		spinner_100.setBounds(0, 25, 29, 20);
		Spiners.add(spinner_100);

		JSpinner spinner_50 = new JSpinner();
		spinner_50.setBounds(0, 50, 29, 20);
		Spiners.add(spinner_50);

		JSpinner spinner_20 = new JSpinner();
		spinner_20.setBounds(0, 75, 29, 20);
		Spiners.add(spinner_20);

		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(0, 100, 29, 20);
		Spiners.add(spinner_10);

		JButton btnReset = new JButton("Resetuj");
		btnReset.setBounds(16, 144, 89, 23);
		Status.add(btnReset);

		JButton btnSave = new JButton("Zapisz");
		btnSave.setToolTipText("Zapiszuje wprowadzone zmiany");
		btnSave.setBounds(320, 232, 89, 23);
		admin.add(btnSave);

		JButton btnDiscardAmends = new JButton("Odzrzu\u0107 zmiany");
		btnDiscardAmends.setToolTipText("Odrzuca zmiany");
		btnDiscardAmends.setBounds(203, 232, 107, 23);
		admin.add(btnDiscardAmends);

		JPanel runtime = new JPanel();
		tabbedPane.addTab("New tab", null, runtime, null);

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
