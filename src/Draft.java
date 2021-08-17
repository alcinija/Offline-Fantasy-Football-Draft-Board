import java.util.ArrayList;

/**
 * Name: Joe Alcini
 * File: Draft.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Creates a Draft object
 * that performs most of the calculations for
 * the draft.
 */

public class Draft {
	// Declares the fields
	private ArrayList<Team> teams;
	private ArrayList<Round> roundlist;
	private int rounds;
	private boolean snake;
	private int pickNo;
	private int lastPickNo;
	private int currentRound;
	private Team currentTeam;
	
	/**
	 * Creates a draft object
	 * @param teams ArrayList<Team> the list of teams
	 * @param rounds int The number of rounds
	 * @param snake boolean The format of the rounds
	 */
	public Draft(ArrayList<Team> teams, int rounds, boolean snake) {
		this.teams = teams;
		this.rounds = rounds;
		this.snake = snake;
		this.pickNo = 1;
		this.currentRound = 1;
		this.lastPickNo = this.rounds * this.teams.size();
		this.currentTeam = this.teams.get(0);
		
		createRoundList();
	}
	
	/**
	 * Creates the list of round objects in the Draft
	 */
	private void createRoundList() {
		// Creates the list
		this.roundlist = new ArrayList<Round>();
		
		// Fills the list with empty rounds
		for (int i = 0; i < this.rounds; i++) {
			// Creates a new round
			this.roundlist.add(new Round(i));
			
			// Determines the order of the teams based on snaking
			if (this.snake && i % 2 != 0) {
				// Fills each round with ordered teams
				for (int j = this.teams.size() - 1; j >= 0; j--) {
					this.roundlist.get(i).addNewSelection(new Selection(this.teams.get(j).getName()));
				}
			} else {
				// Fills each round with ordered teams
				for (int j = 0; j < this.teams.size(); j++) {
					this.roundlist.get(i).addNewSelection(new Selection(this.teams.get(j).getName()));
				}
			}
		}
	}
	
	/**
	 * Returns the list of Teams
	 * @return The list of Teams
	 */
	public ArrayList<Team> getTeams() {
		return this.teams;
	}
	
	/**
	 * Returns the number of Rounds
	 * @return The number of Rounds
	 */
	public int getRounds() {
		return this.rounds;
	}
	
	/**
	 * Returns if the draft has snake format
	 * @return True if the draft snakes false otherwise
	 */
	public boolean getSnake() {
		return this.snake;
	}
	
	/**
	 * Returns the current pick number
	 * @return The current pick number
	 */
	public int getPickNo() {
		return this.pickNo;
	}
	
	/**
	 * Returns the current round number
	 * @return The current round number
	 */
	public int getCurrentRound() {
		return this.currentRound;
	}
	
	/**
	 * Returns the number of the last pick
	 * @return The number of the last pick
	 */
	public int getLastPickNo() {
		return this.lastPickNo;
	}
	
	/**
	 * Returns the current team object
	 * @return The current team object
	 */
	public Team getCurrentTeam() {
		return this.currentTeam;
	}
	
	/**
	 * Returns the picks made in a selected round
	 * @param roundNum int The selected round number
	 * @return The picks made in a selected round
	 */
	public Object[][] getRoundData(int roundNum) {
		return this.roundlist.get(roundNum - 1).getData();
	}
	
	/**
	 * Ads a selected player to a team
	 * @param newPlayer Object] The selected player
	 */
	public void draftPlayer(Object[] newPlayer) {
		// Checks draft format
		if (this.snake && this.currentRound % 2 == 0) {
			// Adds player to team
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			this.roundlist.get(this.currentRound - 1).addPlayer(this.currentTeam.getName(), newPlayer);
		} else {
			// Adds player to the team
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			this.roundlist.get(this.currentRound - 1).addPlayer(this.currentTeam.getName(), newPlayer);
		}
		
		// Iterates to the next pick
		this.nextPick();
	}
	
	/**
	 * Iterates the draft pointers to the next team
	 */
	private void nextPick() {
		// Checks if the final pick has been made
		if (this.pickNo > this.lastPickNo) {
			this.pickNo = -1;
		}
		
		// Iterates the round if necessary
		if ((this.pickNo % this.teams.size())== 0) {
			this.currentRound = this.currentRound + 1;
		}
		
		// Iterates the pick
		this.pickNo =  this.pickNo + 1;
		
		// Assigns the next team to pick
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get((this.teams.size() - 1) - ((this.pickNo - 1) % this.teams.size()));
		} else {
			this.currentTeam =  this.teams.get(((this.pickNo - 1) % this.teams.size()));
		}
	}
	
	/**
	 * Iterates the draft pointers to the next team
	 */
	private void previousPick() {
		// Checks if the pick is non negative
		if (this.pickNo < 1) {
			this.pickNo = -1;
		}
		
		// Removes the last player picked
		this.currentTeam.removeLastPlayerFromRoster();
		
		// Decrements the pick number
		this.pickNo--;
		
		// Assigns the previous team
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get(this.teams.size() - (this.pickNo % this.teams.size()) - 1);
		} else {
			this.currentTeam =  this.teams.get(this.pickNo % this.teams.size() - 1);
		}
		
		// Changes the round number if nessisary
		if (this.pickNo % this.teams.size() == 0) {
			this.currentRound--;
		}
	}
}
