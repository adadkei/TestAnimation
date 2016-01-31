package craneGameAnimation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class State extends JLabel implements ActionListener {

	Timer timer;
	int counter;// トリガー一定時間表示ためのカウンター
	int show_counter = 15;// トリガーをどれくらい表示させるか

	List<JLabel> lists = new ArrayList<>();// リスト
	public JLabel state_label;
	public JLabel sub_state_label;
	public JLabel trigger_label;
	public JLabel state;
	public JLabel trigger;

	// 座標
	int s_x = FrontIllustration.FRONT_ILL_X + 300;// 基準
	int s_y = FrontIllustration.FRONT_ILL_Y + 330;// 基準
	int su_x = s_x + 170;
	int su_y = s_y;
	int t_x = su_x;
	int t_y = s_y;

	// 文字
	String kara = "";
	String c_state = "状態";
	String c_trigger = "トリガー";

	String idle = "アイドリング中";
	String wait_right = "右移動指示待ち";
	String wait_back = "奥移動指示待ち";
	String move_right = "右移動中";
	String move_back = "奥移動中";
	String crane_action = "クレーン動作中";
	String move_return = "復帰移動中";
	String move_left = "左移動中";
	String move_this_side = "手前移動中";
	String prize_action = "景品投下動作中";

	String tri_coin = "コイン投入";
	String tri_right_button = "右ボタン押し";
	String tri_right_switch = "右端スイッチON";
	String tri_right_release = "右ボタン放し";
	String tri_back_button = "奥ボタン押し";
	String tri_back_switch = "奥スイッチON";
	String tri_back_release = "奥ボタン放し";
	String tri_thirty = "30秒経過";
	String tri_left_switch = "左端スイッチON";
	String tri_this_side_switch = "手前端スイッチON";
	String tri_crane_up = "クレーン上昇";
	String tri_this_and_left_switch = "手前端・左端スイッチON";

	public State() {
		// タイマー
		timer = new Timer(100, this);// 1秒毎にタイマーイベント発生
		timer.setCoalesce(true);
		timer.setRepeats(true); // 繰り返しイベント発生
		timer.start(); // タイマー起動

		// 各ラベルを作成
		createCharState();
		createCharTrigger();
		createStateLabel();
		// createSubStateLabel();
		createTriggerLabel();

		// 各状態をリストに追加
		lists.add(state_label);
		// lists.add(sub_state_label);
		lists.add(trigger_label);
		lists.add(state);
		lists.add(trigger);
	}

	private void createTriggerLabel() {
		/*
		 * トリガーのラベル
		 */
		trigger_label = new JLabel();
		// ラベル名を設定
		trigger_label.setText(kara);
		// 文字のフォントの設定
		trigger_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ラベルの位置と大きさの設定
		trigger_label.setBounds(t_x, t_y, 190, 35);
		// 背景色の設定
		trigger_label.setBackground(new Color(255, 204, 255));
		trigger_label.setOpaque(true);// ラベルの背景を非透明にしている
		// 文字位置の設定
		trigger_label.setHorizontalAlignment(JLabel.CENTER);
		// 枠線の設定
		trigger_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createSubStateLabel() {
		/*
		 * サブ状態のラベル
		 */
		sub_state_label = new JLabel();
		// ラベル名を設定
		sub_state_label.setText(move_left);
		// 文字のフォントの設定
		sub_state_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ラベルの位置と大きさの設定
		sub_state_label.setBounds(su_x, su_y, 140, 35);
		// 背景色の設定
		sub_state_label.setBackground(new Color(204, 255, 153));
		sub_state_label.setOpaque(true);// ラベルの背景を非透明にしている
		// 文字位置の設定
		sub_state_label.setHorizontalAlignment(JLabel.CENTER);
		// 枠線の設定
		sub_state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createStateLabel() {
		/*
		 * 状態のラベル
		 */
		state_label = new JLabel();
		// ラベル名を設定
		state_label.setText(kara);
		// 文字のフォントの設定
		state_label.setFont(new Font("Meiryo UI", Font.BOLD, 17));
		// ラベルの位置と大きさの設定
		state_label.setBounds(s_x, s_y, 140, 35);
		// 背景色の設定
		state_label.setBackground(new Color(204, 255, 153));
		state_label.setOpaque(true);// ラベルの背景を非透明にしている
		// 文字位置の設定
		state_label.setHorizontalAlignment(JLabel.CENTER);
		// 枠線の設定
		state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	}

	private void createCharTrigger() {
		/*
		 * トリガー文字のラベル
		 */
		trigger = new JLabel();
		// ラベル名を設定
		trigger.setText(c_trigger);
		// 文字のフォントの設定
		trigger.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		// ラベルの位置と大きさの設定
		trigger.setBounds(t_x - 40, s_y - 25, 140, 35);
		// 文字位置の設定
		trigger.setHorizontalAlignment(JLabel.CENTER);
	}

	private void createCharState() {
		/*
		 * 状態文字のラベル
		 */
		state = new JLabel();
		// ラベル名を設定
		state.setText(c_state);
		// 文字のフォントの設定
		state.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		// ラベルの位置と大きさの設定
		state.setBounds(s_x - 40, s_y - 25, 140, 35);
		// 文字位置の設定
		state.setHorizontalAlignment(JLabel.CENTER);
	}

	public List<JLabel> getStateLists() {
		return lists;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * 状態ラベル
		 */
		if (CheckMethodAndFieldFinder.is_idle) {// もしアイドリング中だったら
			state_label.setText(idle);
		}
		if (CheckMethodAndFieldFinder.is_wait_right) {// もし右移動指示待ちだったら
			state_label.setText(wait_right);
		}
		if (CheckMethodAndFieldFinder.is_move_right) {// もし右移動中だったら
			state_label.setText(move_right);
		}
		if (CheckMethodAndFieldFinder.is_wait_back) {// もし奥移動指示待ちだったら
			state_label.setText(wait_back);
		}
		if (CheckMethodAndFieldFinder.is_move_back) {// もし奥移動中だったら
			state_label.setText(move_back);
		}
		if (CheckMethodAndFieldFinder.is_crane_action) {// もしクレーン動作中だったら
			state_label.setText(crane_action);
		}
		if (CheckMethodAndFieldFinder.is_move_return) {// もし復帰移動中だったら
			state_label.setText(move_return);
		}
		if (CheckMethodAndFieldFinder.is_prize_action) {// もし景品投下動作中だったら
			state_label.setText(prize_action);
		}

		/*
		 * トリガーラベル
		 */
		// コイントリガー
		if (CheckMethodAndFieldFinder.is_tri_coin) {
			trigger_label.setText(tri_coin);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_coin = false;// コイントリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 右ボタントリガー
		else if (CheckMethodAndFieldFinder.is_tri_right_button) {
			trigger_label.setText(tri_right_button);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_right_button = false;// コイントリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 30秒経過トリガー
		else if (CheckMethodAndFieldFinder.is_tri_thirty) {
			trigger_label.setText(tri_thirty);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_thirty = false;// 30秒経過トリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 右端スイッチONトリガー
		else if (CheckMethodAndFieldFinder.is_tri_right_switch) {
			trigger_label.setText(tri_right_switch);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_right_switch = false;// 右端スイッチONトリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 右ボタン放しトリガー
		else if (CheckMethodAndFieldFinder.is_tri_right_release) {
			trigger_label.setText(tri_right_release);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_right_release = false;// 右ボタン離しトリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 奥ボタントリガー
		else if (CheckMethodAndFieldFinder.is_tri_back_button) {
			trigger_label.setText(tri_back_button);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_back_button = false;// コイントリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 奥ボタン放しトリガー
		else if (CheckMethodAndFieldFinder.is_tri_back_release) {
			trigger_label.setText(tri_back_release);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_back_release = false;// 右ボタン離しトリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 奥スイッチONトリガー
		else if (CheckMethodAndFieldFinder.is_tri_back_switch) {
			trigger_label.setText(tri_back_switch);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_back_switch = false;// 奥スイッチONトリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// クレーン上昇トリガー
		else if (CheckMethodAndFieldFinder.is_tri_crane_up) {
			trigger_label.setText(tri_crane_up);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_crane_up = false;// クレーン上昇トリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

		// 手前端・左端スイッチONトリガー
		else if (CheckMethodAndFieldFinder.is_tri_this_and_left_switch) {
			trigger_label.setText(tri_this_and_left_switch);
			counter++;// カウンターを足す

			if (counter > show_counter) {// 一定時間経つと
				CheckMethodAndFieldFinder.is_tri_this_and_left_switch = false;// 手前端・左端スイッチONトリガーをfalseに
				trigger_label.setText(kara);// ラベルの中身を空にする
				counter = 0;
			}
		}

	}

}
