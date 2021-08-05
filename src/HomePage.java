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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class HomePage extends JFrame implements ActionListener {
	private JTable list, roundTab, teamTab;
	private JButton searchButton, nextPick, prevPick;
	private JLabel search;
	private JTextField searchTF;
	
	private JMenuBar menuBar;
	private JMenu filter;
	private JMenuItem qb, wr, rb, def, k, te, clear;
	
	private Draft draft;
	private String[] cols;
	
	public HomePage(Object[][] players, String[] cols, Draft draft) {
		super("Fantasy Draft");
		
		this.draft = draft;
		
		createMenu();
		
		createList(players, cols);
		
		createSearch();
		
		createTeams();
		
		createRounds();
		
		createButtons();
		
		JPanel roundPanel = new JPanel();
		roundPanel.add(this.roundTab, BorderLayout.PAGE_END);
		roundPanel.add(new JScrollPane(this.roundTab));
		
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new FlowLayout());
		listPanel.add(this.searchTF);
		listPanel.add(this.searchButton);
		listPanel.add(this.list);
		listPanel.add(new JScrollPane(this.list));
		
		JPanel teamPanel = new JPanel();
		//roundPanel.setLayout(new GridLayout(2,1));
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
	
	private void createMenu() {
		this.menuBar = new JMenuBar();
		
		this.filter = new JMenu("Filter");
		
		this.qb = new JMenuItem("QB");
		this.qb.addActionListener(this);
		
		this.rb = new JMenuItem("RB");
		this.rb.addActionListener(this);
		
		this.wr = new JMenuItem("WR");
		this.wr.addActionListener(this);
		
		this.te = new JMenuItem("TE");
		this.te.addActionListener(this);
		
		this.k = new JMenuItem("K");
		this.k.addActionListener(this);
		
		this.def = new JMenuItem("DEF");
		this.def.addActionListener(this);
		
		this.clear = new JMenuItem("Clear Filters");
		this.clear.addActionListener(this);
		
		this.filter.add(this.qb);
		this.filter.add(this.rb);
		this.filter.add(this.wr);
		this.filter.add(this.te);
		this.filter.add(this.k);
		this.filter.add(this.def);
		
		this.menuBar.add(this.filter);
	}
	
	private void createSearch() {
		this.searchTF = new JTextField(40);
		this.searchButton = new JButton("Search");
	}
	
	private void createButtons() {
		this.nextPick = new JButton("Next Pick");
		this.prevPick = new JButton("Previous Pick");
	}
	
	private void createList(Object[][] players, String[] cols) {
		DefaultTableModel model = new DefaultTableModel(players, cols) {
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
	
	private Object[] updateList() {
		Object[] selected = null;
		
		for (int i = 0; i < this.list.getRowCount(); i++) {
			//if (this.list.getValueAt(i, 7)) {
				
			//}
		}
		
		return selected;
	}
	
	private void createRounds() {
		Object[] roundTitles = {"Round: " + String.valueOf(this.draft.getCurrentRound()), "Selection"};
		Object[][] roundNames = {{"Joe", "On the Clock"},{"Nate",""}};
		this.roundTab = new JTable(roundNames, roundTitles);
	}
	
	private void createTeams() {
		Object[] teamTitles = {"Team: " + String.valueOf(this.draft.getCurrentTeam().getName()), "Selections"};
		this.teamTab = new JTable(this.draft.getCurrentTeam().rosterRecap(), teamTitles);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next Pick")) {
			if (this.draft.nextPick() == -1) {
			
			}
		}
	}
}
