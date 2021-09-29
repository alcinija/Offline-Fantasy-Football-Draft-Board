import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * Name: Joe Alcini
 * File: Hompage.java
 * Date: 8/05/2000
 * Current Version: 1.0.0 Original Release
 * Description: Creates the main display that
 * the user interacts with
 */
public class HomePage extends JFrame implements ActionListener {
	// Declares visual components
	private JTable list, roundTab, teamTab;
	private JButton searchButton, nextPick, prevPick;
	private JTextField searchTF;
	private JPanel listPanel, roundPanel, teamPanel;
	private DefaultTableModel model, roundModel, teamModel;
	
	// Declares menu items
	private JMenuBar menuBar;
	private JMenu filter, create, save;
	private JMenuItem qb, wr, rb, def, k, te, clear, newP, saveM;
	
	// Declares draft field
	private Draft draft;
	
	/**
	 * Creates the HomePage object 
	 * @param players Object[][] A formatted 2D array of player info
	 * @param cols String[] The labels for the players table 
	 * @param draft Draft the functional draft object
	 */
	public HomePage(Object[][] players, String[] cols, Draft draft) {
		// Titles the frame
		super("Fantasy Draft");
		
		// Assigns draft
		this.draft = draft;
		
		// Creates menu
		createMenu();
		
		// Creates the main list
		createList(players, cols);
		
		// Creates the search bar
		createSearch();
		
		// Creates the selected team recap
		createTeams();
		
		// Creates the selected round recap
		createRounds();
		
		// Creates the buttons
		createButtons();
		
		// Creates the panels
		createPanels();
		
		// Creates a list of players drafted in a round
		JPanel roundPanel = new JPanel();
		roundPanel.add(this.roundTab, BorderLayout.PAGE_END);
		roundPanel.add(new JScrollPane(this.roundTab));
		
		// Creates a list of draftable players
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());
		listPanel.add(this.searchTF);
		listPanel.add(this.searchButton);
		listPanel.add(this.list);
		listPanel.add(new JScrollPane(this.list));
		
		// Creates a list of players
		JPanel teamPanel = new JPanel();
		teamPanel.add(this.teamTab);
		teamPanel.add(new JScrollPane(this.teamTab));
		
		// Creates the directional buttons 
		JPanel buttonRow = new JPanel();
		buttonRow.add(this.prevPick, BorderLayout.WEST);
		buttonRow.add(this.nextPick, BorderLayout.EAST);
		
		// Adds the menu bar 
		this.setJMenuBar(menuBar);
		
