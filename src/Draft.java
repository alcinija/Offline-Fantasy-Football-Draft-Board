import java.util.ArrayList;

public class Draft {
	private ArrayList<Team> teams;
	private int rounds;
	private boolean snake;
	private int pickNo;
	private int lastPickNo;
	private int round;
	
	public Draft(ArrayList<Team> teams, int rounds, boolean snake) {
		this.teams = teams;
		this.rounds = rounds;
		this.snake = snake;
		this.pickNo = 1;
		this.round = 1;
		this.lastPickNo = this.rounds * this.teams.size();
	}
	
	public int nextPick() {
		if (this.pickNo > this.lastPickNo) {
			return -1;
		}
		
		this.pickNo++;
		
		return this.pickNo;
	}
	
	public Team nextTeam() {
		if (this.snake && this.round % 2 == 0) {
			return this.teams.get(this.teams.size() - (this.pickNo % this.teams.size()));
		} else {
			return this.teams.get(this.pickNo % this.teams.size());
		}
	}
	
	public int nextPickRound() {
		if (this.pickNo % 10 == 0) {
			this.round++;
		}
		
		return this.round;
	}
}
