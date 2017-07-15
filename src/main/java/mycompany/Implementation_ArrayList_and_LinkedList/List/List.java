package mycompany.Implementation_ArrayList_and_LinkedList.List;

import mycompany.Implementation_ArrayList_and_LinkedList.List.Iterator.Iterator;

/**
 * Created by Violetta Podvolotskaya on 14-07-2017.
 */
public interface List<T> {

    /**
     * This method adds the valid element to end of this list and returns true.
     * If element is not valid method returns false.
     * @param elem
     * @return
     */
    boolean add(T elem);

    /**
     *
     * This method finds first element in this list what equals o and removes it and returns true.
     * If it wasn't found, method returns false.
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * This method removes index element in this list if index is valid and returns true.
     * Else method returns false.
     * @param index
     * @return
     */
    boolean remove(int index) throws IllegalAccessException;

    /**
     * This method returns size of this list.
     * @return
     */
    int size();

    /**
     * This method verifies emptiness of this list.
     * @return
     */
    boolean isEmpty();

    /**
     * This method returns index element in this list if index is valid.
     * @param index
     * @return
     */
    T get(int index) throws IllegalAccessException;

    /**
     * This method sets index element in this list to element if index is valid and element is valid.
     * @param index
     * @param element
     */
    void set(int index, T element) throws IllegalAccessException;

    /**
     * This method returns iterator to this list.
     * @return
     */
    Iterator<T> iterator();

    /**
     * This method converts this list to array.
     * @return
     */
    Object[] toArray();
}
