package electricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ElectricPot extends JPanel {

	static int POT_X = 150;
	static int POT_Y = 120;
	Image img;

	ElectricPot() {
		// img =
		// getToolkit().getImage("C:\\Users\\ia12008\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\�d�C�P�g��.png");
		
		// �Â���
		img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\pot_mono.png");
	}

	public void drawPot(Graphics gr) {
		if (Button.is_on_clicked) {
			// ���邢��
			img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\�d�C�P�g��.png");
			//Button.is_on_clicked=false;
		}else{//on����Ȃ�����
			//�Â���
			img = getToolkit().getImage("C:\\Users\\Ikemi\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\pot_mono.png");
		}
		gr.drawImage(img, POT_X, POT_Y, this);
	}
}
