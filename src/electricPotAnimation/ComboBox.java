package electricPotAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class ComboBox implements ActionListener {
	private JComboBox cmb;
	Button btn = new Button();

	int c_x = ElectricPot.POT_X + 150;
	int c_y = ElectricPot.POT_Y + 80;
	// 文字
	String k1 = "OFF";
	String k2 = "ON";
	String k3 = "沸騰";

	String[] elements = { k1, k2, k3 };

	public ComboBox() {
		// コンボボックスを追加
		cmb = new JComboBox(elements);
		cmb.setMaximumRowCount(3);// ここでコンボボックスのドロップダウンリストの表示項目数を設定します。
		cmb.setBounds(c_x, c_y, 100, 30);
		cmb.addActionListener(this);
	}

	public JComboBox getJComboBox() {
		return cmb;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i <= 2; i++) {
			if (cmb.getSelectedIndex() == i) {
				btn.getButton().setText(elements[i]);
			}
		}
	}

}
