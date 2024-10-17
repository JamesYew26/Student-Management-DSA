package adt;

import java.util.Comparator;

public interface ListInterface<T> {

    public boolean add(T newEntry);

    public boolean add(int newPosition, T newEntry);

    public T remove(int givenPosition);

    public void clear();

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);

    public boolean contains(int givenPosition);

    public int getNumberOfEntries();

    public int getArraylength();

    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void mergeSort(Comparator<T> comparator);
}
