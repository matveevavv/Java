package lab23CollectionsGenerics;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

public class Credentials implements Serializable {
    UUID ID;
    private String lastName;
    private String firstName;
    private String middleName;
    private String email;

    public Credentials(String lastName, String firstName, String middleName, String email){
 //   public lab23CollectionsGenerics.Credentials() {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.email = email;
        this.ID = UUID.randomUUID();
    }


    public void update() {
        Scanner in = new Scanner(System.in);
        System.out.println("Фамилия:");
        this.lastName = in.nextLine();
        System.out.println("Имя:");
        this.firstName = in.nextLine();
        System.out.println("Отчество:");
        this.middleName = in.nextLine();
        System.out.println("e-mail:");
        in.nextLine();
        this.email = in.nextLine();
    }

    public void show(){
        System.out.println("ID:"+ID);
        System.out.println("Фамилия:"+lastName);
        System.out.println("Имя:"+firstName);
        System.out.println("Отчество:"+middleName);
        System.out.println("e-mail:"+email);
    }
}
