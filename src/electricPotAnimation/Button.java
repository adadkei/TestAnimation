package electricPotAnimation;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Button implements ActionListener {
	private JButton button;
	private JComboBox cmb;

	CheckMethodFinder cm = new CheckMethodFinder();

	// 座標
	int b_x = ElectricPot.POT_X + 150;
	int b_y = ElectricPot.POT_Y + 40;

	int c_x = ElectricPot.POT_X + 150;
	int c_y = ElectricPot.POT_Y + 80;

	// 文字
	String k1 = "OFF";
	String k2 = "ON";
	String k3 = "沸騰ボタン";

	String[] elements = { k1, k2, k3 };

	Button() {
		// ボタンを追加
		button = new JButton("");
		button.setBounds(b_x, b_y, 100, 30);
		button.setHorizontalAlignment(JLabel.CENTER);

		// コンボボックスを追加
		cmb = new JComboBox(elements);
		cmb.setMaximumRowCount(3);// ここでコンボボックスのドロップダウンリストの表示項目数を設定します。
		cmb.setBounds(c_x, c_y, 100, 30);
		cmb.addActionListener(this);
	}

	public JButton getButton() {
		return button;
	}

	public JComboBox getJComboBox() {
		return cmb;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i <= 2; i++) {
			if (cmb.getSelectedIndex() == i) {
				button.setText(elements[i]);
			}
		}
	}
	
		
}
