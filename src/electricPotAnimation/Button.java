package electricPotAnimation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Button implements ActionListener {
    private JButton button;
    private JComboBox cmb;

    CheckMethodAndFieldFinder cm = new CheckMethodAndFieldFinder();

    // ���W
    int b_x = ElectricPot.POT_X + 150;
    int b_y = ElectricPot.POT_Y + 40;

    int c_x = ElectricPot.POT_X + 150;
    int c_y = ElectricPot.POT_Y + 80;

    // ����
    String k1 = "OFF";
    String k2 = "ON";
    String k3 = "�����{�^��";

    String[] elements = { k1, k2, k3 };

    Button() {
        // �{�^����ǉ�
        button = new JButton(k1);
        button.setBounds(b_x, b_y, 100, 30);
        button.setHorizontalAlignment(JLabel.CENTER);
        button.addActionListener(this);

        // �R���{�{�b�N�X��ǉ�
        cmb = new JComboBox(elements);
        cmb.setMaximumRowCount(3);// �����ŃR���{�{�b�N�X�̃h���b�v�_�E�����X�g�̕\�����ڐ���ݒ肵�܂��B
        cmb.setBounds(c_x, c_y, 100, 30);
        cmb.addActionListener(this);
    }

    public JButton getButton() {
        return button;
    }

    public JComboBox getJComboBox() {
        return cmb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cmb)) {// �R���{�{�b�N�X�A�N�V����
            for (int i = 0; i <= 2; i++) {
                if (cmb.getSelectedIndex() == i) {
                    button.setText(elements[i]);
                }
            }
        }
        if (e.getSource().equals(button)) {// �{�^���������ꂽ���̃A�N�V����
            // ON�������ꂽ���̂Ȃ���
            if (cm.checkOnFlow() && button.getText().equals(k2)) {
                CheckMethodAndFieldFinder.is_on_clicked = true;
            }
            // OFF�������ꂽ���̂Ȃ���
            if (cm.checkOffFlow() && button.getText().equals(k1)) {
                CheckMethodAndFieldFinder.is_on_clicked = false;
                CheckMethodAndFieldFinder.is_boiling = false;
                CheckMethodAndFieldFinder.is_keep_warm = false;
                Steam.steam_count = 0;
            }
            // �����{�^���������ꂽ���̗���
            if ((cm.checkKeepWarmToBoilingFlow()||cm.subCheckKeepWarmToBoilingFlow()) && button.getText().equals(k3)
                    && !CheckMethodAndFieldFinder.is_boiling) {
                CheckMethodAndFieldFinder.is_boiling = true;
                Steam.steam_count = 0;
            }

        }
    }

}
