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

	//判別用カウンタ
	int idle_count=0;
	
	public TimerController() {
		// タイマー
		timer = new Timer(100, this);// 1秒毎にタイマーイベント発生
		timer.setCoalesce(true);
		timer.setRepeats(true); // 繰り返しイベント発生
		timer.start(); // タイマー起動

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		// アイドリングまでのながれ、かつ右移動指示待ちがfalseだったら
		
		if (cm.startToidle() && idle_count==0) {
			CheckMethodAndFieldFinder.is_idle = true;
			idle_count++;
		}

		// テスト用
		//System.out.println("model.isPressed() " + bog.getmodel().isPressed());

	}
}
