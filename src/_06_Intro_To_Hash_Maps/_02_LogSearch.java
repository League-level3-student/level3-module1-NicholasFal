package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	HashMap<Integer, String> user = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addEntry = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	public void run() {
		frame.add(panel);
		panel.add(addEntry);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		addEntry.setText("Add Entry");
		addEntry.addActionListener(this);
		search.setText("Search By ID");
		search.addActionListener(this);
		view.setText("View List");
		view.addActionListener(this);
		remove.setText("Remove Entry");
		remove.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == addEntry) {
			String key = JOptionPane.showInputDialog("Enter ID:");
			String name = JOptionPane.showInputDialog("Enter name:");
			int keyInt = Integer.parseInt(key);
			user.put(keyInt, name);
		} else if(arg0.getSource() == search) {
			String key = JOptionPane.showInputDialog("Enter ID: ");
			int keyInt = Integer.parseInt(key);
			if(user.get(keyInt) == null) {
				JOptionPane.showMessageDialog(null, "Name could not be found");
			} else {
			JOptionPane.showMessageDialog(null, user.get(keyInt));
			}
			} else if(arg0.getSource() == view) {
				for(Integer i : user.keySet()) {
					JOptionPane.showMessageDialog(null, "ID: " + i + "   Name: " + user.get(i));
				}
			}
		}
	}

