import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DraftSetupPage extends JFrame implements ActionListener {
	private JComboBox yearCB;
	private JTextField roundsTF, numTeamsTF;
	private JLabel year, rounds, numTeams, snakeL;
	private JRadioButton snakeB;
	private JButton next;
	
	private ArrayList<Team> teamList;
	private int numRounds;
	private boolean snake;
	
	private Draft draft;
	
	public DraftSetupPage() {
		super("Draft Setup");
		
		this.yearCB = new JComboBox(getYears());
		this.yearCB.setSelectedIndex(getYears().length - 1);
		this.yearCB.addActionListener(this);
		this.year = new JLabel("Year: ");
		
		this.roundsTF = new JTextField(15);
		this.rounds = new JLabel("Rounds: ");
		
		this.numTeamsTF = new JTextField(15);
		this.numTeams = new JLabel("Number of Teams: ");
		
		this.snakeB = new JRadioButton();
		this.snakeL = new JLabel("Snake: ");
		
		this.next = new JButton("Next");
		this.next.addActionListener(this);
		
		this.teamList = new ArrayList<Team>();
		
		JPanel yearPanel = new JPanel();
		yearPanel.setLayout(new FlowLayout());
		yearPanel.add(this.year);
		yearPanel.add(this.yearCB);
		
		JPanel roundPanel = new JPanel();
		roundPanel.setLayout(new FlowLayout());
		roundPanel.add(this.rounds);
		roundPanel.add(this.roundsTF);
		
		JPanel numTeamsPanel = new JPanel();
		numTeamsPanel.setLayout(new FlowLayout());
		numTeamsPanel.add(this.numTeams);
		numTeamsPanel.add(this.numTeamsTF);
		
		JPanel pprPanel = new JPanel();
		pprPanel.setLayout(new FlowLayout());
		pprPanel.add(this.snakeL);
		pprPanel.add(this.snakeB);
		
		JPanel nextPanel = new JPanel();
		nextPanel.add(this.next);
		
		this.setLayout(new GridLayout(5, 1));
		this.add(yearPanel);
		this.add(pprPanel);
		this.add(roundPanel);
		this.add(numTeamsPanel);
		this.add(nextPanel);
	}
	
	private void createTeams(Object[] draftParams, int numTeams) {
		TeamCreatorPage tcp =  new TeamCreatorPage(draftParams, numTeams);
		tcp.setSize(500, 100);
		tcp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tcp.setVisible(true);
	}
	
	private String[] getYears() {
		int currentYear = 2021;
		int startYear = 2021;
		
		String[] years = new String[(currentYear - startYear) + 1];
		
		for (int i = 0; i < years.length; i++) {
			years[i] = String.valueOf(currentYear + i);
		}
		
		return years;
	}
	
	public ArrayList<Team> getTeams() {
		return this.teamList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next")) {
			this.dispose();
			
			Object[] draftParams = new Object[3];
			
			draftParams[0] = this.yearCB.getSelectedItem();
			draftParams[1] = this.snakeB.isSelected();
			draftParams[2] = this.roundsTF.getText();
			
			// Creates the teams
			createTeams(draftParams, Integer.parseInt(this.numTeamsTF.getText()));
		}
		
	}
	
	public Draft getDraft() {
		return this.draft;
	}
}
