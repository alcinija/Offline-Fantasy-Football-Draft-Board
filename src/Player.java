/**
 * Name: Joe Alcini
 * File: Driver.java
 * Date: 8/05/2021
 * Current Version: 1.0.0 Original Release
 * Description: Creates a player object with data
 * that can accessed
 */
public class Player implements Comparable<Player> {
	// Declare fields
	private int posRank;
	private int ovlRank;
	private String fName;
	private String lName;
	private String position;
	private String nflTeam;
	private int byeWeek;
	private boolean drafted;
	
	/**
	 * Creates a player object
	 * @param posRank int The rank for the player at their position
	 * @param ovlRank int The rank for the player overall
	 * @param fName String The first name of the player
	 * @param lName String The last name of the player
	 * @param position String The position that the player plays
	 * @param nflTeam String The NFL team that the player is on
	 * @param byeWeek int The week that the player does not play
	 */
	public Player(int posRank, int ovlRank, String fName, String lName, String position, String nflTeam, int byeWeek) {
		this.posRank = posRank;
		this.ovlRank = ovlRank;
		this.fName = fName;
		this.lName = lName;
		this.position = position;
		this.nflTeam = nflTeam;
		this.byeWeek = byeWeek;
		this.drafted = false;
	}
	
	/**
	 * Gets the Position rank of the player
	 * @return The position rank of the player
	 */
	public int getPosrank() {
		return this.posRank;
	}
	
	/**
	 * Gets the overall rank of the player
	 * @return The overall rank
	 */
	public int getOvlrank() {
		return this.ovlRank;
	}
	
	/**
	 * Gets the player's first name
	 * @return The first name
	 */
	public String getFName() {
		return this.fName;
	}
	
	/**
	 * Gets the player's last name
	 * @return The player's last name
	 */
	public String getLName() {
		return this.lName;
	}
	
	/**
	 * Returns a formated full name of the player
	 * @return The full name
	 */
	public String getFullName() {
		return this.fName + " " + this.lName;
	}
	
	/**
	 * Returns the position that the player plays
	 * @return The position name
	 */
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * Returns the NFL team that the player plays for
	 * @return The NFL team name
	 */
	public String getNFLTeam() {
		return this.nflTeam;
	}
	
	/**
	 * Returns the week number the player does not play
	 * @return The bye week number
	 */
	public int getByeWeek() {
		return this.byeWeek;
	}
	
	/**
	 * Returns weather or not the player was drafted in the draft
	 * @return The draft status
	 */
	public boolean getDrafted() {
		return this.drafted;
	}
	
	/**
	 * Returns a formatted String with information
	 * about the player
	 * @return The formatted String
	 */
	@Override
	public String toString() {
		return this.fName + "  " + this.lName + "  " + this.position + "  " + this.nflTeam + "  " + this.byeWeek;
	}
	
	/**
	 * Changes the draft status of a player
	 */
	public void changeDrafted() {
		if (this.drafted) {
			this.drafted = false;
		} else {
			this.drafted = true;
		}
	}

	/**
	 * Compares two player objects based on their ranks
	 * @param otherPlayer Player the other player bing compared
	 * @return The result of comparing two players
	 */
	@Override
	public int compareTo(Player otherPlayer) {
		if (this.getOvlrank() < otherPlayer.getOvlrank()) {
			return -1;
		} else {
			return 1;
		}
	}
}
