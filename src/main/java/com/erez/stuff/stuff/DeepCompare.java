package com.erez.stuff.stuff;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class DeepCompare {

    public DeepCompare(Gson gson) {
        this.gson = gson;
    }

    private Gson gson = null;

    public List<FieldCompare> deepCompare(String json1,
                                          String json2) {

        return this.gson == null ?
                new ArrayList<>() :
                deepCompare(
                        gson.toJsonTree(json1),
                        gson.toJsonTree(json2)
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
        // base case: json1 is a primitive
        if (json1 instanceof JsonPrimitive) {
            acc.add(compare(path, (JsonPrimitive) json1, json2));
            return acc;
        }

        // for the moment the array is just like a base case
        if (json1 instanceof JsonArray) {
            acc.add(compare(path, (JsonArray) json1, json2));
            return acc;
        }

        // for the moment the array is just like a base case
        if (json1 instanceof JsonNull) {
            acc.add(compare(path, JsonNull.INSTANCE, json2));
            return acc;
        }

        // ...then it must be an JsonObject
        //        ((JsonObject) json1).entrySet().stream().
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

    static public <T extends JsonElement> FieldCompare compare(String path,
                                                               JsonNull jsonNull,
                                                               T val2) {
        return new FieldCompare(
                path,
                jsonNull.getAsString(),
                val2.getAsString(),
                val2 instanceof JsonNull);
    }


    static public <T extends JsonElement> FieldCompare compare(String path,
                                                               JsonPrimitive val1,
                                                               T val2) {
        return new FieldCompare(
                path,
                val1.getAsString(),
                val2.getAsString(),
                val1.equals(val2));
    }


    static public <T extends JsonElement> FieldCompare compare(String path,
                                                               JsonArray val1,
                                                               T val2) {
        return new FieldCompare(
                path,
                val1.getAsString(),
                val2.getAsString(),
                val1.equals(val2));
    }

}
