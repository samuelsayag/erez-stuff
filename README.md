Json Deep Compare
=================

!!! In Building !!!

An skeleton project for a comparison of 2 json.

For usage see test at: [these tests](src/test/java/TestDeepCompare.java) 

It looks like:

```java
DeepCompare dp = new DeepCompare(new JsonParser());

String val1 = "{ \"id\" : 123 }";
String val2 = "{ \"id\" : 123 }";
List<FieldCompare> a = dp.deepCompare(val1,val2);

a.get(0) => // [path: root / id, val1: 123, val2: 123, comp: true]
```