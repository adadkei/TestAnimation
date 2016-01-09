package ElectricPotAnimation;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JPanel {
    static Image img;
    // フレームの配置
    final static int HEIGHT = 500;
    final static int WIDTH = 600;
    final static int X = 320;
    final static int Y = 180;

    // Main
    public static void main(String args[]) {
        Main japp = new Main();
        img = japp.getToolkit().getImage(
                "C:\\Users\\ia12008\\Dropbox\\酒井研究室\\ゼミ4年\\卒研\\image\\yuge.png");
        JFrame jframe = new JFrame("Anime Gif");
        Container c = jframe.getContentPane();
        c.add(japp);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(X, Y, WIDTH, HEIGHT);
        c.setBackground(Color.WHITE);
        jframe.setVisible(true);

    }

    // Paint Method
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, X - 70, 150, this);
        }
    }
}