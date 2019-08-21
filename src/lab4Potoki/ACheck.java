package lab4Potoki;

import java.io.Serializable;

abstract public class ACheck implements Runnable, Serializable {

    public boolean fRun = true;
    public long pause = 1000;
    private Orders orders;

    public ACheck(Orders orders) {
        this.orders = orders;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
