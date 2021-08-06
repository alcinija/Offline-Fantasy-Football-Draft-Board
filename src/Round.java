import java.util.ArrayList;

public class Round {
	private int roundNum;
	private ArrayList<Selection> selectionList;
	
	public Round(int roundNum) {
		this.roundNum = roundNum;
		this.selectionList = new ArrayList<Selection>();
	}
	
	public void addPlayer(String teamName, Object[] player) {
		for (int i = 0; i < this.selectionList.size(); i++) {
			if (this.selectionList.get(i).getSelection()[0].equals(teamName)) {
				this.selectionList.get(i).addPlayer(new Player(Integer.parseInt(player[0].toString()), Integer.parseInt(player[1].toString()), player[2].toString(), player[3].toString(), player[4].toString(), player[5].toString(), Integer.parseInt(player[6].toString())));	
			}
		}
	}
	
	public void addNewSelection(Selection selection) {
		this.selectionList.add(selection);
	}
	
	public Object[][] getData() {
		Object[][] result = new Object[this.selectionList.size()][2];
		
		boolean clock = false;
		
		for (int i = 0; i < this.selectionList.size(); i++) {
			result[i][0] = this.selectionList.get(i).getName();
			
			if (this.selectionList.get(i).getSelection()[1].toString().equals("") && !clock) {
				result[i][1] = "On the Clock";
				clock = true;
			} else {
				result[i][1] = this.selectionList.get(i).getSelection()[1].toString();
			}
		}
		
		return result;
	}
	
	public String[] getTitles() {
		String[] titles = new String[2];
		
		titles[0] = String.valueOf(this.roundNum);
		titles[1] = "Selection";
		
		return titles;
	}
}
