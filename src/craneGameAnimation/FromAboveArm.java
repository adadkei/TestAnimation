package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveArm extends JPanel {

	Image img;

	private int y = 0;
	private int a = 0;// 一回だけ実行用

	private boolean is_this = false;
	private boolean is_left = false;

	static int fromabovearm_y_limit = 75;

	public FromAboveArm() {
		img = getToolkit().getImage(Panel.pass + "\\abovearm.png");
		y = FromAboveStrut.ABOVE_ST_Y + 225;
	}

	public void drawAboveArm(Graphics gr) {

		gr.drawImage(img, FromAboveStrut.ABOVE_ST_X - 1, y, this);

		// もし右移動中だったら,ｘ座標が300以下だったら
		if (CheckMethodAndFieldFinder.is_move_right && FrontArm.FRONT_ARM_X < FrontArm.frontarm_x_limit) {
			FromAboveStrut.ABOVE_ST_X = FromAboveStrut.ABOVE_ST_X + 5;
		}

		// もし奥移動,かつy座標が指定数以下だったら
		if (CheckMethodAndFieldFinder.is_move_back && y > fromabovearm_y_limit) {
			y = y - 4;
		}

		// もし奥端スイッチのところまでに到着したら、奥端スイッチon,かつ一回だけ実行
		if (y <= fromabovearm_y_limit && a == 0) {
			CheckMethodAndFieldFinder.is_tri_back_switch = true;
			a++;
		}

		// もし復帰移動中だったら
		if (CheckMethodAndFieldFinder.is_move_return) {

			if (!is_this) {// もし手前にまだ来ていない状態だったら

				// もし移動したアームが最初の手前位置になかったら
				if (y <= (FromAboveIllustration.ABOVE_ILL_Y + 227)) {
					y = y + 4;
				}
				// もし手前位置になったら
				if (y >= (FromAboveIllustration.ABOVE_ILL_Y + 227)) {
					is_this = true;
				}
			}

			if (!is_left) {// もしまだ一番左に来ていない状態だったら

				// もし移動したアームが最初の左位置になかったら
				if (FromAboveStrut.ABOVE_ST_X >= (FromAboveIllustration.ABOVE_ILL_X + 24)) {
					FromAboveStrut.ABOVE_ST_X = FromAboveStrut.ABOVE_ST_X - 5;
				}

				// もし一番左に来たら
				if (FromAboveStrut.ABOVE_ST_X <= (FromAboveIllustration.ABOVE_ILL_X + 24)) {
					is_left = true;
				}
			}

			if (is_left && is_this) {// もし手間端、左端に来た状態になったら
				CheckMethodAndFieldFinder.is_tri_this_and_left_switch = true;
			}
		}
	}
}
