package electricPotAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Button implements ActionListener {
	private JButton button;
	private JComboBox cmb;

	String[] elements = { "OFF", "ON", "沸騰ボタン" };

	Button() {
		//ボタンを追加
		button = new JButton("");
		button.setBounds(400, 160, 100, 30);
		button.setHorizontalAlignment(JLabel.CENTER);

		//コンボボックスを追加
		cmb = new JComboBox(elements);
		cmb.setMaximumRowCount(3);// ここでコンボボックスのドロップダウンリストの表示項目数を設定します。
		cmb.setBounds(400, 200, 100, 30);

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
