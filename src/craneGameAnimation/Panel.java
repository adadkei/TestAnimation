package craneGameAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {

	//���ꂼ��̐}�̃C���X�^���X�쐬
	FrontIllustration fi = new FrontIllustration();
	FrontArm fa = new FrontArm();

	Timer timer;

	public Panel() {// �R���X�g���N�^
		setBackground(Color.white);
		setLayout(null);// ����Ő�΃��C�A�E�g�Ɛ���B���ꂼ��̃R���|�[�l���g�͎����ō��W��ݒ肷��K�v����

		timer = new Timer(1000, this);// 1�b���Ƀ^�C�}�[�C�x���g����
		timer.setCoalesce(true);
		timer.setRepeats(true); // �J��Ԃ��C�x���g����
		timer.start(); // �^�C�}�[�N��
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		fa.drawFrontArm(g2);//�A�[����\��
		fi.drawFrontIll(g2);

	}
}
