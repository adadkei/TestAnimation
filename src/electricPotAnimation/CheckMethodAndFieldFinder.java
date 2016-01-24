package electricPotAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodAndFieldFinder {

    String startState = "�J�n�^�����";

    // ��ԃt�H���_�[
    public static boolean is_on_clicked = false;// ON���N���b�N���ꂽ���ǂ���
    public static boolean is_boiling = false;// ���M�����ǂ���
    public static boolean is_keep_warm = false;// �ۉ������ǂ���

    DecisionController dc = new DecisionController();

    /**
     * �����A���݂̏�Ԗ��ƑO�̏�Ԗ�����v������A���݂̏�Ԗ��̃��x����ݒ肷�� �����Ă��Ȃ�������A�󗓂�ݒ肷��
     * 
     * @param current_vertex
     *            ���݂̏�Ԗ�
     * @param pre_vertex
     *            �O�̏�Ԃ̖��O
     * 
     * @return ���x����
     */
    public String setLabelChar(String current_vertex, String pre_vertex) {
        if (dc.checkPreVertex(current_vertex, pre_vertex)) {
            return current_vertex;
        }

        return "";
    }

    public boolean checkStartToOff() {
        if (dc.checkPreVertex("off", "�J�n�[�����0")) {
            return true;
        }
        return false;

    }

    /**
     * �J�n�^����ԁ�off��on����on�g���K��������
     * 
     * @return boolean
     */
    public boolean checkOnFlow() {
        if (dc.checkPreVertex("off", "�J�n�[�����0") && dc.checkPreVertex("on", "off")
                && dc.checkVertexIncoming("on", "ON")) {
            return true;
        }
        return false;
    }

    /**
     * on��off���J�n�^����Ԃ���off�g���K�[��������
     * 
     * @return boolean
     */
    public boolean checkOffFlow() {
        if (dc.checkPreVertex("off", "on") && dc.checkPreVertex("off", "�J�n�[�����0")
                && dc.checkVertexIncoming("off", "OFF")) {
            return true;
        }
        return false;
    }

    /**
     * �J�n�^����ԁ�off��on����on�g���K����, on����q�J�n�^����ԁA����on����q���M���A���J�n�^����ԁ����M��
     */
    public boolean subCheckHeatingFlow() {
        if (checkOnFlow() && dc.checkPreSubVertex("on", "���M��", "�J�n�[�����1")) {
            return true;
        }
        return false;
    }

    /**
     * ���������J�n�^����ԁ����M�������M�����ۉ����������g���K����������(����q���O������ƂȂ��Ă���)
     */
    public boolean subCheckBoilingToKeepWarmFlow() {
        if (is_boiling && dc.checkPreSubVertex("on", "���M��", "�J�n�[�����1")
                && dc.checkPreSubVertex("on", "�ۉ���", "���M��")
                && dc.checkSubVertexIncoming("on", "�ۉ���", "����")) {
            return true;
        }
        return false;
    }

    /**
     * �ۉ��� ���� �ۉ���ԁ����M��� ���� �����{�^���������g���K
     */
    public boolean subCheckKeepWarmToBoilingFlow() {
        if (is_keep_warm && dc.checkPreSubVertex("on", "���M��", "�ۉ���")
                && dc.checkSubVertexIncoming("on", "���M��", "�����{�^��������")) {
            return true;
        }
        return false;
    }

    /**
     * �J�n�[����ԁ�off��on�����M������ on�g���K��������.����q����Ȃ��o�[�W����
     */
    public boolean checkOnToBoiling() {// ������
        if (checkOnFlow() && dc.checkPreVertex("���M��", "on")) {
            return true;
        }
        return false;
    }

    /**
     * ����q����Ȃ��o�[�W���� �J�n�[����ԁ�off��on�����M������ on�g���K ���� ���M���ۉ��������g���K
     */
    public boolean checkBoilingToKeepWarmFlow() {
        if (checkOnToBoiling() && dc.checkPreVertex("�ۉ���", "���M��")
                && dc.checkVertexIncoming("�ۉ���", "����")) {
            return true;
        }
        return false;
    }

    /**
     * ����q����Ȃ��o�[�W���� �ۉ��� ���� �ۉ���ԁ����M��� ���� �����{�^���������g���K
     */
    public boolean checkKeepWarmToBoilingFlow() {
        if (checkOnToBoiling() && is_keep_warm && dc.checkPreVertex("���M��", "�ۉ���")
                && dc.checkVertexIncoming("���M��", "�����{�^��������")) {
            return true;
        }
        return false;
    }

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
