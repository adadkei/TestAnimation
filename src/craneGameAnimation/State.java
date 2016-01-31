package craneGameAnimation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class State extends JLabel implements ActionListener {

	Timer timer;
	int counter;// �g���K�[��莞�ԕ\�����߂̃J�E���^�[
	int show_counter = 15;// �g���K�[���ǂꂭ�炢�\�������邩

	List<JLabel> lists = new ArrayList<>();// ���X�g
	public JLabel state_label;
	public JLabel sub_state_label;
	public JLabel trigger_label;
	public JLabel state;
	public JLabel trigger;

	// ���W
	int s_x = FrontIllustration.FRONT_ILL_X + 300;// �
	int s_y = FrontIllustration.FRONT_ILL_Y + 330;// �
	int su_x = s_x + 170;
	int su_y = s_y;
	int t_x = su_x;
	int t_y = s_y;

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

	public State() {
		// �^�C�}�[
		timer = new Timer(100, this);// 1�b���Ƀ^�C�}�[�C�x���g����
		timer.setCoalesce(true);
		timer.setRepeats(true); // �J��Ԃ��C�x���g����
		timer.start(); // �^�C�}�[�N��

		// �e���x�����쐬
		createCharState();
		createCharTrigger();
		createStateLabel();
		// createSubStateLabel();
		createTriggerLabel();

		// �e��Ԃ����X�g�ɒǉ�
		lists.add(state_label);
		// lists.add(sub_state_label);
		lists.add(trigger_label);
		lists.add(state);
		lists.add(trigger);
	}

	private void createTriggerLabel() {
		/*
		 * �g���K�[�̃��x��
		 */
		trigger_label = new JLabel();
		// ���x������ݒ�
		trigger_label.setText(kara);
		// �����̃t�H���g�̐ݒ�
		trigger_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		trigger_label.setBounds(t_x, t_y, 190, 35);
		// �w�i�F�̐ݒ�
		trigger_label.setBackground(new Color(255, 204, 255));
		trigger_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
		// �����ʒu�̐ݒ�
		trigger_label.setHorizontalAlignment(JLabel.CENTER);
		// �g���̐ݒ�
		trigger_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createSubStateLabel() {
		/*
		 * �T�u��Ԃ̃��x��
		 */
		sub_state_label = new JLabel();
		// ���x������ݒ�
		sub_state_label.setText(move_left);
		// �����̃t�H���g�̐ݒ�
		sub_state_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		sub_state_label.setBounds(su_x, su_y, 140, 35);
		// �w�i�F�̐ݒ�
		sub_state_label.setBackground(new Color(204, 255, 153));
		sub_state_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
		// �����ʒu�̐ݒ�
		sub_state_label.setHorizontalAlignment(JLabel.CENTER);
		// �g���̐ݒ�
		sub_state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createStateLabel() {
		/*
		 * ��Ԃ̃��x��
		 */
		state_label = new JLabel();
		// ���x������ݒ�
		state_label.setText(kara);
		// �����̃t�H���g�̐ݒ�
		state_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		state_label.setBounds(s_x, s_y, 140, 35);
		// �w�i�F�̐ݒ�
		state_label.setBackground(new Color(204, 255, 153));
		state_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
		// �����ʒu�̐ݒ�
		state_label.setHorizontalAlignment(JLabel.CENTER);
		// �g���̐ݒ�
		state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createCharTrigger() {
		/*
		 * �g���K�[�����̃��x��
		 */
		trigger = new JLabel();
		// ���x������ݒ�
		trigger.setText(c_trigger);
		// �����̃t�H���g�̐ݒ�
		trigger.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		trigger.setBounds(t_x - 40, s_y - 25, 140, 35);
		// �����ʒu�̐ݒ�
		trigger.setHorizontalAlignment(JLabel.CENTER);
	}

	private void createCharState() {
		/*
		 * ��ԕ����̃��x��
		 */
		state = new JLabel();
		// ���x������ݒ�
		state.setText(c_state);
		// �����̃t�H���g�̐ݒ�
		state.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		state.setBounds(s_x - 40, s_y - 25, 140, 35);
		// �����ʒu�̐ݒ�
		state.setHorizontalAlignment(JLabel.CENTER);
	}

	public List<JLabel> getStateLists() {
		return lists;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * ��ԃ��x��
		 */
		if (CheckMethodAndFieldFinder.is_idle) {// �����A�C�h�����O����������
			state_label.setText(idle);
		}
		if (CheckMethodAndFieldFinder.is_wait_right) {// �����E�ړ��w���҂���������
			state_label.setText(wait_right);
		}
		if (CheckMethodAndFieldFinder.is_move_right) {// �����E�ړ�����������
			state_label.setText(move_right);
		}
		if (CheckMethodAndFieldFinder.is_wait_back) {// �������ړ��w���҂���������
			state_label.setText(wait_back);
		}
		if (CheckMethodAndFieldFinder.is_move_back) {// �������ړ�����������
			state_label.setText(move_back);
		}
		if (CheckMethodAndFieldFinder.is_crane_action) {// �����N���[�����쒆��������
			state_label.setText(crane_action);
		}
		if (CheckMethodAndFieldFinder.is_move_return) {// �������A�ړ�����������
			state_label.setText(move_return);
		}
		if (CheckMethodAndFieldFinder.is_prize_action) {// �����i�i�������쒆��������
			state_label.setText(prize_action);
		}

		/*
		 * �g���K�[���x��
		 */
		// �R�C���g���K�[
		if (CheckMethodAndFieldFinder.is_tri_coin) {
			trigger_label.setText(tri_coin);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_coin = false;// �R�C���g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// �E�{�^���g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_right_button) {
			trigger_label.setText(tri_right_button);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_right_button = false;// �R�C���g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// 30�b�o�߃g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_thirty) {
			trigger_label.setText(tri_thirty);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_thirty = false;// 30�b�o�߃g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// �E�[�X�C�b�`ON�g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_right_switch) {
			trigger_label.setText(tri_right_switch);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_right_switch = false;// �E�[�X�C�b�`ON�g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// �E�{�^�������g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_right_release) {
			trigger_label.setText(tri_right_release);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_right_release = false;// �E�{�^�������g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// ���{�^���g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_back_button) {
			trigger_label.setText(tri_back_button);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_back_button = false;// �R�C���g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// ���{�^�������g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_back_release) {
			trigger_label.setText(tri_back_release);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_back_release = false;// �E�{�^�������g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// ���X�C�b�`ON�g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_back_switch) {
			trigger_label.setText(tri_back_switch);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_back_switch = false;// ���X�C�b�`ON�g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// �N���[���㏸�g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_crane_up) {
			trigger_label.setText(tri_crane_up);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_crane_up = false;// �N���[���㏸�g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

		// ��O�[�E���[�X�C�b�`ON�g���K�[
		else if (CheckMethodAndFieldFinder.is_tri_this_and_left_switch) {
			trigger_label.setText(tri_this_and_left_switch);
			counter++;// �J�E���^�[�𑫂�

			if (counter > show_counter) {// ��莞�Ԍo��
				CheckMethodAndFieldFinder.is_tri_this_and_left_switch = false;// ��O�[�E���[�X�C�b�`ON�g���K�[��false��
				trigger_label.setText(kara);// ���x���̒��g����ɂ���
				counter = 0;
			}
		}

	}

}
