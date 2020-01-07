import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.plaf.FontUIResource;
import java.io.FileNotFoundException;
import java.io.File;
import java.applet.*;
import java.net.*;

/**
 * Creates JFrame to hold the other components of the GUI window
 * */

public class EWFrame extends JFrame {
	final int FRAME_WIDTH = 800;
	final int FRAME_HEIGHT = 800;
	AudioClip audioClip;
	URL audioUrl;
	static JPanel welcomePanel;
	JPanel menuPanel;
	JPanel bottomPanel;
	static JTextField totalScoreField;
	JLabel totalScoreLabel;
	static JPanel questionPanel;
	static int count = 0;
	static int indivScore = 0;
	static int totalScore = 0;
	static ArrayList<Player> sortedList;;

public EWFrame() {						// method to establish JFrame

	super("Alphabet Learning Game: Alphabet Match");
	setSize(FRAME_WIDTH, FRAME_HEIGHT);

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);

	WelcomePanel();			// methods to build the panels
	MenuPanel();
	BottomPanel();

	add(welcomePanel, BorderLayout.NORTH);
	add(menuPanel, BorderLayout.WEST);
	add(bottomPanel, BorderLayout.SOUTH);

	QuestionPanel();

	add(questionPanel, BorderLayout.CENTER);

	//background music
		try{
			audioUrl = new URL("file:" + new File(".").getCanonicalPath() + "//Sound//abcSong.wav");
			Clip clip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem.getAudioInputStream(audioUrl);
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			audioClip = Applet.newAudioClip(audioUrl);
			audioClip.play();
			//audioClip.loop();
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

// panel to hold the question.  Center position.
void QuestionPanel(){
	questionPanel = new JPanel();
	questionPanel.setBackground(Color.YELLOW);
	questionPanel.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
	}

// welcome message panel. North position.
private void WelcomePanel(){
	JLabel welcomeMessage = new JLabel("Welcome!");
	welcomePanel = new JPanel();
	welcomePanel.setBackground(Color.WHITE);
	welcomePanel.add(welcomeMessage);
	}

// menu panel.  West position.
private void MenuPanel(){
	JLabel menuLabel = new JLabel("MENU");
	JButton scoresButton = new JButton("High Scores");

	scoresButton.addActionListener(new highScoresListener());

	JButton learnButton = new JButton("How to Play");

	learnButton.addActionListener(new learnButtonListener());

	menuPanel = new JPanel();
	menuPanel.setBackground(Color.PINK);
	menuPanel.setPreferredSize(new Dimension(200,600));
	menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));			// make box layout vertical
	menuPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	menuPanel.add(menuLabel);
	menuPanel.add(Box.createVerticalStrut(25));
	menuPanel.add(learnButton);

	menuPanel.add(Box.createVerticalStrut(25));
	menuPanel.add(scoresButton);

	}

class highScoresListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			PlayerArrayList.scanData();	// reads the data from the file and puts it in ArrayList playerlist
			PlayerArrayList.sortScores();	// sorts playerList
			//PlayerArrayList.printArrayList(PlayerArrayList.playerList);
			System.out.println();
			sortedList = new ArrayList<Player>();
			String sortedListStr = "Top 5 Scores!\n";

			for (int i = 0; i <=4; i++){
				sortedList.add(PlayerArrayList.playerList.get(i));
			}
			sortedListStr += PlayerArrayList.printArrayList(sortedList);
			System.out.println(sortedListStr);
			JOptionPane.showMessageDialog(null, sortedListStr);
			}
		catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "File not found");
		}

		catch (IndexOutOfBoundsException e2){
			String playerListStr = "There are currently fewer than 5 scores in our records, "
					+ "so we do not have 5 scores to display.  Here are the scores currently "
					+ "in the records.\n";
			// prints the currently available scores (fewer than 5)
			playerListStr += PlayerArrayList.printArrayList(PlayerArrayList.playerList);
			JOptionPane.showMessageDialog(null, playerListStr);
			System.out.println(playerListStr);

		}

	}

}

static class learnButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e){
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
		          "Arial", Font.BOLD, 20)));
		JOptionPane.showMessageDialog(null, "Welcome to the Alphabet Match!" + " \n" + "Directions: Match the letters to the pictures.\n For example, if the picture was a jellyfish, then the answer would be \"J\"." +
		 "\n Every question you get correct earns you a point and at the end, you can see how many point you got!"+ "\n Try to beat your last score and challenge your friends! Have fun :)");
	}
}

// panel to hold other things, e.g. volume.  South position.
private void BottomPanel(){
	totalScoreLabel = new JLabel("Total Score:");
	totalScoreField = new JTextField(3);
	totalScoreField.setText("0");
	bottomPanel = new JPanel();
	bottomPanel.setBackground(Color.ORANGE);
	bottomPanel.setPreferredSize(new Dimension(800, 100));
	bottomPanel.add(totalScoreLabel);
	bottomPanel.add(totalScoreField);
}

static void PickQuestion(){
	switch(count){
	case 0:
		questionPanel.add(GetName.build());
		questionPanel.repaint();
		questionPanel.revalidate();
		totalScore = 0;
		break;
	case 1:
		questionPanel.add(JQuestionOne.build());
		questionPanel.repaint();
		questionPanel.revalidate();
		break;
	case 2:
		questionPanel.add(JQuestionTwo.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 3:
		questionPanel.add(JQuestionCat.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 4:
		questionPanel.add(JQuestionDog.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 5:
		questionPanel.add(JQuestionMickey.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 6:
		questionPanel.add(JQuestionOwl.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 7:
		questionPanel.add(JQuestionPikachu.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 8:
		questionPanel.add(JQuestionTigger.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 9:
		questionPanel.add(JQuestionStar.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 10:
		questionPanel.add(JQuestionWhale.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	case 11:
		questionPanel.add(SubmitScore.build());
		questionPanel.repaint();
		questionPanel.validate();
		break;
	}

}

}
