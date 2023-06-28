package Program;

public class contact {
    String name;
    String surname;
    String mail;
    String number;


    public contact(String name, String surname, String mail, String number){
        this.name=name;
        this.surname=surname;
        this.mail = mail;
        this.number = number;
    }
    public String getName(){

        return name;
    }
    public String getSurname(){

        return surname;
    }
    public String getMail(){

        return mail;
    }
    public String getNumber(){

        return number;
    }
}