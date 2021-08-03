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

public class TeamCreatorPage extends JFrame implements ActionListener {
	private JTextField tNameTF;
	private JLabel tName;
	private JButton finish;
	
	private Object[] draftParams;
	private ArrayList<Team> teams;
	private int maxTeamNum;
	
	public TeamCreatorPage(Object[] draftParams, int maxTeamNum) {
		super("Team Creator");
		
		this.draftParams = draftParams;
		
		this.maxTeamNum = maxTeamNum;
		
		this.teams = new ArrayList<Team>();
		
		this.tNameTF = new JTextField(30);
		this.tName = new JLabel("Team 1 Name: ");
		
		this.finish = new JButton("Finish Team");
		this.finish.addActionListener(this);
		
		JPanel panel  =new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(this.tName);
		panel.add(this.tNameTF);
		panel.add(this.finish);
		
		this.add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Finish Team")) {
			this.teams.add(new Team(this.tNameTF.getText()));
			
			if (this.teams.size() >= maxTeamNum) {
				this.dispose();
				
				String year = "players" + draftParams[0] + ".csv";
				Draft draft = createDraft();
				
				Object[][] players = new Object[0][0];
				String[] cols = {"PosRank", "OvlRank", "FName", "LName", "NFLTeam", "Pos", "ByeWeek", "IsDrafted"};
				
				try {
					players = new PlayerReader(year).toObjArray();
				} catch (FileNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				HomePage hp =  new HomePage(players, cols, draft);
				hp.setSize(1500, 600);
				hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
				hp.setVisible(true);
				
			}
			
			this.tNameTF.setText(null);
			this.tName.setText("Team " + (this.teams.size() + 1) + " Name: ");
		}
	}
	
	private Draft createDraft() {
		Draft result = new Draft(this.teams, Integer.parseInt(this.draftParams[3].toString()), Boolean.parseBoolean(this.draftParams[2].toString()));
		
		return result;
	}
	
	public static void main(String[] args) {
		TeamCreatorPage dsp =  new TeamCreatorPage(3);
		dsp.setSize(500, 100);
		dsp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dsp.setVisible(true);
	}
}
