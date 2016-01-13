package electricPotAnimation;

import acquisitionOfAstahDiagram.DecisionController;

public class CheckMethodFinder {

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

	/**
	 * �J�n�^����ԁ�off��on����on�g���K��������
	 * 
	 * @return boolean
	 */
	public boolean checkOnFlow() {
		if (dc.checkPreVertex("off", "�J�n�^�����0") && dc.checkPreVertex("on", "off") && dc.checkIncoming("on", "ON")) {
			return true;
		}
		return false;
	}

	/**
	 * on��off���J�n�^����Ԃ���off�g���K�[��������
	 * @return boolean
	 */
	public boolean checkOffFlow() {
		if (dc.checkPreVertex("off", "on") && dc.checkPreVertex("off", "�J�n�^�����0") && dc.checkIncoming("off", "OFF")) {
			return true;
		}
		return false;
	}

}
