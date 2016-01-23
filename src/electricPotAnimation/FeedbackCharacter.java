package electricPotAnimation;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class FeedbackCharacter extends JLabel {

	JLabel mainSentence;
	JLabel answerSentence;
	JLabel sentence1;
	JLabel sentence2;
	JLabel sentence3;
	List<JLabel> label = new ArrayList<JLabel>();

	// ����
	String correct = "����";
	String mistake = "�s����";
	String disappoint = "�ɂ���";

	String incorrect_State = "��Ԃ̐����C�Ԉ���Ă��܂�.�K�؂ȏ�Ԗ����ǂ������m�F���Ă�������";
	String correct_state = "��Ԃ̐����C�����Ă��܂�!";

	String incorrect_trigger = "�ǂ����̃g���K�[���C�Ԉ���Ă��܂��D�K�؂ȃg���K�[�����ǂ������m�F���Ă�������";
	String correcr_trigger = "�S�Ẵg���K�[�́C�����Ă��܂��I";

	String is_sub_state = "��Ԃ̓���q�𗘗p���Ă݂悤�I";

	FeedbackCharacter() {

		makeAnswerSentence();
		makeSentence1();
		makeSentence2();
		makeSentence3();
		makeSentence4();

	}

	private void makeSentence1() {
		mainSentence = new JLabel();
		mainSentence.setText("�ł�");
		mainSentence.setBounds(Main.X - 150, Main.Y - 250, 300, 250);
		mainSentence.setFont(new Font("Meiryo UI", Font.PLAIN | Font.BOLD, 19));
		label.add(mainSentence);
	}

	private void makeSentence2() {
		sentence1 = new JLabel();
		sentence1.setText("�|");
		sentence1.setBounds(Main.X - 220, Main.Y - 200, 300, 250);
		sentence1.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence1);
	}

	private void makeSentence3() {
		sentence2 = new JLabel();
		sentence2.setText("�|");
		sentence2.setBounds(Main.X - 220, Main.Y - 160, 300, 250);
		sentence2.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence2);
	}

	private void makeSentence4() {
		sentence3 = new JLabel();
		sentence3.setText("�|");
		sentence3.setBounds(Main.X - 220, Main.Y - 120, 300, 250);
		sentence3.setFont(new Font("Meiryo UI", Font.PLAIN, 19));
		label.add(sentence3);
	}

	private void makeAnswerSentence() {
		answerSentence = new JLabel();
		answerSentence.setText(mistake);
		answerSentence.setBounds(Main.X - 220, Main.Y - 250, 300, 250);
		answerSentence.setFont(new Font("Meiryo UI", Font.PLAIN | Font.BOLD, 19));
		answerSentence.setForeground(Color.RED);
		label.add(answerSentence);
	}

	public List<JLabel> getFeedbackChar1() {
		return this.label;
	}

}
