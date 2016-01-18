package electricPotAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawSteamPanel extends JPanel implements ActionListener {

    Timer timer;
    static int counter = 0;
    Steam steam = new Steam();
    ElectricPot pot = new ElectricPot();
    State state = new State();
    Button button = new Button();

    public DrawSteamPanel() {

        setBackground(Color.white);
        setLayout(null);// ����Ő�΃��C�A�E�g�Ɛ���B���ꂼ��̃R���|�[�l���g�͎����ō��W��ݒ肷��K�v����

        // �d����ԃ��x����ǉ�
        add(state.getPowerState());// state�N���X����AJ���x�����Q�b�g���A�p�l���ɒǉ�
        // ��ԃ��x����ǉ�
        add(state.getState());
        // �{�^����ǉ�
        add(button.getButton());
        // �R���{�{�b�N�X�ǉ�
        add(button.getJComboBox());

        timer = new Timer(1000, this);// 1�b���Ƀ^�C�}�[�C�x���g����
        timer.setCoalesce(true);
        timer.setRepeats(true); // �J��Ԃ��C�x���g����
        timer.start(); // �^�C�}�[�N��
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        steam.drawSteam(g2);
        pot.drawPot(g2);

        counter++;
        if (counter > 30)
            counter = 0;
        // System.out.println(counter);
    }

}
