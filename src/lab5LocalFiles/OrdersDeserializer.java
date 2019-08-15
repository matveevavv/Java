package lab5LocalFiles;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lab1.Caps;
import lab23CollectionsGenerics.Order;
import lab4Potoki.Orders;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.LinkedList;

public final class OrdersDeserializer implements JsonDeserializer<Orders> {

    @Override
    public Orders deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();

        Type typeList = new TypeToken<LinkedList<Order>>(){}.getType();
        LinkedList<Order> list = context.deserialize(jsonObj.get("map"), typeList);
        HashMap<Date, Order> map = new HashMap<>();
        for (Order item: list) {
            map.put(item.getTimeCreate(), item);
        }
        return new Orders(list, map);
    }
}