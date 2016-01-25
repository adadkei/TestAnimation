package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveStrut extends JPanel {

	Image img;

	static int ABOVE_ST_X = FromAboveIllustration.ABOVE_ILL_X + 25;
	static int ABOVE_ST_Y = FromAboveIllustration.ABOVE_ILL_Y + 2;

	public FromAboveStrut() {
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\ŽðˆäŒ¤‹†Žº\\ƒ[ƒ~4”N\\‘²Œ¤\\image\\cranegame\\abovestrut.png");
	}

	public void drawAboveStrut(Graphics gr) {
		gr.drawImage(img, ABOVE_ST_X, ABOVE_ST_Y, this);
	}
}
