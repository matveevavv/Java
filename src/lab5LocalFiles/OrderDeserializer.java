package lab5LocalFiles;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lab1.Clothes;
import lab23CollectionsGenerics.Credentials;
import lab23CollectionsGenerics.Order;
import lab23CollectionsGenerics.OrderStatus;
import lab23CollectionsGenerics.ShoppingCart;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public final class OrderDeserializer implements JsonDeserializer<Order> {

    @Override
    public Order deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();

        UUID id = UUID.fromString(jsonObj.get("ID").getAsString());
        var status = OrderStatus.valueOf(jsonObj.get("Статус").getAsString());

        Date timeCreate = null;
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        try {
            timeCreate = new Date(format.parse(jsonObj.get("Дата создания").getAsString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        var timeWaiting = jsonObj.get("Ожидание").getAsLong();

        Type typecart = new TypeToken<ShoppingCart<Clothes>>() {
        }.getType();

        ShoppingCart<Clothes> cart = context.deserialize(jsonObj.get("Карта покупателя"), typecart);
        Credentials user = new Gson().fromJson(jsonObj.get("Покупатель"), Credentials.class);
        return new Order(id, cart, user, status, timeCreate, timeWaiting);
    }
}
