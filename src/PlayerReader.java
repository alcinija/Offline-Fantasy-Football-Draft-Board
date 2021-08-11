import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Name: Joe Alcini
 * File: PlayerReader.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Takes in a csv file to create a list
 * of players to be put in the main list.
 */

public class PlayerReader {
	// Declare fields
	PriorityQueue<Player> playerQueue;
	
	/**
	 * Creates a PlayerReader object
	 * @param path String the file path of the object
	 * @throws FileNotFoundException Throws if the file path does not exist
	 */
	public PlayerReader(String path) throws FileNotFoundException {
		// Creates file scanner
		Scanner fin = new Scanner(new File(path));
		
		// Creates the Queue to order the players bvy overall rank
		this.playerQueue = new PriorityQueue<Player>();
		
		// Reads the file line by line
		while (fin.hasNextLine()) {
			// Creates the array fields
			String line = fin.nextLine();
			String[] info = line.split(",");
			
			// Initialize player attributes
			int posRank = Integer.parseInt(info[0]);
			int ovlRank = Integer.parseInt(info[1]);
			String fName = info[2];
			String lName = info[3];
			String position = info[4];
			String nflTeam = info[5];
			int byeWeek = Integer.parseInt(info[6]);
			
			// Add the new player to the queue
			this.playerQueue.add(new Player(posRank, ovlRank, fName, lName, position, nflTeam, byeWeek));
		}
		
		// Close the file
		fin.close();
	}
	
	/**
	 * Exports the new players as an ArrayList
	 * @return ArrayList<Player> the sorted list of players
	 */
	public ArrayList<Player> toArrayList() {
		// Creates the ArrayList
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		// Adds the players to the list from the queue
		while (!this.playerQueue.isEmpty()) {
			// Removed player from the list
			Player p = this.playerQueue.poll();
			
			// Adds the player to the list
			playerList.add(p);
		}
		
		// Return the list of players
		return playerList;
	}
	
	/**
	 * Exports the list of players as a 2D array
	 * @return Object[][] the 2D array of the player list
	 */
	public Object[][] toObjArray() {
		// Creates the array
		Object[][] playerArray = new Object[this.playerQueue.size()][8];
		
		// Creates the starting row
		int row = 0;
		
		while (!this.playerQueue.isEmpty()) {
			// Removes the player from the queue
			Player p = this.playerQueue.poll();
			
			// Fills the row in the array
			playerArray[row][0] = p.getPosrank();
			playerArray[row][1] = p.getOvlrank();
			playerArray[row][2] = p.getFName();
			playerArray[row][3] = p.getLName();
			playerArray[row][4] = p.getPosition();
			playerArray[row][5] = p.getNFLTeam();
			playerArray[row][6] = p.getByeWeek();
			playerArray[row][7] = Boolean.FALSE;
			
			// Iterates the row
			row++;
		}
		
		// Returns the 2D array
		return playerArray;
	}
}
