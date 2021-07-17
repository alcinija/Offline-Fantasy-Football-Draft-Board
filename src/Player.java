public class Player implements Comparable<Player> {
	private int posRank;
	private int ovlRank;
	private String fName;
	private String lName;
	private String position;
	private String nflTeam;
	private int byeWeek;
	private boolean drafted;
	
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
	
	public int getPosrank() {
		return this.posRank;
	}
	
	public int getOvlrank() {
		return this.ovlRank;
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
	
	public boolean getDrafted() {
		return this.drafted;
	}
	
	public String toString() {
		return this.ovlRank + "\t" + this.posRank + "\t" + this.fName + " " + this.lName + "\t" + this.position + "\t" + this.nflTeam + "\t" + this.byeWeek;
	}
	
	public void changeDrafted() {
		if (this.drafted) {
			this.drafted = false;
		} else {
			this.drafted = true;
		}
	}

	@Override
	public int compareTo(Player otherPlayer) {
		
		return 0;
	}
}
