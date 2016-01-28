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
    String tri_crane_up = "�N���[���㏸";
    String tri_this_and_left_switch = "��O�[�E���[�X�C�b�`ON";

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
     * �J�n��ԁ��A�C�h�����O��
     * 
     * @return
     */
    public boolean startToidle() {
        if (dc.checkPreVertex(idle, "�J�n")) {
            return true;
        }
        return false;
    }

    /**
     * �A�C�h�����O�����E�ړ��w���҂�
     * 
     * @return
     */
    public boolean idleToRightWait() {
        if (dc.checkPreVertex(wait_right, idle)) {
            return true;
        }
        return false;
    }

    /**
     * �E�ړ��w���҂����E�ړ���
     * 
     * @return
     */
    public boolean waitRightToMoveRight() {
        if (dc.checkPreVertex(move_right, wait_right)) {
            return true;
        }
        return false;
    }

    /**
     * �E�ړ��������ړ��w���҂�
     * 
     * @return
     */
    public boolean moveRightToWaitBack() {
        if (dc.checkPreVertex(wait_back, move_right)) {
            return true;
        }
        return false;
    }

    /**
     * �E�ړ��w���҂������ړ��w���҂�
     * 
     * @return
     */
    public boolean waitRightToWaitBack() {
        if (dc.checkPreVertex(wait_back, wait_right)) {
            return true;
        }
        return false;
    }

    /**
     * ���ړ��w���҂������ړ���
     * 
     * @return
     */
    public boolean waitBackToMoveBack() {
        if (dc.checkPreVertex(move_back, wait_back)) {
            return true;
        }
        return false;
    }

    /**
     * ���ړ������N���[�����쒆
     * 
     * @return
     */
    public boolean moveBackToMoveCrane() {
        if (dc.checkPreVertex(crane_action, move_back)) {
            return true;
        }
        return false;
    }

    /**
     * ���ړ��w���҂����N���[�����쒆
     * 
     * @return
     */
    public boolean waitBackToCraneAction() {
        if (dc.checkPreVertex(crane_action, wait_back)) {
            return true;
        }
        return false;
    }

    /**
     * �N���[�����쒆�����A�ړ���
     * 
     * @return
     */
    public boolean craneActionToMoveReturn() {
        if (dc.checkPreVertex(move_return, crane_action)) {
            return true;
        }
        return false;
    }

    /**
     * ���A�ړ������i�i�������쒆
     * 
     * @return
     */
    public boolean moveReturnToPrizeAction() {
        if (dc.checkPreVertex(prize_action, move_return)) {
            return true;
        }
        return false;
    }

    /**
     * �i�i�������쒆���A�C�h�����O��
     * 
     * @return
     */
    public boolean prizeActionToIdle() {
        if (dc.checkPreVertex(idle, prize_action)) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // ����q���
    // ///////////////////////////////////////
    /**
     * ����q<br>
     * �J�n�����ړ���
     * 
     * @return
     */
    public boolean startToMoveLeft() {
        if (dc.checkPreSubVertex(move_return, move_left, "�J�n")) {
            return true;
        }
        return false;
    }

    /**
     * ����q<br>
     * ���ړ������I��
     * 
     * @return
     */
    public boolean moveLeftToFinish() {
        if (dc.checkPreSubVertex(move_return, "�I��", move_left)) {
            return true;
        }
        return false;
    }

    /**
     * ����q<br>
     * �J�n����O�ړ���
     * 
     * @return
     */
    public boolean startToMoveThisSide() {
        if (dc.checkPreSubVertex(move_return, move_this_side, "�J�n")) {
            return true;
        }
        return false;
    }

    /**
     * ����q<br>
     * ��O�ړ������I��
     * 
     * @return
     */
    public boolean MoveThisSideToFinish() {
        if (dc.checkPreSubVertex(move_return, "�I��", move_this_side)) {
            return true;
        }
        return false;
    }

    // ////////////////////////////////////////
    // �g���K�[
    // ///////////////////////////////////////

    /**
     * �E�ړ��w���҂��ɓ����Ă���R�C�������g���K�[
     * 
     * @return
     */
    public boolean coinTrigger() {
        if (dc.checkVertexIncoming(wait_right, tri_coin)) {
            return true;
        }
        return false;

    }

    /**
     * �E�ړ����ɓ����Ă���E�{�^�������g���K�[
     * 
     * @return
     */
    public boolean rightButtonTrigger() {
        if (dc.checkVertexIncoming(move_right, tri_right_button)) {
            return true;
        }
        return false;

    }

    /**
     * ���ړ��w���҂��ɓ����Ă���E�[�X�C�b�`�E�I���g���K�[
     * 
     * @return
     */
    public boolean rightSwitchTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_right_switch)) {
            return true;
        }
        return false;

    }

    /**
     * ���ړ��w���҂��ɓ����Ă���E�{�^�������g���K�[
     * 
     * @return
     */
    public boolean releaseRightButtonTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_right_release)) {
            return true;
        }
        return false;

    }

    /**
     * ���ړ��w���҂��ɓ����Ă���30�b�o�߃g���K�[
     * 
     * @return
     */
    public boolean thirtyToBackTrigger() {
        if (dc.checkVertexIncoming(wait_back, tri_thirty)) {
            return true;
        }
        return false;
    }

    /**
     * ���ړ����ɓ����Ă��鉜�{�^�������g���K�[
     * 
     * @return
     */
    public boolean backBottunTrigger() {
        if (dc.checkVertexIncoming(move_back, tri_back_button)) {
            return true;
        }
        return false;
    }

    /**
     * �N���[�����쒆�ɓ����Ă��鉜�X�C�b�`�E�I���g���K�[
     * 
     * @return
     */
    public boolean backSwitchTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_back_switch)) {
            return true;
        }
        return false;
    }

    /**
     * �N���[�����쒆�ɓ����Ă��鉜�{�^�������g���K�[
     * 
     * @return
     */
    public boolean releaseBackButtonTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_back_release)) {
            return true;
        }
        return false;
    }

    /**
     * �N���[�����쒆�ɓ����Ă���30�b�o�߃g���K�[
     * 
     * @return
     */
    public boolean thirtyToCraneActionTrigger() {
        if (dc.checkVertexIncoming(crane_action, tri_thirty)) {
            return true;
        }
        return false;
    }

    /**
     * ���A�ړ����ɓ����Ă���N���[���㏸�g���K�[
     * 
     * @return
     */
    public boolean craneUpTrigger() {
        if (dc.checkVertexIncoming(move_return, tri_crane_up)) {
            return true;
        }
        return false;
    }

    /**
     * �i�i�������쒆�ɓ����Ă����O�[�E���[�X�C�b�`�g���K�[
     * 
     * @return
     */
    public boolean thisSideAndLeftTrigger() {
        if (dc.checkVertexIncoming(prize_action, tri_this_and_left_switch)) {
            return true;
        }
        return false;
    }

    // /////////////////////////////////////////////
    // ����q �g���K�[
    // /////////////////////////////////////////////

    /**
     * ����q<br>
     * ��O�ړ������I�� ��O�[�X�C�b�`�E�I���g���K�[
     * 
     * @return
     */
    public boolean thisSideSwitchTrigger() {
        if (dc.checkSubVertexIncoming(move_return, "�I��", tri_this_side_switch)) {
            return true;
        }
        return false;

    }

    /**
     * ����q<br>
     * ���ړ������I�� ���[�X�C�b�`�E�I���g���K�[
     * 
     * @return
     */
    public boolean leftSwitchTrigger() {
        if (dc.checkSubVertexIncoming(move_return, "�I��", tri_left_switch)) {
            return true;
        }
        return false;

    }

}
