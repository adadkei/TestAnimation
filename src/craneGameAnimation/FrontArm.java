package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FrontArm extends JPanel {

	Image img;

	public FrontArm() {
		// TODO Auto-generated constructor stub
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\ŽðˆäŒ¤‹†Žº\\ƒ[ƒ~4”N\\‘²Œ¤\\image\\cranegame\\armlong.png");
	}
	
	public void drawFrontArm(Graphics gr) {
		gr.drawImage(img, FrontIllustration.FRONT_ILL_X+70, FrontIllustration.FRONT_ILL_Y, this);
	}


}
