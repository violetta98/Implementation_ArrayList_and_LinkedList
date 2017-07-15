package mycompany.Implementation_ArrayList_and_LinkedList.List.ArrayList;

import mycompany.Implementation_ArrayList_and_LinkedList.List.Iterator.Iterator;
import mycompany.Implementation_ArrayList_and_LinkedList.List.List;

import java.util.ConcurrentModificationException;

/**
 * Created by Violetta Podvolotskaya on 14-07-2017.
 */

/**
 * This class describes list with array implementation.
 * Class ArrayList implements List.
 * @param <T>
 */
public class ArrayList<T> implements List<T> {
    /**
     * It is real size of array.
     */
    private int size;

    /**
     * It is current size of array (curSize <= size).
     */
    private int curSize;

    /**
     * It is array for data storage in list.
     */
    private T array[];

    /**
     * It is default constructor. At first we believe that size (real size of array) equals 10.
     */
    public ArrayList() {
        this.array = (T[]) new Object[10];
        this.size = 10;
        this.curSize = 0;
    }

    /**
     * It is constructor with parameter size.
     * @param size
     */
    public ArrayList(int size) {
        this.array = (T[]) new Object[size];
        this.size = size;
        this.curSize = 0;
    }

    /**
     * This method adds the valid element to end of this list and returns true.
     * If element is not valid method returns false.
     * @param elem
     * @return
     */
    @Override
    public boolean add(T elem) {
        if (this.validObject(elem)) {
            if (this.curSize < this.size) {
                this.array[this.curSize++] = elem;
            } else {
                T oldArray[] = (T[]) new Object[this.size];
                System.arraycopy(this.array, 0, oldArray, 0, this.size);
                int newSize = (3 * this.size) / 2 + 1;
                this.array = (T[]) new Object[newSize];
                System.arraycopy(oldArray, 0, this.array, 0, this.size);
                this.size = newSize;
                this.array[this.curSize++] = elem;
            }
            return true;
        }
        else
            return false;
    }

    /**
     *
     * This method finds first element in array what equals o and removes it and returns true.
     * If it wasn't found, method returns false.
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        if (this.validObject(o)) {
            boolean mark = false;
            int i = 0;
            for (; i < this.curSize; i++) {
                if (o.equals(this.array[i])) {
                    mark = true;
                    break;
                }
            }
            if (!mark) { // o was not found
                return false;
            } else {
                this.remove(i);
                return true;
            }
        }
        else
            return false;
    }

    /**
     * This method removes index element in this list if index is valid and returns true.
     * Else method returns false.
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        if (this.validIndex(index)) {
            for (int i = index; i < this.curSize; i++)
                this.array[i] = this.array[i+1];
            curSize--;
            this.array[curSize] = null;
            return true;
        } else
            return false;
    }

    /**
     * This method returns size of this list.
     * @return
     */
    @Override
    public int size() {
        return this.curSize;
    }

    /**
     * This method verifies emptiness of this list.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.curSize == 0;
    }

    /**
     * This method returns index element in this list if index is valid.
     * Else method throws IndexOutOfBoundsException.
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (this.validIndex(index))
            return this.array[index];
        else
            throw new IndexOutOfBoundsException("It is not available index! Please change it!");
    }

    /**
     * This method sets index element in this list to element if index is valid and element is valid.
     * If index is not valid method throws IndexOutOfBoundsException.
     * If element is not valid method throws IllegalArgumentException.
     * @param index
     * @param element
     * @throws IndexOutOfBoundsException
     * @throws IllegalArgumentException
     */
    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (!this.validIndex(index))
            throw new IndexOutOfBoundsException("It is not available index! Please change it!");
        else if (!this.validObject(element))
            throw new IllegalArgumentException("Is is not allowable element! Please change it!");
        else
            this.array[index] = element;
    }

    /**
     * This method returns iterator to this list.
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iter<>();
    }

    /**
     * This method converts this list to array.
     * @return
     */
    @Override
    public Object[] toArray() {
        Object [] objects = new Object[this.curSize];
        System.arraycopy(this.array, 0, objects, 0, this.curSize);
        return objects;
    }

    /**
     * This method converts this list to string.
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.curSize; i++) {
            stringBuilder.append(this.array[i]);
            if (i != this.curSize - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * This method verifies validness of element.
     * @param o
     * @return
     */
    private boolean validObject(Object o) {
        return o != null;
    }

    /**
     * This method verifies validness of index.
     * @param index
     * @return
     */
    private boolean validIndex(int index) {
        return (index >= 0 && index < this.curSize);
    }

    /**
     * This class describes iterator in ArrayList.
     * @param <T>
     */
    private class Iter<T> implements Iterator<T> {

        /**
         * It is pointer to the current position.
         */
        private int pointer = -1;

        /**
         * This method verifies existing next element in this list.
         * @return
         */
        @Override
        public boolean hasNext() {
            if (this.pointer >= curSize - 1)
                return false;
            else
                return true;
        }

        /**
         * This method returns next element of this list.
         * @return
         */
        @Override
        public T next() {
            return (T) array[++this.pointer];
        }

        /**
         * This method removes select element.
         * @throws ConcurrentModificationException
         */
        @Override
        public void remove() throws ConcurrentModificationException {
            if (this.pointer >= 0) {
                ArrayList.this.remove(pointer);
                this.pointer--;
            }
            else
                throw new ConcurrentModificationException();
        }
    }
}