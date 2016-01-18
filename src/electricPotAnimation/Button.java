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
        button = new JButton(k1);
        button.setBounds(b_x, b_y, 100, 30);
        button.setHorizontalAlignment(JLabel.CENTER);
        button.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cmb)) {// コンボボックスアクション
            for (int i = 0; i <= 2; i++) {
                if (cmb.getSelectedIndex() == i) {
                    button.setText(elements[i]);
                }
            }
        }
        if (e.getSource().equals(button)) {// ボタンが押された時のアクション
            // ONが押された時のながれ
            if (cm.checkOnFlow() && button.getText().equals(k2)) {
                CheckMethodAndFieldFinder.is_on_clicked = true;
            }
            // OFFが押された時のながれ
            if (cm.checkOffFlow() && button.getText().equals(k1)) {
                CheckMethodAndFieldFinder.is_on_clicked = false;
                CheckMethodAndFieldFinder.is_boiling = false;
                CheckMethodAndFieldFinder.is_keep_warm = false;
                Steam.steam_count = 0;
            }
            // 沸騰ボタンが押された時の流れ
            if ((cm.checkKeepWarmToBoilingFlow()||cm.subCheckKeepWarmToBoilingFlow()) && button.getText().equals(k3)
                    && !CheckMethodAndFieldFinder.is_boiling) {
                CheckMethodAndFieldFinder.is_boiling = true;
                Steam.steam_count = 0;
            }

        }
    }

}
