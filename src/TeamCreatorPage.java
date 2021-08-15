import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Name: Joe Alcini
 * File: TeamCreatorPage.java
 * Date: 8/05/2020
 * Current Version: 1.0.0 Original Release
 * Description: Creates a GUI to create a team for a draft
 */
public class TeamCreatorPage extends JFrame implements ActionListener {
	// Creates display elements
	private JTextField tNameTF;
	private JLabel tName;
	private JButton finish;
	
	// Declares fields
	private Object[] draftParams;
	private ArrayList<Team> teams;
	private int maxTeamNum;
	
	/**
	 * Creates a GUI to create team objects
	 * @param draftParams Object[] A list of parameters for a draft
	 * @param maxTeamNum int The number of teams drafting
	 */
	public TeamCreatorPage(Object[] draftParams, int maxTeamNum) {
		// Creates a title for the frame
		super("Team Creator");
		
		// Creates params
		this.draftParams = draftParams;
		
		// Creates the number of teams
		this.maxTeamNum = maxTeamNum;
		
		// Creates the team list
		this.teams = new ArrayList<Team>();
		
		// Creates the input line
		this.tNameTF = new JTextField(30);
		this.tName = new JLabel("Team 1 Name: ");
		
		// Creates the submission button 
		this.finish = new JButton("Finish Team");
		this.finish.addActionListener(this);
		
		// Creates a display panel
		JPanel panel  =new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(this.tName);
		panel.add(this.tNameTF);
		panel.add(this.finish);
		
		// Adds the panel to the frame
		this.add(panel, BorderLayout.CENTER);
	}

	/**
	 * Triggers when an interaction with the frame occurs
	 * @param e ActionEvent The event that occurred in the frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Checks if the finish button was clicked
		if (e.getActionCommand().equals("Finish Team")) {
			// Creates a new team
			this.teams.add(new Team(this.tNameTF.getText()));
			
			// Checks if all teams have been created
			if (this.teams.size() >= maxTeamNum) {
				// Removes the frame
				this.dispose();
				
				// Creates a file and a draft object
				String year = "players" + draftParams[0] + ".csv";
				Draft draft = createDraft();
				
				// Creates table headings
				Object[][] players = new Object[0][0];
				String[] cols = {"PosRank", "OvlRank", "FName", "LName", "NFLTeam", "Pos", "ByeWeek", "IsDrafted"};
				
				// Ensures a file exists
				try {
					players = new PlayerReader(year).toObjArray();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
				
				// Creates the frame
				HomePage hp =  new HomePage(players, cols, draft);
				hp.setSize(1500, 600);
				hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
				hp.setVisible(true);
				
			}
			
			// Empties the filed and changes the title
			this.tNameTF.setText(null);
			this.tName.setText("Team " + (this.teams.size() + 1) + " Name: ");
		}
	}
	
	/**
	 * Creates a new draft from passed parameters
	 * @return The new draft object
	 */
	private Draft createDraft() {
		// Creates the Draft
		Draft result = new Draft(this.teams, Integer.parseInt(this.draftParams[2].toString()), Boolean.parseBoolean(this.draftParams[1].toString()));
		
		// Returns the Draft
		return result;
	}
}
