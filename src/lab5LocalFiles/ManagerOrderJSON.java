package lab5LocalFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lab1.Clothes;
import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.io.*;
import java.lang.reflect.Type;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {
    private Gson json;

    public ManagerOrderJSON() {
        saveFile = new File("/home/latty/java/saveFile.json");

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Order.class, new OrderDeserializer())
                .registerTypeAdapter(Orders.class, new OrdersDeserializer())
                .registerTypeAdapter(Clothes.class, new ClothesDeserializer());
        json = gsonBuilder.setPrettyPrinting().create();
    }

    @Override
    public Order readByID(UUID ID) throws IOException, ClassNotFoundException {
        Order order = null;
        FileReader read = new FileReader(saveFile.getAbsoluteFile());
        if (!saveFile.exists()) {
            return null;
        }
        Type type = new TypeToken<Order>() {
        }.getType();
        order = json.fromJson(read, type);
        return order;
    }

    @Override
    public void saveByID(Order order) throws IOException {
        FileWriter write = new FileWriter(saveFile.getAbsoluteFile());
        if (!saveFile.exists()) {
            saveFile.createNewFile();
        }
        json.toJson(order, write);
    }

    @Override
    public Object readAll() throws FileNotFoundException, NullPointerException {
        FileReader read = new FileReader(saveFile.getAbsoluteFile());
        if (!saveFile.exists()) {
            return null;
        }
        Type type = new TypeToken<Orders<Order>>() {
        }.getType();
        return json.fromJson(read, type);
    }

    @Override
    public void saveAll(Orders orders) {
        try (FileWriter write = new FileWriter(saveFile.getAbsoluteFile())) {
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            json.toJson(orders, write);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
