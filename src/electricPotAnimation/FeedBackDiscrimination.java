package electricPotAnimation;

public class FeedBackDiscrimination {

    CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

    /**
     * 全ての状態が解答と一緒だったら.入れ子も使われているということ
     * 
     * @return
     */
    public boolean isAllState() {
        if (cm.startToOff() && cm.offToOn() && cm.onToOff() && cm.subStartToBoil()
                && cm.subBoilToKeep() && cm.subKeepToBoil()) {
            return true;
        }
        return false;

    }

    /**
     * 全てのトリガーが解答と一緒だったら。入れ子も使われているということ
     * 
     * @return
     */
    public boolean isAllTrigger() {
        if (cm.onTrigger() && cm.offTrigger() && cm.subBoilTrigger() && cm.subBoilButtonTrigger()) {
            return true;
        }
        return false;
    }

    /**
     * もし入れ子を使わないverで,状態が正解だったら
     * 
     * @return
     */
    public boolean isAnotherState() {
        if (cm.startToOff() && cm.offToOn() && cm.onToOff() && cm.onToBoil() && cm.boilToKeep()
                && cm.keepToBoil() && cm.boilToOff() && cm.keepToOff()) {
            return true;
        }
        return false;
    }

    /**
     * もし、入れ子使わないverで、トリガーが正解だったら
     */
    public boolean isAnotherTrigger() {
        if (cm.onTrigger() && cm.offTrigger() && cm.boilTrigger() && cm.boilButtonTrigger()
                && cm.boilToOff() && cm.keepToOff()) {
            return true;
        }
        return false;
    }
}
