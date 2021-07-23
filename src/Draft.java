import java.util.ArrayList;

public class Draft {
	private ArrayList<Team> teams;
	private int rounds;
	private boolean snake;
	private int pickNo;
	private int lastPickNo;
	private int currentRound;
	private Team currentTeam;
	
	public Draft(ArrayList<Team> teams, int rounds, boolean snake) {
		this.teams = teams;
		this.rounds = rounds;
		this.snake = snake;
		this.pickNo = 1;
		this.currentRound = 1;
		this.lastPickNo = this.rounds * this.teams.size();
		this.currentTeam = this.teams.get(0);
	}
	
	public ArrayList<Team> getTeams() {
		return this.teams;
	}
	
	public int getRounds() {
		return this.rounds;
	}
	
	public boolean getSnake() {
		return this.snake;
	}
	
	public int getPickNo() {
		return this.pickNo;
	}
	
	public int getCurrentRound() {
		return this.currentRound;
	}
	
	public int getLastPickNo() {
		return this.lastPickNo;
	}
	
	public Team getCurrentTeam() {
		return this.currentTeam;
	}
	
	public boolean draftPlayer(Object[] newPlayer) {
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			return true;
		} else {
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			return true;
		}
	}
	
	public int nextPick() {
		if (this.pickNo > this.lastPickNo) {
			return -1;
		}
		
		this.pickNo++;
		
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get(this.teams.size() - (this.pickNo % this.teams.size()) - 1);
		} else {
			this.currentTeam =  this.teams.get(this.pickNo % this.teams.size() - 1);
		}
		
		if (this.pickNo % 10 == 0) {
			this.currentRound++;
		}
		
		return this.pickNo;
	}
	
	public int previousPick() {
		if (this.pickNo < 1) {
			return -1;
		}
		
		this.currentTeam.removeLastPlayerFromRoster();
		
		this.pickNo--;
		
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get(this.teams.size() - (this.pickNo % this.teams.size()) - 1);
		} else {
			this.currentTeam =  this.teams.get(this.pickNo % this.teams.size() - 1);
		}
		
		if (this.pickNo % 10 == 0) {
			this.currentRound--;
		}
		
		return this.pickNo;
	}
}
