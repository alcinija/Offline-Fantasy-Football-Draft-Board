import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DraftSetupPage extends JFrame implements ActionListener {
	private JComboBox yearCB;
	private JTextField roundsTF, numTeamsTF, teamNameTF;
	private JLabel year, rounds, numTeams, teamName, ppr;
	private JRadioButton pprB;
	
	public DraftSetupPage() {
		this.yearCB = new JComboBox(getYears());
		this.yearCB.setSelectedIndex(getYears().length - 1);
		this.yearCB.addActionListener(this);
		this.year = new JLabel("Year: ");
		
		this.roundsTF = new JTextField(15);
		this.rounds = new JLabel("Rounds: ");
		
		this.numTeamsTF = new JTextField(15);
		this.numTeams = new JLabel("Number of Teams: ");
		
		this.teamNameTF = new JTextField(15);
		this.teamName = new JLabel("Team Name: ");
		
		String[] pprOptions = {"PPR", "Non-PPR"};
		this.pprB = new JRadioButton();
		this.ppr = new JLabel("PPR: ");
		
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
		pprPanel.add(this.ppr);
		pprPanel.add(this.pprB);
		
		this.setLayout(new GridLayout(4, 1));
		this.add(yearPanel);
		this.add(pprPanel);
		this.add(roundPanel);
		this.add(numTeamsPanel);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DraftSetupPage dsp =  new DraftSetupPage();
		dsp.setSize(500, 300);
		dsp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dsp.setVisible(true);
	}
}
