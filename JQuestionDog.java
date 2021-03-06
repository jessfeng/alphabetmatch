import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

public class JQuestionDog {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel dogIcon;
	static JButton choiceT;
	static JButton choiceD;
	static JButton choiceM;
	static JButton choiceO;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this animal start with? Hint: it's a pet.");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		dogIcon = new JLabel(new ImageIcon("images 2/dog.png"));

		choicesPanel = new JPanel();

		choiceT = new JButton("T");
		choiceD = new JButton("D");
		choiceM = new JButton("M");
		choiceO = new JButton("O");
		choiceT.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceD.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceM.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceT);
		choicesPanel.add(choiceD);
		choicesPanel.add(choiceM);
		choicesPanel.add(choiceO);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(dogIcon);
		q1Panel.add(choicesPanel);

		choiceD.addActionListener(new RightListener());
		choiceT.addActionListener(new WrongListener());
		choiceM.addActionListener(new WrongListener());
		choiceO.addActionListener(new WrongListener());

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
