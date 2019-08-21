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
    public static final String PATH = "/home/latty/java/saveFile.json";
    private final Gson json;

    public ManagerOrderJSON() {
        saveFile = new File(PATH);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Clothes.class, new ClothesDeserializer())
                .registerTypeAdapter(Order.class, new OrderDeserializer())
                .registerTypeAdapter(Orders.class, new OrdersDeserializer());
        json = gsonBuilder.setPrettyPrinting().create();
    }

    @Override
    public Order readByID(UUID id) {
        Order order = new Order();
        try (FileReader reader = new FileReader(PATH)) {
            if (!saveFile.exists()) {
                return null;
            }
            Type type = new TypeToken<Order>() {
            }.getType();
           order = json.fromJson(reader, type);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    @Override
    public void saveByID(Order order) {
        try (FileWriter writer = new FileWriter(PATH))
        {
            if (saveFile.exists()) {
                json.toJson(order, writer);
            } else {
                saveFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Orders readAll() throws FileNotFoundException, NullPointerException {
        Orders orders = null;
        FileReader read = new FileReader(PATH);
        if (!saveFile.exists()) {
            return null;
        }
        Type type = new TypeToken<Orders<Order>>() {
        }.getType();
        orders = json.fromJson(read, type);
        return orders;
    }

    @Override
    public void saveAll(Orders orders) {
        try (FileWriter writer = new FileWriter(PATH)) {
            if (saveFile.exists()) {
                json.toJson(orders, writer);
            } else {
                saveFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
