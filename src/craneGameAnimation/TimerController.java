package craneGameAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acquisitionOfAstahDiagram.DecisionController;

public class TimerController implements ActionListener {

    Timer timer;
    CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();
    DecisionController dc = new DecisionController();

    public TimerController() {
        // �^�C�}�[
        timer = new Timer(100, this);// 1�b���Ƀ^�C�}�[�C�x���g����
        timer.setCoalesce(true);
        timer.setRepeats(true); // �J��Ԃ��C�x���g����
        timer.start(); // �^�C�}�[�N��

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (cm.startToidle()) {
            CheckMethodAndFieldFinder.is_idle = true;
        }

    }
}
