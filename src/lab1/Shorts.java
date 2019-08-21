package lab1;

import lab1.Clothes;
import lab1.RandomData;

import java.io.Serializable;
import java.util.UUID;

public class Shorts extends Clothes implements Serializable {

    public Shorts() {

        ID = UUID.randomUUID();
        this.name = "";
        this.price = 0;
        this.firm = "";
    }

    //перегруз
    Shorts(UUID ID, String name, float price, String firm) {

        this.name = "";
        this.price = 0;
        this.firm = "";
    }

    @Override

    public void create() {
        super.create();
        RandomData rd = new RandomData();
        this.name = rd.randNameShorts();

    }

    @Override
    public void read() {
        super.read();
    }

    @Override
    public void delete() {
        super.delete();
    }
}
