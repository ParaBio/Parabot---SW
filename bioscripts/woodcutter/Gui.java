
package sw.bioscripts.woodcutter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sw.bioscripts.woodcutter.data.Constants;

/**
 * @author bio scripts
 */
public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gui() {
		initComponents();
	}

	private void button_runActionPerformed(ActionEvent e) {
		if (comboBox_tree.getSelectedIndex() == 1) {
			// Teak
			Constants.TREE_ID = 9036;
		} else if (comboBox_tree.getSelectedIndex() == 2) {
			// Mahogany
			Constants.TREE_ID = 9034;
		} else if (comboBox_tree.getSelectedIndex() == 3) {
			// Magic
			Constants.TREE_ID = 1306;
		}
		setVisible(false);
	}

	private void initComponents() {
		comboBox_tree = new JComboBox<>();
		label2 = new JLabel();
		comboBox_log = new JComboBox<>();
		label3 = new JLabel();
		button_run = new JButton();
		label4 = new JLabel();
		label5 = new JLabel();
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		label6 = new JLabel();
		textField_lvl = new JTextField();
		label7 = new JLabel();
		textField_logs = new JTextField();

		// ======== this ========
		setTitle("BChopper");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// ---- comboBox_tree ----
		comboBox_tree.setModel(new DefaultComboBoxModel<>(new String[] { " ", "Teak", "Mahogany", "Magic" }));
		comboBox_tree.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		contentPane.add(comboBox_tree);
		comboBox_tree.setBounds(5, 55, 85, comboBox_tree.getPreferredSize().height);

		// ---- label2 ----
		label2.setText("Choose Tree");
		label2.setFont(new Font("Vani", Font.PLAIN, 12));
		contentPane.add(label2);
		label2.setBounds(5, 35, 75, label2.getPreferredSize().height);

		// ---- comboBox_log ----
		comboBox_log.setModel(new DefaultComboBoxModel<>(new String[] { " ", "Bank", "Drop" }));
		comboBox_log.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		contentPane.add(comboBox_log);
		comboBox_log.setBounds(5, 100, 85, comboBox_log.getPreferredSize().height);

		// ---- label3 ----
		label3.setText("Choose Log Option");
		label3.setFont(new Font("Vani", Font.PLAIN, 11));
		contentPane.add(label3);
		label3.setBounds(5, 85, 120, label3.getPreferredSize().height);

		// ---- button_run ----
		button_run.setText("Start");
		button_run.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		button_run.addActionListener(e -> button_runActionPerformed(e));
		contentPane.add(button_run);
		button_run.setBounds(5, 135, 85, button_run.getPreferredSize().height);

		// ---- label4 ----
		label4.setText("BChopper ");
		label4.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		contentPane.add(label4);
		label4.setBounds(5, 5, 180, label4.getPreferredSize().height);

		// ---- label5 ----
		label5.setText("- BioScripts");
		label5.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		contentPane.add(label5);
		label5.setBounds(10, 20, 95, label5.getPreferredSize().height);

		// ======== tabbedPane1 ========
		{

			// ======== panel1 ========
			{
				// ---- label6 ----
				label6.setText("Stop After Level? -");
				label6.setFont(new Font("Vani", Font.PLAIN, 11));
				panel1.add(label6);
				label6.setBounds(5, 5, 95, label6.getPreferredSize().height);

				// ---- textField_lvl ----
				textField_lvl.setText("---");
				panel1.add(textField_lvl);
				textField_lvl.setBounds(100, 5, 30, 15);

				// ---- label7 ----
				label7.setText("Stop after how many logs -");
				panel1.add(label7);
				label7.setBounds(5, 25, 135, label7.getPreferredSize().height);

				// ---- textField_logs ----
				textField_logs.setText("---");
				panel1.add(textField_logs);
				textField_logs.setBounds(140, 25, 35, 15);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for (int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Options", panel1);
		}
		contentPane.add(tabbedPane1);
		tabbedPane1.setBounds(115, 40, 185, 80);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for (int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
	}

	public static JComboBox<String> comboBox_tree;
	private JLabel label2;
	public static JComboBox<String> comboBox_log;
	private JLabel label3;
	private JButton button_run;
	private JLabel label4;
	private JLabel label5;
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JLabel label6;
	public static JTextField textField_lvl;
	private JLabel label7;
	public static JTextField textField_logs;
}
