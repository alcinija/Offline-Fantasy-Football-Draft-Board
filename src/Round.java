import java.util.ArrayList;

public class Round {
	private int roundNum;
	private ArrayList<Player> playerList;
	
	public Round(int roundNum) {
		this.roundNum = roundNum;
		this.playerList = new ArrayList<Player>();
	}
	
	public void addPlayer(Object[] player) {
		this.playerList.add(new Player(Integer.parseInt(player[0].toString()), Integer.parseInt(player[1].toString()), player[2].toString(), player[3].toString(), player[4].toString(), player[5].toString(), Integer.parseInt(player[6].toString())));
	}
	
	public String[] getTitles() {
		String[] titles = new String[2];
		
		titles[0] = String.valueOf(this.roundNum);
		titles[1] = "Selection";
		
		return titles;
	}
}
