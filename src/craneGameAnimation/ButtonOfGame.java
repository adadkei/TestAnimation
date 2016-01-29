package craneGameAnimation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;

public class ButtonOfGame implements ActionListener {

	private JButton rightButton;
	private JButton upButton;
	private JButton coinButton;
	private JButton releaseButton;

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();
	ButtonModel model;
	// ���W
	int b_x = FrontIllustration.FRONT_ILL_X + 460;
	int b_y = FrontIllustration.FRONT_ILL_Y + 400;

	// ����
	String right = "��";
	String up = "��";
	String coin = "�R�C������";
	String release = "�{�^������";

	// ���ʗp�J�E���^
	int right_button_counter = 0;
	int right_button_release_counter = 0;

	public ButtonOfGame() {
		rightButton = new JButton(right);
		rightButton.setBounds(b_x, b_y, 60, 40);
		rightButton.setFont(new Font("Meiryo UI", Font.BOLD, 20));
		rightButton.setBackground(Color.ORANGE);
		rightButton.setHorizontalAlignment(JLabel.CENTER);
		rightButton.addActionListener(this);

		upButton = new JButton(up);
		upButton.setBounds(b_x + 90, b_y, 60, 40);
		upButton.setFont(new Font("Meiryo UI", Font.BOLD, 20));
		upButton.setBackground(Color.ORANGE);
		upButton.setHorizontalAlignment(JLabel.CENTER);
		upButton.addActionListener(this);

		coinButton = new JButton(coin);
		coinButton.setBounds(b_x - 150, b_y, 120, 40);
		coinButton.setFont(new Font("Meiryo UI", Font.BOLD, 15));
		coinButton.setBackground(Color.ORANGE);
		coinButton.setHorizontalAlignment(JLabel.CENTER);
		coinButton.addActionListener(this);

		releaseButton = new JButton(release);
		releaseButton.setBounds(b_x + 20, b_y + 45, 120, 30);
		releaseButton.setFont(new Font("Meiryo UI", Font.BOLD, 18));
		releaseButton.setBackground(Color.ORANGE);
		releaseButton.setHorizontalAlignment(JLabel.CENTER);
		releaseButton.addActionListener(this);

	}

	public JButton getRButton() {
		return rightButton;
	}

	public JButton getUButton() {
		return upButton;
	}

	public JButton getCButton() {
		return coinButton;
	}

	public JButton getReleaseButton() {
		return releaseButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * �E�{�^���������ꂽ��
		 *********************************************/
		if (e.getSource().equals(rightButton)) {

			if (CheckMethodAndFieldFinder.is_wait_right && cm.waitRightToMoveRight() && cm.rightButtonTrigger()
					&& right_button_counter == 0) {
				CheckMethodAndFieldFinder.is_move_right = true;// �E�ړ����ɂ���
				CheckMethodAndFieldFinder.is_tri_right_button = true;// �E�{�^��ON
				CheckMethodAndFieldFinder.is_wait_right = false;// �E�ړ��w���҂���false��
				right_button_counter++;// �I���̍��}
				CheckMethodAndFieldFinder.time_counter = 0;// 30�b�o�߃g���K�[��0�b�ɂ���
			}
		}

		/*
		 * ���{�^���������ꂽ��
		 */
		if (e.getSource().equals(upButton)) {

			if (CheckMethodAndFieldFinder.is_wait_back && cm.waitBackToMoveBack() && cm.backBottunTrigger()) {
				CheckMethodAndFieldFinder.is_wait_back = false;// ���ړ��w���҂���false��
				CheckMethodAndFieldFinder.is_move_back = true;// ���ړ����ɂ���
				CheckMethodAndFieldFinder.is_tri_back_button = true;// ���{�^��ON

				CheckMethodAndFieldFinder.time_counter = 0;// 30�b�o�߃g���K�[��0�b�ɂ���
			}
		}

		/*
		 * �����{�^���������ꂽ��
		 */
		if (e.getSource().equals(releaseButton)) {

			// �E�ړ��������ړ��w���҂�,�E�{�^�������g���K�[
			if (cm.moveRightToWaitBack() && cm.releaseRightButtonTrigger() && CheckMethodAndFieldFinder.is_move_right) {// �����E�ړ����ŁA�����{�^���������ꂽ��
				CheckMethodAndFieldFinder.is_move_right = false;// �E�ړ���������
				CheckMethodAndFieldFinder.is_wait_back = true;// ���ړ��w���҂��ɂ���
				CheckMethodAndFieldFinder.is_tri_right_release = true;// �E�{�^��������true��
			}

			// ���ړ������N���[�����쒆,���{�^�������g���K�[
			if (cm.moveBackToMoveCrane() && cm.releaseBackButtonTrigger() && CheckMethodAndFieldFinder.is_move_back) {// �������ړ����ŁA�����{�^���������ꂽ��
				CheckMethodAndFieldFinder.is_move_back = false;// ���ړ���������
				CheckMethodAndFieldFinder.is_crane_action = true;// �N���[�����쒆�ɂ���
				CheckMethodAndFieldFinder.is_tri_back_release = true;// ���{�^��������true��
			}
		}

		/*
		 * �R�C���{�^���������ꂽ��
		 */
		if (e.getSource().equals(coinButton)) {
			if (CheckMethodAndFieldFinder.is_idle) {// �����A�C�h�����O����������
				CheckMethodAndFieldFinder.is_wait_right = true;// �E�ړ��w���҂��ɂ���
				CheckMethodAndFieldFinder.is_idle = false;// �A�C�h�����O���ł͂Ȃ�����
				CheckMethodAndFieldFinder.is_tri_coin = true;// �R�C���g���K�[ON
			}
		}
	}

}
