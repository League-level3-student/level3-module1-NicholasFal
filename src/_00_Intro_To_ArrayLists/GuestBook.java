package _00_Intro_To_ArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	JFrame frame = new JFrame("Guest Book");
	JPanel panel = new JPanel();
	JButton addName = new JButton();
	JButton viewNames = new JButton();
	ArrayList<String> names = new ArrayList<String>();
	public void run() {
		frame.add(panel);
		panel.add(addName);
		panel.add(viewNames);
		addName.setText("Add Names");
		viewNames.setText("View Names");
		addName.addActionListener(this);
		viewNames.addActionListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == addName) {
			String newName = JOptionPane.showInputDialog("Name:");
			names.add(newName);
		} else if(arg0.getSource() == viewNames) {
			String viewing = "";
			int guestNumber;
			for(int i = 0; i < names.size(); i++) {
				guestNumber = i + 1;
				viewing += "Guest #" + guestNumber + ": ";
				viewing += names.get(i);	
				viewing += "\n";
			}
			JOptionPane.showMessageDialog(null, viewing);

		}
	}
}
