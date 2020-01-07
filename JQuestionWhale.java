import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JQuestionWhale {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel whaleIcon;
	static JButton choiceW;
	static JButton choiceD;
	static JButton choiceM;
	static JButton choiceO;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this start with? Hint: it lives in the sea. ");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		whaleIcon = new JLabel(new ImageIcon("images 2/whale.png"));
		choicesPanel = new JPanel();

		choiceW = new JButton("W");
		choiceD = new JButton("D");
		choiceM = new JButton("M");
		choiceO = new JButton("O");
		choiceW.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceD.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceM.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceW);
		choicesPanel.add(choiceD);
		choicesPanel.add(choiceM);
		choicesPanel.add(choiceO);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(whaleIcon);
		q1Panel.add(choicesPanel);

		choiceW.addActionListener(new RightListener());
		choiceD.addActionListener(new WrongListener());
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
