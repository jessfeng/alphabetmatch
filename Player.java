
public class Player {

		protected String name;
		protected int score;

		Player (String name, int score){   // Constructor
			this.name = name;
			this.score = score;
		}

		public String getName(){						// getters
			return name;
		}

		public int getTotalScore(){
			return score;
		}

		public String toString(){                      // override toString()
			String message = name + "     \tHigh Score: " + score;
			return message;
		}

}
