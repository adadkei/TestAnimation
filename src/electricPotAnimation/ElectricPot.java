package electricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ElectricPot extends JPanel {
	static int POT_X = 250;
	static int POT_Y = 120;
	Image img;

	ElectricPot() {
        //img = getToolkit().getImage("C:\\Users\\ia12008\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\�d�C�P�g��.png");
        img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\�d�C�P�g��.png");
    }

	public void drawPot(Graphics gr) {
		gr.drawImage(img, POT_X, POT_Y, this);
	}
}
