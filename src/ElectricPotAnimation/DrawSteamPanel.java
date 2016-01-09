package ElectricPotAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawSteamPanel extends JPanel implements ActionListener {

    static int IMAGE_X = 250;
    static int IMAGE_Y = 150;
    Timer timer;
    int counter = 0;
    Steam steam = new Steam();

    public DrawSteamPanel() {

        setBackground(Color.white);

        timer = new Timer(1, this);// 1�b���Ƀ^�C�}�[�C�x���g����
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
    }

}
