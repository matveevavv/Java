package lab5LocalFiles;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lab1.Caps;
import lab1.Clothes;
import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class OrdersDeserializer implements JsonDeserializer<Orders> {
    Type typeList;
    LinkedList<Order> list;
    HashMap<Date, Order> map;

    @Override
    public Orders deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();
        typeList = new TypeToken<LinkedList<Order>>(){}.getType();
        list = context.deserialize(jsonObj.get("orders"), typeList);
        map = new HashMap<>();
        for (Order item: list) {
            map.put(item.getTimeCreate(), item);
        }
        return new Orders(list, map);


    }
}