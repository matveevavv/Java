package lab1;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

public abstract class Clothes implements ICrudAction, Serializable {

    public UUID ID;
    public String name;
    int price;
    static int count;
    String firm;


    @Override
    public void create() {
        this.count++;
        RandomData rd = new RandomData();
        this.price = rd.randPrice();
        this.firm = rd.randNameFirm();
    }

    @Override
    public void read() {
        System.out.println("Счётчик товаров: " + count);
        System.out.println("ID товара: " + this.ID);
        System.out.println("Название: " + this.name);
        System.out.println("Цена: " + this.price);
        System.out.println("Фирма-производитель: " + this.firm);
    }

    @Override
    public void update() {
        this.count++;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название: ");
        this.name = in.nextLine();
        System.out.println("Введите цену: ");
        this.price = in.nextInt();
        System.out.println("Введите фирму-производитель: ");
        in.nextLine();
        this.firm = in.nextLine();
    }

    @Override
    public void delete() {
        this.count--;
        this.name = "";
        this.price = 0;
        this.firm = "";
    }
    public UUID getUUID(){
        return ID;
    }

}