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

/**
 * Name: Joe Alcini
 * File: DraftSetupPage.java
 * Date: 8/05/2020
 * Current Version: 1.0.0 Original Release
 * Description: Loads the pages to create the preferences
 */
public class DraftSetupPage extends JFrame implements ActionListener {
	// Creates the visible components
	private JComboBox yearCB;
	private JTextField roundsTF, numTeamsTF;
	private JLabel year, rounds, numTeams, snakeL;
	private JRadioButton snakeB;
	private JButton next;
	
	// Creates the fields
	private ArrayList<Team> teamList;
	private int numRounds;
	private boolean snake;
	private Draft draft;
	
	/**
	 * Creates the visible frames
	 */
	public DraftSetupPage() {
		// Puts the title of the frame
		super("Draft Setup");
		
		// Creates the years
		this.yearCB = new JComboBox(getYears());
		this.yearCB.setSelectedIndex(getYears().length - 1);
		this.yearCB.addActionListener(this);
		this.year = new JLabel("Year: ");
		
		// Creates the number of rounds
		this.roundsTF = new JTextField(15);
		this.rounds = new JLabel("Rounds: ");
		
		// Creates the number of teams
		this.numTeamsTF = new JTextField(15);
		this.numTeams = new JLabel("Number of Teams: ");
		
		// Creates the ability for snake rounds
		this.snakeB = new JRadioButton();
		this.snakeL = new JLabel("Snake: ");
		
		// Creates the next window button
		this.next = new JButton("Next");
		this.next.addActionListener(this);
		
		// Creates a new team list 
		this.teamList = new ArrayList<Team>();
		
		// Creates the panel for the year
		JPanel yearPanel = new JPanel();
		yearPanel.setLayout(new FlowLayout());
		yearPanel.add(this.year);
		yearPanel.add(this.yearCB);
		
		// Creates the panel for the rounds
		JPanel roundPanel = new JPanel();
		roundPanel.setLayout(new FlowLayout());
		roundPanel.add(this.rounds);
		roundPanel.add(this.roundsTF);
		
		// Creates the panel for the number of teams
		JPanel numTeamsPanel = new JPanel();
		numTeamsPanel.setLayout(new FlowLayout());
		numTeamsPanel.add(this.numTeams);
		numTeamsPanel.add(this.numTeamsTF);
		
		// Creates the [panel for ppr options
		JPanel pprPanel = new JPanel();
		pprPanel.setLayout(new FlowLayout());
		pprPanel.add(this.snakeL);
		pprPanel.add(this.snakeB);
		
		// Creates the button panel
		JPanel nextPanel = new JPanel();
		nextPanel.add(this.next);
		
		// Adds the panels to the frame
		this.setLayout(new GridLayout(5, 1));
		this.add(yearPanel);
		this.add(pprPanel);
		this.add(roundPanel);
		this.add(numTeamsPanel);
		this.add(nextPanel);
	}
	
	/**
	 * Creates the teams creator
	 * @param draftParams Object[] the setting selected on the page
	 * @param numTeams int The number of teams in the draft
	 */
	private void createTeams(Object[] draftParams, int numTeams) {
		TeamCreatorPage tcp =  new TeamCreatorPage(draftParams, numTeams);
		tcp.setSize(500, 100);
		tcp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		tcp.setVisible(true);
	}
	
	/**
	 * Creates the number of years available
	 * in the drop down menu
	 * @return The list of numbers
	 */
	private String[] getYears() {
		// Creates the range of years
		int currentYear = 2021;
		int startYear = 2021;
		
		// Creates the array
		String[] years = new String[(currentYear - startYear) + 1];
		
		// Creates the array entries
		for (int i = 0; i < years.length; i++) {
			years[i] = String.valueOf(currentYear + i);
		}
		
		// Returns the array
		return years;
	}
	
	/**
	 * Gets the list of teams
	 * @return
	 */
	public ArrayList<Team> getTeams() {
		return this.teamList;
	}

	/**
	 * Processes interactions in the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next")) {
			// Deletes the frame
			this.dispose();
			
			// Creates array
			Object[] draftParams = new Object[3];
			
			// Assigns values in the array
			draftParams[0] = this.yearCB.getSelectedItem();
			draftParams[1] = this.snakeB.isSelected();
			draftParams[2] = this.roundsTF.getText();
			
			// Creates the teams
			createTeams(draftParams, Integer.parseInt(this.numTeamsTF.getText()));
		}
		
	}
	
	/**
	 * Returns the draft object
	 * @return The draft object
	 */
	public Draft getDraft() {
		return this.draft;
	}
}
