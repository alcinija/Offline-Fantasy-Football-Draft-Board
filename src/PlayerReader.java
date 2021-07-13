import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PlayerReader {
	PriorityQueue<Player> playerQueue;
	
	public PlayerReader(String path) throws FileNotFoundException {
		Scanner fin = new Scanner(new File(path));
		
		this.playerQueue = new PriorityQueue<Player>();
		
		while (fin.hasNextLine()) {
			String line = fin.nextLine();
			String[] info = line.split(",");
			
			int posRank = Integer.parseInt(info[0]);
			int ovlRank = Integer.parseInt(info[1]);
			String fName = info[2];
			String lName = info[3];
			String position = info[4];
			String nflTeam = info[5];
			int byeWeek = Integer.parseInt(info[6]);
			
			this.playerQueue.add(new Player(posRank, ovlRank, fName, lName, position, nflTeam, byeWeek));
		}
		
		fin.close();
	}
	
	public ArrayList<Player> toArrayList() {
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		while (!this.playerQueue.isEmpty()) {
			Player p = this.playerQueue.poll();
			
			playerList.add(p);
		}
		
		return playerList;
	}
}
