import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.*;


public class AddressBookFrame extends JFrame implements ActionListener {

	private AddressBook currentbook;
	private JList addressList;
	private JMenuBar menubar = new JMenuBar();
	private JMenu filemenu = new JMenu("File");
	private JMenuItem create = new JMenuItem("Create");
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem load = new JMenuItem("Display");
	private JMenuItem add = new JMenuItem("Add");
	private JMenuItem remove = new JMenuItem("Remove");
	private JMenuItem edit = new JMenuItem("Edit");
	private JPanel panel = new JPanel(new BorderLayout());
	
	public AddressBookFrame(String label){
		super(label);
		
		create.addActionListener(this);
		filemenu.add(create);
		save.addActionListener(this);
		filemenu.add(save);
		save.setEnabled(false);
		load.addActionListener(this);
		filemenu.add(load);
		load.setEnabled(false);
		add.addActionListener(this);
		filemenu.add(add);
		add.setEnabled(false);
		remove.addActionListener(this);
		filemenu.add(remove);
		remove.setEnabled(false);
		edit.addActionListener(this);
		filemenu.add(edit);
		edit.setEnabled(false);
		
		
		menubar.add(filemenu);
		setJMenuBar(menubar);
		add(panel);
		panel.setVisible(true);
		
	}
	
	public static void main(String[] args){
		AddressBookFrame frame1 = new AddressBookFrame("Address Book GUI");
		frame1.setSize(500,500);
		frame1.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		String buttonclicked = e.getActionCommand();
		
		if(buttonclicked == "Create"){
			
			currentbook = new AddressBook();
			addressList = new JList(currentbook);
			addressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			panel.add(addressList, BorderLayout.CENTER);
			addressList.setVisible(true);
			
			create.setEnabled(false);
			save.setEnabled(true);
			load.setEnabled(true);
			add.setEnabled(true);
			remove.setEnabled(true);
			edit.setEnabled(true);
			
		}
		else if(buttonclicked == "Save"){
			String s = "";
			
			DefaultListModel temp = currentbook.getStringList();
			for(int i=0; i<temp.size(); ++i){
				s+=(temp.get(i) +"   \n");
			}
			
			String filename = JOptionPane.showInputDialog("Enter Filename w/ extension:  (ex. output.txt)");
			
			try{BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(s);
			
			out.close();
			}
			catch(IOException ae){
				ae.printStackTrace();
			}
			
		}
		else if(buttonclicked == "Display"){
			addressList.setModel(currentbook);
			
		}
		else if(buttonclicked == "Add"){
			String name= JOptionPane.showInputDialog("Enter Name:");
			String address= JOptionPane.showInputDialog("Enter Address:");
			String phone_num= JOptionPane.showInputDialog("Enter Phone Number:");
			BuddyInfo temp = new BuddyInfo();
			temp.setName(name);
			temp.setAddress(address);
			temp.setPhone_num(phone_num);
			currentbook.addBuddy(temp);
		}
		
		else if(buttonclicked == "Remove"){
			currentbook.removeBuddy((BuddyInfo)addressList.getSelectedValue());
		}
		
		else if(buttonclicked == "Edit"){
			String name= JOptionPane.showInputDialog("Enter Name:");
			String address= JOptionPane.showInputDialog("Enter Address:");
			String phone_num= JOptionPane.showInputDialog("Enter Phone Number:");
			BuddyInfo temp = new BuddyInfo();
			temp.setName(name);
			temp.setAddress(address);
			temp.setPhone_num(phone_num);
			currentbook.removeBuddy((BuddyInfo)addressList.getSelectedValue());
			currentbook.addBuddy(temp);
		}
		
	}
	
	
}
