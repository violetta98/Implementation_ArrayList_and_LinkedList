package mycompany.Implementation_ArrayList_and_LinkedList.List.LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Violetta on 15-07-2017.
 */
public class LinkedListTest {
    LinkedList<Integer> linkedList = new LinkedList<>();

    @Before
    public void addData() {
        this.linkedList.add(45);
        this.linkedList.add(-23);
        this.linkedList.add(90);
        this.linkedList.add(-65);
    }

    @Test
    public void add() throws Exception {
        Integer expectedArray[] = new Integer[]{45, -23, 90, -65};
        assertArrayEquals(this.linkedList.toArray(), expectedArray);
    }

    @Test
    public void removeByIndex() throws Exception {
        this.linkedList.remove(3);
        Integer expectedArray[] = new Integer[]{45, -23, 90};
        assertArrayEquals(this.linkedList.toArray(), expectedArray);
    }

    @Test
    public void removeByObject() throws Exception {
        this.linkedList.remove(new Integer(100));
        Integer expectedArray[] = new Integer[]{45, -23, 90, -65};
        assertArrayEquals(this.linkedList.toArray(), expectedArray);
    }

    @Test
    public void size() throws Exception {
        assertEquals(this.linkedList.size(), 4);
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(this.linkedList.isEmpty(), false);
    }

    @Test
    public void get1() throws Exception {
        assertEquals(this.linkedList.get(2), new Integer(90));
    }

    @Test(expected = IllegalAccessException.class)
    public void get2() throws Exception {
        this.linkedList.get(4);
    }

    @Test
    public void set() throws Exception {
        this.linkedList.set(2, 56);
        this.linkedList.set(3, 1234);
        Integer expectedArray[] = new Integer[]{45, -23, 56, 1234};
        assertArrayEquals(this.linkedList.toArray(), expectedArray);
    }
}