/**
 * Name: Joe Alcini
 * File: Selection.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Holds the team and selection for the round
 */
public class Selection {
	// Declare fields
	private String teamName;
	private Player player;
	
	/**
	 * Create a Selection object
	 * @param teamName String the team name that made
	 * the selection
	 */
	public Selection(String teamName) {
		this.teamName = teamName;
		this.player = null;
	}
	
	/**
	 * Adds a player to the selection
	 * @param newPlayer Player the player that was selected
	 */
	public void addPlayer(Player newPlayer) {
		this.player = newPlayer;
	}
	
	/**
	 * Removes the selection if a mistake was made
	 */
	public void removePlayer() {
		this.player = null;
	}
	
	/**
	 * Returns the name of a team making a selection
	 * @return String the Team name
	 */
	public String getName() {
		return this.teamName;
	}
	
	/**
	 * Returns the team name and player name in an array
	 * @return Object[] the name and the player name
	 */
	public Object[] getSelection() {
		// Declare the return array
		Object[] selection = new Object[2];
		
		// Sets the name
		selection[0] = this.teamName;
		
		// Determines if a selection has been made
		if (this.player != null) {
			selection[1] = this.player.toString();
		} else {
			selection[1] = "";
		}
		
		// Returns the selection
		return selection;
	}
}
