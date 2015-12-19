package sw.bioscripts.woodcutter.strats;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;

import sw.bioscripts.woodcutter.data.Constants;
import sw.bioscripts.woodcutter.data.Variables;

public class DropLogs implements Strategy {

	@Override
	public boolean activate() {

		return Inventory.isFull() && Variables.isPowerChopping();
	}

	@Override
	public void execute() {
		if (Game.getOpenBackDialogId() == -1) {
			Keyboard.getInstance().sendKeys("::empty");
			Constants.LOGS_CHOP += Inventory.getCount(6334, 6333, 1514);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return !Inventory.isFull();
				}
			}, 5000);
		} else if (Game.getOpenBackDialogId() != -1) {
			Menu.sendAction(679, 148013056, 299, 4275);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenBackDialogId() == -1;
				}
			}, 5000);
		}
	}
}
