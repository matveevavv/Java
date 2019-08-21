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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public final class OrderDeserializer implements JsonDeserializer<Order> {

    @Override
    public Order deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();

        UUID id = UUID.fromString(jsonObj.get("ID").getAsString());
        OrderStatus status = OrderStatus.valueOf(jsonObj.get("status").getAsString());

        Date timeCreate = null;
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        try {
            timeCreate = new Date(format.parse(jsonObj.get("timeCreate").getAsString()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        var timeWaiting = jsonObj.get("timeWaiting").getAsLong();

        Type typecart = new TypeToken<ShoppingCart<Clothes>>() {
        }.getType();

        ShoppingCart<Clothes> cart = context.deserialize(jsonObj.get("cart"), typecart);
        Credentials user = new Gson().fromJson(jsonObj.get("user"), Credentials.class);
        return new Order(id, cart, user, status, timeCreate, timeWaiting);


    }
}
