import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JQuestionOwl {
	protected static JPanel q1Panel;
	private static JLabel question;
	private static JLabel owlIcon;
	static JButton choiceT;
	static JButton choiceQ;
	static JButton choiceM;
	static JButton choiceO;
	static JPanel choicesPanel;

	static JPanel build(){
		question = new JLabel("What letter does this animal start with? Hint: it's a bird");
		question.setFont(new Font("Serif", Font.PLAIN,25));
		owlIcon = new JLabel(new ImageIcon("images 2/owl.png"));
		choicesPanel = new JPanel();

		choiceT = new JButton("T");
		choiceQ = new JButton("Q");
		choiceM = new JButton("M");
		choiceO = new JButton("O");
		choiceT.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceQ.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceM.setFont(new Font("Serif", Font.PLAIN, 50));
		choiceO.setFont(new Font("Serif", Font.PLAIN, 50));
		choicesPanel.add(choiceT);
		choicesPanel.add(choiceQ);
		choicesPanel.add(choiceM);
		choicesPanel.add(choiceO);

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 600));

		q1Panel.add(question);
		q1Panel.add(owlIcon);
		q1Panel.add(choicesPanel);

		choiceO.addActionListener(new RightListener());
		choiceT.addActionListener(new WrongListener());
		choiceM.addActionListener(new WrongListener());
		choiceQ.addActionListener(new WrongListener());

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
