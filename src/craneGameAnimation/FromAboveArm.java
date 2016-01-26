package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveArm extends JPanel {

    Image img;

    public FromAboveArm() {
        img = getToolkit().getImage(Panel.pass + "\\abovearm.png");
    }

    public void drawAboveArm(Graphics gr) {
        gr.drawImage(img, FromAboveStrut.ABOVE_ST_X - 1, FromAboveStrut.ABOVE_ST_Y + 225, this);
    }
}
