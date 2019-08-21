package lab4Potoki;

import lab1.Shorts;
import lab23CollectionsGenerics.Credentials;
import lab1.Caps;
import lab23CollectionsGenerics.ShoppingCart;

import java.io.Serializable;

public class Generator extends ACheck implements Serializable {

    public Generator (Orders orders){
        super(orders);
    }

    @Override
    public void run(){
        while (fRun) {
        Orders orders = getOrders();
        ShoppingCart cart = new ShoppingCart();
            Shorts[] arrayShorts = new Shorts[3];
            Caps[] arrayCaps = new Caps[3];
            for (int i = 0; i < 3; i++) {
                arrayCaps[i] = new Caps();
                arrayCaps[i].create();
//                arrayCaps[i].read();
                cart.add(arrayCaps[i]);

                arrayShorts[i] = new Shorts();
                arrayShorts[i].create();
//                arrayShorts[i].read();
                cart.add(arrayShorts[i]);

            }

            Credentials user = new Credentials("Иванов", "Иван", "Иваныч", "ivanov@mail.ru");
            synchronized (orders){
                orders.offer(cart, user);
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
