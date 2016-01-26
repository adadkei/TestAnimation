package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FrontArm extends JPanel {

    Image img;

    static int FRONT_ARM_X = FrontIllustration.FRONT_ILL_X - 30;
    static int FRONT_ARM_Y = FrontIllustration.FRONT_ILL_Y - 22;

    public FrontArm() {
        // TODO Auto-generated constructor stub
        img = getToolkit().getImage(Panel.pass + "\\arm1.png");
    }

    public void drawFrontArm(Graphics gr) {
        gr.drawImage(img, FRONT_ARM_X, FRONT_ARM_Y, this);
    }

}
