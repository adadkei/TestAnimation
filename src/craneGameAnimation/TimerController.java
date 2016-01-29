package craneGameAnimation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acquisitionOfAstahDiagram.DecisionController;

public class TimerController implements ActionListener {

	Timer timer;
	ButtonOfGame bog = new ButtonOfGame();
	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();
	DecisionController dc = new DecisionController();

	// ���ʗp�J�E���^
	int idle_count = 0;

	public TimerController() {
		// �^�C�}�[
		timer = new Timer(100, this);// 1�b���Ƀ^�C�}�[�C�x���g����
		timer.setCoalesce(true);
		timer.setRepeats(true); // �J��Ԃ��C�x���g����
		timer.start(); // �^�C�}�[�N��

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// �A�C�h�����O�܂ł̂Ȃ���A���E�ړ��w���҂���false��������
		if (cm.startToidle() && idle_count == 0) {
			CheckMethodAndFieldFinder.is_idle = true;
			idle_count++;
		}

		/*
		 * ���ړ��w���҂��ɑJ�ڂ��闬��
		 */
		// �����E�ړ��w���҂��ɂȂ�����J�E���g�J�n
		if (CheckMethodAndFieldFinder.is_wait_right) {
			CheckMethodAndFieldFinder.time_counter++;
		}
		// �E�ړ��w���҂������ړ��w���҂�
		if (cm.waitRightToWaitBack() && cm.thirtyToBackTrigger() && CheckMethodAndFieldFinder.is_wait_right
				&& CheckMethodAndFieldFinder.time_counter > 80) {// �����E�ړ��w���҂���ԁA���J�E���^�[��100�𒴂�����
			CheckMethodAndFieldFinder.is_wait_right = false;// �E�ړ��w���҂�������
			CheckMethodAndFieldFinder.is_wait_back = true;// ���ړ��w���҂��ɂ���
			CheckMethodAndFieldFinder.is_tri_thirty = true;// 30�b�g���K�[�t���Oon
			CheckMethodAndFieldFinder.time_counter = 0;// �J�E���^�[��0��
		}
		// �E�ړ��������ړ��w���҂�,�E�[�X�C�b�`ON�g���K�[�ɂ����
		if (cm.moveRightToWaitBack() && cm.releaseRightButtonTrigger() && CheckMethodAndFieldFinder.is_move_right
				&& CheckMethodAndFieldFinder.is_tri_right_switch) {// �����E�ړ����A���E�[�X�C�b�`�g���K�[��true��������
			CheckMethodAndFieldFinder.is_move_right = false;// �E�ړ���������
			CheckMethodAndFieldFinder.is_wait_back = true;// ���ړ��w���҂��ɂ���
		}

		/*
		 * �N���[�����쒆�ɑJ�ڂ��闬��
		 */
		// �������ړ��w���҂��ɂȂ�����J�E���g�J�n
		if (CheckMethodAndFieldFinder.is_wait_back) {
			CheckMethodAndFieldFinder.time_counter++;
		}
		// ���ړ��w���҂����N���[�����쒆
		if (cm.waitBackToCraneAction() && cm.thirtyToCraneActionTrigger() && CheckMethodAndFieldFinder.is_wait_back
				&& CheckMethodAndFieldFinder.time_counter > 80) {// �������ړ��w���҂���ԁA���J�E���^�[����萔�𒴂�����
			CheckMethodAndFieldFinder.is_wait_back = false;// ���ړ��w���҂�������
			CheckMethodAndFieldFinder.is_crane_action = true;// �N���[�����쒆�ɂ���
			CheckMethodAndFieldFinder.is_tri_thirty = true;// 30�b�g���K�[�t���Oon
			CheckMethodAndFieldFinder.time_counter = 0;// �J�E���^�[��0��
		}

		// ���ړ������N���[�����쒆,���X�C�b�`ON�g���K�[�ɂ����
		if (cm.moveBackToMoveCrane() && cm.backSwitchTrigger() && CheckMethodAndFieldFinder.is_move_back
				&& CheckMethodAndFieldFinder.is_tri_back_switch) {// �������ړ����A�����[�X�C�b�`�g���K�[��true��������
			CheckMethodAndFieldFinder.is_move_back = false;// ���ړ���������
			CheckMethodAndFieldFinder.is_crane_action = true;// �N���[�����쒆�ɂ���
		}

		/*
		 * ���A�ړ����ɑJ�ڂ��闬��
		 */
		if (cm.craneActionToMoveReturn() && cm.craneUpTrigger() && CheckMethodAndFieldFinder.is_crane_action
				&& CheckMethodAndFieldFinder.is_tri_crane_up) {// �����N���[�����쒆�A���N���[���㏸�g���K�[��true��������
			CheckMethodAndFieldFinder.is_crane_action = false;// �N���[�����쒆������
			CheckMethodAndFieldFinder.is_move_return = true;// ���A�ړ����ɂ���
		}

		/*
		 * �i�i�������쒆�ɑJ�ڂ��闬��
		 */
		if (cm.moveReturnToPrizeAction() && cm.thisSideAndLeftTrigger() && CheckMethodAndFieldFinder.is_move_return
				&& CheckMethodAndFieldFinder.is_tri_this_and_left_switch) {// �������A�ړ����A����O�[�E���[�X�C�b�`�g���K�[��true��������
			CheckMethodAndFieldFinder.is_move_return = false;// ���A�ړ�������������
			CheckMethodAndFieldFinder.is_prize_action = true;// �i�i�������쒆�ɂ���
		}
		// �e�X�g�p
		System.out.println("time_counter" + CheckMethodAndFieldFinder.time_counter);

	}
}
