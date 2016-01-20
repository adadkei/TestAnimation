package electricPotAnimation;

import java.awt.Color;

import javax.swing.JPanel;

public class FeedbakckPanel extends JPanel {

	FeedbackCharacter fc = new FeedbackCharacter();

	public FeedbakckPanel() {
		setBackground(Color.white);
		setLayout(null);// これで絶対レイアウトと成る。それぞれのコンポーネントは自分で座標を設定する必要あり
		add(fc.getFeedbackChar());
	}
}
