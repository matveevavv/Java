package lab5LocalFiles;

import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.io.*;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {

    public ManagerOrderFile() {
        saveFile = new File("/home/latty/java/saveFile.bin");
    }

    @Override
    public Order readByID(UUID ID) throws IOException, ClassNotFoundException {
        Order order = null;
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(saveFile.getAbsoluteFile()));
        if (!saveFile.exists()){
            return null;
        }
        order = (Order) oin.readObject();
        return order;
    }

    @Override
    public void saveByID(Order order) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile.getAbsoluteFile()));
        if (!saveFile.exists()){
            saveFile.createNewFile();
        }
        oos.writeObject(order);
        oos.flush();
        oos.close();
    }

    @Override
    public Object readAll() throws IOException, ClassNotFoundException {
        //Orders orders = null;
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(saveFile.getAbsoluteFile()));
        if (!saveFile.exists()){
            return null;
        }
//        orders = (Orders) oin.readObject();
//        return orders;
        return oin.readObject();
    }

    @Override
    public void saveAll(Orders orders) throws IOException {
        ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream(saveFile.getAbsoluteFile()));
        if (!saveFile.exists()){
            saveFile.createNewFile();
        }
        fos.writeObject(orders);
        fos.flush();
        fos.close();
    }
}
