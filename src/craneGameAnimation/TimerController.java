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
        // タイマー
        timer = new Timer(100, this);// 1秒毎にタイマーイベント発生
        timer.setCoalesce(true);
        timer.setRepeats(true); // 繰り返しイベント発生
        timer.start(); // タイマー起動

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (cm.startToidle()) {
            CheckMethodAndFieldFinder.is_idle = true;
        }

    }
}
