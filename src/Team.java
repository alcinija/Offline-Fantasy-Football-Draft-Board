import java.util.ArrayList;

/**
 * Name: Joe Alcini
 * File: Driver.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Creates a Team object for each team in the draft
 */

public class Team {
	// Declares fields
	private String name;
	private ArrayList<Player> roster;
	
	/**
	 * Creates a team object
	 * @param name String the name of the team
	 */
	public Team(String name) {
		this.name = name;
		this.roster = new ArrayList<Player>();
	}
	
	/**
	 * Returns the name of the team
	 * @return the Team name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the list of players that
	 * the team drafted
	 * @return The list of teams
	 */
	public ArrayList<Player> getRoster() {
		return this.roster;
	}
	
	/**
	 * Takes the input fields to create players to 
	 * add their roster
	 * @param posRank int The rank of the player at their position
	 * @param ovlRank int The rank related to all players
	 * @param fName String The player's first name
	 * @param lName String The player's last name
	 * @param position String the position that the player plays
	 * @param nflTeam String The NFL team that the player plays for
	 * @param byeWeek int The week number that the player does not play
	 */
	public void addPlayerToRoster(int posRank, int ovlRank, String fName, String lName, String position, String nflTeam, int byeWeek) {
		this.roster.add(new Player(posRank, ovlRank, fName, lName, position, nflTeam, byeWeek));
	}
	
	/**
	 * Removes a player from the roster
	 * @param playerFName String the player's first name
	 * @param playerLName String the player's last name
	 * @param nflTeam String the player's  NFL team
	 */
	public void removePlayerFromRoster(String playerFName, String playerLName, String nflTeam) {
		// Searches through the roster to search for the player
		for (Player p : roster) {
			if (p.getFName().equals(playerFName) && p.getLName().equals(playerLName) && p.getNFLTeam().equals(nflTeam)) {
				this.roster.remove(p);
			}
		}
	}
	
	/**
	 * Removes the last player from the roster
	 */
	public void removeLastPlayerFromRoster() {
		this.roster.remove(this.roster.size() - 1);
	}
	
	/**
	 * Returns all players on the roster in  a formatted array 
	 * @return The formatted array of the roster
	 */
	public Object[][] rosterRecap() {
		// Creates the array
		Object[][] recap = new String[this.roster.size()][2];
		
		// Takes each player from the roster and adds it to the loop
		for (int i = 0; i < this.roster.size(); i++) {
			recap[i][0] = "Rnd " + (i + 1) + ": ";
			recap[i][1] = this.roster.get(i).getOvlrank() + "  " + this.roster.get(i).getFName() + "  " + this.roster.get(i).getLName() + "  " + this.roster.get(i).getPosition() + "  " + this.roster.get(i).getNFLTeam() + "  " + this.roster.get(i).getByeWeek();
		}
		
		// Returns the array
		return recap;
	}
}