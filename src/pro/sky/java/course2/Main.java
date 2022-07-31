package pro.sky.java.course2;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        StringList strings = new StringListImpl();
        System.out.println(strings.add("Ksusha"));
        System.out.println(strings.add("Vitaly"));
        System.out.println(strings.add("Lea"));
        System.out.println(strings.add("Stark"));
        System.out.println(strings.add("Rachel"));
        System.out.println(strings.add("Belle"));
        strings.toString();
        System.out.println("strings = " + strings);
        System.out.println(strings.add(3, "Lev"));
        System.out.println("strings = " + strings);
        System.out.println(strings.set(0, "Vitaly"));
        System.out.println(strings.set(1, "Ksusha"));
        System.out.println("strings = " + strings);
        System.out.println(strings.remove("Vitaly"));
        System.out.println("strings = " + strings);
        System.out.println(strings.add(0, "Vitaly"));
        System.out.println("strings = " + strings);
        System.out.println(strings.add("R"));
        System.out.println("strings = " + strings);
        System.out.println(strings.remove(7));
        System.out.println("strings = " + strings);
        System.out.println(strings.contains("L"));
        System.out.println("strings = " + strings);
        System.out.println(strings.indexOf("Belle"));
        StringList anotherArray = new StringListImpl();
        System.out.println(anotherArray.add("Ksusha"));
        System.out.println(anotherArray.add("Vitaly"));
        System.out.println(anotherArray.add("Lea"));
        System.out.println(anotherArray.add("Stark"));
        System.out.println(anotherArray.add("Rachel"));
        System.out.println(anotherArray.add("Belle"));
        System.out.println(anotherArray.add(3, "Lev"));
        System.out.println(anotherArray.set(0, "Vitaly"));
        System.out.println(anotherArray.set(1, "Ksusha"));
        System.out.println(anotherArray.toString());
        System.out.println(strings.equals(anotherArray));
        System.out.println(anotherArray.size());
        System.out.println(anotherArray.isEmpty());
        StringList emptyArray = new StringListImpl();
        System.out.println(emptyArray.isEmpty());
        anotherArray.clear();
        System.out.println(anotherArray);
        strings.toArray();
        System.out.println(strings.toString());
        System.out.println(strings.get(3));
    }
}