package sw.bioscripts.woodcutter.strats;

import javax.swing.JOptionPane;

import org.parabot.core.Context;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.SceneObjects.Option;
import org.rev317.min.api.methods.Skill;
import org.rev317.min.api.wrappers.SceneObject;

import sw.bioscripts.woodcutter.data.Constants;
import sw.bioscripts.woodcutter.data.Variables;

public class BankLogs implements Strategy {

	@Override
	public boolean activate() {
		return Variables.isBanking() && Inventory.isFull();
	}

	@Override
	public void execute() {
		SceneObject[] bankBooth = SceneObjects.getNearest(9398, 9397);
		if (Skill.WOODCUTTING.getLevel() < 80) {
			JOptionPane.showMessageDialog(null, "Need Level 80 Woodcutting To Bank!");
			Context.getInstance().getRunningScript().setState(Script.STATE_STOPPED);
		} else if (Skill.WOODCUTTING.getLevel() >= 80) {
			if (Game.getOpenInterfaceId() != 23350) {
				if (bankBooth.length > 0 && bankBooth != null) {
					bankBooth[0].interact(Option.DEPOSIT);
					Time.sleep(new SleepCondition() {
						@Override
						public boolean isValid() {
							return Game.getOpenInterfaceId() == 23350;
						}
					}, 5000);
				}
			} else if (Game.getOpenInterfaceId() == 23350) {
				Menu.sendAction(646, 995, 36, 23412);
				Constants.LOGS_CHOP += Inventory.getCount(6334, 6333, 1514);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return !Inventory.isFull();
					}
				}, 5000);
			}
		}
	}
}
