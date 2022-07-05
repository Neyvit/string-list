package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.NullStringException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final int DEFAULT_CAPACITY = 20;
    private int size;


    private String[] stringArray;

    public StringListImpl(int size) {
        stringArray = new String[size];
    }

    public StringListImpl() {
        stringArray = new String[DEFAULT_CAPACITY];
    }


    public String[] getStringArray() {
        return stringArray;
    }

//    public StringListImpl(StringListImpl[] myStringList) {
//        this.myStringList = myStringList;
//    }


    @Override
    public String add(String item) {
        if (item != null) {
            return item;
        } else throw new NullStringException();
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > DEFAULT_CAPACITY) {
            throw new NullStringException();
        }
        for (int i = index; i < DEFAULT_CAPACITY - 1; i++) {
            stringArray[i + 1] = stringArray[i];
            stringArray[i] = item;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index > DEFAULT_CAPACITY) {
            throw new NullStringException();
        }
        stringArray[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (item == stringArray[i]) {
                stringArray[i] = stringArray[i + 1];
                i++;
            } else throw new NullStringException();
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (stringArray[index] == null) {
            throw new NullStringException();
        }else
        for (int i = index; i < DEFAULT_CAPACITY; i++) {
            stringArray[i] = stringArray[i + 1];
            i++;
        }
        return stringArray[index];
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (item == stringArray[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (item == stringArray[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = DEFAULT_CAPACITY - 1; i >= 0; i--) {
            if (item == stringArray[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (index < 0 || index > DEFAULT_CAPACITY) {
                throw new NullStringException();
            }
        }
        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NegativeArraySizeException();
        }
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (stringArray[i] == otherList.toArray()[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return stringArray.length + 1;
    }

    @Override
    public boolean isEmpty() {
        if (stringArray.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringArray = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArray,DEFAULT_CAPACITY);
    }
}
