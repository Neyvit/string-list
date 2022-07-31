package pro.sky.java.course2;

import pro.sky.java.course2.exceptions.InvalidIndexException;
import pro.sky.java.course2.exceptions.NullStringException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private static final int DEFAULT_CAPACITY = 20;
    private int size = 0;


    private String[] stringArray;

    public StringListImpl(int size) {
        stringArray = new String[size];
    }

    public StringListImpl() {
        stringArray = new String[DEFAULT_CAPACITY];
    }


    @Override
    public boolean validateItem(String item) {
        if (item == null) {
            throw new NullStringException();
        } else
            return true;
    }

    @Override
    public boolean validateIndex(int index) {
        if (index < 0 || index >= DEFAULT_CAPACITY - 1) {
            throw new InvalidIndexException();
        } else
            return true;
    }

    @Override
    public String add(String item) {
        if (size == stringArray.length) {
            throw new InvalidIndexException();
        } else if (validateItem(item) == true) {
            stringArray[size++] = item;
            return item;
        } else {
            throw new NullStringException();
        }
    }

    @Override
    public String add(int index, String item) {
        if (validateItem(item) == true && validateIndex(index) == true) {
                for (int i = size; i >= index; i--) {
                    stringArray[i + 1] = stringArray[i];
                }
            stringArray[index] = item;
            size++;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (validateIndex(index) == true && validateItem(item) == true) {
            stringArray[index] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) {
        if (validateItem(item) == true) {
            remove(indexOf(item));
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String temp = null;
        if (validateIndex(index) == true) {
            temp = stringArray[index];
            for (int i = index; i < size; i++) {
                stringArray[i] = stringArray[i + 1];
            }
            size--;
        }
        return temp;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (indexOf(item) != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size; i >= 0; i--) {
            if (item.equals(stringArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (validateIndex(index) == true) {
            return stringArray[index];
        } else {
            throw new InvalidIndexException();
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NegativeArraySizeException();
        }
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (Arrays.equals(this.toArray(), otherList.toArray())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        stringArray = new String[size = 0];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringArray, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(stringArray);
    }
}
