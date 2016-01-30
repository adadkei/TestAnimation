package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.poi.util.SystemOutLogger;

public class FrontArm extends JPanel {

	Image img;

	int a = 0;

	static int frontarm_x_limit = 323;

	static int FRONT_ARM_X = FrontIllustration.FRONT_ILL_X - 30;
	static int FRONT_ARM_Y = FrontIllustration.FRONT_ILL_Y - 22;

	List<Image> frontArmImages = new ArrayList<Image>();

	public FrontArm() {
		// TODO Auto-generated constructor stub
		img = getToolkit().getImage(Panel.pass + "\\arm1.png");
	}

	public void drawFrontArm(Graphics gr) {

		// もしクレーン動作中だったら
		if (CheckMethodAndFieldFinder.is_crane_action) {
			
			img = getToolkit().getImage(Panel.pass + "\\arm2.png");
			gr.drawImage(img, FRONT_ARM_X-5, FRONT_ARM_Y+24, this);
		
		} else {// 通常の表示
			gr.drawImage(img, FRONT_ARM_X, FRONT_ARM_Y, this);
		}

		// もし右移動中だったら,ｘ座標が300以下だったら
		if (CheckMethodAndFieldFinder.is_move_right && FRONT_ARM_X < frontarm_x_limit) {
			FRONT_ARM_X = FRONT_ARM_X + 5;
		}

		// もし右端スイッチのところまでに到着したら、右端スイッチon,かつ一回だけ実行
		if (FRONT_ARM_X > frontarm_x_limit && a == 0) {
			CheckMethodAndFieldFinder.is_tri_right_switch = true;
			a++;
		}

	}

}
