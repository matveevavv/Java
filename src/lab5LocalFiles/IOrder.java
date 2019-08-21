package lab5LocalFiles;

import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.io.IOException;
import java.util.UUID;

public interface IOrder {

    Order readByID(UUID ID) throws IOException, ClassNotFoundException;

    void saveByID(Order order) throws IOException;

    Orders readAll() throws IOException, ClassNotFoundException;

    void saveAll(Orders orders) throws IOException;

}
