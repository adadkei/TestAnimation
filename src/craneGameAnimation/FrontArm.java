package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FrontArm extends JPanel {

	Image img;

	static int a = 0;// 動作カウンタ
	static int b = 0;// クレーン動作中カウンタ

	private int speed = 7;// 上下に行くスピード

	static int frontarm_x_limit = 323;
	static int frontarm_y_bottom_limit = 230;
	static int frontarm_y_top_limit = 29;

	static int FRONT_ARM_X = FrontIllustration.FRONT_ILL_X - 30;
	static int FRONT_ARM_Y = FrontIllustration.FRONT_ILL_Y - 22;

	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

	public FrontArm() {
		// TODO Auto-generated constructor stub
		img = getToolkit().getImage(Panel.pass + "\\arm1.png");
	}

	public void drawFrontArm(Graphics gr) {

		// もしクレーン動作中だったら
		if (CheckMethodAndFieldFinder.is_crane_action) {

			// アームが開いているものにする,b=0
			if (b == 0) {
				img = getToolkit().getImage(Panel.pass + "\\arm2.png");
				gr.drawImage(img, FRONT_ARM_X - 5, FRONT_ARM_Y + 24, this);// アームを描画

				// 下にいく動作
				if (FRONT_ARM_Y < frontarm_y_bottom_limit) {
					FRONT_ARM_Y = FRONT_ARM_Y + speed;
				}

				// もし一番下まで来たら
				if (FRONT_ARM_Y >= frontarm_y_bottom_limit) {
					img = getToolkit().getImage(Panel.pass + "\\arm3.png");
					gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);
					b++;
				}
			}

			// アームがボールを掴んでいるものにする,b=1
			if (b == 1) {
				img = getToolkit().getImage(Panel.pass + "\\arm3.png");
				gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);

				// 上にいく動作
				if (FRONT_ARM_Y > frontarm_y_top_limit) {
					FRONT_ARM_Y = FRONT_ARM_Y - speed;
				}
				// もし一番上まで行ったら,かつクレーン上昇記述あったら
				if (FRONT_ARM_Y <= frontarm_y_top_limit && cm.craneUpTrigger()) {
					CheckMethodAndFieldFinder.is_tri_crane_up = true;
					b++;
				}
			}

		} else if (CheckMethodAndFieldFinder.is_move_return) {// 復帰移動中だったら
			img = getToolkit().getImage(Panel.pass + "\\arm3.png");
			gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);
			// 元の位置に戻る
			if (FRONT_ARM_X >= (FrontIllustration.FRONT_ILL_X - 20)) {// もし最初の位置じゃなかったら
				FRONT_ARM_X = FRONT_ARM_X - 5;
			}

		} else if (CheckMethodAndFieldFinder.is_prize_action) {// 景品投下動作中だったら
			img = getToolkit().getImage(Panel.pass + "\\arm2.png");// 開いている画像にする
			gr.drawImage(img, FRONT_ARM_X - 5, FRONT_ARM_Y + 24, this);// それを描く
			Prize.is_prize = true;// 景品をtrueにして動作作動
		}

		else {// 最初の表示
			img = getToolkit().getImage(Panel.pass + "\\arm1.png");
			gr.drawImage(img, FRONT_ARM_X, FRONT_ARM_Y, this);
		}

		// もし右移動中だったら,ｘ座標が300以下だったら
		if (CheckMethodAndFieldFinder.is_move_right && FRONT_ARM_X < frontarm_x_limit)

		{
			FRONT_ARM_X = FRONT_ARM_X + 5;
		}

		// もし右端スイッチのところまでに到着したら、かつこの記述が図にあったら、右端スイッチon,かつ一回だけ実行
		if (FRONT_ARM_X > frontarm_x_limit && cm.rightSwitchTrigger() && a == 0) {
			CheckMethodAndFieldFinder.is_tri_right_switch = true;
			a++;
		}

	}

}
