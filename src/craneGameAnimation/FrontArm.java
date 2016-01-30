package craneGameAnimation;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.poi.util.SystemOutLogger;

public class FrontArm extends JPanel {

	Image img;

	static int a = 0;// ����J�E���^
	static int b = 0;// �N���[�����쒆�J�E���^

	private int speed = 7;// �㉺�ɍs���X�s�[�h

	static int frontarm_x_limit = 323;
	static int frontarm_y_bottom_limit = 230;
	static int frontarm_y_top_limit = 29;

	static int FRONT_ARM_X = FrontIllustration.FRONT_ILL_X - 30;
	static int FRONT_ARM_Y = FrontIllustration.FRONT_ILL_Y - 22;

	List<Image> frontArmImages = new ArrayList<Image>();

	public FrontArm() {
		// TODO Auto-generated constructor stub
		img = getToolkit().getImage(Panel.pass + "\\arm1.png");
	}

	public void drawFrontArm(Graphics gr) {

		// �����N���[�����쒆��������
		if (CheckMethodAndFieldFinder.is_crane_action) {

			// �A�[�����J���Ă�����̂ɂ���,b=0
			if (b == 0) {
				img = getToolkit().getImage(Panel.pass + "\\arm2.png");
				gr.drawImage(img, FRONT_ARM_X - 5, FRONT_ARM_Y + 24, this);// �A�[����`��

				// ���ɂ�������
				if (FRONT_ARM_Y < frontarm_y_bottom_limit) {
					FRONT_ARM_Y = FRONT_ARM_Y + speed;
				}

				// ������ԉ��܂ŗ�����
				if (FRONT_ARM_Y >= frontarm_y_bottom_limit) {
					img = getToolkit().getImage(Panel.pass + "\\arm3.png");
					gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);
					b++;
				}
			}

			// �A�[�����{�[����͂�ł�����̂ɂ���,b=1
			if (b == 1) {
				img = getToolkit().getImage(Panel.pass + "\\arm3.png");
				gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);

				// ��ɂ�������
				if (FRONT_ARM_Y > frontarm_y_top_limit) {
					FRONT_ARM_Y = FRONT_ARM_Y - speed;
				}
				// ������ԏ�܂ōs������
				if (FRONT_ARM_Y <= frontarm_y_top_limit) {
					CheckMethodAndFieldFinder.is_tri_crane_up = true;
					b++;
				}
			}

		} else if (CheckMethodAndFieldFinder.is_move_return) {// ���A�ړ�����������
			img = getToolkit().getImage(Panel.pass + "\\arm3.png");
			gr.drawImage(img, FRONT_ARM_X + 4, FRONT_ARM_Y + 21, this);
			// ���̈ʒu�ɖ߂�
			if (FRONT_ARM_X >= (FrontIllustration.FRONT_ILL_X - 20)) {// �����ŏ��̈ʒu����Ȃ�������
				FRONT_ARM_X = FRONT_ARM_X - 5;
			}

		} else if (CheckMethodAndFieldFinder.is_prize_action) {// �i�i�������쒆��������
			img = getToolkit().getImage(Panel.pass + "\\arm2.png");// �J���Ă���摜�ɂ���
			gr.drawImage(img, FRONT_ARM_X - 5, FRONT_ARM_Y + 24, this);// �����`��
			Prize.is_prize = true;// �i�i��true�ɂ��ē���쓮
		}

		else {// �ŏ��̕\��
			img = getToolkit().getImage(Panel.pass + "\\arm1.png");
			gr.drawImage(img, FRONT_ARM_X, FRONT_ARM_Y, this);
		}

		// �����E�ړ�����������,�����W��300�ȉ���������
		if (CheckMethodAndFieldFinder.is_move_right && FRONT_ARM_X < frontarm_x_limit)

		{
			FRONT_ARM_X = FRONT_ARM_X + 5;
		}

		// �����E�[�X�C�b�`�̂Ƃ���܂łɓ���������A�E�[�X�C�b�`on,����񂾂����s
		if (FRONT_ARM_X > frontarm_x_limit && a == 0)

		{
			CheckMethodAndFieldFinder.is_tri_right_switch = true;
			a++;
		}

	}

}
