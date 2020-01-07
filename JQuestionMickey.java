import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JQuestionMickey {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel mickeyIcon;
	static JButton choiceT;
	static JButton choiceA;
	static JButton choiceM;
	static JButton choiceO;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this start with? Hint: Disney character");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		mickeyIcon = new JLabel(new ImageIcon("images 2/mickey.png"));
		choicesPanel = new JPanel();

		choiceT = new JButton("T");
		choiceA = new JButton("A");
		choiceM = new JButton("M");
		choiceO = new JButton("O");
		choiceT.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceA.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceM.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceT);
		choicesPanel.add(choiceA);
		choicesPanel.add(choiceM);
		choicesPanel.add(choiceO);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(mickeyIcon);
		q1Panel.add(choicesPanel);

		choiceM.addActionListener(new RightListener());
		choiceA.addActionListener(new WrongListener());
		choiceT.addActionListener(new WrongListener());
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
