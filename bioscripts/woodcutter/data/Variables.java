package sw.bioscripts.woodcutter.data;

import sw.bioscripts.woodcutter.Gui;

public class Variables {
	public static boolean isBanking() {
		return Gui.comboBox_log.getSelectedIndex() == 1;
	}

	public static boolean isPowerChopping() {
		return Gui.comboBox_log.getSelectedIndex() == 2;
	}

	public static boolean stopAfterLevel() {
		// Version 1.2
		return Gui.textField_lvl.getText().length() > 0;
	}

	public static boolean stopAfterLogs() {
		// Version 1.2
		return Gui.textField_logs.getText().length() > 0;
	}

}
