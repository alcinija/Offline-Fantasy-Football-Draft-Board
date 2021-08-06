import java.util.ArrayList;

public class Draft {
	private ArrayList<Team> teams;
	private ArrayList<Round> roundlist;
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
		
		createRoundList();
	}
	
	private void createRoundList() {
		this.roundlist = new ArrayList<Round>();
		
		for (int i = 0; i < this.rounds; i++) {
			this.roundlist.add(new Round(i));
			if (this.snake && i % 2 != 0) {
				for (int j = this.teams.size() - 1; j >= 0; j--) {
					this.roundlist.get(i).addNewSelection(new Selection(this.teams.get(j).getName()));
				}
			} else {
				for (int j = 0; j < this.teams.size(); j++) {
					this.roundlist.get(i).addNewSelection(new Selection(this.teams.get(j).getName()));
				}
			}
		}
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
	
	public Object[][] getRoundData(int roundNum) {
		return this.roundlist.get(roundNum - 1).getData();
	}
	
	public void draftPlayer(Object[] newPlayer) {
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			this.roundlist.get(this.currentRound - 1).addPlayer(this.currentTeam.getName(), newPlayer);
		} else {
			this.currentTeam.addPlayerToRoster(Integer.parseInt(newPlayer[0].toString()), Integer.parseInt(newPlayer[1].toString()), newPlayer[2].toString(), newPlayer[3].toString(), newPlayer[4].toString(), newPlayer[5].toString(), Integer.parseInt(newPlayer[6].toString()));
			this.roundlist.get(this.currentRound - 1).addPlayer(this.currentTeam.getName(), newPlayer);
		}
		
		this.nextPick();
	}
	
	private void nextPick() {
		if (this.pickNo > this.lastPickNo) {
			this.pickNo = -1;
		}
		
		if ((this.pickNo % this.teams.size())== 0) {
			this.currentRound = this.currentRound + 1;
		}
		
		this.pickNo =  this.pickNo + 1;
		
		System.out.println(this.getPickNo());
		
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get((this.teams.size() - 1) - ((this.pickNo - 1) % this.teams.size()));
		} else {
			this.currentTeam =  this.teams.get(((this.pickNo - 1) % this.teams.size()));
		}
	}
	
	private void previousPick() {
		if (this.pickNo < 1) {
			this.pickNo = -1;
		}
		
		this.currentTeam.removeLastPlayerFromRoster();
		
		this.pickNo--;
		
		if (this.snake && this.currentRound % 2 == 0) {
			this.currentTeam = this.teams.get(this.teams.size() - (this.pickNo % this.teams.size()) - 1);
		} else {
			this.currentTeam =  this.teams.get(this.pickNo % this.teams.size() - 1);
		}
		
		if (this.pickNo % this.teams.size() == 0) {
			this.currentRound--;
		}
	}
}
