package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FrontIllustration extends JPanel {

    static int FRONT_ILL_X = 50;
    static int FRONT_ILL_Y = 50;

    Image img;// ‰æ‘œ

    public FrontIllustration() {

        img = getToolkit().getImage(Panel.pass + "\\waku.png");
    }

    public void drawFrontIll(Graphics gr) {
        gr.drawImage(img, FRONT_ILL_X, FRONT_ILL_Y, this);
    }

}
