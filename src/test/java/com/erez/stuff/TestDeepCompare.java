package com.erez.stuff;

import com.erez.stuff.stuff.DeepCompare;
import com.erez.stuff.stuff.FieldCompare;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestDeepCompare  {

    private DeepCompare dp = new DeepCompare(new Gson());

    @Test
    public void dummy() {
        assertTrue(true);
    }

    @Test
    public void simplePrimitive(){
        String val1 = "toto";
        String val2 = "toto";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertTrue(a.get(0).getCmp());
    }

    @Test
    public void simpleArray(){
        String val1 = "[1,2,3,4]";
        String val2 = "[1,2,3,4]";
        List<FieldCompare> a = dp.deepCompare(val1,val2);
        assertEquals(1, a.size());
        assertTrue(a.get(0).getCmp());
    }
}
