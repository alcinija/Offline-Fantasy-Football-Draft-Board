
public class Player {
	private String fName;
	private String lName;
	private String position;
	private String nflTeam;
	private int byeWeek;
	
	public Player(String fName, String lName, String position, String nflTeam, int byeWeek) {
		this.fName = fName;
		this.lName = lName;
		this.position = position;
		this.nflTeam = nflTeam;
		this.byeWeek = byeWeek;
	}
	
	public String getFName() {
		return this.fName;
	}
	
	public String getLName() {
		return this.lName;
	}
	
	public String getFullName() {
		return this.fName + " " + this.lName;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String getNFLTeam() {
		return this.nflTeam;
	}
	
	public int getByeWeek() {
		return this.byeWeek;
	}
	
	public String toString() {
		return this.fName + "\t" + this.lName + "\t" + this.position + "\t" + this.nflTeam + "\t" + this.byeWeek;
	}
}
