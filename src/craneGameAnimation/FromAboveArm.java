package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveArm extends JPanel {

	Image img;

	public FromAboveArm() {
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\cranegame\\abovearm.png");
	}

	public void drawAboveArm(Graphics gr) {
		gr.drawImage(img, FromAboveStrut.ABOVE_ST_X - 1, FromAboveStrut.ABOVE_ST_Y+225, this);
	}
}
