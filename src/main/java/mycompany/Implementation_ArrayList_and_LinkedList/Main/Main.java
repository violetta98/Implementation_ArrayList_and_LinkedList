package mycompany.Implementation_ArrayList_and_LinkedList.Main;


import mycompany.Implementation_ArrayList_and_LinkedList.List.ArrayList.ArrayList;
import mycompany.Implementation_ArrayList_and_LinkedList.List.Iterator.Iterator;
import mycompany.Implementation_ArrayList_and_LinkedList.List.LinkedList.LinkedList;
import mycompany.Implementation_ArrayList_and_LinkedList.List.List;

//import java.util.*;

/**
 * Created by Violetta Podvolotskaya on 14-07-2017.
 */

public class Main {
    /**
     * This method has simple actions with list.
     * @param list
     * @throws Exception
     */
    public void action(List<Integer> list) throws Exception {
        for (int i = 1; i <= 20; i++)
            list.add(i);
        System.out.println(list);
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
            iterator.remove();
        }
        System.out.println();
        System.out.println(list);
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        List<Integer> list = new ArrayList<>();
        main.action(list);

        List<Integer> list2 = new LinkedList<>();
        main.action(list2);
    }
}
