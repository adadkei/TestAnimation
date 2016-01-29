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

	// 判別用カウンタ
	int idle_count = 0;

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
		if (cm.startToidle() && idle_count == 0) {
			CheckMethodAndFieldFinder.is_idle = true;
			idle_count++;
		}

		/*
		 * 奥移動指示待ちに遷移する流れ
		 */
		// もし右移動指示待ちになったらカウント開始
		if (CheckMethodAndFieldFinder.is_wait_right) {
			CheckMethodAndFieldFinder.time_counter++;
		}
		// 右移動指示待ち→奥移動指示待ち
		if (cm.waitRightToWaitBack() && cm.thirtyToBackTrigger() && CheckMethodAndFieldFinder.is_wait_right
				&& CheckMethodAndFieldFinder.time_counter > 80) {// もし右移動指示待ち状態、かつカウンターが100を超えたら
			CheckMethodAndFieldFinder.is_wait_right = false;// 右移動指示待ちを解除
			CheckMethodAndFieldFinder.is_wait_back = true;// 奥移動指示待ちにする
			CheckMethodAndFieldFinder.is_tri_thirty = true;// 30秒トリガーフラグon
			CheckMethodAndFieldFinder.time_counter = 0;// カウンターを0に
		}
		// 右移動中→奥移動指示待ち,右端スイッチONトリガーによって
		if (cm.moveRightToWaitBack() && cm.releaseRightButtonTrigger() && CheckMethodAndFieldFinder.is_move_right
				&& CheckMethodAndFieldFinder.is_tri_right_switch) {// もし右移動中、かつ右端スイッチトリガーがtrueだったら
			CheckMethodAndFieldFinder.is_move_right = false;// 右移動中を解除
			CheckMethodAndFieldFinder.is_wait_back = true;// 奥移動指示待ちにする
		}

		/*
		 * クレーン動作中に遷移する流れ
		 */
		// もし奥移動指示待ちになったらカウント開始
		if (CheckMethodAndFieldFinder.is_wait_back) {
			CheckMethodAndFieldFinder.time_counter++;
		}
		// 奥移動指示待ち→クレーン動作中
		if (cm.waitBackToCraneAction() && cm.thirtyToCraneActionTrigger() && CheckMethodAndFieldFinder.is_wait_back
				&& CheckMethodAndFieldFinder.time_counter > 80) {// もし奥移動指示待ち状態、かつカウンターが一定数を超えたら
			CheckMethodAndFieldFinder.is_wait_back = false;// 奥移動指示待ちを解除
			CheckMethodAndFieldFinder.is_crane_action = true;// クレーン動作中にする
			CheckMethodAndFieldFinder.is_tri_thirty = true;// 30秒トリガーフラグon
			CheckMethodAndFieldFinder.time_counter = 0;// カウンターを0に
		}

		// 奥移動中→クレーン動作中,奥スイッチONトリガーによって
		if (cm.moveBackToMoveCrane() && cm.backSwitchTrigger() && CheckMethodAndFieldFinder.is_move_back
				&& CheckMethodAndFieldFinder.is_tri_back_switch) {// もし奥移動中、かつ奥端スイッチトリガーがtrueだったら
			CheckMethodAndFieldFinder.is_move_back = false;// 奥移動中を解除
			CheckMethodAndFieldFinder.is_crane_action = true;// クレーン動作中にする
		}

		/*
		 * 復帰移動中に遷移する流れ
		 */
		if (cm.craneActionToMoveReturn() && cm.craneUpTrigger() && CheckMethodAndFieldFinder.is_crane_action
				&& CheckMethodAndFieldFinder.is_tri_crane_up) {// もしクレーン動作中、かつクレーン上昇トリガーがtrueだったら
			CheckMethodAndFieldFinder.is_crane_action = false;// クレーン動作中を解除
			CheckMethodAndFieldFinder.is_move_return = true;// 復帰移動中にする
		}

		/*
		 * 景品投下動作中に遷移する流れ
		 */
		if (cm.moveReturnToPrizeAction() && cm.thisSideAndLeftTrigger() && CheckMethodAndFieldFinder.is_move_return
				&& CheckMethodAndFieldFinder.is_tri_this_and_left_switch) {// もし復帰移動中、かつ手前端・左端スイッチトリガーがtrueだったら
			CheckMethodAndFieldFinder.is_move_return = false;// 復帰移動中を解除する
			CheckMethodAndFieldFinder.is_prize_action = true;// 景品投下動作中にする
		}
		// テスト用
		System.out.println("time_counter" + CheckMethodAndFieldFinder.time_counter);

	}
}
