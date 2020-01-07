import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JQuestionPikachu {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel pikaIcon;
	static JButton choiceA;
	static JButton choiceQ;
	static JButton choiceP;
	static JButton choiceK;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this start with? Hint: it's a Pokemon!");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		pikaIcon = new JLabel(new ImageIcon("images 2/pika.png"));
		choicesPanel = new JPanel();

		choiceA = new JButton("A");
		choiceQ = new JButton("Q");
		choiceP = new JButton("P");
		choiceK = new JButton("K");
		choiceQ.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceA.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceP.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceK.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceA);
		choicesPanel.add(choiceQ);
		choicesPanel.add(choiceP);
		choicesPanel.add(choiceK);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(pikaIcon);
		q1Panel.add(choicesPanel);

		choiceP.addActionListener(new RightListener());
		choiceA.addActionListener(new WrongListener());
		choiceQ.addActionListener(new WrongListener());
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
