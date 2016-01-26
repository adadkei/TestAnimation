package craneGameAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodAndFieldFinder {

	DecisionController dc = new DecisionController();

	// ����
	String kara = "";
	String c_state = "���";
	String c_trigger = "�g���K�[";

	String idle = "�A�C�h�����O��";
	String wait_right = "�E�ړ��w���҂�";
	String wait_back = "���ړ��w���҂�";
	String move_right = "�E�ړ���";
	String move_back = "���ړ���";
	String crane_action = "�N���[�����쒆";
	String move_return = "���A�ړ���";
	String move_left = "���ړ���";
	String move_this_side = "��O�ړ���";
	String prize_action = "�i�i�������쒆";

	String tri_coin = "�R�C������";
	String tri_right_button = "�E�{�^������";
	String tri_right_switch = "�E�[�X�C�b�`ON";
	String tri_right_release = "�E�{�^������";
	String tri_back_button = "���{�^������";
	String tri_back_switch = "���X�C�b�`ON";
	String tri_back_release = "���{�^������";
	String tri_thirty = "30�b�o��";
	String tri_left_switch = "���[�X�C�b�`ON";
	String tri_this_side_switch = "��O�[�X�C�b�`ON";

	// ��ԃt�H���_�[
	public static boolean is_idle = false;
	public static boolean is_wait_right = false;
	public static boolean is_wait_back = false;
	public static boolean is_move_right = false;
	public static boolean is_move_back = false;
	public static boolean is_crane_action = false;
	public static boolean is_move_return = false;
	public static boolean is_move_left = false;
	public static boolean is_move_this_side = false;
	public static boolean is_prize_action = false;
	
	/************************************************************************
     * 
     * ��������́A���ꂼ��̏��,�g���K�[�̔��ʃ��\�b�h
     * 
     *************************************************************************/

    // ////////////////////////////////////////////////////////
    // ���
    // ///////////////////////////////////////////////////////

    /**
     * �J�n��off
     * 
     * @return
     */
    public boolean startToOff() {
        if (dc.checkPreVertex("off", "�J�n")) {
            return true;
        }
        return false;
    }

    /**
     * off��on
     * 
     * @return
     */
    public boolean offToOn() {
        if (dc.checkPreVertex("on", "off")) {
            return true;
        }
        return false;
    }

    /**
     * on��off
     * 
     * @return
     */
    public boolean onToOff() {
        if (dc.checkPreVertex("off", "on")) {
            return true;
        }
        return false;
    }

    /**
     * on�����M��
     * 
     * @return
     */
    public boolean onToBoil() {
        if (dc.checkPreVertex("���M��", "on")) {
            return true;
        }
        return false;
    }

    /**
     * ���M�����ۉ���
     * 
     * @return
     */
    public boolean boilToKeep() {
        if (dc.checkPreVertex("�ۉ���", "���M��")) {
            return true;
        }
        return false;
    }

    /**
     * �ۉ��������M��
     * 
     * @return
     */
    public boolean keepToBoil() {
        if (dc.checkPreVertex("���M��", "�ۉ���")) {
            return true;
        }
        return false;
    }

    /**
     * ���M����off
     * 
     * @return
     */
    public boolean boilToOff() {
        if (dc.checkPreVertex("off", "���M��")) {
            return true;
        }
        return false;
    }

    /**
     * �ۉ�����off
     * 
     * @return
     */
    public boolean keepToOff() {
        if (dc.checkPreVertex("off", "�ۉ���")) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // ����q���
    // ///////////////////////////////////////
    /**
     * ����q<br>
     * �J�n�����M��
     * 
     * @return
     */
    public boolean subStartToBoil() {
        if (dc.checkPreSubVertex("on", "���M��", "�J�n")) {
            return true;
        }
        return false;
    }

    /**
     * ����q<br>
     * ���M�����ۉ���
     * 
     * @return
     */
    public boolean subBoilToKeep() {
        if (dc.checkPreSubVertex("on", "�ۉ���", "���M��")) {
            return true;
        }
        return false;
    }

    /**
     * ����q<br>
     * �ۉ��������M��
     * 
     * @return
     */
    public boolean subKeepToBoil() {
        if (dc.checkPreSubVertex("on", "�ۉ���", "���M��")) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // �g���K�[
    // ///////////////////////////////////////

    /**
     * on�ɓ����Ă���ON�g���K�[
     * 
     * @return
     */
    public boolean onTrigger() {
        if (dc.checkVertexIncoming("on", "ON")) {
            return true;
        }
        return false;

    }

    /**
     * off�ɓ����Ă���OFF�g���K�[
     * 
     * @return
     */
    public boolean offTrigger() {
        if (dc.checkVertexIncoming("off", "OFF")) {
            return true;
        }
        return false;

    }

    /**
     * �ۉ��ɓ����Ă��镦���g���K�[
     * 
     * @return
     */
    public boolean boilTrigger() {
        if (dc.checkVertexIncoming("�ۉ���", "����")) {
            return true;
        }
        return false;

    }

    /**
     * ���M���ɓ����Ă��镦���{�^���g���K�[
     * 
     * @return
     */
    public boolean boilButtonTrigger() {
        if (dc.checkVertexIncoming("���M��", "�����{�^��������")) {
            return true;
        }
        return false;

    }

    // /////////////////////////////////////////////
    // ����q �g���K�[
    // /////////////////////////////////////////////

    /**
     * ����q<br>
     * �ۉ��ɓ����Ă��镦���g���K�[
     * 
     * @return
     */
    public boolean subBoilTrigger() {
        if (dc.checkSubVertexIncoming("on", "�ۉ���", "����")) {
            return true;
        }
        return false;

    }

    /**
     * ����q<br>
     * ���M���ɓ����Ă��镦���{�^���g���K�[
     * 
     * @return
     */
    public boolean subBoilButtonTrigger() {
        if (dc.checkSubVertexIncoming("on", "���M��", "�����{�^��������")) {
            return true;
        }
        return false;

    }

}
