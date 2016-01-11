package electricPotAnimation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

class TestMain extends JFrame {
    // �t���[���̔z�u
    final static int HEIGHT = 500;
    final static int WIDTH = 600;
    final static int X = 320;
    final static int Y = 180;

    TestMain() {
        DrawSteamPanel dsPanel = new DrawSteamPanel();
        State state = new State();
        add(dsPanel);

        new Timer(100, dsPanel).start();
    }

    // Main
    public static void main(String args[]) {
        JFrame mainFrame = new TestMain();
        mainFrame.setTitle("�d�C�|�b�g�A�j���[�V����");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(X, Y, WIDTH, HEIGHT);
        mainFrame.setBackground(Color.WHITE);
        mainFrame.setVisible(true);

    }
}