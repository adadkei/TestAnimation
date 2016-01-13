package electricPotAnimation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

import acquisitionOfAstahDiagram.DecisionController;

public class State extends JLabel implements ActionListener {

	Timer timer;
	public JLabel power_label;
	public JLabel state_label;

	// ���W
	int s1_x = ElectricPot.POT_X - 30;
	int s1_y = ElectricPot.POT_Y + 120;
	int s2_x = ElectricPot.POT_X + 60;
	int s2_y = ElectricPot.POT_Y + 120;

	CheckMethodFinder cm = new CheckMethodFinder();

	String off = "off";
	String on = "on";
	String boiling = "������";
	String keep_warm = "�ۉ�";
	String push_button = "�����{�^��";
	String kara = "";

	State() {
		timer = new Timer(1000, this);// 1�b���Ƀ^�C�}�[�C�x���g����
		timer.setCoalesce(true);
		timer.setRepeats(true); // �J��Ԃ��C�x���g����
		timer.start(); // �^�C�}�[�N��
		/*
		 * �d����Ԃ̃��x��
		 */
		power_label = new JLabel();
		// ���x������ݒ�
		power_label.setText(cm.setLabelChar(off, "�J�n�^�����0"));
		// �����̃t�H���g�̐ݒ�
		power_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		power_label.setBounds(s1_x, s1_y, 65, 28);
		// �w�i�F�̐ݒ�
		power_label.setBackground(new Color(251, 236, 26, 200));
		power_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
		// �����ʒu�̐ݒ�
		power_label.setHorizontalAlignment(JLabel.CENTER);
		// �g���̐ݒ�
		power_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		/*
		 * ��Ԃ̃��x��
		 */
		state_label = new JLabel();
		// ���x������ݒ�
		// ���x������ݒ�
		state_label.setText(keep_warm);
		// �����̃t�H���g�̐ݒ�
		state_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
		// ���x���̈ʒu�Ƒ傫���̐ݒ�
		state_label.setBounds(s2_x, s2_y, 65, 28);
		// �w�i�F�̐ݒ�
		state_label.setBackground(new Color(255, 40, 25, 150));
		state_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
		// �����ʒu�̐ݒ�
		state_label.setHorizontalAlignment(JLabel.CENTER);
		// �g���̐ݒ�
		state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//on�{�^���������ꂽ��
		if(Button.is_on_clicked){
			power_label.setText(on);
		}else{
			power_label.setText(off);
		}
		
	}
	
	public JLabel getPowerState() {
		return power_label;
	}

	public JLabel getState() {
		return state_label;
	}


	

	

}
