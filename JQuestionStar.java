import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JQuestionStar {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel starIcon;
	static JButton choiceA;
	static JButton choiceS;
	static JButton choiceP;
	static JButton choiceK;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this start with? Hint: it's in the sky");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		starIcon = new JLabel(new ImageIcon("images 2/star.png"));
		choicesPanel = new JPanel();

		choiceA = new JButton("A");
		choiceS = new JButton("S");
		choiceP = new JButton("P");
		choiceK = new JButton("K");
		choiceA.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceS.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceK.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceA);
		choicesPanel.add(choiceS);
		choicesPanel.add(choiceP);
		choicesPanel.add(choiceK);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(starIcon);
		q1Panel.add(choicesPanel);

		choiceS.addActionListener(new RightListener());
		choiceA.addActionListener(new WrongListener());
		choiceP.addActionListener(new WrongListener());
		choiceK.addActionListener(new WrongListener());

		return q1Panel;

	}

	static class RightListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "Correct!");
			EWFrame.totalScore += 1;
			EWFrame.totalScoreField.setText(Integer.toString(EWFrame.totalScore));
			EWFrame.count++;
			EWFrame.questionPanel.remove(q1Panel);
			EWFrame.PickQuestion();
			}
	}
	static class WrongListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
	JOptionPane.showMessageDialog(null, "Wrong");
	EWFrame.count++;  // count should now equal 2
	EWFrame.questionPanel.remove(q1Panel);
	EWFrame.PickQuestion();
	}
	}

}
