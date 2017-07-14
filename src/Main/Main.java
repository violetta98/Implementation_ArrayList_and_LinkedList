package Main;


import List.ArrayList.ArrayList;
import List.Iterator.Iterator;
import List.LinkedList.LinkedList;
import List.List;


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
