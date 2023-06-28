package Program;

import java.util.*;

public class Functions {
    List<contact> contacts = new ArrayList();

    public Functions(List<contact> contacts){
        this.contacts = contacts;
    }

    public void add(Scanner scan){
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Surname:");
        String surname = scan.nextLine();
        System.out.println("Mail:");
        String mail = scan.nextLine();
        System.out.println("Number:");
        String number = scan.nextLine();
        System.out.println("help(.h),add(.a),create(.c),update(.u),delete(.d),sort(.srt),search(.sr),exit(.e)");
        contacts.add(new contact(name, surname, mail, number));
    }
    public void list(Scanner scan){
        for(contact i : contacts){
            System.out.println(i.getName() + " " + i.getSurname() + " " + i.getMail() + " " + i.getNumber());
        }
    }
    public void update(Scanner scan){
        System.out.println("Який елемент?");
        int el = scan.nextInt();
        String c = scan.nextLine();
        System.out.println("Name:");
        String name = scan.nextLine();
        System.out.println("Surname:");
        String surname = scan.nextLine();
        System.out.println("Mail:");
        String mail = scan.nextLine();
        System.out.println("Number:");
        String number = scan.nextLine();

        contacts.set((el-1), new contact(name, surname, mail, number));
    }
    public void delete(Scanner scan){
        System.out.println("який елемент?");
        int l = scan.nextInt();
        String c = scan.nextLine();
        contacts.remove(l-1);
    }
    public void sort(Scanner scan){
        Collections.sort(contacts, new Comparator<contact>() {
            @Override
            public int compare(contact o1, contact o2) {

                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Просортовано");
    }
    public void search(Scanner scan){
        System.out.println("Введіть ім'я");
        String d = scan.nextLine();
        for(contact a : contacts){
            if(a.getName().contains(d)){
                System.out.println(a.getName()+" " +a.getSurname()+" " +a.getMail()+" " +a.getNumber() );
            }
        }
    }
}
