package electricPotAnimation;

import java.awt.Font;

import javax.swing.JLabel;

public class FeedbackCharacter extends JLabel {

	JLabel mainSentence; 

	FeedbackCharacter() {
		mainSentence =  new JLabel();
		mainSentence.setText("aaaaaaaaaaaa");
		mainSentence.setBounds(Main.X, Main.Y, 300, 250);
		mainSentence.setFont(new Font("Meiryo UI", Font.ITALIC, 15));
	}
	
	public JLabel getFeedbackChar(){
		return this.mainSentence;
	}

}

