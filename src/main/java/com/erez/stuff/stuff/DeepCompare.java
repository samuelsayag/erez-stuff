package com.erez.stuff.stuff;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class DeepCompare {

    public DeepCompare(JsonParser parser) {
        this.parser = parser;
    }

    private JsonParser parser = null;

    public List<FieldCompare> deepCompare(String json1,
                                          String json2) {

        return this.parser == null ?
                new ArrayList<>() :
                deepCompare(
                        parser.parse(json1),
                        parser.parse(json2)
                );
    }


    public List<FieldCompare> deepCompare(JsonElement json1,
                                          JsonElement json2) {
        return deepCompare(
                "",
                new ArrayList<>(),
                json1,
                json2);
    }

    private List<FieldCompare> deepCompare(String path,
                                           List<FieldCompare> acc,
                                           JsonElement json1,
                                           JsonElement json2) {
        if (json1.isJsonPrimitive()) {
            acc.add(compare(path, json1.getAsJsonPrimitive(), json2));
            return acc;
        }

        if (json1.isJsonArray()) {
            acc.add(compare(path, json1.getAsJsonArray(), json2));
            return acc;
        }

        // for the moment the array is just like a base case
        if (json1.isJsonNull()) {
            acc.add(compare(path, json1.getAsJsonNull(), json2));
            return acc;
        }

        // ...then it must be an JsonObject
//        ((JsonObject) json1).entrySet().stream().map(entry -> {
//            String updatedPath = String.format("%s / %s", path, entry.getKey());
//            return null;
//        });
        // flatMap( [... map each JsonElement to a List<FieldCompare> ...] ).
        // reduce( [... reduce to one List<FieldCompare>] ... )

        return null;
    }


//    static public FieldCompare compare(String path,
//                                       JsonPrimitive val1,
//                                       JsonPrimitive val2) {
//        return new FieldCompare(
//                path,
//                val1.getAsString(),
//                val2.getAsString(),
//                val1.equals(val2));
//    }

    static public FieldCompare compare(String path,
                                       JsonNull jsonNull,
                                       JsonElement val2) {
        return new FieldCompare(
                path,
                jsonNull.toString(),
                jeToString(val2),
                val2.isJsonNull());
    }


    static public FieldCompare compare(String path,
                                       JsonPrimitive val1,
                                       JsonElement val2) {
        return new FieldCompare(
                path,
                val1.toString(),
                jeToString(val2),
                val1.equals(val2));
    }


    static public FieldCompare compare(String path,
                                       JsonArray val1,
                                       JsonElement val2) {
        System.out.println(val1.toString());
        return new FieldCompare(
                path,
                val1.toString(),
                jeToString(val2),
                val1.equals(val2));
    }

    static public String jeToString(JsonElement je){
        return je == null ? "null" : je.toString();
    }

}
