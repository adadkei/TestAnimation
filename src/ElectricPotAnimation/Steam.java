package ElectricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Steam extends JPanel {

    Image img;

    Steam() {
        img = getToolkit()
                .getImage("C:\\Users\\ia12008\\Dropbox\\���䌤����\\�[�~4�N\\����\\image\\yuge.png");
    }

    public void drawSteam(Graphics gr) {
        gr.drawImage(img, DrawSteamPanel.IMAGE_X, DrawSteamPanel.IMAGE_Y, this);
    }
}
