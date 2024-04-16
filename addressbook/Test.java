package addressbook;
import java.util.ArrayList;
import javax.swing.*;

class PersonInfo {

    String name;
    String address;
    String phoneNumber;

    PersonInfo(String n, String a, String p) {

        name = n;
        address = a;
        phoneNumber = p;
    }

    // display on the GUI
    void display() {

        JOptionPane.showMessageDialog(null, "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber);

    }
}

class AdressBook{

    ArrayList persons;

    AdressBook() {

        persons = new ArrayList();

    }

    // add person
    void addPerson() {

        String name = JOptionPane.showInputDialog("Enter name: ");
        String address = JOptionPane.showInputDialog("Enter address: ");
        String phoneNo = JOptionPane.showInputDialog("Enter Phone Number: ");

        // create the person
        PersonInfo p = new PersonInfo(name, address, phoneNo);
        persons.add(p);

    }

    // search a specific person
    void SearchPerson(String n) {

        for(int i=0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if(n.equals(p.name)) {
                p.display();
            }
        }
    }

    // delete a specific person
    void deletePerson(String n) {
        for(int i=0; i<persons.size();i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if(n.equals(p.name)) {
                persons.remove(i);
            }
        }
    }
}

    



public class Test {

    public static void main(String[] args) {
        
        AdressBook ab = new AdressBook();
        String input, s;
        int choice;


        while(true) {

            input = JOptionPane.showInputDialog("1 - Add person\n2 - Show person\n3 - Delete person\n4 - Exit\n");
            choice = Integer.parseInt(input);

            switch(choice) {

                case 1:
                    ab.addPerson();
                    break;
                
                case 2:
                    s = JOptionPane.showInputDialog("Enter name to search: ");
                    ab.SearchPerson(s);
                    break;
                
                case 3:
                    s = JOptionPane.showInputDialog("Enter name to delete: ");
                    ab.deletePerson(s);
                    break;
                
                case 4:
                    System.exit(0);

            }
        }
    }
    
}
