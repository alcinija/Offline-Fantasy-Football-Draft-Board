import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> roster;
	
	public Team(String name) {
		this.name = name;
		this.roster = new ArrayList<Player>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Player> getRoster() {
		return this.roster;
	}
	
	public void addPlayerToRoster(int posRank, int ovlRank, String fName, String lName, String position, String nflTeam, int byeWeek) {
		this.roster.add(new Player(posRank, ovlRank, fName, lName, position, nflTeam, byeWeek));
	}
	
	public void removePlayerFromRoster(String playerFName, String playerLName, String nflTeam) {
		for (Player p : roster) {
			if (p.getFName().equals(playerFName) && p.getLName().equals(playerLName) && p.getNFLTeam().equals(nflTeam)) {
				this.roster.remove(p);
			}
		}
	}
	public String rosterRecap() {
		String recap = "";
		
		for (int i = 0; i < this.roster.size(); i++) {
			recap = recap + "Rnd " + i + ": " + this.roster.get(i).getOvlrank() + " " + this.roster.get(i).getFName().charAt(0) + ". " + this.roster.get(i).getLName() + " " + this.roster.get(i).getPosition() + " " + this.roster.get(i).getNFLTeam() + " " + this.roster.get(i).getByeWeek() + "\n";
		}
		
		return recap;
	}
}