package electricPotAnimation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class State extends JLabel {

    public JLabel power_label;
    public JLabel state_label;

    String off = "OFF";
    String on = "ON";
    String boiling = "������";
    String keep_warm = "�ۉ�";
    String push_button = "�����{�^��";

    State() {
        /*
         * �d����Ԃ̃��x��
         */
        power_label = new JLabel(off);
        // �����̃t�H���g�̐ݒ�
        power_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
        // ���x���̈ʒu�Ƒ傫���̐ݒ�
        power_label.setBounds(220, 240, 65, 28);
        // �w�i�F�̐ݒ�
        power_label.setBackground(new Color(251, 236, 26, 200));
        power_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
        // �����ʒu�̐ݒ�
        power_label.setHorizontalAlignment(JLabel.CENTER);
        // �g���̐ݒ�
        power_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        /*
         * ��Ԃ̃��x��
         */
        state_label = new JLabel(keep_warm);
        // �����̃t�H���g�̐ݒ�
        state_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
        // ���x���̈ʒu�Ƒ傫���̐ݒ�
        state_label.setBounds(310, 240, 65, 28);
        // �w�i�F�̐ݒ�
        state_label.setBackground(new Color(255, 40, 25, 150));
        state_label.setOpaque(true);// ���x���̔w�i��񓧖��ɂ��Ă���
        // �����ʒu�̐ݒ�
        state_label.setHorizontalAlignment(JLabel.CENTER);
        // �g���̐ݒ�
        state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
    }

    public JLabel getPowerState() {
        return power_label;
    }

    public JLabel getState() {
        return state_label;
    }
}
