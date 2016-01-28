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

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();
	ButtonModel model;
	// ���W
	int b_x = FrontIllustration.FRONT_ILL_X + 460;
	int b_y = FrontIllustration.FRONT_ILL_Y + 400;

	// ����
	String right = "��";
	String up = "��";
	String coin = "�R�C������";

	// ���ʗp�J�E���^
	int right_button_counter = 0;

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

		model = rightButton.getModel();
		
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

	public ButtonModel getmodel(){
		return model;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		
		/*
		 * �E�{�^���������ꂽ��
		 */
		if (e.getSource().equals(rightButton)) {

			System.out.println("aaaaaaaa");
			if (CheckMethodAndFieldFinder.is_wait_right && cm.waitRightToMoveRight()
					&& cm.rightButtonTrigger() && right_button_counter == 0) {
				CheckMethodAndFieldFinder.is_move_right = true;// �E�ړ����ɂ���
				CheckMethodAndFieldFinder.is_tri_right_button=true;//�E�{�^��ON
				CheckMethodAndFieldFinder.is_wait_right = false;// �E�ړ��w���҂���false��
				//right_button_counter++;// �I���̍��}
			}
		}

		/*
		 * ��{�^���������ꂽ��
		 */
		if (e.getSource().equals(upButton)) {

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