		// adds the panels
		this.add(roundPanel, BorderLayout.WEST);
		this.add(listPanel, BorderLayout.CENTER);
		this.add(teamPanel, BorderLayout.EAST);
		this.add(buttonRow, BorderLayout.SOUTH);
	}
	
	/**
	* Creates the filtering menu
	*/
	private void createMenu() {
		// Creates a menu bar
		this.menuBar = new JMenuBar();
		
		// Creates the first menues
		this.filter = new JMenu("Filter");
		this.create = new JMenu("Create");
		
		// Adds a quarterback option
		this.qb = new JMenuItem("QB");
		this.qb.addActionListener(this);
		
		// Adds a runnung back option
		this.rb = new JMenuItem("RB");
		this.rb.addActionListener(this);
		
		// Adds a wide reciever option
		this.wr = new JMenuItem("WR");
		this.wr.addActionListener(this);
		
		// adds a tight end option
		this.te = new JMenuItem("TE");
		this.te.addActionListener(this);
		
		// Adds a kicker option
		this.k = new JMenuItem("K");
		this.k.addActionListener(this);
		
		// Adds a defense option
		this.def = new JMenuItem("D");
		this.def.addActionListener(this);
		
		// Clears the filters to show all players
		this.clear = new JMenuItem("Clear Filters");
		this.clear.addActionListener(this);
		
		// Adds a new player to the list
		this.newP = new JMenuItem("New Player");
		this.newP.addActionListener(this);
		
		// Adds a tab to save picks
		this.save = new JMenu("Save");
		
		// Option to save picks
		this.saveM = new JMenuItem("Save Pick");
		this.saveM.addActionListener(this);
		
		// Adds the player filters
		this.filter.add(this.qb);
		this.filter.add(this.rb);
		this.filter.add(this.wr);
		this.filter.add(this.te);
		this.filter.add(this.k);
		this.filter.add(this.def);
		
		// Adds the new player option
		this.create.add(this.newP);
		
		// Adds the filter and creation buttons
		this.menuBar.add(this.filter);
		this.menuBar.add(this.create);
	}
	
	
	private void createSearch() {
		this.searchTF = new JTextField(40);
		this.searchButton = new JButton("Search");
	}
	
	private void createButtons() {
		this.nextPick = new JButton("Next Pick");
		this.nextPick.addActionListener(this);
		this.prevPick = new JButton("Previous Pick");
	}
	
	private void createList(Object[][] players, String[] cols) {
		this.model = new DefaultTableModel(players, cols) {
			public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                        return o.getClass();
                }

                return Object.class;
            }
		};
		
		
		this.list = new JTable(model);
		
		
		DefaultCellEditor dce = (DefaultCellEditor)this.list.getDefaultEditor(Boolean.class);
		JCheckBox cbe = (JCheckBox)dce.getComponent();
		
		TableCellRenderer tcr = this.list.getDefaultRenderer(Boolean.class);
        JCheckBox cbr = (JCheckBox)tcr;
	}
	
	private void createPanels() {
		roundPanel = new JPanel();
		roundPanel.add(this.roundTab, BorderLayout.PAGE_END);
		roundPanel.add(new JScrollPane(this.roundTab));
		
		listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());
		listPanel.add(this.searchTF);
		listPanel.add(this.searchButton);
		listPanel.add(this.list);
		listPanel.add(new JScrollPane(this.list));
		
		teamPanel = new JPanel();
		teamPanel.add(this.teamTab);
		teamPanel.add(new JScrollPane(this.teamTab));
		
		JPanel buttonRow = new JPanel();
		buttonRow.add(this.prevPick, BorderLayout.WEST);
		buttonRow.add(this.nextPick, BorderLayout.EAST);
		
		
		this.setJMenuBar(menuBar);
		
		
		this.add(roundPanel, BorderLayout.WEST);
		this.add(listPanel, BorderLayout.CENTER);
		this.add(teamPanel, BorderLayout.EAST);
		this.add(buttonRow, BorderLayout.SOUTH);
	}
	
	private void updatePanels() {
		roundPanel = new JPanel();
		roundPanel.add(this.roundTab, BorderLayout.PAGE_END);
		roundPanel.add(new JScrollPane(this.roundTab));
		
		teamPanel = new JPanel();
		teamPanel.add(this.teamTab);
		teamPanel.add(new JScrollPane(this.teamTab));
		
		this.add(roundPanel, BorderLayout.WEST);
		this.add(teamPanel, BorderLayout.EAST);
	}
	
	private Object[] updateList() {
		Object[] selected = null;
	
		selected = new Object[7];
		selected[0] = this.model.getValueAt(this.list.getSelectedRow(), 0).toString();
		selected[1] = this.model.getValueAt(this.list.getSelectedRow(), 1).toString();
		selected[2] = this.model.getValueAt(this.list.getSelectedRow(), 2).toString();
		selected[3] = this.model.getValueAt(this.list.getSelectedRow(), 3).toString();
		selected[4] = this.model.getValueAt(this.list.getSelectedRow(), 4).toString();
		selected[5] = this.model.getValueAt(this.list.getSelectedRow(), 5).toString();
		selected[6] = this.model.getValueAt(this.list.getSelectedRow(), 6).toString();
				
		this.model.removeRow(this.list.getSelectedRow());
		
		return selected;
	}
	
	private void createRounds() {
		Object[] roundTitles = {"Round: " + String.valueOf(this.draft.getCurrentRound()), "Selection"};
		Object[][] roundNames = this.draft.getRoundData(this.draft.getCurrentRound());
		
		
		this.roundModel = new DefaultTableModel(roundNames, roundTitles);
		this.roundTab = new JTable(roundModel);
		
		this.roundTab.setAutoCreateColumnsFromModel( false );
	}
	
	private void updateRounds() {
		Object[] roundTitles = {"Round: " + String.valueOf(this.draft.getCurrentRound()), "Selection"};
		Object[][] roundNames = this.draft.getRoundData(this.draft.getCurrentRound());
		
		for (int i = 0; i < this.roundTab.getRowCount(); i++) {
			this.roundModel.setValueAt(roundNames[i][0], i, 0);
			this.roundModel.setValueAt(roundNames[i][1], i, 1);
		}
		
		this.roundTab.getColumnModel().getColumn(0).setHeaderValue(roundTitles[0].toString());
		this.roundTab.getTableHeader().repaint();
	}
	
	private void createTeams() {
		Object[] teamTitles = {"Team: " + String.valueOf(this.draft.getCurrentTeam().getName()), "Selections"};
		
				
		this.teamModel = new DefaultTableModel(this.draft.getCurrentTeam().rosterRecap(), teamTitles);
		this.teamTab = new JTable(teamModel);

		this.teamTab.setAutoCreateColumnsFromModel( false );
	}
	
	private void updateTeams() {
		Object[] teamTitles = {"Team: " + String.valueOf(this.draft.getCurrentTeam().getName()), "Selections"};
		
		for (int i = this.teamModel.getRowCount() - 1; i >= 0; i--) {
			this.teamModel.removeRow(i);
		}
		
		for (int i = 0; i < this.draft.getCurrentTeam().rosterRecap().length; i++) {
			//this.teamModel.setValueAt(this.draft.getCurrentTeam().rosterRecap()[i][0], i, 0);
			//this.teamModel.setValueAt(this.draft.getCurrentTeam().rosterRecap()[i][1], i, 1);
			this.teamModel.addRow(this.draft.getCurrentTeam().rosterRecap()[i]);
		}
			
		
		this.teamTab.getColumnModel().getColumn(0).setHeaderValue(teamTitles[0].toString());
		this.teamTab.getTableHeader().repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next Pick")) {
			
			Object[] p = updateList();
			this.draft.draftPlayer(p);
			
			System.out.println(this.draft.getCurrentTeam().getName());
			
			int currentPick = this.draft.getPickNo();
			
			if (currentPick == -1) {
				this.dispose();
			} else {
				updateRounds();
				updateTeams();
				
			}
		} else if (e.getActionCommand().equals("New Player")) {
			JFrame newP = new JFrame();
			JLabel newPFNL = new JLabel("FName:");
			JLabel newPLNL = new JLabel("LName:");
			JLabel newPTNL = new JLabel("Team Name:");
			JLabel newPoTNL = new JLabel("Position:");
			JLabel newByeL = new JLabel("Bye Week");
			
			JTextField newFName = new JTextField(15);
			JTextField newLName = new JTextField(15);
			JTextField newPos = new JTextField(15);
			JTextField newTName = new JTextField(15);
			JTextField newBye = new JTextField(15);
			
			JButton end = new JButton("Complete");
			
			JPanel newPPanel = new JPanel();
			newPPanel.setLayout(new GridLayout(6, 2));
			newPPanel.add(newPFNL, 0);
			newPPanel.add(newFName, 1);
			newPPanel.add(newPLNL, 2);
			newPPanel.add(newLName, 3);
			newPPanel.add(newPTNL, 4);
			newPPanel.add(newTName, 5);
			newPPanel.add(newByeL, 6);
			newPPanel.add(newBye, 7);
			newPPanel.add(newPoTNL, 8);
			newPPanel.add(newPos, 9);
			
			
			
			ActionListener a = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (e.getActionCommand().equals("Complete")) {
						Object[] newPlayer = {91, 301, newFName.getText(), newLName.getText(),  newTName.getText(), newPos.getText(), newBye.getText(), Boolean.TRUE};
						
						model.addRow(newPlayer);
						
						newP.dispose();
					}
				}
				
			};
			
			end.addActionListener(a);
			
			newPPanel.add(end);
			
			newP.add(newPPanel);
			newP.setSize(500, 200);
			newP.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			newP.setVisible(true);
		} else if (e.getActionCommand().equals("Save Pick")) {
			
		}
	} 
}
