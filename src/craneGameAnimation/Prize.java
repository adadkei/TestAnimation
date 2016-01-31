package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Prize extends JPanel {

	static boolean is_prize;
	Image img;
	CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

	private int x = FrontIllustration.FRONT_ILL_X + 12;
	private int y = FrontIllustration.FRONT_ILL_Y + 50;

	private int limit = 260;

	public Prize() {
		img = getToolkit().getImage(Panel.pass + "\\maru1.png");
	}

	public void drawPrize(Graphics gr) {

		if (is_prize) {// もし景品がtrueになったら
			if (y < limit) {// もしまだ景品口座標より上だったら
				gr.drawImage(img, x, y, this);
				y = y + 8;
			}
			if (y >= limit) {// もし景品が、景品口に到着したら
				is_prize = false;
				CheckMethodAndFieldFinder.is_prize_action = false;
				if (cm.prizeActionToIdle()) {// もし正しい記述があったら
					CheckMethodAndFieldFinder.is_idle = true;
				}
			}

		}

	}

}
