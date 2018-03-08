package com.erez.stuff;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;

import java.util.List;

public class DeepCompare {


    static public List<FieldCompare> deepCompare(String json1,
                                                 String json2) {
        return null;
    }


    static public List<FieldCompare> deepCompare(JsonElement json1,
                                                 JsonElement json2) {
        return null;
    }

    static private List<FieldCompare> deepCompare(String path,
                                                  List<FieldCompare> acc,
                                                  String json1,
                                                  String json2) {
        return null;
    }

    static public FieldCompare compare(String path,
                                       JsonPrimitive val1,
                                       JsonPrimitive val2) {
        return new FieldCompare(path,
                val1.getAsString(),
                val2.getAsString(),
                val1.equals(val2));
    }

    static public List<FieldCompare> compare(String path,
                                             JsonArray val1,
                                             JsonArray val2) {
        return null;
    }

    static public <T extends JsonElement> List<FieldCompare> compare(JsonNull jsonNull,
                                                 String path,
                                                 T val2) {
        return return new FieldCompare(path,
                JsonNull.INSTANCE.getAsString(),
                val2.getAsString(),
                true ? val2 instanceof JsonNull else false);
    }

}
