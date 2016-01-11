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
    String boiling = "沸かす";
    String keep_warm = "保温";
    String push_button = "沸騰ボタン";

    State() {
        /*
         * 電源状態のラベル
         */
        power_label = new JLabel(off);
        // 文字のフォントの設定
        power_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
        // ラベルの位置と大きさの設定
        power_label.setBounds(220, 240, 65, 28);
        // 背景色の設定
        power_label.setBackground(new Color(251, 236, 26, 200));
        power_label.setOpaque(true);// ラベルの背景を非透明にしている
        // 文字位置の設定
        power_label.setHorizontalAlignment(JLabel.CENTER);
        // 枠線の設定
        power_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));

        /*
         * 状態のラベル
         */
        state_label = new JLabel(keep_warm);
        // 文字のフォントの設定
        state_label.setFont(new Font("Meiryo UI", Font.BOLD, 18));
        // ラベルの位置と大きさの設定
        state_label.setBounds(310, 240, 65, 28);
        // 背景色の設定
        state_label.setBackground(new Color(255, 40, 25, 150));
        state_label.setOpaque(true);// ラベルの背景を非透明にしている
        // 文字位置の設定
        state_label.setHorizontalAlignment(JLabel.CENTER);
        // 枠線の設定
        state_label.setBorder(new EtchedBorder(EtchedBorder.RAISED));
    }

    public JLabel getPowerState() {
        return power_label;
    }

    public JLabel getState() {
        return state_label;
    }
}
