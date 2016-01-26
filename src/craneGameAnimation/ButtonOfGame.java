package craneGameAnimation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonOfGame implements ActionListener {

	private JButton rightButton;
	private JButton upButton;
	private JButton coinButton;

	// 座標
	int b_x = FrontIllustration.FRONT_ILL_X + 400;
	int b_y = FrontIllustration.FRONT_ILL_Y + 420;

	// 文字
	String right = "→";
	String up = "↑";
	String coin = "コイン投入";

	public ButtonOfGame() {
		rightButton = new JButton(right);
		rightButton.setBounds(b_x, b_y, 60, 40);
		rightButton.setFont(new Font("Meiryo UI", Font.BOLD, 20));
		rightButton.setBackground(Color.ORANGE);
		rightButton.setHorizontalAlignment(JLabel.CENTER);
		rightButton.addActionListener(this);

		upButton = new JButton(up);
		upButton.setBounds(b_x + 90, b_y, 60, 40);
		upButton.setFont(new Font("Meiryo UI", Font.BOLD, 20));
		upButton.setBackground(Color.ORANGE);
		upButton.setHorizontalAlignment(JLabel.CENTER);
		upButton.addActionListener(this);

		coinButton = new JButton(coin);
		coinButton.setBounds(b_x -150, b_y, 120, 40);
		coinButton.setFont(new Font("Meiryo UI", Font.BOLD, 15));
		coinButton.setBackground(Color.ORANGE);
		coinButton.setHorizontalAlignment(JLabel.CENTER);
		coinButton.addActionListener(this);
	}

	public JButton getRButton() {
		return rightButton;
	}

	public JButton getUButton() {
		return upButton;
	}

	public JButton getCButton() {
		return coinButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * 右ボタンが押された時
		 */
		if (e.getSource().equals(rightButton)) {

		}

		/*
		 * 上ボタンが押された時
		 */
		if (e.getSource().equals(upButton)) {

		}
	}

}
