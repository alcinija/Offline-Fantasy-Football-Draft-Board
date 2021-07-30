import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private ArrayList<Team> teams;
	private String teamName;
	
	public TeamCreatorPage(int teamNum, ArrayList<Team> teams) {
		super("Team " + teamNum + " Creator");
		
		this.teams = teams;
		
		this.tNameTF = new JTextField(30);
		this.tName = new JLabel("Team " + teamNum + " Name: ");
		
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
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Finish Team")) {
			this.teamName = this.tNameTF.getText();
			
			this.teams.add(new Team(this.teamName));
			
			this.dispose();
		}
	}
	
	public String getTeamName() {
		return this.teamName;
	}
	
	public static void main(String[] args) {
		TeamCreatorPage dsp =  new TeamCreatorPage(1, new ArrayList<Team>());
		dsp.setSize(500, 100);
		dsp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dsp.setVisible(true);
	}
}
