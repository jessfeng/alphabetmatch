import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JQuestionTwo extends JPanel{

	// had to change all variables to static so this method can be referenced by EWFrame.java :(

	protected static JPanel q1Panel;
	private static JLabel question;
	static JButton choice1;
	static JButton choice2;
	static JButton choice3;
	static JButton choice4;
	static JPanel choicesPanel;

	static JPanel build(){

		question = new JLabel("Select the consonant from the choices below..");
		question.setFont(new Font("Serif", Font.PLAIN,25));

		choicesPanel = new JPanel();

		choice1 = new JButton("A");
		choice2 = new JButton("B");
		choice3 = new JButton("E");
		choice1.setFont(new Font("Serif", Font.PLAIN, 50));
		choice2.setFont(new Font("Serif", Font.PLAIN, 50));
		choice3.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choice1);
		choicesPanel.add(choice2);
		choicesPanel.add(choice3);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 500));

		q1Panel.add(question);
		q1Panel.add(choicesPanel);

		choice2.addActionListener(new RightListener());
		choice1.addActionListener(new WrongListener());
		choice3.addActionListener(new WrongListener());

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
