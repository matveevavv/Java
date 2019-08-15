package lab5LocalFiles;

import com.google.gson.*;
import lab1.Caps;
import lab1.Clothes;
import lab1.Shorts;

import java.lang.reflect.Type;

public class ClothesDeserializer implements JsonDeserializer<Void> {
    @Override
    public Void deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.has("ident")){
            return context.deserialize(jsonObject, Caps.class);
        }
        else {
            return context.deserialize(jsonObject,
                    Shorts.class);
        }
   }
}
