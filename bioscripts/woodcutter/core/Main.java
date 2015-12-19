package sw.bioscripts.woodcutter.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;

import sw.bioscripts.woodcutter.Gui;
import sw.bioscripts.woodcutter.data.Constants;
import sw.bioscripts.woodcutter.strats.BankLogs;
import sw.bioscripts.woodcutter.strats.ChopTree;
import sw.bioscripts.woodcutter.strats.DropLogs;
import sw.bioscripts.woodcutter.unused.StopAfterLevel;
import sw.bioscripts.woodcutter.unused.StopAfterLogs;

@ScriptManifest(author = "BioScripts", category = Category.WOODCUTTING, description = "Chops supported tress. Drops or banks. ", name = "BChopper", servers = {
		"Pkhonor" }, version = 1.0)
public class Main extends Script implements MessageListener, Paintable {
	private Timer time = new Timer();
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public boolean onExecute() {
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(50);
		}
		strategies.add(new StopAfterLogs());
		strategies.add(new StopAfterLevel());
		strategies.add(new ChopTree());
		strategies.add(new DropLogs());
		strategies.add(new BankLogs());
		provide(strategies);
		return true;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.ITALIC, 14));
		g.drawString("Run Time - " + time, 20, 40);
		g.drawString(Constants.LOGS_CHOP + " Logs Chopped!", 20, 60);
		g.drawString("Leveled " + Constants.WC_LVL + " Times!", 20, 80);

	}

	public void messageReceived(MessageEvent i) {
		if (i.getMessage().contains("woodcutting level")) {
			Constants.WC_LVL++;
		}
	}
}
