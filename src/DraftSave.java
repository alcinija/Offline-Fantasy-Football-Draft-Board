import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DraftSave {
	private String players;
	private Object[] player;
	
	public DraftSave(String teamName, Object[] player) throws FileNotFoundException {
		Scanner fin = new Scanner(new File("results.csv"));
		
		this.players = "";
		
		while (fin.hasNext()) {
			this.players = this.players + fin.nextLine() + "\n";
		}
		
		this.players = teamName + "," +player[0] + "," + player[1] + "," + player[2] + "," + player[3] + "," + player[4] + "," + player[5] + "," + player[6] + "\n";
	}
}
