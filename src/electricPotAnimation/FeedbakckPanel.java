package electricPotAnimation;

import java.awt.Color;

import javax.swing.JPanel;

public class FeedbakckPanel extends JPanel {

    FeedbackCharacter fc = new FeedbackCharacter();

    public FeedbakckPanel() {
        setBackground(Color.white);
        setLayout(null);// ����Ő�΃��C�A�E�g�Ɛ���B���ꂼ��̃R���|�[�l���g�͎����ō��W��ݒ肷��K�v����
        for (int i = 0; i < fc.getFeedbackChar1().size(); i++)
            add(fc.getFeedbackChar1().get(i));
    }
}
