package craneGameAnimation;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;

import acquisitionOfAstahDiagram.StateMachineDiagram;

public class Main extends JFrame {
	// �t���[���̔z�u
	final static int HEIGHT = 700;
	final static int WIDTH = 1000;
	final static int X = 150;
	final static int Y = 150;

	Main() {

	}

	// Main
	public static void main(String args[]) throws ClassNotFoundException, LicenseNotFoundException,
			ProjectNotFoundException, NonCompatibleException, IOException, ProjectLockedException, Throwable {
		new StateMachineDiagram();

		Panel panel = new Panel();

		makeMainFrame(panel);// ���C���ƂȂ�t���[�����쐬
	}

	private static void makeMainFrame(JPanel panel) {
		JFrame mainFrame = new Main();
		mainFrame.setTitle("�N���[���Q�[���A�j���[�V����");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(X, Y, WIDTH, HEIGHT);
		mainFrame.setBackground(Color.WHITE);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
	}

}
