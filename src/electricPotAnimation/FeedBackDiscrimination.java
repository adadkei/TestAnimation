package electricPotAnimation;

public class FeedBackDiscrimination {

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

	/**
	 * 全ての状態が解答と一緒だったら.入れ子も使われているということ
	 * @return
	 */
	public boolean isAllState() {
		if (cm.startToOff() && cm.offToOn() && cm.onToOff() && cm.subStartToBoil() && cm.subBoilToKeep()
				&& cm.subKeepToBoil()) {
			return true;
		}
		return false;

	}

	/**
	 * 全てのトリガーが解答と一緒だったら。入れ子も使われているということ
	 * @return
	 */
	public boolean isAllTrigger() {
		if (cm.onTrigger() && cm.offTrigger() && cm.subBoilTrigger() && cm.subBoilButtonTrigger()) {
			return true;
		}
		return false;
	}
}
