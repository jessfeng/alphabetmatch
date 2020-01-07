import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetName extends JPanel {

	protected static JPanel q1Panel;
	private static JLabel prompt;
	static JTextField nameField;
	static String name;
	static JButton submitNameButton;
	static JLabel nameLabel;

	static JPanel build(){

			prompt = new JLabel("Enter your first name:");
			nameField = new JTextField(20);

			submitNameButton = new JButton("Begin the Game!");
			submitNameButton.addActionListener(new submitListener());

			q1Panel = new JPanel();
			q1Panel.setPreferredSize(new Dimension(600, 300));

			q1Panel.add(prompt);
			q1Panel.add(nameField);
			q1Panel.add(submitNameButton);

			return q1Panel;

		}

	static class submitListener implements ActionListener
	{
	public void actionPerformed(ActionEvent e){
			name = nameField.getText();

			EWFrame.questionPanel.remove(q1Panel);
			EWFrame.count = 1;
			EWFrame.PickQuestion();
			}
	}

}
