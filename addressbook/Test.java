
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

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
        loadPerson();

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

    // save persons in a file
    void savePerson() {

        try {
            PersonInfo p;
            String line;
            FileWriter fw = new FileWriter("persons.txt");
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i< persons.size(); i++) {

                p = (PersonInfo) persons.get(i);
                line = p.name + ","+ p.address + "," + p.phoneNumber;
                
                pw.println(line);
            }
            pw.flush();
            fw.close();
            pw.close();

        } catch(IOException e) {

            System.out.println("Something went wrong!");
        }
    }

    // load persons from the file
    void loadPerson() {
        String tokens[];
        String na,ad,ph;
        PersonInfo p;

        try {
        FileReader fr = new FileReader("persons.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while(line!=null) {
        tokens = line.split(",");
        na = tokens[0];
        ad = tokens[1];
        ph = tokens[2];

        
        p = new PersonInfo(na, ad, ph);
        persons.add(p);
        line = br.readLine();
        } 
        br.close();
        fr.close();

        } catch(IOException e) {

            System.out.println("Persons file does not exist!");
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
                    ab.savePerson();
                    System.exit(0);

            }
        }
    }
    
}
