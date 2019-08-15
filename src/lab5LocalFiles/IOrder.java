package lab5LocalFiles;

import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.io.IOException;
import java.util.UUID;

public interface IOrder {
    public  Order readByID(UUID ID) throws IOException, ClassNotFoundException;
    public  void saveByID(Order order) throws IOException;
    public Object readAll() throws IOException, ClassNotFoundException;
    public  void saveAll(Orders orders) throws IOException;

}
