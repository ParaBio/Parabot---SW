package sw.bioscripts.woodcutter.strats;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.methods.SceneObjects.Option;
import org.rev317.min.api.wrappers.SceneObject;

import sw.bioscripts.woodcutter.data.Constants;

public class ChopTree implements Strategy {

	@Override
	public boolean activate() {
		return !Inventory.isFull();
	}

	@Override
	public void execute() {
		SceneObject[] treeId = SceneObjects.getNearest(Constants.TREE_ID);
		if (Players.getMyPlayer().getAnimation() == -1) {
			if (treeId.length > 0 && treeId != null) {
				treeId[0].interact(Option.CHOP_DOWN);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getAnimation() != -1;
					}
				}, 5000);
			}
		}
	}
}
