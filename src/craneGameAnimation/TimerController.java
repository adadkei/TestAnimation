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

	//���ʗp�J�E���^
	int idle_count=0;
	
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
		
		if (cm.startToidle() && idle_count==0) {
			CheckMethodAndFieldFinder.is_idle = true;
			idle_count++;
		}

		// �e�X�g�p
		//System.out.println("model.isPressed() " + bog.getmodel().isPressed());

	}
}
