package com.erez.stuff;

public class FieldCompare {
    
    public FieldCompare(String jsonPath, String val1, String val2, Boolean cmp) {
        this.jsonPath = jsonPath;
        this.val1 = val1;
        this.val2 = val2;
        this.cmp = cmp;
    }

    String jsonPath = null;
    String val1 = null;
    String val2 = null;
    Boolean cmp = false;

    public String getJsonPath() {
        return jsonPath;
    }

    public String getVal1() {
        return val1;
    }

    public String getVal2() {
        return val2;
    }

    public Boolean getCmp() {
        return cmp;
    }
}
