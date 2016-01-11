package electricPotAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Steam extends JPanel {

    static int IMAGE_X = 230;
    static int IMAGE_Y = 100;
    Image img;

    Steam() {
        img = getToolkit()
                .getImage("C:\\Users\\ia12008\\Dropbox\\ŽðˆäŒ¤‹†Žº\\ƒ[ƒ~4”N\\‘²Œ¤\\image\\yuge.png");
    }

    public void drawSteam(Graphics gr) {
        if (DrawSteamPanel.counter < 30) {
            gr.drawImage(img, IMAGE_X, IMAGE_Y, this);
        }
        if (DrawSteamPanel.counter > 10) {
            gr.drawImage(img, IMAGE_X - 10, IMAGE_Y - 35, this);
        }
        if (DrawSteamPanel.counter > 20) {
            gr.drawImage(img, IMAGE_X - 20, IMAGE_Y - 70, this);
        }

    }
}
