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

	FromAboveIllustration fai = new FromAboveIllustration();//�ォ��݂��C���X�g
	FromAboveStrut fas = new FromAboveStrut();//�ォ�猩���x��
	FromAboveArm faa = new FromAboveArm();//�ォ�猩���A�[��
	
	ButtonOfGame bg = new ButtonOfGame();
	
	Timer timer;

	public Panel() {// �R���X�g���N�^
		setBackground(Color.white);
		setLayout(null);// ����Ő�΃��C�A�E�g�Ɛ���B���ꂼ��̃R���|�[�l���g�͎����ō��W��ݒ肷��K�v����

		//�Q�[���{�^����ǉ�
		add(bg.getRButton());
		add(bg.getUButton());
		add(bg.getCButton());
		
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
		fi.drawFrontIll(g2);//�O���猩���C���X�g��\��
		fai.drawAboveIll(g2);//�ォ��݂��C���X�g��\��
		fas.drawAboveStrut(g2);//�ォ�猩���x����\��
		faa.drawAboveArm(g2);//�ォ�猩���A�[����\��

	}
}
