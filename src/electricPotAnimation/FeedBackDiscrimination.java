package electricPotAnimation;

public class FeedBackDiscrimination {

    CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

    /**
     * �S�Ă̏�Ԃ��𓚂ƈꏏ��������.����q���g���Ă���Ƃ�������
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
     * �S�Ẵg���K�[���𓚂ƈꏏ��������B����q���g���Ă���Ƃ�������
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
     * ��������q���g��Ȃ�ver��,��Ԃ�������������
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
     * �����A����q�g��Ȃ�ver�ŁA�g���K�[��������������
     */
    public boolean isAnotherTrigger() {
        if (cm.onTrigger() && cm.offTrigger() && cm.boilTrigger() && cm.boilButtonTrigger()
                && cm.boilToOff() && cm.keepToOff()) {
            return true;
        }
        return false;
    }
}
