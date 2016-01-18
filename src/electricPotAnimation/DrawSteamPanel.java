package electricPotAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawSteamPanel extends JPanel implements ActionListener {

    Timer timer;
    static int counter = 0;
    Steam steam = new Steam();
    ElectricPot pot = new ElectricPot();
    State state = new State();
    Button button = new Button();

    public DrawSteamPanel() {

        setBackground(Color.white);
        setLayout(null);// これで絶対レイアウトと成る。それぞれのコンポーネントは自分で座標を設定する必要あり

        // 電源状態ラベルを追加
        add(state.getPowerState());// stateクラスから、Jラベルをゲットし、パネルに追加
        // 状態ラベルを追加
        add(state.getState());
        // ボタンを追加
        add(button.getButton());
        // コンボボックス追加
        add(button.getJComboBox());

        timer = new Timer(1000, this);// 1秒毎にタイマーイベント発生
        timer.setCoalesce(true);
        timer.setRepeats(true); // 繰り返しイベント発生
        timer.start(); // タイマー起動
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        steam.drawSteam(g2);
        pot.drawPot(g2);

        counter++;
        if (counter > 30)
            counter = 0;
        // System.out.println(counter);
    }

}
