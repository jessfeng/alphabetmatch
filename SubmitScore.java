import javax.swing.*;
import java.io.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;

public class SubmitScore {
	protected static JPanel q1Panel;
	private static JLabel endingLabel;
	static JButton submitScoreButton;
	static JButton playAgainButton;
	static FileWriter filewriter;
	static PrintWriter writeToFile;

	static JPanel build(){
		endingLabel = new JLabel("You are done!  Click the button to submit your score.");

		submitScoreButton = new JButton("Submit Score");
		playAgainButton = new JButton("Play Again");

		q1Panel = new JPanel();
		q1Panel.setPreferredSize(new Dimension(600, 300));

		q1Panel.add(endingLabel);
		q1Panel.add(submitScoreButton);
		q1Panel.add(playAgainButton);

		submitScoreButton.addActionListener(new submitScoreListener());

		playAgainButton.addActionListener(new playAgainListener());

		return q1Panel;

	}

	static void WriteScore() throws IOException  {
		filewriter = new FileWriter("scoresfile.txt", true);
		writeToFile = new PrintWriter(filewriter);
	}

	static class submitScoreListener implements ActionListener  // nested class
	{
	public void actionPerformed(ActionEvent e){
			try {
				WriteScore();
				writeToFile.print(GetName.name + " ");
				writeToFile.println(EWFrame.totalScore);
				writeToFile.close();
				JOptionPane.showMessageDialog(null, "You have submitted your score.");
				}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "An error occured when submitting your score.");
			}

		}
	}

	static class playAgainListener implements ActionListener
		{
		public void actionPerformed(ActionEvent e){
				GetName.name = null;
				EWFrame.totalScore = 0;
				EWFrame.count = 0;
				EWFrame.questionPanel.remove(q1Panel);
				EWFrame.PickQuestion();
			}

		}
	}
