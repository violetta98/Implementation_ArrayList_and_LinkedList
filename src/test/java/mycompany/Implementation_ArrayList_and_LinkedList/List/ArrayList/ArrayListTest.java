package mycompany.Implementation_ArrayList_and_LinkedList.List.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Violetta on 15-07-2017.
 */
public class ArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Before
    public void addData() {
        this.arrayList.add(3);
        this.arrayList.add(56);
        this.arrayList.add(-34);
    }

    @Test
    public void add() throws Exception {
        Integer expectedArray[] = new Integer[]{3, 56, -34};
        assertArrayEquals(this.arrayList.toArray(), expectedArray);
    }

    @Test
    public void removeByIndex() throws Exception {
        this.arrayList.remove(1);
        Integer expectedArray[] = new Integer[]{3, -34};
        assertArrayEquals(this.arrayList.toArray(), expectedArray);
    }

    @Test
    public void removeByObject() throws Exception {
        this.arrayList.remove(new Integer(-34));
        Integer expectedArray[] = new Integer[]{3, 56};
        assertArrayEquals(this.arrayList.toArray(), expectedArray);
    }

    @Test
    public void size() throws Exception {
        assertEquals(this.arrayList.size(), 3);
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(this.arrayList.isEmpty(), false);
    }

    @Test
    public void get1() throws Exception {
        assertEquals(this.arrayList.get(0), new Integer(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get2() throws Exception {
        this.arrayList.get(-34);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set() throws Exception {
        this.arrayList.set(2, null);
    }
}