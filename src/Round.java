import java.util.ArrayList;

/**
 * Name: Joe Alcini
 * File: PlayerReader.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Creates a round object
 * stores the picks made by teams
 */

public class Round {
	// Declares the fields
	private int roundNum;
	private ArrayList<Selection> selectionList;
	
	/**
	 * Creates a Round object 
	 * @param roundNum int the number of the round
	 */
	public Round(int roundNum) {
		this.roundNum = roundNum;
		this.selectionList = new ArrayList<Selection>();
	}
	
	/**
	 * Adds a player to a selection that is made
	 * @param teamName String The name of the team picking
	 * @param player Object[] The player selected
	 */
	public void addPlayer(String teamName, Object[] player) {
		// Finds the team and adds a player to it
		for (int i = 0; i < this.selectionList.size(); i++) {
			if (this.selectionList.get(i).getSelection()[0].equals(teamName)) {
				this.selectionList.get(i).addPlayer(new Player(Integer.parseInt(player[0].toString()), Integer.parseInt(player[1].toString()), player[2].toString(), player[3].toString(), player[4].toString(), player[5].toString(), Integer.parseInt(player[6].toString())));	
			}
		}
	}
	
	/**
	 * Adds a new selection to the round
	 * @param selection Selection a selection object
	 */
	public void addNewSelection(Selection selection) {
		this.selectionList.add(selection);
	}
	
	/**
	 * Returns the selections in the round
	 * as a 2D object array
	 * @return Object[][] the selection from the round
	 */
	public Object[][] getData() {
		// Creates the array
		Object[][] result = new Object[this.selectionList.size()][2];
		
		// Checks if a team is on the clock
		boolean clock = false;
		
		// Adds teams and selections to the array
		for (int i = 0; i < this.selectionList.size(); i++) {
			// Adds the team name
			result[i][0] = this.selectionList.get(i).getName();
			
			// Checks if the team is currently making a pick
			if (this.selectionList.get(i).getSelection()[1].toString().equals("") && !clock) {
				result[i][1] = "On the Clock";
				clock = true;
			} else {
				result[i][1] = this.selectionList.get(i).getSelection()[1].toString();
			}
		}
		
		// Returns the 2D array
		return result;
	}
	
	/**
	 * Returns the current round and selections
	 * heading for display in a table within a GUI
	 * @return The round number and the Selections
	 */
	public String[] getTitles() {
		// Creates the array
		String[] titles = new String[2];
		
		// Sets the values
		titles[0] = String.valueOf(this.roundNum);
		titles[1] = "Selection";
		
		// Returns the array
		return titles;
	}
}
