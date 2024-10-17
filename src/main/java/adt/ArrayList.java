package adt;

import java.util.Comparator;

public class ArrayList<T> implements ListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 2;
    private static int DOUBLE = 2;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            doubleArraySize();
        }
        array[numberOfEntries++] = newEntry;
        return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (isFull()) {
                doubleArraySize();
            }
            addSpace(newPosition);
            array[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

        if (!isEmpty()) {
            if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
                result = array[givenPosition - 1];
                if (givenPosition < numberOfEntries) {
                    removeSpace(givenPosition);
                }
                numberOfEntries--;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        numberOfEntries = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            array[givenPosition - 1] = newEntry;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = array[givenPosition - 1];
        }
        return result;
    }

    public boolean contains(T givenEntry) {
        boolean found = false;
        for (int index = 0; index < numberOfEntries; index++) {
            if (array[index].equals(givenEntry)) {
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public boolean contains(int givenPosition) {
        return givenPosition >= 1 && givenPosition <= numberOfEntries;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public int getArraylength() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == array.length;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += "----------" + (index + 1)
                    + "------------\n" + array[index] + "\n";
        }
        return outputStr;
    }

    private void addSpace(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeSpace(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    private void doubleArraySize() {
        int arraySize = array.length;
        T[] doubleArray = (T[]) new Object[arraySize * DOUBLE];
        for (int i = 0; i < numberOfEntries; i++) {
            doubleArray[i] = array[i];
        }
        array = doubleArray;
    }

    @Override
    public void mergeSort(Comparator<T> comparator) {
        if (isEmpty() || getNumberOfEntries() == 1) {
            return;
        }

        int middle = getNumberOfEntries() / 2;
        ArrayList<T> leftList = new ArrayList<>();
        ArrayList<T> rightList = new ArrayList<>();

        for (int i = 1; i <= middle; i++) {
            leftList.add(getEntry(i));
        }
        for (int i = middle + 1; i <= getNumberOfEntries(); i++) {
            rightList.add(getEntry(i));
        }
        leftList.mergeSort(comparator);
        rightList.mergeSort(comparator);

        merge(leftList, rightList, comparator);
    }

    private void merge(ArrayList<T> left, ArrayList<T> right, Comparator<T> comparator) {
        clear();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (comparator.compare(left.getEntry(1), right.getEntry(1)) <= 0) {
                add(left.remove(1));
            } else {
                add(right.remove(1));
            }
        }
        while (!left.isEmpty()) {
            add(left.remove(1));
        }
        while (!right.isEmpty()) {
            add(right.remove(1));
        }
    }

}
