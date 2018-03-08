package com.erez.stuff;

import com.erez.stuff.stuff.DeepCompare;
import com.erez.stuff.stuff.FieldCompare;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class TestDeepCompare  {

    private DeepCompare dp = new DeepCompare(new JsonParser());

    @Test
    public void dummy() {
        assertTrue(true);
    }

    @Test
    public void simplePrimitiveIdentical(){
        String val1 = "toto";
        String val2 = "toto";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertTrue(a.get(0).getCmp());
    }

    @Test
    public void simplePrimitiveDifferent(){
        String val1 = "toto";
        String val2 = "tata";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertFalse(a.get(0).getCmp());
    }

    @Test
    public void simpleArrayIdentical(){
        String val1 = "[1,2,3,4]";
        String val2 = "[1,2,3,4]";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertTrue(a.get(0).getCmp());
    }

    @Test
    public void simpleArrayDifferent(){
        String val1 = "[1,2,3,4]";
        String val2 = "[1,2,3,5]";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertFalse(a.get(0).getCmp());
    }

}
