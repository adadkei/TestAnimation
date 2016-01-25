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

	FromAboveIllustration fai = new FromAboveIllustration();//上からみたイラスト
	FromAboveStrut fas = new FromAboveStrut();//上から見た支柱
	FromAboveArm faa = new FromAboveArm();//上から見たアーム
	
	ButtonOfGame bg = new ButtonOfGame();
	
	Timer timer;

	public Panel() {// コンストラクタ
		setBackground(Color.white);
		setLayout(null);// これで絶対レイアウトと成る。それぞれのコンポーネントは自分で座標を設定する必要あり

		//ゲームボタンを追加
		add(bg.getRButton());
		add(bg.getUButton());
		add(bg.getCButton());
		
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
		fi.drawFrontIll(g2);//前から見たイラストを表示
		fai.drawAboveIll(g2);//上からみたイラストを表示
		fas.drawAboveStrut(g2);//上から見た支柱を表示
		faa.drawAboveArm(g2);//上から見たアームを表示

	}
}
