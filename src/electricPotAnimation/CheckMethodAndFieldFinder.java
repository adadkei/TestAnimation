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
		if (is_boiling && dc.checkPreSubVertex("on", "���M��", "�J�n�[�����1") && dc.checkPreSubVertex("on", "�ۉ���", "���M��")
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
		if (checkOnToBoiling() && dc.checkPreVertex("�ۉ���", "���M��") && dc.checkVertexIncoming("�ۉ���", "����")) {
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

	/**
	 * �ėp�B�C�ӂ̏�ԂP���C�ӂ̏�ԂQ���C�ӂ̃g���K����������Atrue��Ԃ�
	 * 
	 * @param current_vertex
	 *            �C�ӂ̌��݂̏�Ԗ�
	 * @param pre_vertex
	 *            �C�ӂ̑O�̏�Ԗ�
	 * @param trigger
	 *            �C�ӂ̃g���K�[��
	 * @return boolean
	 */
	public boolean generalPurposeCheckVertexAndTrigger(String current_vertex, String pre_vertex, String trigger) {
		if (dc.checkPreVertex(current_vertex, pre_vertex) && dc.checkVertexIncoming(current_vertex, trigger)) {
			return true;
		}
		return false;
	}

}
