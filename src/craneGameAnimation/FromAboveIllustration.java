package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveIllustration extends JPanel {

	static  int ABOVE_ILL_X = 500;
	static  int ABOVE_ILL_Y = 48;

	Image img;

	public FromAboveIllustration() {
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\ŽðˆäŒ¤‹†Žº\\ƒ[ƒ~4”N\\‘²Œ¤\\image\\cranegame\\aboveill.png");
	}

	public void drawAboveIll(Graphics gr) {
		gr.drawImage(img, ABOVE_ILL_X, ABOVE_ILL_Y, this);
	}

}
