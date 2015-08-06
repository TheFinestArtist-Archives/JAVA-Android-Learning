public class AllTypesSerializer implements JsonSerializer<AllTypes> {

    @Override
    public JsonElement serialize(AllTypes src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("columnString", src.getColumnString());
        jsonObject.addProperty("columnLong", src.getColumnLong());
        jsonObject.addProperty("columnFloat", src.getColumnFloat());
        jsonObject.addProperty("columnDouble", src.getColumnDouble());
        jsonObject.addProperty("columnBoolean", src.isColumnBoolean());
        jsonObject.addProperty("columnDate", DateUtil.getDateFormat(src.getColumnDate()));
        jsonObject.add("columnBinary", context.serialize(src.getColumnBinary()));
        jsonObject.add("columnRealmObject", context.serialize(src.getColumnRealmObject()));
        jsonObject.add("columnRealmList", context.serialize(src.getColumnRealmList()));

        return jsonObject;
    }
}
