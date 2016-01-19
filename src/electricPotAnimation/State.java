package electricPotAnimation;

import java.awt.Color;
import java.awt.Font;
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

	public static int keep_warm_counter;

	// 座標
	int s1_x = ElectricPot.POT_X - 30;
	int s1_y = ElectricPot.POT_Y + 120;
	int s2_x = ElectricPot.POT_X + 60;
	int s2_y = ElectricPot.POT_Y + 120;

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();
	DecisionController dc = new DecisionController();

	String off = "off";
	String on = "on";
	String boiling = "加熱中";
	String keep_warm = "保温中";
	String push_button = "沸騰ボタン";
	String kara = "";

	State() {
		timer = new Timer(100, this);// 1秒毎にタイマーイベント発生
		timer.setCoalesce(true);
		timer.setRepeats(true); // 繰り返しイベント発生
		timer.start(); // タイマー起動
		/*
		 * 電源状態のラベル
		 */
		power_label = new JLabel();
		// ラベル名を設定
		power_label.setText(cm.setLabelChar("off", "開始擬似状態0"));
		// 文字のフォントの設定
		power_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
		// ラベルの位置と大きさの設定
		power_label.setBounds(s1_x, s1_y, 65, 28);
		// 背景色の設定
		power_label.setBackground(new Color(251, 236, 26, 200));
		power_label.setOpaque(true);// ラベルの背景を非透明にしている
		// 文字位置の設定
		power_label.setHorizontalAlignment(JLabel.CENTER);
		// 枠線の設定
		power_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));

		/*
		 * 状態のラベル
		 */
		state_label = new JLabel();
		// ラベル名を設定
		// ラベル名を設定
		state_label.setText(kara);
		// 文字のフォントの設定
		state_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
		// ラベルの位置と大きさの設定
		state_label.setBounds(s2_x, s2_y, 65, 28);
		// 背景色の設定
		state_label.setBackground(new Color(255, 40, 25, 150));
		state_label.setOpaque(true);// ラベルの背景を非透明にしている
		// 文字位置の設定
		state_label.setHorizontalAlignment(JLabel.CENTER);
		// 枠線の設定
		state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (CheckMethodAndFieldFinder.is_on_clicked) {// onボタンが押されたら
			power_label.setText(on);
		} else if (cm.checkStartToOff()) {// 開始疑似状態→offがあったら
			power_label.setText(off);
		} else if (!CheckMethodAndFieldFinder.is_on_clicked && cm.checkOffFlow()) {// on状態じゃなかったら
			power_label.setText(off);
		} else {
			power_label.setText(kara);
		}
		
		//トリガーonがなければ、自動的にon状態に移行
		if(isTriggerON()){
			CheckMethodAndFieldFinder.is_on_clicked=true;
		}

			
			
			
		// 加熱状態表示(入れ子あり) または入れ子無しで加熱中までの遷移があったら
		if (dc.OrNotSubPreVertex() && CheckMethodAndFieldFinder.is_on_clicked && cm.checkOnFlow()
				&& cm.subCheckHeatingFlow() || (CheckMethodAndFieldFinder.is_on_clicked && cm.checkOnToBoiling())) {
			state_label.setText(boiling);
			CheckMethodAndFieldFinder.is_boiling = true;
		} else {
			state_label.setText(kara);
		}

		// 保温中表示
		if (dc.OrNotSubPreVertex() && cm.subCheckBoilingToKeepWarmFlow() || (cm.checkBoilingToKeepWarmFlow())) {
			if (Steam.steam_count >= 70) {// 加熱中アニメーションが終わると
				state_label.setText(keep_warm);
				CheckMethodAndFieldFinder.is_boiling = false;
			}
			CheckMethodAndFieldFinder.is_keep_warm = true;
		}

	}
	
	/**
	 * 開始擬似状態→off→on→加熱　かつ　onトリガなしのとき
	 * @return
	 */
	public boolean isTriggerON(){
		if(dc.checkPreVertex("off", "開始擬似状態0")&&dc.checkPreVertex("on","off")&&dc.checkVertexIncoming("on", kara)){
			return true;
		}
		return false;
	}

	public JLabel getPowerState() {
		return power_label;
	}

	public JLabel getState() {
		return state_label;
	}

}
