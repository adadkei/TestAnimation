package electricPotAnimation;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;

import acquisitionOfAstahDiagram.StateMachineDiagram;

class Main extends JFrame {
    // フレームの配置
    final static int HEIGHT = 500;
    final static int WIDTH = 600;
    final static int X = 320;
    final static int Y = 180;

    Main() {
        DrawSteamPanel dsPanel = new DrawSteamPanel();
        State state = new State();
        add(dsPanel);

        new Timer(100, dsPanel).start();
    }

    // Main
    public static void main(String args[]) throws ClassNotFoundException, LicenseNotFoundException, ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException, Throwable {
        JFrame mainFrame = new Main();
        mainFrame.setTitle("電気ポットアニメーション");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(X, Y, WIDTH, HEIGHT);
        mainFrame.setBackground(Color.WHITE);
        mainFrame.setVisible(true);

        new StateMachineDiagram();
        
    }
}