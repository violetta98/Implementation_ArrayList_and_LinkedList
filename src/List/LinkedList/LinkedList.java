package List.LinkedList;

import List.Iterator.Iterator;
import List.List;

import java.util.ConcurrentModificationException;

/**
 * Created by Violetta Podvolotskaya on 14-07-2017.
 */

/**
 * This class describes list with linked list implementation.
 * Class LinkedList implements List.
 * @param <T>
 */
public class LinkedList<T> implements List<T> {
    /**
     * This class describes node.
     * @param <T>
     */
    private static class Node<T> {
        private Node<T> next;
        private T data;
        private Node<T> prev;

        Node(Node<T> next, T data, Node<T> prev) {
            this.next = next;
            this.data = data;
            this.prev = prev;
        }

        Node() {
            this.next = null;
            this.data = null;
            this.prev = null;
        }

        Node(Node<T> node) {
            this.next = node.next;
            this.data = node.data;
            this.prev = node.prev;
        }
    }

    /**
     * It is head of linked list.
     */
    private Node<T> head;

    /**
     * It is tail of linked list.
     */
    private  Node<T> tail;

    /**
     * It is size of linked list.
     */
    private int size = 0;

    /**
     * It is default constructor.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method adds the valid element to end of this list and returns true.
     * If element is not valid method returns false.
     * @param elem
     * @return
     */
    @Override
    public boolean add(T elem) {
        if (this.validObject((elem))) {
            if (this.head == null) { // empty list
                Node<T> newNode = new Node<>(null, elem, null);
                this.head = newNode;
                this.tail = newNode;
            }
            else { // not empty list
                Node<T> newNode = new Node<>(null, elem, this.tail);
                this.tail.next = newNode;
                this.tail = newNode;
            }
            this.size++;
            return true;
        }
        else
            return false;
    }

    /**
     *
     * This method finds first element in this list what equals o and removes it and returns true.
     * If it wasn't found, method returns false.
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) throws IllegalArgumentException {
        if (this.validObject(o)) {
            int index = getIndexByData(o);
            if (index != this.size) {
                this.remove(index);
                return true;
            } else {
                return false;
            }
        } else
            throw new IllegalArgumentException();
    }

    /**
     * This method removes index element in this list if index is valid and returns true.
     * Else method returns false.
     * @param index
     * @return
     */
    @Override
    public boolean remove(int index) {
        Node<T> tmp = this.getNode(index);
        if (!this.validIndex(index))
            return false;
        if (this.validObject(tmp)) {
            if (this.size == 1) { // list has only one element and we remove it
                this.head = null;
                this.tail = null;
            } else {
                if (index == 0) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if (index == this.size - 1) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    Node<T> oldTmp = tmp;
                    tmp = tmp.next;
                    tmp.prev = oldTmp.prev;
                    oldTmp.prev.next = tmp;
                }
            }
            this.size--;
            return true;
        } else
            return true;
    }

    /**
     * This method returns size of this list.
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method verifies emptiness of this list.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * This method returns index element in this list if index is valid.
     * @param index
     * @return
     */
    @Override
    public T get(int index) throws IllegalAccessException {
       if (this.validIndex(index)) {
           Node<T> tmp = this.getNode(index);
           if (this.validObject(tmp.data))
               return tmp.data;
           else
               throw new IllegalArgumentException();
       } else
           throw new IllegalAccessException();
    }

    /**
     * This method gets node by index.
     * @param index
     * @return
     */
    private Node<T> getNode(int index) {
        Node<T> tmp = null;
        for (int i = 0; i<this.size; i++) {
            if (i == 0)
                tmp = this.head;
            else
                tmp = tmp.next;
            if (i == index) {
                break;
            }
        }
        return tmp;
    }

    /**
     * This method gets index of node by data.
     * @param o
     * @return
     */
    private int getIndexByData(Object o) {
        int i = 0;
        Node<T> tmp = null;
        for (; i<this.size; i++) {
            if (i == 0)
                tmp = this.head;
            else
                tmp = tmp.next;
            if (o.equals(tmp.data)) {
                break;
            }
        }
        return i;
    }

    /**
     * This method sets index element in this list to element if index is valid and element is valid.
     * @param index
     * @param element
     */
    @Override
    public void set(int index, T element) throws IllegalAccessException, IllegalArgumentException {
        if (this.validIndex(index)) {
            Node<T> tmp = this.getNode(index);
            if (this.validObject(element))
                tmp.data = element;
            else
                throw new IllegalArgumentException();
        } else
            throw new IllegalAccessException();
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
        Object[] objects = new Object[this.size];
        int i = 0;
        Node<T> tmp = this.head;
        while (tmp != null) {
            objects[i] = tmp.data;
            tmp = tmp.next;
        }
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
        Node<T> tmp = this.head;
        while (tmp != null) {
            stringBuilder.append(tmp.data);
            if (tmp.next != null)
                stringBuilder.append(", ");
            tmp = tmp.next;
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
        return (index >= 0 && index < this.size);
    }

    /**
     * This class describes iterator in LinkedList.
     * @param <T>
     */
    private class Iter<T> implements Iterator<T> {

        /**
         * It is pointer to the current position.
         */
        private int pointer = -1;

        /**
         * It is current node.
         */
        private Node<T> curNode = null;

        /**
         * This method verifies existing next element in this list.
         * @return
         */
        @Override
        public boolean hasNext() {
            if (this.pointer >= LinkedList.this.size - 1)
                return false;
            else
                return true;
        }

        /**
         * This method returns next element of this list.
         * @return
         */
        @Override
        public T next() throws IndexOutOfBoundsException {
            if (this.curNode == null) {
                if (this.pointer == -1) {
                    this.pointer++;
                    this.curNode = (Node<T>) LinkedList.this.head;
                    return this.curNode.data;
                } else
                    throw new IndexOutOfBoundsException();
            } else {
                this.pointer++;
                this.curNode = this.curNode.next;
                return this.curNode.data;
            }
        }

        /**
         * This method removes select element.
         * @throws ConcurrentModificationException
         */
        @Override
        public void remove() throws ConcurrentModificationException {
            if (this.curNode == null) {
                throw new ConcurrentModificationException();
            } else {
                LinkedList.this.remove(this.pointer);
                this.pointer--;
            }
        }
    }
}
