package mycompany.Implementation_ArrayList_and_LinkedList.List.Iterator;

import java.util.ConcurrentModificationException;

/**
 * Created by Violetta Podvolotskaya on 14-07-2017.
 */

/**
 * This interface describes iterator for each collection.
 * @param <T>
 */
public interface Iterator<T> {

    /**
     * This method verifies existing next element in collection.
     * @return
     */
    boolean hasNext();

    /**
     * This method returns next element of collection.
     * @return
     */
    T next();

    /**
     * This method removes current element of collection.
     * @throws Exception
     * @throws ConcurrentModificationException
     */
    void remove() throws Exception, ConcurrentModificationException;
}
