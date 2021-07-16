import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomePage extends JFrame implements ActionListener {
	private JTable list;
	private JTextArea teamTA;
	private JLabel team, search;
	private JTextField searchTF;
	
	public HomePage(ArrayList<Player> players) {
		super("Fantasy Draft");
		
		this.search = new JLabel("Search: ");
		this.searchTF = new JTextField(50);
		
		this.team = new JLabel("Team");
		this.teamTA = new JTextArea(50, 80);
		
		this.list = new JTable(players.size(), 7);
		
		JScrollPane sp = new JScrollPane(this.list);
	}
	
	public static void main (String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		
		try {
			players = new PlayerReader("playersTest.csv").toArrayList();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HomePage hp =  new HomePage(players);
		hp.setSize(670, 550);
		hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		hp.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
