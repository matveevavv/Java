package lab23CollectionsGenerics;

import lab1.Clothes;
import lab23CollectionsGenerics.Credentials;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

public class Order implements Serializable {

    public UUID ID;
    private ShoppingCart cart;
    private Credentials user;
    private OrderStatus status;
    private Date timeCreate;
    private long timeWaiting;

    public Order(ShoppingCart cart, Credentials user) {
        this.ID = UUID.randomUUID();
        this.cart = cart;
        this.user = user;
        status = OrderStatus.WAITING;
        timeCreate = new Date(System.currentTimeMillis());
        timeWaiting = (int) (Math.random() * 1000);
    }

    public Order(UUID id, ShoppingCart<Clothes> cart, Credentials user, OrderStatus status, Date timeCreate, long timeWaiting) {

        this.ID = ID;
        this.status = status;
        this.timeCreate = timeCreate;
        this.timeWaiting = timeWaiting;
        this.cart = cart;
        this.user = user;
    }


    public OrderStatus getStatus() {

        return status;
    }

    public Date getTimeCreate() {

        return timeCreate;
    }

    public long getTimeWaiting() {

        return timeWaiting;
    }

    public void setStatus(OrderStatus status) {

        this.status = status;
    }


    public long getInterval() {

        return timeCreate.getTime() + timeWaiting;
    }

    public boolean checkInterval(long time) {
        if ((timeCreate.getTime() + timeWaiting) < time) {
            return true;
        } else
            return false;
    }

    public UUID getUUID() {
        return this.ID;
    }

    public void show() {
        System.out.println("Заказчик:");
        user.show();
        System.out.println("-------");
        System.out.println("Заказ:");
        cart.show();
        System.out.println("-------");
        System.out.println("Статус заказа:" + status);
        System.out.println("Время создания:" + timeCreate);
        System.out.println("Время ожидания:" + timeWaiting);
    }
}
