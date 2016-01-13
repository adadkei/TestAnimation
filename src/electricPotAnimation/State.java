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

	// 座標
	int s1_x = ElectricPot.POT_X - 30;
	int s1_y = ElectricPot.POT_Y + 120;
	int s2_x = ElectricPot.POT_X + 60;
	int s2_y = ElectricPot.POT_Y + 120;

	CheckMethodFinder cm = new CheckMethodFinder();

	String off = "off";
	String on = "on";
	String boiling = "沸かす";
	String keep_warm = "保温";
	String push_button = "沸騰ボタン";
	String kara = "";

	State() {
		timer = new Timer(1000, this);// 1秒毎にタイマーイベント発生
		timer.setCoalesce(true);
		timer.setRepeats(true); // 繰り返しイベント発生
		timer.start(); // タイマー起動
		/*
		 * 電源状態のラベル
		 */
		power_label = new JLabel();
		// ラベル名を設定
		power_label.setText(cm.setLabelChar(off, "開始疑似状態0"));
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
		state_label.setText(keep_warm);
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
		//onボタンが押されたら
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
