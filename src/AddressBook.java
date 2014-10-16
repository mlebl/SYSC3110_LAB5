
import java.util.*;

import javax.swing.DefaultListModel;

public class AddressBook extends DefaultListModel {
	
	public AddressBook(){
		super();
	}
	
	public void addBuddy(BuddyInfo buddy){
		super.addElement(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		super.removeElement(buddy);
	}
	
	public DefaultListModel getStringList(){
		DefaultListModel temp = new DefaultListModel();
		for(int i=0;i<super.size();++i){
			temp.addElement(super.get(i).toString());
		}
		return(temp);
	}
		
}


