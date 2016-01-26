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
	// ����
	String k1 = "OFF";
	String k2 = "ON";
	String k3 = "����";

	String[] elements = { k1, k2, k3 };

	public ComboBox() {
		// �R���{�{�b�N�X��ǉ�
		cmb = new JComboBox(elements);
		cmb.setMaximumRowCount(3);// �����ŃR���{�{�b�N�X�̃h���b�v�_�E�����X�g�̕\�����ڐ���ݒ肵�܂��B
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
