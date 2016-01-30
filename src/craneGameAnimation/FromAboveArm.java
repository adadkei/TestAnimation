package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FromAboveArm extends JPanel {

	Image img;

	private int y = 0;
	private int a = 0;//��񂾂����s�p

	static int fromabovearm_y_limit = 75;

	public FromAboveArm() {
		img = getToolkit().getImage(Panel.pass + "\\abovearm.png");
		y = FromAboveStrut.ABOVE_ST_Y + 225;
	}

	public void drawAboveArm(Graphics gr) {

		gr.drawImage(img, FromAboveStrut.ABOVE_ST_X - 1, y, this);

		// �����E�ړ�����������,�����W��300�ȉ���������
		if (CheckMethodAndFieldFinder.is_move_right && FrontArm.FRONT_ARM_X < FrontArm.frontarm_x_limit) {
			FromAboveStrut.ABOVE_ST_X = FromAboveStrut.ABOVE_ST_X + 5;
		}

		// �������ړ�,����y���W���w�萔�ȉ���������
		if (CheckMethodAndFieldFinder.is_move_back && y > fromabovearm_y_limit) {
			y = y - 4;
		}

		// �������[�X�C�b�`�̂Ƃ���܂łɓ���������A���[�X�C�b�`on,����񂾂����s
		if (y <= fromabovearm_y_limit && a == 0) {
			CheckMethodAndFieldFinder.is_tri_back_switch = true;
			a++;
		}
	}
}
