package electricPotAnimation;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class FeedbackCharacter extends JLabel {

	FeedBackDiscrimination fdb = new FeedBackDiscrimination();

	JLabel mainSentence;
	JLabel answerSentence;
	JLabel stateSentence;
	JLabel triggerSentence;
	JLabel subStateSentence;

	JLabel sentence1;
	JLabel sentence2;
	JLabel sentence3;
	List<JLabel> label = new ArrayList<JLabel>();

	// 文字
	String correct = "正解";
	String mistake = "不正解";
	String disappoint = "惜しい";

	String incorrect_State = "状態の数が，間違っています.適切な状態名かどうかも確認してください";
	String correct_state = "状態の数は，合っています!";

	String incorrect_trigger = "どこかのトリガーが，間違っています．適切なトリガー名かどうかも確認してください";
	String correct_trigger = "全てのトリガーは，合っています！";

	String is_sub_state = "状態の入れ子を利用してみよう！";

	FeedbackCharacter() {

		makeAnswerSentence();
		makeStateSentence();
		makeTriggerSentence();
		makeSubStateSentence();

		makeSentence1();
		makeSentence2();
		makeSentence3();
		makeSentence4();

	}

	private void makeSentence1() {
		mainSentence = new JLabel();
		mainSentence.setText("です");
		mainSentence.setBounds(Main.X - 150, Main.Y - 250, 300, 250);
		mainSentence.setFont(new Font("Meiryo UI", Font.PLAIN | Font.BOLD, 19));
		label.add(mainSentence);
	}

	private void makeSentence2() {
		sentence1 = new JLabel();
		sentence1.setText("－");
		sentence1.setBounds(Main.X - 220, Main.Y - 200, 300, 250);
		sentence1.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence1);
	}

	private void makeSentence3() {
		sentence2 = new JLabel();
		sentence2.setText("－");
		sentence2.setBounds(Main.X - 220, Main.Y - 160, 300, 250);
		sentence2.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence2);
	}

	private void makeSentence4() {
		sentence3 = new JLabel();
		sentence3.setText("－");
		sentence3.setBounds(Main.X - 220, Main.Y - 120, 300, 250);
		sentence3.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence3);
	}

	private void makeAnswerSentence() {
		answerSentence = new JLabel();

		if (fdb.isAllState() && fdb.isAllTrigger()) {// もし状態とトリガーがあっていたら
			answerSentence.setText(correct);// 正解を表示
		} else if (fdb.isAnotherState() && fdb.isAnotherTrigger()) {// もし、違うバージョンの解答をしたら
			answerSentence.setText(disappoint);// 惜しいを表示
		} else {
			answerSentence.setText(mistake);// 不正解を表示
		}

		answerSentence.setBounds(Main.X - 220, Main.Y - 250, 300, 250);
		answerSentence.setFont(new Font("Meiryo UI", Font.PLAIN | Font.BOLD, 19));
		answerSentence.setForeground(Color.RED);
		label.add(answerSentence);
	}

	private void makeStateSentence() {
		stateSentence = new JLabel();
		if (fdb.isAllState()) {
			stateSentence.setText(correct_state);
		} else {
			stateSentence.setText(incorrect_State);
		}

		stateSentence.setBounds(Main.X - 200, Main.Y - 200, 600, 250);
		stateSentence.setFont(new Font("Meiryo UI", Font.PLAIN, 17));
		label.add(stateSentence);
	}

	private void makeTriggerSentence() {
		triggerSentence = new JLabel();
		if (fdb.isAllTrigger()) {
			triggerSentence.setText(correct_trigger);
		} else {
			triggerSentence.setText(incorrect_trigger);
		}
		triggerSentence.setBounds(Main.X - 200, Main.Y - 160, 700, 250);
		triggerSentence.setFont(new Font("Meiryo UI", Font.PLAIN, 17));
		label.add(triggerSentence);
	}

	private void makeSubStateSentence() {
		subStateSentence = new JLabel();
		if (fdb.isAnotherState()) {// もし違うバージョンで状態を作っていたら
			subStateSentence.setText(is_sub_state);
		}
		subStateSentence.setBounds(Main.X - 200, Main.Y - 120, 700, 250);
		subStateSentence.setFont(new Font("Meiryo UI", Font.PLAIN, 17));
		label.add(subStateSentence);
	}

	public List<JLabel> getFeedbackChar1() {
		return this.label;
	}

}
