
public class Selection {
	private String teamName;
	private Player player;
	
	public Selection(String teamName) {
		this.teamName = teamName;
		this.player = null;
	}
	
	public void addPlayer(Player newPlayer) {
		this.player = newPlayer;
	}
	
	public void removePlayer() {
		this.player = null;
	}
	
	public String getName() {
		return this.teamName;
	}
	
	public Object[] getSelection() {
		Object[] selection = new Object[2];
		
		selection[0] = this.teamName;
		
		if (this.player != null) {
			selection[1] = this.player.toString();
		} else {
			selection[1] = "";
		}
		
		return selection;
	}
}
