package lab1;

import java.util.UUID;

public class Caps extends Clothes {

    public Caps() {

        ID = UUID.randomUUID();
        this.name = "";
        this.price = 0;
        this.firm = "";

    }

    //перегруз
    Caps(UUID ID, String name, float price, String firm) {

        this.name = "";
        this.price = 0;
        this.firm = "";

    }

    @Override
    public void create() {
        super.create();
        RandomData rd = new RandomData();
        this.name = rd.randNameCaps();


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

