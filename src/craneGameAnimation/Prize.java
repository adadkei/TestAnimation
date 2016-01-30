package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Prize extends JPanel {

	static boolean is_prize;
	Image img;

	private int x = FrontIllustration.FRONT_ILL_X + 12;
	private int y = FrontIllustration.FRONT_ILL_Y + 50;

	private int limit = 260;

	public Prize() {
		img = getToolkit().getImage(Panel.pass + "\\maru1.png");
	}

	public void drawPrize(Graphics gr) {

		if (is_prize) {// ‚à‚µŒi•i‚ªtrue‚É‚È‚Á‚½‚ç
			if (y < limit) {// ‚à‚µ‚Ü‚¾Œi•iŒûÀ•W‚æ‚èã‚¾‚Á‚½‚ç
				gr.drawImage(img, x, y, this);
				y = y + 8;
			}
			if (y >= limit) {// ‚à‚µŒi•i‚ªAŒi•iŒû‚É“’…‚µ‚½‚ç
				is_prize = false;
				CheckMethodAndFieldFinder.is_prize_action = false;
				CheckMethodAndFieldFinder.is_idle = true;

			}

		}

	}

}
