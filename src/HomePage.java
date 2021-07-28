import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomePage extends JFrame implements ActionListener {
	private JTable list, roundTab, teamTab;
	private JButton searchButton, nextPick, prevPick;
	//private JTextArea teamTA;
	private JLabel team, search, round;
	private JTextField searchTF;
	
	private Draft draft;
	
	public HomePage(Object[][] players, String[] cols) {
		super("Fantasy Draft");
		
		this.draft = new Draft();
		
		this.search = new JLabel("Search: ");
		this.searchTF = new JTextField(50);
		this.searchButton = new JButton("Search");
		
		this.team = new JLabel("Team");
		//this.teamTab = new JTextArea(20, 20);
		this.teamTab = new JTable(12, 1);
		
		this.list = new JTable(players, cols);
		
		this.roundTab = new JTable(12, 1);
		this.round = new JLabel("Round: #");
		
		this.nextPick = new JButton("Next Pick");
		this.prevPick = new JButton("Previous Pick");
		
		JPanel roundPanel = new JPanel();
		//roundPanel.add(this.round, BorderLayout.PAGE_START);
		roundPanel.add(this.roundTab, BorderLayout.PAGE_END);
		roundPanel.add(new JScrollPane(this.roundTab));
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());
		listPanel.add(this.search);
		listPanel.add(this.searchTF);
		listPanel.add(this.searchButton);
		listPanel.add(this.list);
		listPanel.add(new JScrollPane(this.list));
		
		JPanel teamPanel = new JPanel();
		roundPanel.setLayout(new GridLayout(2,1));
		//teamPanel.add(this.team, 0);
		teamPanel.add(this.teamTab, 1);
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(this.prevPick, BorderLayout.WEST);
		buttonRow.add(this.nextPick, BorderLayout.EAST);
		
		
		this.add(roundPanel, BorderLayout.WEST);
		this.add(listPanel, BorderLayout.CENTER);
		this.add(teamPanel, BorderLayout.EAST);
		this.add(buttonRow, BorderLayout.SOUTH);
	}
	
	public static void main (String[] args) {
		Object[][] players = new Object[0][0];
		String[] cols = {"PosRank", "OvlRank", "FName", "LName", "NFLTeam", "Pos", "ByeWeek", "IsDrafted"};
		
		try {
			players = new PlayerReader("playersTest.csv").toObjArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HomePage hp =  new HomePage(players, cols);
		hp.setSize(1500, 600);
		hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		hp.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next Pick")) {
			int nextPick = this.draft.nextPick();
			
			Object[] roundTitles = {String.valueOf(this.draft.getRounds()), "Selections"};
			Object[] teamTitle = {this.draft.getCurrentTeam().getName()};
			
			if (nextPick != -1) {
				this.teamTab = new JTable(this.draft.getCurrentTeam().rosterRecap(), teamTitle);
			}
		}
	}
}
