package craneGameAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {

	//それぞれの図のインスタンス作成
	FrontIllustration fi = new FrontIllustration();
	FrontArm fa = new FrontArm();

	Timer timer;

	public Panel() {// コンストラクタ
		setBackground(Color.white);
		setLayout(null);// これで絶対レイアウトと成る。それぞれのコンポーネントは自分で座標を設定する必要あり

		timer = new Timer(1000, this);// 1秒毎にタイマーイベント発生
		timer.setCoalesce(true);
		timer.setRepeats(true); // 繰り返しイベント発生
		timer.start(); // タイマー起動
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		fa.drawFrontArm(g2);//アームを表示
		fi.drawFrontIll(g2);

	}
}
