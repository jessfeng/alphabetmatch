import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class EWDriverApp {

	public static void main(String[] args) throws IOException {

		JFrame frame = new EWFrame();

		((EWFrame) frame).PickQuestion();

		frame.setVisible(true);			// sets frame to visible

	}

}
