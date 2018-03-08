package com.erez.stuff;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeepCompare {

    private Gson gson = null;

    private Gson gson() throws Exception {
        if (this.gson == null)
            throw new Exception("No instanc of Gson object given: new DeepCompare(new Gson())");
        else
            return gson;
    }

    static public List<FieldCompare> deepCompare(String json1,
                                                 String json2) {
        return null;
    }


    static public List<FieldCompare> deepCompare(JsonElement json1,
                                                 JsonElement json2) {
        return deepCompare(
                "",
                new ArrayList<FieldCompare>(),
                json1,
                json2);
    }

    static private List<FieldCompare> deepCompare(String path,
                                                  List<FieldCompare> acc,
                                                  JsonElement json1,
                                                  JsonElement json2) {


        return null;
    }

    static public FieldCompare compare(String path,
                                       JsonPrimitive val1,
                                       JsonPrimitive val2) {
        return new FieldCompare(
                path,
                val1.getAsString(),
                val2.getAsString(),
                val1.equals(val2));
    }

    static public FieldCompare compare(String path,
                                       JsonArray val1,
                                       JsonArray val2) {
        // TODO - naive comparison of JsonArray but it would be nice to evolve to a comparison by cell
        return new FieldCompare(
                path,
                val1.getAsString(),
                val2.getAsString(),
                val1.equals(val2));
    }

    static public <T extends JsonElement> FieldCompare compare(JsonNull jsonNull,
                                                               String path,
                                                               T val2) {
        return new FieldCompare(
                path,
                JsonNull.INSTANCE.getAsString(),
                val2.getAsString(),
                val2 instanceof JsonNull);
    }

}
