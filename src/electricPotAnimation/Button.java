package electricPotAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Button implements ActionListener {
	private JButton button;
	private JComboBox cmb;

	String[] elements = { "OFF", "ON", "�����{�^��" };

	Button() {
		//�{�^����ǉ�
		button = new JButton("");
		button.setBounds(400, 160, 100, 30);
		button.setHorizontalAlignment(JLabel.CENTER);

		//�R���{�{�b�N�X��ǉ�
		cmb = new JComboBox(elements);
		cmb.setMaximumRowCount(3);// �����ŃR���{�{�b�N�X�̃h���b�v�_�E�����X�g�̕\�����ڐ���ݒ肵�܂��B
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
