package ElectricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Steam extends JPanel {

    Image img;

    Steam() {
        img = getToolkit()
                .getImage("C:\\Users\\ia12008\\Dropbox\\ŽðˆäŒ¤‹†Žº\\ƒ[ƒ~4”N\\‘²Œ¤\\image\\yuge.png");
    }

    public void drawSteam(Graphics gr) {
        gr.drawImage(img, DrawSteamPanel.IMAGE_X, DrawSteamPanel.IMAGE_Y, this);
    }
}
