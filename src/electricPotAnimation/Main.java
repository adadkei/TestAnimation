package electricPotAnimation;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;

import acquisitionOfAstahDiagram.StateMachineDiagram;

class Main extends JFrame {

	// フレームの配置
	final static int HEIGHT = 400;
	final static int WIDTH = 500;
	final static int X = 250;
	final static int Y = 180;

	Main() {

		State state = new State();

	}

	// Main
	public static void main(String args[]) throws ClassNotFoundException, LicenseNotFoundException,
			ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException, Throwable {
		new StateMachineDiagram();

		DrawSteamPanel dsPanel = new DrawSteamPanel();
		FeedbackPanel fbPanel = new FeedbackPanel();
		
		new Timer(100, dsPanel).start();// 必要
		
		makeFeedbackFrame(fbPanel);
		makeMainFrame(dsPanel);
		
		FeedBackDiscrimination fbd = new FeedBackDiscrimination();
		
		

	}

	private static void makeMainFrame(JPanel dsPanel) {
		JFrame mainFrame = new Main();
		mainFrame.setTitle("電気ポットアニメーション");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(X, Y, WIDTH, HEIGHT);
		mainFrame.setBackground(Color.WHITE);
		mainFrame.add(dsPanel);
		mainFrame.setVisible(true);
	}
	private static void makeFeedbackFrame(JPanel dsPanel) {
		JFrame subFrame = new Main();
		subFrame.setTitle("電気ポットアニメーションフィードバック");
		subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subFrame.setBounds(X+200, Y+30, WIDTH+100, HEIGHT+200);
		subFrame.setBackground(Color.WHITE);
		subFrame.add(dsPanel);
		subFrame.setVisible(true);
	}
}