package electricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ElectricPot extends JPanel {

	static int POT_X = 150;
	static int POT_Y = 120;
	Image img;

	ElectricPot() {
		// 暗い方
		// img = getToolkit().getImage(
		// "C:\\Users\\ia12008\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\pot_mono.png");

		// 暗い方
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\pot_mono.png");
	}

	public void drawPot(Graphics gr) {
		if (CheckMethodAndFieldFinder.is_on_clicked) {
			// 明るい方
			// img = getToolkit().getImage(
			// "C:\\Users\\ia12008\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\電気ケトル.png");
			img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\電気ケトル.png");
		} else {// onじゃない時は
				// 暗い方
			// img = getToolkit().getImage(
			// "C:\\Users\\ia12008\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\pot_mono.png");
			img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\pot_mono.png");
		}
		gr.drawImage(img, POT_X, POT_Y, this);
	}
}
