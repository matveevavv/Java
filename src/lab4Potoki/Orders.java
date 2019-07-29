package lab4Potoki;

import lab23CollectionsGenerics.Credentials;
import lab23CollectionsGenerics.Order;
import lab23CollectionsGenerics.OrderStatus;
import lab23CollectionsGenerics.ShoppingCart;

import java.util.*;


public class Orders<T extends Order> {

    private LinkedList<T> orders;
    private Map<Date, T> dateOrder;

    public Orders() {

        this.orders = new LinkedList<>();
        this.dateOrder = new HashMap<>();
    }

    void addOrders(T object) {
        this.orders.add(object);
    }

    void deleteOrders(T object) {
        this.orders.remove(object);
    }

    public void offer(ShoppingCart cart, Credentials user) {
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getTimeCreate(), (T) order);
        cart.sokrashenyiShow();
    }

    public void checkTime() {
        synchronized(orders) {
            Iterator it = orders.iterator();
            while (it.hasNext()) {
                Order order = (Order) it.next();

            if (order.getStatus() == OrderStatus.WAITING &&
                    order.checkInterval(System.currentTimeMillis())) {
                order.setStatus(OrderStatus.DONE);
                System.out.println("------");
                System.out.println("Check time");
                System.out.println("------");
            }
        }
    }}

    public void checkDone() {

        synchronized (orders) {
            Iterator it = orders.iterator();
            while (it.hasNext()) {
                Order order = (Order) it.next();
                if (order.getStatus() == OrderStatus.DONE) {
                    //orders.remove(order);//зарыта соббака
                    it.remove();
                    System.out.println("------");
                    System.out.println("Delete order");
                    System.out.println("------");
                }
            }
        }
    }

    public void show() {
        for (Order order : orders) {
            order.show();
        }
    }
}