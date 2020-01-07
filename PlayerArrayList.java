import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class PlayerArrayList {

static File scoresFile = new File("scoresfile.txt");
static Scanner scanScores;
static String fname;  // file name
static int fscore;		// file score

static ArrayList<Player> playerList = new ArrayList<Player>();


	static void scanData() throws FileNotFoundException{
	scanScores = new Scanner(scoresFile);
	playerList.clear();

	while (scanScores.hasNext()){
		fname = scanScores.next();
		fscore = scanScores.nextInt();
		playerList.add(new Player(fname, fscore));
		}

	scanScores.close();			// closes file after Scanning
	}

	// Comparator
	static class CompareScores implements Comparator<Player>{

		@Override
		public int compare(Player p1, Player p2) {
			if(p1.getTotalScore() < p2.getTotalScore())
				return 1;
			else return -1;
			}
		}

	static void sortScores(){
		Collections.sort(playerList, new CompareScores());
		//String sortedScoresStr =
	}

		public static String printArrayList(ArrayList<Player> playerList){	// method to print each object Player in the ArrayList
		String scoresStr = "\n";
		for (Object Player : playerList){		// for each Object Player in playerList
			System.out.println(Player);
			scoresStr += Player + "\n";
			}
		return scoresStr;
		}

}
