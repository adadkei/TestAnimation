package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveArm extends JPanel {

	Image img;

	private int y = 0;
	private int a = 0;//一回だけ実行用

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
	}
}
